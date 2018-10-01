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

public class CreateNewBugTest {
	
	static Properties prop=new Properties();
	@BeforeTest
	public static void initializeProperties() throws IOException
	{
	
		FileInputStream fis= new FileInputStream("E:\\Java Experiment\\JIRA_RestAPI\\src\\main\\java\\com\\restapi\\Properties\\Environment.properties");
		prop.load(fis);
	}
	
	
	@Test(priority=2)
	public static void  createJiraSession(){
		
		RestAssured.baseURI=prop.getProperty("Host");
		Response rs=given().header("Content-Type", "application/json").
				header("Cookie","JSESSIONID="+ReusableMethod.getSessionKEY()).
				body(Payload.CreateJiraBug()).when().
				post(Resource.PostJiraCreateNewbug()).then().statusCode(201).extract().response();
				
				   JsonPath js= ReusableMethod.rawToJson(rs);
				   String id=js.get("id");
				   System.out.println("Bug Id "+id);
				
				}
		}