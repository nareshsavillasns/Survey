package com.survey.app.config;

import java.util.List;

import com.concretepage.job.dto.RespondentDTO;

public class CSVContext {
	
private List<RespondentDTO> respondentDTOs;

public List<RespondentDTO> getRespondentDTOs() {
	return respondentDTOs;
}

public void setRespondentDTOs(List<RespondentDTO> respondentDTOs) {
	this.respondentDTOs = respondentDTOs;
}

}
