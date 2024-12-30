package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	
	
	public static Response  createUser(User payload)
	{
		Response post_Res=given().accept(ContentType.JSON).contentType(ContentType.JSON).body(payload)
		.when().post(Routes.post_Url);
		
		return post_Res;
			
	}
	
	
	public static Response  readingUser(String userName)
	{
		Response get_Res=given().accept(ContentType.JSON)
				.pathParam("username", userName)
		.when().get(Routes.get_Url);
		
		return get_Res;
			
	}
	
	public static Response  updateUser(String userName,User payload)
	{
		Response update_Res=given().accept(ContentType.JSON).contentType(ContentType.JSON)
				.pathParam("username", userName).body(payload)
		.when().put(Routes.update_Url);
		
		return update_Res;
			
	}
	
	public static Response  deletingUser(String userName)
	{
		Response delete_Res=given().accept(ContentType.JSON)
				.pathParam("username", userName)
		.when().delete(Routes.delete_Url);
		
		return delete_Res;
			
	}

}
