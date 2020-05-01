package com.wfm.server.workorder.facade;

import java.util.ArrayList;
import java.util.List;

import com.wfm.common.JCWMCommonServices;
import com.wfm.server.workorder.dao.JIWMWOHistoryDAO;
import com.wfm.server.workorder.daoimpl.JCWMWOHistoryDAOImpl;
import com.wfm.server.workorder.dto.JCWMWOHistCriteriaDTO;
//import com.wfm.server.workorder.dto.JCWMWOHistCriteriaDTO;
import com.wfm.server.workorder.dto.JCWMWorkOrderDTO;
import com.wfm.server.workorder.model.JCWMWOHistoryModel;



public class JCWMWOHistoryFacade 
{


	public JCWMWorkOrderDTO retrieveWOHistory(long woNo)
	{
		JCWMWorkOrderDTO l_WOfacDTO=null;
		JCWMWOHistoryModel l_WOfacModel = null;

		try
		{
			
			System.out.println("JCWMWOHistoryFacade ::retrieveWOHistory() is called.");
			JIWMWOHistoryDAO l_WOfacDao = JCWMWOHistoryDAOImpl.getInstance();

			l_WOfacModel = l_WOfacDao.retrieveWOHistory(woNo);
			l_WOfacDTO = toDTO(l_WOfacModel);
	
			System.out.println("JCWMWOHistoryFacade::retrieveWOHistory()- Exits");
		
			
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return l_WOfacDTO ;
	}

	
	
	
	public List<JCWMWorkOrderDTO> retrieveByDateRange( JCWMWOHistCriteriaDTO histCriteriaDTO)
	{

		List<JCWMWorkOrderDTO> l_WOfacDTOList = new ArrayList<>();

		try
		{
			
			System.out.println("JCWMWOHistoryFacade::retrieveByDateRange() is called.");
			JIWMWOHistoryDAO l_WOfacDao = JCWMWOHistoryDAOImpl.getInstance();
			List<JCWMWOHistoryModel> l_WOfacModelList = l_WOfacDao.retrieveByDateRange(histCriteriaDTO) ;
			l_WOfacDTOList =  toDTOList(l_WOfacModelList) ;
			
			System.out.println("JCWMWOHistoryFacade::retrieveByDateRange()- Exits");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();

		}
		
		
		
		return l_WOfacDTOList;
		
	}
	
	
	
	
	
	public List<JCWMWorkOrderDTO> retrieveByDateRangeCreatedBy( JCWMWOHistCriteriaDTO histCriteriaDTO)
	{
		
		List<JCWMWorkOrderDTO> l_WOfacDTOList = new ArrayList<>();

		try
		{
			System.out.println("JCWMWOHistoryFacade::retrieveByDateRangeCreatedBy() is called.");
			JIWMWOHistoryDAO l_WOfacDao = JCWMWOHistoryDAOImpl.getInstance();
			List<JCWMWOHistoryModel> l_WOfacModelList = l_WOfacDao.retrieveByDateRangeCreatedBy(histCriteriaDTO) ;
			l_WOfacDTOList =  toDTOList(l_WOfacModelList) ;
			
			System.out.println("JCWMWOHistoryFacade::retrieveByDateRangeCreatedBy()- Exits");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}		
		
		return l_WOfacDTOList;
	}
	
	
	
	

	private JCWMWorkOrderDTO toDTO(JCWMWOHistoryModel l_WOfacModel) 
	{

		JCWMWorkOrderDTO l_WOfacDTO = new JCWMWorkOrderDTO();
		try
		{
			l_WOfacDTO.setWoNo(l_WOfacModel.getWoNo());
			l_WOfacDTO.setRequestId(l_WOfacModel.getRequestId());
			l_WOfacDTO.setRequestSourceId(l_WOfacModel.getRequestSourceId());
			l_WOfacDTO.setActualDuration(l_WOfacModel.getActualDuration());
			l_WOfacDTO.setDescription(l_WOfacModel.getDescription());
			l_WOfacDTO.setWoTypeId(l_WOfacModel.getWoTypeId());
			l_WOfacDTO.setWoTypeCd(l_WOfacModel.getWoTypeCd());
			l_WOfacDTO.setPrefStartDate(l_WOfacModel.getPrefStartDate());
			l_WOfacDTO.setScheduleStartDate(l_WOfacModel.getScheduleStartDate());
			l_WOfacDTO.setScheduleStopDate(l_WOfacModel.getScheduleStopDate());
			l_WOfacDTO.setActualStartDate(l_WOfacModel.getActualStartDate());
			l_WOfacDTO.setActualStopDate(l_WOfacModel.getActualStopDate());
			l_WOfacDTO.setCreationDate(l_WOfacModel.getCreationDate());
			l_WOfacDTO.setCreatedBy(l_WOfacModel.getCreatedBy());
			l_WOfacDTO.setModBy(l_WOfacModel.getModBy());
			l_WOfacDTO.setModOn(l_WOfacModel.getModOn());
			l_WOfacDTO.setStatus(l_WOfacModel.getStatus());
			l_WOfacDTO.setRemarks(l_WOfacModel.getRemarks());
			
			if(l_WOfacDTO.getStatus() == JCWMCommonServices.STATUS_VALID)
				l_WOfacDTO.setStatusCd(JCWMCommonServices.STATUS_VALID_CD);
			else if (l_WOfacModel.getStatus() == JCWMCommonServices.STATUS_INVALID)
				l_WOfacDTO.setStatusCd(JCWMCommonServices.STATUS_INVALID_CD);
			
		}
		catch (Exception e) 
		{
			throw e;
		}
		return l_WOfacDTO;
	}

	
	
	
	
	@SuppressWarnings("unused")
	private JCWMWOHistoryModel toModel(JCWMWorkOrderDTO l_WOfacDTO)
	{
		
		JCWMWOHistoryModel l_WOfacModel = new JCWMWOHistoryModel();
		try
		{
			l_WOfacModel.setWoNo(l_WOfacDTO.getWoNo());
			l_WOfacModel.setRequestId(l_WOfacDTO.getRequestId());
			l_WOfacModel.setRequestSourceId(l_WOfacDTO.getRequestSourceId());
			l_WOfacModel.setActualDuration(l_WOfacDTO.getActualDuration());
			l_WOfacModel.setDescription(l_WOfacDTO.getDescription());
			l_WOfacModel.setWoTypeId(l_WOfacDTO.getWoTypeId());
			l_WOfacModel.setWoTypeCd(l_WOfacDTO.getWoTypeCd());
			l_WOfacModel.setPrefStartDate(l_WOfacDTO.getPrefStartDate());
			l_WOfacModel.setScheduleStartDate(l_WOfacDTO.getScheduleStartDate());
			l_WOfacModel.setScheduleStopDate(l_WOfacDTO.getScheduleStopDate());
			l_WOfacModel.setActualStartDate(l_WOfacDTO.getActualStartDate());
			l_WOfacModel.setActualStopDate(l_WOfacDTO.getActualStopDate());
			l_WOfacModel.setCreationDate(l_WOfacDTO.getCreationDate());
			l_WOfacModel.setCreatedBy(l_WOfacDTO.getCreatedBy());
			l_WOfacModel.setModBy(l_WOfacDTO.getModBy());
			l_WOfacModel.setModOn(l_WOfacDTO.getModOn());
			l_WOfacModel.setStatus(l_WOfacDTO.getStatus());
			l_WOfacModel.setRemarks(l_WOfacDTO.getRemarks());
			

			if(l_WOfacDTO.getStatus() == JCWMCommonServices.STATUS_VALID)
				l_WOfacDTO.setStatusCd(JCWMCommonServices.STATUS_VALID_CD);
			else if (l_WOfacModel.getStatus() == JCWMCommonServices.STATUS_INVALID)
				l_WOfacDTO.setStatusCd(JCWMCommonServices.STATUS_INVALID_CD);
			
			
		}
		catch (Exception e) 
		{
			throw e;
		}
		
		
		
		return l_WOfacModel;
		
		

		
	}

	
	
	
	
	private List<JCWMWorkOrderDTO> toDTOList(List<JCWMWOHistoryModel> l_WOfacModel) 
	{

		List<JCWMWorkOrderDTO> l_WOfacDTOList = new ArrayList<>();
		
		if(l_WOfacModel==null || l_WOfacModel.isEmpty())
		{
			return null;
		}
		try
		{
			
			for(int i=0;i<l_WOfacModel.size();i++)
			{
				JCWMWorkOrderDTO l_WOfacDTO = new JCWMWorkOrderDTO();
				l_WOfacDTO.setWoNo(l_WOfacModel.get(i).getWoNo());
				l_WOfacDTO.setRequestId(l_WOfacModel.get(i).getRequestId());
				l_WOfacDTO.setRequestSourceId(l_WOfacModel.get(i).getRequestSourceId());
				l_WOfacDTO.setActualDuration(l_WOfacModel.get(i).getActualDuration());
				l_WOfacDTO.setDescription(l_WOfacModel.get(i).getDescription());
				l_WOfacDTO.setWoTypeId(l_WOfacModel.get(i).getWoTypeId());
				l_WOfacDTO.setWoTypeCd(l_WOfacModel.get(i).getWoTypeCd());
				l_WOfacDTO.setPrefStartDate(l_WOfacModel.get(i).getPrefStartDate());
				l_WOfacDTO.setScheduleStartDate(l_WOfacModel.get(i).getScheduleStartDate());
				l_WOfacDTO.setScheduleStopDate(l_WOfacModel.get(i).getScheduleStopDate());
				l_WOfacDTO.setActualStartDate(l_WOfacModel.get(i).getActualStartDate());
				l_WOfacDTO.setActualStopDate(l_WOfacModel.get(i).getActualStopDate());
				l_WOfacDTO.setCreationDate(l_WOfacModel.get(i).getCreationDate());
				l_WOfacDTO.setCreatedBy(l_WOfacModel.get(i).getCreatedBy());
				l_WOfacDTO.setModBy(l_WOfacModel.get(i).getModBy());
				l_WOfacDTO.setModOn(l_WOfacModel.get(i).getModOn());
				l_WOfacDTO.setStatus(l_WOfacModel.get(i).getStatus());
				l_WOfacDTO.setRemarks(l_WOfacModel.get(i).getRemarks());
				
				if(l_WOfacDTO.getStatus() == JCWMCommonServices.STATUS_VALID)
					l_WOfacDTO.setStatusCd(JCWMCommonServices.STATUS_VALID_CD);
				else if (l_WOfacDTO.getStatus() == JCWMCommonServices.STATUS_INVALID)
					l_WOfacDTO.setStatusCd(JCWMCommonServices.STATUS_INVALID_CD);
				
				l_WOfacDTOList.add(l_WOfacDTO);
			}
			
		}
		catch (Exception e) 
		{
			throw e;
		}
		return l_WOfacDTOList;
	}
	
	
}
