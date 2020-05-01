package com.wfm.common;

import java.io.File;
import java.sql.Connection;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonObject;
import com.wfm.server.workorder.dto.JCWMWOHistCriteriaDTO;

//import java.sql.SQLException;
//import java.sql.PreparedStatement;
import factory.JCConnectionFactory;


public class JCWMCommonServices 
{
	public static final String RETURN_FAILURE = null;
	public static final String RETURN_SUCCESS = null;
	public static final int STATUS_VALID = 0;
	public static final String STATUS_VALID_CD = null;
	public static final int STATUS_INVALID = 0;
	public static final String STATUS_INVALID_CD = null;

	public static JCConnectionFactory i_connFactory = null;
	
	//private static Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy HH:mm:ss").setPrettyPrinting().create();


	public static void createPool() throws Exception
	{
		
		String l_configFile = System.getProperty("user.dir")+"\\config\\config.properties";
		
		try 
		{
			if(l_configFile==null)
			{
				throw new Exception("Connection Pool Configuration File not available");
			}
			
			i_connFactory = JCConnectionFactory.getInstance(l_configFile);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("Create Pool Exception");
		}
		
	}
	
	
	
	
	public static Connection getConnection() throws Exception
	{
		if(i_connFactory==null)
		{
			throw new Exception("ConnectionFactory Object Not Initialized");
		}
		Connection l_conn=null;
		l_conn = i_connFactory.getMySQLConnection();
		

		return l_conn;
	}




//	public static String getJSONfromObj(Object sourceObj)
//	{
//		return gson.toJson(sourceObj);
//
//	}
//	

}
