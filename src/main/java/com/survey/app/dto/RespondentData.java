package com.survey.app.dto;

import java.util.List;

import org.joda.time.LocalDate;

import com.survey.app.model.Block;
import com.survey.app.model.District;
import com.survey.app.model.Region;

public class RespondentData {
    private Long id;
    private String awcCode;
    private String regionName;
    private String districtName;
    private String blockName;
    private String interviewerName;
    private String villageName;
    private Long sampleNum;
    private String audio;
	private String respondentName;
	private LocalDate lastSubmission;
	private List<Region> regions;
	private List<District> districts;
	private List<Block> blocks;
   


	public RespondentData(Long id, String regionName, String districtName,
			String blockName, String villageName, String interviewerName,
			String respondentName, String audio, Long samplenum,
			LocalDate lastSubmission) {
		this.id =id;
		this.regionName =regionName;
		this.districtName = districtName;
		this.blockName = blockName;
		this.villageName = villageName;
		this.interviewerName = interviewerName;
		this.respondentName = respondentName;
		this.audio =audio;
		this.sampleNum = samplenum;
		//this.lastSubmission = lastSubmission;
	}



	public RespondentData(List<Region> regions, List<District> districts,
			List<Block> blocks) {
		
		this.regions =regions;
		this.districts =districts;
		this.blocks =blocks;
		
	}

	public List<Region> getRegions() {
		return regions;
	}



	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}



	public List<District> getDistricts() {
		return districts;
	}



	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}



	public List<Block> getBlocks() {
		return blocks;
	}



	public void setBlocks(List<Block> blocks) {
		this.blocks = blocks;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getAwcCode() {
		return awcCode;
	}



	public void setAwcCode(String awcCode) {
		this.awcCode = awcCode;
	}



	public String getRegionName() {
		return regionName;
	}



	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}



	public String getDistrictName() {
		return districtName;
	}



	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}



	public String getBlockName() {
		return blockName;
	}



	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}



	public String getInterviewerName() {
		return interviewerName;
	}



	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}



	public String getVillageName() {
		return villageName;
	}



	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}



	public Long getSampleNum() {
		return sampleNum;
	}



	public void setSampleNum(Long sampleNum) {
		this.sampleNum = sampleNum;
	}



	public String getAudio() {
		return audio;
	}



	public void setAudio(String audio) {
		this.audio = audio;
	}



	public String getRespondentName() {
		return respondentName;
	}



	public void setRespondentName(String respondentName) {
		this.respondentName = respondentName;
	}



	public LocalDate getLastSubmission() {
		return lastSubmission;
	}



	public void setLastSubmission(LocalDate lastSubmission) {
		this.lastSubmission = lastSubmission;
	}

	
}