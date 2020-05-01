//Class for Model (Represents database table)
//Class for Data Transfer Object (DTO - data from client to server)
//Interface for Data Access Object (DAO - method for data manipulation in server)
//Singleton for DAO Implementation
//Class Facade (conversion of DTO to Model and vice versa - top level of server)

//populate the table with some sample data (10 data)
//
//1. write a main class. 
//2. create an object of facade
//3. from where call the methods of the facade, check the result






import com.wfm.common.JCWMCommonServices;
import com.wfm.server.workorder.dto.JCWMWOHistCriteriaDTO;
import com.wfm.server.workorder.dto.JCWMWorkOrderDTO;
import com.wfm.server.workorder.facade.JCWMWOHistoryFacade;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class cs_sql
{
	
	public static void main(String[] args) throws Exception 
	{

		
		try
		{
			
			JCWMCommonServices.createPool();
			//JCWMCommonServices.getConnection();

			
			JCWMWOHistoryFacade l_WOfac = new JCWMWOHistoryFacade();
			
			long woNo1 = 25734;
			
			JCWMWOHistCriteriaDTO histCriteriaDTO = new JCWMWOHistCriteriaDTO();
			
			String startD ="10-April-2019 17:11:00";
			String stopD = "10-May-2019 12:27:52";
			
			SimpleDateFormat format =new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
			Date start= format.parse(startD);
			Date stop=format.parse(stopD);
		
			
			String createdby = "Swaraj_RunService";
			
			histCriteriaDTO.setstartDate(start);
			histCriteriaDTO.setstopDate(stop);
			histCriteriaDTO.setcreatedBy(createdby);
			//String data = JCWMCommonServices.getJSONfromObj(histCriteriaDTO);

			JCWMWorkOrderDTO val = null;
			
			val = l_WOfac.retrieveWOHistory(woNo1);
			
			System.out.println(val.toString());
			
			List<JCWMWorkOrderDTO> list1 = l_WOfac.retrieveByDateRange(histCriteriaDTO);
			
			System.out.println(list1.toString());
			
			
			//System.out.println(l_WOfac.retrieveByDateRangeCreatedBy(histCriteriaDTO));
			
			List<JCWMWorkOrderDTO> list2 = l_WOfac.retrieveByDateRangeCreatedBy(histCriteriaDTO);
			System.out.println(list2.toString());
			
			//...System.out.println(JCWMCommonServices.getJSONfromObj(val));
			
			//...System.out.println( l_WOfac.retrieveByDateRange(data));
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

}
