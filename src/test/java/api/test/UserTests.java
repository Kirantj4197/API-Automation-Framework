package api.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	
	Faker faker;
	User userPayload;
	
	@BeforeClass
	public void setUp()
	{
		faker=new Faker();
		userPayload=new User();
		 userPayload.setId(faker.idNumber().hashCode());
		 userPayload.setUsername(faker.name().username());
		 userPayload.setFirstName(faker.name().firstName());
		 userPayload.setLastName(faker.name().lastName());
		 userPayload.setPassword(faker.internet().password());
		
	}
	
	@Test(priority=1)
	public void testPostUser()
	{
		Response res=UserEndPoints.createUser(userPayload);
		res.then().log().all();
	}
	
	@Test(priority=2)
	public void getUserByName()
	{
		Response resp=UserEndPoints.readingUser(this.userPayload.getUsername());
		resp.then().log().all();
	}
	
	@Test(priority=3)
	public void updateUserByName()
	{
		 userPayload.setFirstName(faker.name().firstName());
		 userPayload.setLastName(faker.name().lastName());
		 userPayload.setPassword(faker.internet().password());
		 
		Response respo=UserEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
		respo.then().log().all();
		
	}
	
	
	@Test(priority=4)
	public void deleteUserByName()
	{
		Response respon=UserEndPoints.deletingUser(this.userPayload.getUsername());
	}

}
