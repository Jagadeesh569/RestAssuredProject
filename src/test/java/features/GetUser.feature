Feature: Get user API

Scenario Outline: Get user details by sending ID in the request URL
	Given GetUserAPI request with "<paramName>" and "<paramValue>"
	When user calls "GetUserAPI" with "GET" http request
	Then the API call got success with status code 200
	Examples:
	| paramName | paramValue |
	| first_name | Boris |