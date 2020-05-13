package resources;

import java.util.List;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class JsonParser {
	
	public String getFirstName1(Response response,String key)
	{ 
		
		String val = response.asString();
		Object document = Configuration.defaultConfiguration().jsonProvider().parse(val);
		//System.out.println(" print ="+document);
		//int len = JsonPath.read(document, "$.result.length()");
		//System.out.println("Length is ="+len); 
		//String userID = JsonPath.read(document, "$.result.id");
		//System.out.println("ID is ="+userID);
		//System.out.println("fname  is ="+JsonPath.read(document, "$.result.first_name"));
		return  JsonPath.read(document, "$.result.first_name");
	}
	
	public String getFirstName(Response response) {
		String val = response.asString();
		Object document = Configuration.defaultConfiguration().jsonProvider().parse(val);
		List<String> names = JsonPath.read(document, "$.result[*].first_name");
		for (int k =0 ; k< names.size();k++) {
			//System.out.println("first name =  "+names.get(k));
		}
		return  JsonPath.read(document, "$['result'][0]['first_name']");
		
		
		
	}

}
