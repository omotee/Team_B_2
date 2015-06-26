#@regression
Feature: Validate login functionality of the Seotoaster web application
  As a customer
  I want to login to the web application
  So I can purchase bike

#  @regression @smoke
  Scenario Outline: Validate with username and password
    Given that a customer is on the home page
    When he logs on with username as "<username>" and password as "<password>"
    Then he should see "<result>" on the landing page
   
   Examples: 
  |username							|password			|result			| 
  |demo@seotoaster.com				|demo				|LOGOUT			|
 # |dexx@seotoaster.com				|demo				|There is no	|
 # |demo@seotoaster.com				|xxmo				|There is no	|
 # |									|					|				|


 