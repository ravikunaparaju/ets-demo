Feature: Server should return product details for a product by id

	Scenario: Verify server returns product details 
	
		Given client have valid authorization token
		When client sends get product details request with all valid required parameters
		Then server should respond with 200 ok 
		And product details information 
		
	Scenario: Verify server returns 400 error code and error response for missing required parameters
	
		Given client have valid authorization token
		When client sends get product details request with missing required  parameters
		Then server should respond with 400 resposne code and error description
		
	Scenario: Verify server returns 400 error for invalid http method
	
		Given client have valid authorization token
		When client sends get product details request by post method
		Then server should respond with 400 resposne code