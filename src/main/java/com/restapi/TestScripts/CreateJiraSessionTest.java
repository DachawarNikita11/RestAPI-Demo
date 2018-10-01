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
public class CreateJiraSessionTest {

	static Properties prop=new Properties();
	@BeforeTest
	public static void initializeProperties() throws IOException
	{
	
		FileInputStream fis= new FileInputStream("E:\\Java Experiment\\JIRA_RestAPI\\src\\main\\java\\com\\restapi\\Properties\\Environment.properties");
		prop.load(fis);
	}
	
	
	@Test(priority=1)
	public static String  createJiraSession(){
		
		RestAssured.baseURI=prop.getProperty("Host");
		
		Response res=given().header("Content-Type", "application/json").
				body( "{ \"username\": \"XXXX\", \"password\": \"nikita123\" }").
				when().
				post(Resource.PostJiraCreateNewSession()).then().statusCode(200)
		        .extract().response();
	
          JsonPath  jsonResponse=ReusableMethod.rawToJson(res);
          
          String SessionId= jsonResponse.get("session.value");
          
          System.out.println("Session Id "+SessionId);
		return SessionId;
		
		
		
	}
}
