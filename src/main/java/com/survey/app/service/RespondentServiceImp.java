package com.survey.app.service;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.survey.app.dao.RespondentDao;
import com.survey.app.dto.RespondentData;
import com.survey.app.model.FileUpload;
import com.survey.app.repository.FileUploadRepository;
import com.survey.app.util.FileStorageProperties;
import com.survey.app.util.FileUtils;
import com.survey.app.util.Page;

@Service
public class RespondentServiceImp implements RespondentService{
	private  Path fileStorageLocation;
	
	@Autowired
	private RespondentDao respondentDao;
	
	@Autowired
	private FileUploadRepository fileUploadRepository;
	
	@Autowired
    Job processJob;
	
	@Autowired
    JobLauncher simpleJobLauncher;
	
	
	@Autowired
    public RespondentServiceImp(FileStorageProperties fileStorageProperties) {}
	
	@Override
	public Page<RespondentData> getAllRespondents(Long blockId, Long districtId,Long regionId, Long interviewerId,String searchString,Long pageNum, Long pageSize) {
		return respondentDao.findAllRespondents(blockId, districtId, regionId,interviewerId, searchString, pageNum, pageSize);
	}

	@Override
	public String storeFile(MultipartFile file)  throws Exception {
		// Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        this.fileStorageLocation = Paths.get(FileUtils.generateXlsFileDirectory())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
        	
        }
    
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileAlreadyExistsException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            FileUpload fileUpload = new FileUpload();
            fileUpload.setFileName(fileName);
            fileUpload.setFileLocation(targetLocation.toAbsolutePath().toString());
            fileUpload.setUploadDate(new  Date());
            fileUploadRepository.save(fileUpload);
            JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
            		.addString("filelocation", fileUpload.getFileLocation())
                    .toJobParameters();
            simpleJobLauncher.run(processJob, jobParameters);
 
           // return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (IOException ex) {}
		return fileName;
	}

}
