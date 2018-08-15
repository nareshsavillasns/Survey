package com.survey.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.app.dao.RespondentDao;
import com.survey.app.dto.RespondentData;
import com.survey.app.util.Page;

@Service
public class RespondentServiceImp implements RespondentService{

	@Autowired
	private RespondentDao respondentDao;
	
	@Override
	public Page<RespondentData> getAllRespondents(Long blockId, Long districtId,Long regionId,String searchString,Long pageNum, Long pageSize) {
		return respondentDao.findAllRespondents(blockId, districtId, regionId, searchString, pageNum, pageSize);
	}

}
