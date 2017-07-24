Feature: Server adds product to cart

	Scenario: Verify server adds product to cart 
	
		Given client have valid authorization token
		When client sends add to cart request
		Then server should respond with 200 ok response
		And product successfully added to cart message response
		
	Scenario: Verify server returns 400 error code and error response for missing required parameters
	
		Given client have valid authorization token
		When client sends add to cart request with missing required  parameters
		Then server should respond with 400 resposne code and error description
		
	Scenario: Verify server returns 400 error for invalid http method
	
		Given client have valid authorization token
		When client sends add to cart request by get method
		Then server should respond with 400 resposne code