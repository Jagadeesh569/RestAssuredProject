package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;
import pojo.AddUser;

public class TestDataBuild {
	
	public AddUser addUserPayLoad(String name, String email)
	{
		
		AddUser a = new AddUser();
		a.setFirst_name(name);
		a.setLast_name("Bourne");
		a.setDateofBirth("01-01-1985");
		a.setGender("male");
		a.setAddress("newyork NY");
		a.setPhone("5173641121");
		a.setWebsite("https://gorest.co.in");
		a.setStatus("active");
		a.setEmail(email);
		return a;
	}
	
	public String deletePlacePayload(String placeId)
	{
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
	}

}
