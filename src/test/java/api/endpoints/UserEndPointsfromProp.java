package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPointsfromProp {
	
	static ResourceBundle getUrl()
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes");
		return routes;
	}
	
	
	public static Response  createUser(User payload)
	{
		
		String post_Url=getUrl().getString("post_url");
		Response post_Res=given().accept(ContentType.JSON).contentType(ContentType.JSON).body(payload)
		.when().post(post_Url);
		
		return post_Res;
			
	}
	
	
	public static Response  readingUser(String userName)
	{
		String get_Url=getUrl().getString("get_url");
		Response get_Res=given().accept(ContentType.JSON)
				.pathParam("username", userName)
		.when().get(get_Url);
		
		return get_Res;
			
	}
	
	public static Response  updateUser(String userName,User payload)
	{
		String update_Url=getUrl().getString("update_url");
		Response update_Res=given().accept(ContentType.JSON).contentType(ContentType.JSON)
				.pathParam("username", userName).body(payload)
		.when().put(update_Url);
		
		return update_Res;
			
	}
	
	public static Response  deletingUser(String userName)
	{
		String delete_Url=getUrl().getString("delete_url");
		Response delete_Res=given().accept(ContentType.JSON)
				.pathParam("username", userName)
		.when().delete(delete_Url);
		
		return delete_Res;
			
	}

}
