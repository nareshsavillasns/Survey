package com.survey.app.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suervey.app.util.AppConstants;
import com.survey.app.dto.RespondentData;
import com.survey.app.model.Block;
import com.survey.app.model.District;
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
                                                @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Long page,
                                                @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Long size) {
    	
        return respondentService.getAllRespondents(blockId, districtId, regionId, searchString, page, size);
    }
 
    @GetMapping("/template")
	public RespondentData getRespondentTemplateData( @RequestParam(value = "regionId", defaultValue = AppConstants.DEFAULT_LONG_VALUE) Long regionId,
			 @RequestParam(value = "districtId", defaultValue = AppConstants.DEFAULT_LONG_VALUE) Long districtId)
	{
    	List<Region> regions = this.surveyCommonService.findAllRegions();
    	List<District> districts =regionId == 0?this.surveyCommonService.findAllDistricts():this.surveyCommonService.findDistrictsByRegionId(regionId);
    	List<Block> blocks = districtId==0?this.surveyCommonService.findAllBlocks():this.surveyCommonService.findBlocksByDistrictId(districtId);
		return new RespondentData(regions,districts,blocks);
    	
	}
 
   

}
