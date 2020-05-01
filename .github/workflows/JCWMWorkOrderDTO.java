/******************************************************************************************************************************
* Class Name : JCWMWorkOrderDTO.java
* File Path : src.com.wfm.server.workorder.dto
* Copyright : Usha Martin Technologies Pvt Ltd
* Author : Sabyasachi.Nath
* Project Name : WFMProj
* Creation Date : Feb 19, 2019
* Purpose : 
* =============================================================================================================================
													Change History
* =============================================================================================================================
* SL 			ID 					Date 				By 									Description
* =============================================================================================================================
******************************************************************************************************************************/

package com.wfm.server.workorder.dto;

import java.util.Date;

public class JCWMWorkOrderDTO
{
	private long woNo;
	private long requestId;
	private long woTypeId;
	private String woTypeCd;
	private int requestSourceId;
	private int status;
	private String statusCd;
	private String description;
	private String createdBy;
	private Date creationDate;
	private Date scheduleStartDate;
	private Date scheduleStopDate;
	private Date actualStartDate;
	private Date actualStopDate;
	private long actualDuration; 
	private Date prefStartDate;
	private String modBy;
	private Date modOn;
	private String remarks;

	
	public String getStatusCd() {
		return statusCd;
	}

	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}

	public long getWoNo()
	{
		return woNo;
	}

	public void setWoNo(long woNo)
	{
		this.woNo = woNo;
	}

	
	public int getRequestSourceId()
	{
		return requestSourceId;
	}

	public void setRequestSourceId(int requestSourceId)
	{
		this.requestSourceId = requestSourceId;
	}
	
	
	public Date getActualStartDate()
	{
		return actualStartDate;
	}
	public void setActualStartDate(Date actualStartDate)
	{
		this.actualStartDate = actualStartDate;
	}
	
	
	
	public Date getActualStopDate()
	{
		return actualStopDate;
	}

	public void setActualStopDate(Date actualStopDate)
	{
		this.actualStopDate = actualStopDate;
	}

	
	
	public long getActualDuration()
	{
		return actualDuration;
	}

	public void setActualDuration(long actualDuration)
	{
		this.actualDuration = actualDuration;
	}
	
	
	
	public Date getScheduleStartDate()
	{
		return scheduleStartDate;
	}

	public void setScheduleStartDate(Date scheduleStartDate)
	{
		this.scheduleStartDate = scheduleStartDate;
	}

	
	public Date getScheduleStopDate()
	{
		return scheduleStopDate;
	}

	public void setScheduleStopDate(Date scheduleStopDate)
	{
		this.scheduleStopDate = scheduleStopDate;
	}

	
	
	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	
	public String getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	
	
	public Date getCreationDate()
	{
		return creationDate;
	}

	public void setCreationDate(Date creationDate)
	{
		this.creationDate = creationDate;
	}


	
	public long getWoTypeId()
	{
		return woTypeId;
	}

	public void setWoTypeId(long woTypeId)
	{
		this.woTypeId = woTypeId;
	}

	
	
	public String getWoTypeCd()
	{
		return woTypeCd;
	}

	public void setWoTypeCd(String woTypeCd)
	{
		this.woTypeCd = woTypeCd;
	}

	
	public long getRequestId()
	{
		return requestId;
	}

	public void setRequestId(long requestId)
	{
		this.requestId = requestId;
	}

	
	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

	public Date getPrefStartDate()
	{
		return prefStartDate;
	}

	public void setPrefStartDate(Date prefStartDate)
	{
		this.prefStartDate = prefStartDate;
	}
	
	
	
	public String getModBy()
	{
		return modBy;
	}

	public void setModBy(String modBy)
	{
		this.modBy = modBy;
	}
	
	
	public Date getModOn()
	{
		return modOn;
	}

	public void setModOn(Date modOn)
	{
		this.modOn = modOn;
	}
	
	
	
	public String getRemarks()
	{
		return remarks;
	}

	public void setRemarks(String remarks)
	{
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "JCWMWorkOrderDTO [woNo=" + woNo + ", requestId=" + requestId + ", woTypeId=" + woTypeId + ", woTypeCd="
				+ woTypeCd + ", requestSourceId=" + requestSourceId + ", status=" + status + ", statusCd=" + statusCd
				+ ", description=" + description + ", createdBy=" + createdBy + ", creationDate=" + creationDate
				+ ", scheduleStartDate=" + scheduleStartDate + ", scheduleStopDate=" + scheduleStopDate
				+ ", actualStartDate=" + actualStartDate + ", actualStopDate=" + actualStopDate + ", actualDuration="
				+ actualDuration + ", prefStartDate=" + prefStartDate + ", modBy=" + modBy + ", modOn=" + modOn
				+ ", remarks=" + remarks + "]";
	}

}