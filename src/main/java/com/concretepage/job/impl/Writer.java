package com.concretepage.job.impl;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.survey.app.config.CSVContext;

public class Writer implements ItemWriter<CSVContext> {

	@Override
	public void write(List<? extends CSVContext> messages) throws Exception {
		for (CSVContext msg : messages) {
			System.out.println("Writing the data " + msg.getRespondentDTOs().get(0).getName());
		}
	}

}