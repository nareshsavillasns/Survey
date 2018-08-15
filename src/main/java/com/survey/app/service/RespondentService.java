package com.survey.app.service;

import com.survey.app.dto.RespondentData;
import com.survey.app.util.Page;

public interface RespondentService {

Page<RespondentData> getAllRespondents(Long blockId, Long districtId,
		Long regionId, String searchString, Long pageNum, Long pageSize);
	
}
