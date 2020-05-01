package com.wfm.server.workorder.dao;

import java.util.List;

import com.wfm.server.workorder.dto.JCWMWOHistCriteriaDTO ;
import com.wfm.server.workorder.model.JCWMWOHistoryModel;


public interface JIWMWOHistoryDAO
{
	
	public List<JCWMWOHistoryModel> retrieveByDateRangeCreatedBy(JCWMWOHistCriteriaDTO histCriteriaDTO) throws Exception;
	
	public List<JCWMWOHistoryModel> retrieveByDateRange(JCWMWOHistCriteriaDTO histCriteriaDTO) throws Exception;
	
	public JCWMWOHistoryModel retrieveWOHistory(long woNo) throws Exception;

}
