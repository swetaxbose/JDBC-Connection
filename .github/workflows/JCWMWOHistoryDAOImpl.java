package com.wfm.server.workorder.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wfm.common.JCWMCommonServices;
import com.wfm.server.workorder.dao.JIWMWOHistoryDAO;
import com.wfm.server.workorder.dto.JCWMWOHistCriteriaDTO;
import com.wfm.server.workorder.model.JCWMWOHistoryModel;

import factory.JCConnectionFactory;
import java.sql.SQLException;




public class JCWMWOHistoryDAOImpl implements JIWMWOHistoryDAO
{
	private static JCWMWOHistoryDAOImpl i_WOHistoryDAOImpl = null;
	
	// static method to return singleton instance
	public static synchronized JCWMWOHistoryDAOImpl getInstance() 
	{
		
		if (i_WOHistoryDAOImpl == null) 
		{
			synchronized(JCWMWOHistoryDAOImpl.class)
			{
				if(i_WOHistoryDAOImpl == null)
				{
					i_WOHistoryDAOImpl = new JCWMWOHistoryDAOImpl();
				}
			}
		}
		return i_WOHistoryDAOImpl;
	}
	
	@Override
	public JCWMWOHistoryModel retrieveWOHistory(long woNo) throws Exception
	{
		System.out.println("JCWMWOHistoryDAOImpl::retrieveWOHistory() is called.");
		JCWMWOHistoryModel l_histCriteriaModel = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String retrieveSql = "SELECT WORKORDERNO, WOREQUESTID, REQUESTSOURCE, DURATION, DESCRIPTION,"+ 
		" ORDERTYPEID, ORDERTYPECD, PREFSARTDATE, SCHEDULEDSTARTDATE, SCHEDULEDSTOPDATE, "+ "ACTUALSTARTDATE, ACTUALSTOPDATE, "
				+ "CREATIONDATE, CREATEDBY, MODBY, MODON, STATUS,"+ " REMARKS FROM " + getTableName() + " WHERE WORKORDERNO = ?";
		
			
			
			//JCWMCommonServices.createPool();
			con = JCWMCommonServices.getConnection();
			ps = con.prepareStatement(retrieveSql);
			ps.setLong(1, woNo);
			
			rs = ps.executeQuery();
			while (rs.next()) 
			{
				
				l_histCriteriaModel = new JCWMWOHistoryModel();
				l_histCriteriaModel.setWoNo(rs.getLong("WORKORDERNO"));
				l_histCriteriaModel.setRequestId(rs.getLong("WOREQUESTID"));
				l_histCriteriaModel.setRequestSourceId(rs.getInt("REQUESTSOURCE"));
				l_histCriteriaModel.setActualDuration(rs.getLong("DURATION"));
				l_histCriteriaModel.setDescription(rs.getString("DESCRIPTION"));
				l_histCriteriaModel.setWoTypeId(rs.getLong("ORDERTYPEID"));
				l_histCriteriaModel.setWoTypeCd(rs.getString("ORDERTYPECD"));
				l_histCriteriaModel.setPrefStartDate(rs.getTimestamp("PREFSARTDATE"));
				l_histCriteriaModel.setScheduleStartDate(rs.getTimestamp("SCHEDULEDSTARTDATE"));//..//
				l_histCriteriaModel.setScheduleStopDate(rs.getTimestamp("SCHEDULEDSTOPDATE"));
				l_histCriteriaModel.setActualStartDate(rs.getTimestamp("ACTUALSTARTDATE"));
				l_histCriteriaModel.setActualStopDate(rs.getTimestamp("ACTUALSTOPDATE"));
				l_histCriteriaModel.setCreationDate(rs.getTimestamp("CREATIONDATE"));
				l_histCriteriaModel.setCreatedBy(rs.getString("CREATEDBY"));
				l_histCriteriaModel.setModBy(rs.getString("MODBY"));
				l_histCriteriaModel.setModOn(rs.getTimestamp("MODON"));
				l_histCriteriaModel.setStatus(rs.getInt("STATUS"));
				l_histCriteriaModel.setRemarks(rs.getString("REMARKS"));
			}
			
			

			System.out.println("JCWMWOHistoryDAOImpl::retrieveWOHistory()- Exits");
			
			return l_histCriteriaModel;
			
		} 
		catch (Exception e) 
		{
			e.getStackTrace();
			throw e;
		}
		finally 
		{
			if(rs != null)
				rs.close();
			if(ps != null)
				ps.close();
			if(con !=null)
				con.close();
		}
		
	}



	
	@Override
	public List<JCWMWOHistoryModel> retrieveByDateRange(JCWMWOHistCriteriaDTO histCriteriaDTO) throws Exception
	{
		
		System.out.println("JCWMWOHistoryDAOImpl::retrieveByDateRange() is called.");
		List<JCWMWOHistoryModel> l_histModel = new ArrayList<>();
		Connection l_con = null;
		PreparedStatement l_ps = null;
		ResultSet l_rs = null;
		
		
		try
		{
			String retrieveSql = "SELECT WORKORDERNO, WOREQUESTID, REQUESTSOURCE, DURATION, DESCRIPTION, "
					+ "ORDERTYPEID, ORDERTYPECD, PREFSARTDATE, SCHEDULEDSTARTDATE, SCHEDULEDSTOPDATE, ACTUALSTARTDATE, "
					+ "ACTUALSTOPDATE, CREATIONDATE, CREATEDBY, MODBY, MODON, STATUS, REMARKS FROM " + getTableName() +
					" WHERE CREATIONDATE between ? and ?";
			l_con = JCWMCommonServices.getConnection();
			l_ps = l_con.prepareStatement(retrieveSql);
			l_ps.setObject(1, histCriteriaDTO.getstartDate());
			l_ps.setObject(2, histCriteriaDTO.getstopDate());
			
			System.out.println("Query="+l_ps.toString());
			
			l_rs = l_ps.executeQuery();
			while(l_rs.next()) 
			{
				
				JCWMWOHistoryModel l_hist = new JCWMWOHistoryModel();
					//l_histModel.get(i);
				l_hist.setWoNo(l_rs.getLong("WORKORDERNO"));
				l_hist.setRequestId(l_rs.getInt("WOREQUESTID"));
				l_hist.setRequestSourceId(l_rs.getInt("REQUESTSOURCE"));
				l_hist.setActualDuration(l_rs.getLong("DURATION"));
				l_hist.setDescription(l_rs.getString("DESCRIPTION"));
				l_hist.setWoTypeId(l_rs.getLong("ORDERTYPEID"));
				l_hist.setWoTypeCd(l_rs.getString("ORDERTYPECD"));
				l_hist.setPrefStartDate(l_rs.getTimestamp("PREFSARTDATE"));
				l_hist.setScheduleStartDate(l_rs.getTimestamp("SCHEDULEDSTARTDATE"));
				l_hist.setScheduleStopDate(l_rs.getTimestamp("SCHEDULEDSTOPDATE"));
				l_hist.setActualStartDate(l_rs.getTimestamp("ACTUALSTARTDATE"));
				l_hist.setActualStopDate(l_rs.getTimestamp("ACTUALSTOPDATE"));
				l_hist.setCreationDate(l_rs.getTimestamp("CREATIONDATE"));
				l_hist.setCreatedBy(l_rs.getString("CREATEDBY"));
				l_hist.setModBy(l_rs.getString("MODBY"));
				l_hist.setModOn(l_rs.getTimestamp("MODON"));
				l_hist.setStatus(l_rs.getInt("STATUS"));
				l_hist.setRemarks(l_rs.getString("REMARKS"));
				
				l_histModel.add(l_hist);
				
			}
			
			
			System.out.println("JCWMWOHistoryDAOImpl::retrieveByDateRange()- Exits");
			return l_histModel;
		}
		catch(Exception e)
		{
			e.getStackTrace();
			throw e;
		}
		finally 
		{
			if(l_ps != null)
				l_ps.close();
			if(l_rs != null)
				l_rs.close();
			if(l_con !=null)
				l_con.close();
		}
	}
	
	

	
	@Override
	public List<JCWMWOHistoryModel> retrieveByDateRangeCreatedBy(JCWMWOHistCriteriaDTO histCriteriaDTO) throws Exception 
{
		
		System.out.println("JCWMWOHistoryDAOImpl::retrieveByDateRangeCreatedBy() is called.");
		List<JCWMWOHistoryModel> l_arrModel = new ArrayList<>();
		Connection l_con = null;
		PreparedStatement l_ps = null;
		ResultSet l_rs = null;
		
		
		try
		{
			String retrieveSql = "SELECT WORKORDERNO, WOREQUESTID, REQUESTSOURCE, DURATION, DESCRIPTION, "
					+ "ORDERTYPEID, ORDERTYPECD, PREFSARTDATE, SCHEDULEDSTARTDATE, SCHEDULEDSTOPDATE, ACTUALSTARTDATE, "
					+ "ACTUALSTOPDATE, CREATIONDATE, CREATEDBY, MODBY, MODON, STATUS, REMARKS FROM " + getTableName() +
					" WHERE CREATEDBY=? and CREATIONDATE between ? and ?";
			l_con = JCWMCommonServices.getConnection();
			l_ps = l_con.prepareStatement(retrieveSql);
			l_ps.setObject(1,histCriteriaDTO.getcreatedBy());
			l_ps.setObject(2, histCriteriaDTO.getstartDate());
			l_ps.setObject(3, histCriteriaDTO.getstopDate());
			l_rs = l_ps.executeQuery();
			
			System.out.println("Query="+l_ps.toString());
			
			while (l_rs.next()) 
			{
				
				JCWMWOHistoryModel l_hist = new JCWMWOHistoryModel();
				
				l_hist.setWoNo(l_rs.getLong("WORKORDERNO"));
				l_hist.setRequestId(l_rs.getInt("WOREQUESTID"));
				l_hist.setRequestSourceId(l_rs.getInt("REQUESTSOURCE"));
				l_hist.setActualDuration(l_rs.getLong("DURATION"));
				l_hist.setDescription(l_rs.getString("DESCRIPTION"));
				l_hist.setWoTypeId(l_rs.getLong("ORDERTYPEID"));
				l_hist.setWoTypeCd(l_rs.getString("ORDERTYPECD"));
				l_hist.setPrefStartDate(l_rs.getTimestamp("PREFSARTDATE"));
				l_hist.setScheduleStartDate(l_rs.getTimestamp("SCHEDULEDSTARTDATE"));
				l_hist.setScheduleStopDate(l_rs.getTimestamp("SCHEDULEDSTOPDATE"));
				l_hist.setActualStartDate(l_rs.getTimestamp("ACTUALSTARTDATE"));
				l_hist.setActualStopDate(l_rs.getTimestamp("ACTUALSTOPDATE"));
				l_hist.setCreationDate(l_rs.getTimestamp("CREATIONDATE"));
				l_hist.setCreatedBy(l_rs.getString("CREATEDBY"));
				l_hist.setModBy(l_rs.getString("MODBY"));
				l_hist.setModOn(l_rs.getTimestamp("MODON"));
				l_hist.setStatus(l_rs.getInt("STATUS"));
				l_hist.setRemarks(l_rs.getString("REMARKS"));
				l_arrModel.add(l_hist);
			}
			
			
			System.out.println("JCWMWOHistoryDAOImpl::retrieveByDateRangeCreatedBy()- Exits");
			return l_arrModel;
		}
		catch(Exception e)
		{
			e.getStackTrace();
			throw e;
		}
		finally 
		{
			if(l_ps != null)
				l_ps.close();
			if(l_rs != null)
				l_rs.close();
			if(l_con !=null)
				l_con.close();
		}
	}
	
	
	
	private String getTableName()
	{	
		return "wm_workorder";
	}

}
