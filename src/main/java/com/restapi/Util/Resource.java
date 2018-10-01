package com.restapi.Util;

public class Resource {

	public static String PostJiraCreateNewSession(){
		
		String res="/rest/auth/1/session";
		return res;
		
		
	}
public static String PostJiraCreateNewbug(){
		
		String res="/rest/api/2/issue";
		return res;
		
		
	}
public static String UpdatingComments(){
	
	String UpdateComment="/rest/api/2/issue/"+ReusableMethod.GetBugID()+"/comment/";
	return UpdateComment;
	
}

}