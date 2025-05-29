Feature: Class Page Validation

  Background: 
    Given Admin is logged in to LMS Portal
    And Admin is on home page after Login
    When Admin clicks on the "Class" navigation bar
    
    # @ClassNavigation
  Scenario: Navigate to Manage Class Page and Verify title,header and Search Bar
    Then Admin should see "LMS - Learning Management System" as the title
    And Admin should see "Manage Class" as the page header
    And Admin should see the search bar

 # @ClassPage
  Scenario: Verify Data Table Headers and Sort Icons of all the fields
    Then Admin should see the datatable heading like Batchname,class topic,class description,status,class Date,staff name,Edit/Delete 
    And Admin should see the Sort icon of all the field in the datatable.


 # @ClassCheckBoxes
  Scenario: Verify Checkboxs default state beside Batch Name column header and beside each Batch Name in the data table
    Then Admin should see Checkbox default state as unchecked beside Batch Name column header
    And Admin should see Checkboxs default state as unchecked on the left side in all rows against Batch Name

  #@ClassPagination
  Scenario: Verify Pagination Controls and Text
    Then Admin should see the text " showing x to y of z entries" 
    And enabled pagination controls under the data table
    And Admin should see "Total Classes: <number>" text at the bottom of the page

  #@ClassDelete
  Scenario: Verify DELETE Button and Total Classes Count
    Then Admin should see a DELETE button under the Manage Class page header
 
    
    
 