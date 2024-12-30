package api.test;

import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	
	
	
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostUser(String userId,
			String uName,String fName,String Lname,String email,String pwd,String phone)
	{
		
		User userPayload=new User();
		
		 userPayload.setId(Integer.parseInt(userId));
		 userPayload.setUsername(uName);
		 userPayload.setFirstName(fName);
		 userPayload.setLastName(Lname);
		 userPayload.setPassword(pwd);
		userPayload.setPhone(phone);
		
		
		Response res=UserEndPoints.createUser(userPayload);
	}
	
	
	@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void deleteByName(String uName)
	{
		
		Response res=  UserEndPoints.deletingUser(uName);
		
	}

	
	
	
	
	
}
