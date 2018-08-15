package com.concretepage.job.impl;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.concretepage.job.dto.RespondentDTO;
import com.survey.app.config.CSVContext;

public class ReaderCsv implements ItemReader<CSVContext> {


	@Override
	public CSVContext read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		CSVContext context = new CSVContext();
		BufferedReader reader = Files.newBufferedReader(Paths.get("C:\\Users\\home\\Desktop\\student.csv"));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ArrayList<RespondentDTO>  list = new ArrayList<>();
        for (CSVRecord csvRecord: csvParser) {
        	
        	 RespondentDTO dto = new RespondentDTO();
        	 dto.setName(csvRecord.get(0));
        	 dto.setName(csvRecord.get(1));
            System.out.println("Record Number - " + csvRecord.getRecordNumber());
            list.add(dto);
        }
        context.setRespondentDTOs(list);
        return context;
	}

}