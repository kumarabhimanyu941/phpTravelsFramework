package com.qa.phpTravels.util;

public class AppConstants {

	public final static String titleText = "Client Area - PHPTRAVELS";
	public final static int WebDriver_Wait_TimeOut = 20;
	public final static String Login_Page_Title = "Client Area - PHPTRAVELS";
	public static final String Home_Page_Message = "Login This page is restricted";
	public static final String Register_Page_Message = "Create an account with us . . .";
	public static final String Register_Page_Sheet_Name = "register";
	
	
	//mySQL DB details
	
	public final static String mysqldriver ="com.mysql.jdbc.Driver";
	public final static String mysqlusername="root";
	public final static String mysqlpassword="root";
	public final static String mysqlurl="jdbc:mysql://localhost:3306/DBname";
	public final static String mysqlquery="select * from purl_attributes where token=''";
}
