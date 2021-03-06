package com.survey.app.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.suervey.app.util.AppConstants;
import com.survey.app.dto.RespondentData;
import com.survey.app.model.Block;
import com.survey.app.model.District;
import com.survey.app.model.Interviewer;
import com.survey.app.model.Region;
import com.survey.app.service.RespondentService;
import com.survey.app.service.SurveyCommonService;
import com.survey.app.util.Page;


@RestController
@RequestMapping("/api/respondents")
public class RespondentController {

@Autowired
private RespondentService respondentService;

@Autowired
private SurveyCommonService surveyCommonService;


 @GetMapping
 public Page<RespondentData> getPolls( @RequestParam(value = "blockId", defaultValue = AppConstants.DEFAULT_LONG_VALUE) Long blockId,
            									@RequestParam(value = "districtId", defaultValue = AppConstants.DEFAULT_LONG_VALUE) Long districtId,
            									@RequestParam(value = "regionId", defaultValue = AppConstants.DEFAULT_LONG_VALUE) Long regionId,
            									@RequestParam(value = "searchString", defaultValue = StringUtils.EMPTY) String searchString,
            									@RequestParam(value = "interviewerId", defaultValue = AppConstants.DEFAULT_LONG_VALUE) Long interviewerId,
                                                @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Long page,
                                                @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Long size) {
    	
        return respondentService.getAllRespondents(blockId, districtId, regionId,interviewerId, searchString, page, size);
    }
 
    @GetMapping("/template")
	public RespondentData getRespondentTemplateData( @RequestParam(value = "regionId", defaultValue = AppConstants.DEFAULT_LONG_VALUE) Long regionId,
			 @RequestParam(value = "districtId", defaultValue = AppConstants.DEFAULT_LONG_VALUE) Long districtId,
			 	@RequestParam(value = "interviewerId", defaultValue = AppConstants.DEFAULT_LONG_VALUE) Long interviewerId)
	{
    	List<Region> regions = this.surveyCommonService.findAllRegions();
    	List<District> districts =regionId == 0?this.surveyCommonService.findAllDistricts():this.surveyCommonService.findDistrictsByRegionId(regionId);
    	List<Block> blocks = districtId==0?this.surveyCommonService.findAllBlocks():this.surveyCommonService.findBlocksByDistrictId(districtId);
    	List<Interviewer> interviewers = districtId==0?this.surveyCommonService.findAllInterviewers():this.surveyCommonService.findInterviewerById(interviewerId);
		return new RespondentData(regions,districts,blocks,interviewers);
    	
	}
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        String fileName = respondentService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return fileDownloadUri;
    }
   

}
