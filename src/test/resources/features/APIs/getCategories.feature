Feature: Server should return all categories for get categories request

	Scenario: Verify server returns all categories
	
		Given client have valid authorization token
		When client sends get categories request with all valid required parameters
		Then server should respond with 200 ok 
		And all categories available
		
	Scenario: Verify server returns 400 error code and error response for missing required parameters
	
		Given client have valid authorization token
		When client sends get categories request with missing required  parameters
		Then server should respond with 400 resposne code and error description
		
	Scenario: Verify server returns 400 error for invalid http method
	
		Given client have valid authorization token
		When client sends get categories request by post method
		Then server should respond with 400 resposne code