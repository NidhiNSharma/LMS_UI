Feature: Batch Page validation 
 
 Background:
 Given Admin is logged in to LMS Portal
    

  Scenario: Validate Title in Batch Page
  	Given Admin is on the home Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the "LMS - Learning Management System" Title
  

  Scenario: Validate heading in the Batch Page
  	Given Admin is on the home Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the "Manage Batch" Heading
    

  Scenario: Validate disabled Delete Icon under the header in the Batch Page
  	Given Admin is on the home Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the disabled Delete Icon under the header
           

  Scenario: Validate pagination in the Batch Page
  	Given Admin is on the home Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the enabled pagination controls under the data table
    

  Scenario: Validate Checkbox in the Datatable header row
  	Given Admin is on the home Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the checkbox in the datatable header row
    

  Scenario Outline: Validate Datatable headers
  	Given Admin is on the home Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the datatable headers <List>
  Examples:
	|List|
	|""|
	|"Batch Name"|
	|"Batch Description"|
	|"Batch Status"|
	|"No Of Classes"|
	|"Program Name"| 
	|"Edit / Delete"|  
	

  Scenario: Validate sort icon next to all the datatable header
  	Given Admin is on the home Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the sort icon next to all Datatable headers
    


  Scenario: validate checkbox in each data rows
  	Given Admin is on the home Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the checkbox in each row 
 

  Scenario: validate delete icon in each data rows
  	Given Admin is on the home Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the delete icon in each row   

  Scenario: Validate edit icon in each data rows
  	Given Admin is on the home Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the edit icon in each row
   
    