package com.concretepage.job.impl;

import org.springframework.batch.item.ItemProcessor;

import com.survey.app.config.CSVContext;


public class Processor implements ItemProcessor<CSVContext,CSVContext> {

	@Override
	public CSVContext process(CSVContext data) throws Exception {
		return data;
	}

}