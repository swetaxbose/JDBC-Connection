package com.wfm.server.workorder.dto;

import java.util.Date;


//Input DTO Class
public class JCWMWOHistCriteriaDTO 
{
	
		private long workOrderNo;
		private String createdBy;
		private Date startDate;
		private Date stopDate;
		
		
		public long getworkOrderNo()
		{
			return workOrderNo;
		}
		public void setworkOrderNo(long workOrderNo)
		{
			this.workOrderNo = workOrderNo;
		}
		
		
		public String getcreatedBy()
		{
			return createdBy;
		}
		public void setcreatedBy(String createdBy)
		{
			this.createdBy = createdBy;
		}
		
		
		public Date getstartDate() 
		{
			return startDate;
		}
		public void setstartDate(Date startDate) 
		{
			this.startDate =startDate;
		}
		
		
		public Date getstopDate() 
		{
			return stopDate;
		}
		public void setstopDate(Date stopDate) 
		{
			this.stopDate =stopDate;
		}
}
