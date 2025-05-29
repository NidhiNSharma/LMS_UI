@program
Feature: Program Page Validation

  Background: 
    Given Admin is logged in to LMS Portal

  #Navigation
  Scenario: Verify that Admin is able to navigate to Program page
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should be navigated to Program page
    
   #1 Menu Bar Logout
  Scenario: Verify Logout displayed in menu bar
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see Logout in menu bar
    
  #3 Tabs in Header
  Scenario: Verify other page's name displayed in menu bar
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the page names as in order "Home Program Batch Class "
  
  #4 subMenu Add new program 
  Scenario: Verify sub menu displayed in program menu bar
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see sub menu in menu bar as "Add New Program"
    
  #5 Manage Program
  Scenario: Verify heading in manage program
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the heading as "Manage Program"
    
  #6 Manage Program Details
  Scenario: Verify view details of programs
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should able to see Program name, description, and status for each program
    
  #7 Deletebutton
  Scenario: Verify the Multiple Delete button state 
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see a Delete button in left top is disabled
    
  #8 Search
  Scenario: Verify the Search button  
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see Search bar with text as "Search..."
    
  #9 data Table Headers
  Scenario: Verify column header name of data table  
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see data table on the Manage Program Page with column headers
   

  #10 checkbox
  Scenario: Verify checkbox default state beside Program Name column header
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see checkbox default state as unchecked beside Program Name column header 
  
  #11 unchecked checkbox
  Scenario: Verify checkboxes default state beside each Program names in the data table   
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see check box default state as unchecked on the left side in all rows against program name 
  
  #12 sort icon
  Scenario: Verify Sort icon in manage program  
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the sort arrow icon beside to each column header except Edit and Delete 
  
  #13 Edit Delete
  Scenario: Verify edit and delete icon in manage program  
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the Edit and Delete buttons on each row of the data table
    
  #14 Total Entries
  Scenario: Verify pagination icons below data table in manage program  
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then "Admin should see the text as ""Showing x to y of z entries"" along with Pagination icon below the table. 

  #15 footer
  Scenario: Verify footer message in manage program  
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the footer as ""In total there are z programs"".
    
  
  


