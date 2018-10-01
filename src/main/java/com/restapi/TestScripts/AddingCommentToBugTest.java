package com.restapi.TestScripts;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.restapi.Util.Payload;
import com.restapi.Util.Resource;
import com.restapi.Util.ReusableMethod;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AddingCommentToBugTest {
	
// post request to add comment in the bug
	
	static Properties prop=new Properties();
	@BeforeTest
	public static void initializeProperties() throws IOException
	{
	
		FileInputStream fis= new FileInputStream("E:\\Java Experiment\\JIRA_RestAPI\\src\\main\\java\\com\\restapi\\Properties\\Environment.properties");
		prop.load(fis);
	}
	
	
	@Test(priority=3)
	public static void  Addingcommenttothebug(){
		
		RestAssured.baseURI= "http://localhost:8080";
		Response res=given().header("Content-Type", "application/json").
		header("Cookie","JSESSIONID="+ReusableMethod.getSessionKEY()).
		pathParams("bugid",ReusableMethod.GetBugID()).
		body("{ \"body\": \"Inserting comment from the automation code\","+
    "\"visibility\": {"+
        "\"type\": \"role\","+
        "\"value\": \"Administrators\" }"+
"}").when().
		post("/rest/api/2/issue/{bugid}/comment/").then().statusCode(201).extract().response();
		   JsonPath js= ReusableMethod.rawToJson(res);
		   String id=js.get("id");
		   System.out.println("Comment id "+id);
		
		
		
		
		
		
		
		
		
		
		
		  
		
				
		
		
		
		}
}
