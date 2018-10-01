package com.restapi.Util;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class ReusableMethod {

	public static JsonPath rawToJson(Response r)
	{ 
		String respon=r.asString();
		JsonPath x=new JsonPath(respon);
		return x;
	}
	
	public static String getSessionKEY()
	{
		RestAssured.baseURI= "http://localhost:8080";
		Response res=given().header("Content-Type", "application/json").
		body("{ \"username\": \"XXXXX\", \"password\": \"nikita123\" }").
		when().
		post("/rest/auth/1/session").then().statusCode(200).
		extract().response();
		 JsonPath js= ReusableMethod.rawToJson(res);
		String sessionid= js.get("session.value");
		return sessionid;
	}
	
	public static String GetBugID(){
	
		RestAssured.baseURI="http://localhost:8080";
		Response rs=given().header("Content-Type", "application/json").
				header("Cookie","JSESSIONID="+ReusableMethod.getSessionKEY()).
				body(Payload.CreateJiraBug()).when().
				post(Resource.PostJiraCreateNewbug()).then().statusCode(201).extract().response();
				
				   JsonPath js= ReusableMethod.rawToJson(rs);
				String id=js.get("id");
				   System.out.println(id);
				return id;
	}
	
	
public static String GetCommentID( ){
		
	RestAssured.baseURI= "http://localhost:8080";
	Response res=given().header("Content-Type", "application/json").
	header("Cookie","JSESSIONID="+ReusableMethod.getSessionKEY()).
	//pathParams("bugid",ReusableMethod.GetBugID()).
	body("{ \"body\": \"Inserting comment from the automation code\","+
"\"visibility\": {"+
    "\"type\": \"role\","+
    "\"value\": \"Administrators\" }"+
"}").when().
	post(Resource.UpdatingComments()).then().statusCode(201).extract().response();
	   JsonPath js= ReusableMethod.rawToJson(res);
	   String Commentid=js.get("id");
	   System.out.println(Commentid);
	return Commentid;
	
	}
}
