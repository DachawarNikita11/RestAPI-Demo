package com.restapi.Util;

public class Payload {
	
	public  static String getSessiondata(){
		
		String Getsessiondata="{ \"username\": \"XXXXX\"+ \"password\": \"nikita123\" }";
		
		return Getsessiondata;
		
		
	}
	
	public static String CreateJiraBug(){
		
		String createjirabug="{"+
			    "\"fields\": {"+
			       "\"project\":{"+
			          "\"key\": \"RES\""+
			       "},"+
			       "\"summary\": \"Issue 5 for adding comment\","+
			       "\"description\": \"Creating my second bug\","+
			       "\"issuetype\": {"+
			          "\"name\": \"Bug\""+
			       "}"+
			   "}}";
		return createjirabug;
		
		
	}
	
public static String AddingCommentToTheBug(){
		
		String AddingCoomentToTheBug="{"+
				"\"body\": \"Inserting comment from the automation code\","+
			    "\"visibility\": {"+
			        "\"type\": \"role\","+
			        "\"value\": \"Administrators\" }";
		return AddingCoomentToTheBug;
		
	
	}

}
