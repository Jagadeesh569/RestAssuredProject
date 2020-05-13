Feature: Create user API test

@AddPlace @Regression
Scenario Outline: Verify if user is being Succesfully created using createUserAPI
	Given Create User Payload with "<name>" "<email>"
	When user calls "CreateUserAPI" with "POST" http request
	Then the API call got success with status code 302
	And verify first_name created maps to "<name>" using "GetUserAPI"
Examples: 
	| name | email |
	| Sachin | sachingbcci@gmail.com |
	| Ganguly | gangulybcci@gmail.com |
	| Dravid | dravidbcci@gmail.com |
	


	

	
	
	
	
	
	

	
	
	