@login
Feature: Login  Page Verification 

Background:
        Given Admin is on login Page
    
  Scenario: Verify Admin is able to land on login page
  		Given The browser is open
  		When Admin gives the correct LMS portal URL
  		Then Admin should land on the login page
  		
  @validlogin
  Scenario: Validate login with valid data in all field	
  		Given Admin gives the correct LMS portal URL
  		When Admin enter valid username as "sdetnumpyninja@gmail.com" ,password as "Feb@2025" and role as "Admin" 
  		And clicks login button 

  #Data driven from Excel worksheet		
   Scenario Outline: Validate login with valid data in all field 
    Given Admin gives the correct LMS portal URL
    When Admin enter valid credentials from "<SheetName>" and <rowNumber>
    And clicks login button 
    Then Admin should land on home page

    Examples: 
      | SheetName  | rowNumber |
      | Login |   0 |

