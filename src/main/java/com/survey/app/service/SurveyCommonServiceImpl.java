package com.survey.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.app.model.Block;
import com.survey.app.model.District;
import com.survey.app.model.Region;
import com.survey.app.repository.BlockRepository;
import com.survey.app.repository.DistrictRepository;
import com.survey.app.repository.RegionRepository;


@Service
public class SurveyCommonServiceImpl implements SurveyCommonService{
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private BlockRepository blockRepository;
	
	@Autowired
	private RegionRepository regionRepository;

	@Override
	public List<District> findAllDistricts() {
      return districtRepository.findAll();
	}
	
	@Override
	public List<Block> findAllBlocks() {
      return blockRepository.findAll();
	}
	
	@Override
	public List<Region> findAllRegions() {
      return regionRepository.findAll();
	}
	
	@Override
	public List<District> findDistrictsByRegionId(Long regionId) {
      return districtRepository.findDistrictsByRegionId(regionId);
	}
	
	@Override
	public List<Block> findBlocksByDistrictId(Long regionId) {
      return blockRepository.findBlockBydistrictId(regionId);
	}
	

}
