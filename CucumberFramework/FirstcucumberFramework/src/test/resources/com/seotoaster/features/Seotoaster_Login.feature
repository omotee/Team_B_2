Feature:  Validate login functionality of the Seotoaster web application
	As a customer
	I want to login to the web application
	So I can purchase bike


Scenario: Validate with valid username and valid password
	Given that a customer is on the homepage
	When he logs on with username as "demo@seotoaster.com" and password as "demo"
	Then he should be on the landing page
	
	

	
	 

