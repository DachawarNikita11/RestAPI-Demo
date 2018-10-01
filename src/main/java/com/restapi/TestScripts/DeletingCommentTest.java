package com.restapi.TestScripts;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.restapi.Util.ReusableMethod;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeletingCommentTest {
	static Properties prop=new Properties();
	
	@BeforeTest
	public static void initializeProperties() throws IOException
	{
	
		FileInputStream fis= new FileInputStream("E:\\Java Experiment\\JIRA_RestAPI\\src\\main\\java\\com\\restapi\\Properties\\Environment.properties");
		prop.load(fis);
	}
	
	//deleting the Added Comment
	
		   @Test(priority=4)
			public static void  deletecomment(){
				
				RestAssured.baseURI= "http://localhost:8080";
				Response res=given().header("Content-Type", "application/json").
				header("Cookie","JSESSIONID="+ReusableMethod.getSessionKEY()).
				pathParams("bugid",ReusableMethod.GetBugID()).
			when().
				delete("/rest/api/2/issue/{bugid}").then().statusCode(204).extract().response();
				System.out.println("Comment Deleted");
						
				
				
				}
}




