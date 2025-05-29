Feature: Add New Class

  Background: 
    Given Admin is logged in to LMS Portal
    And Admin is on home page after Login
    When Admin clicks on the "Class" navigation bar

  @AddNewClass
  Scenario: Validate Class Details Popup window, input fields and their text boxes in Class details form
    When Admin clicks on add new class under the class menu bar
    Then Admin should see a popup open for class details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window

  @AddNewClassPopup
  Scenario: Check if Class is created when only mandatory fields are entered with valid data
    Given Admin is on the Class Popup window
    When Admin enters mandatory fields in the form and clicks on save button
    Then Admin gets message Class added Successfully

  @AddNewClassPopup
  Scenario: Check no classes value added when selecting class dates  
    When Admin selects Class Date in date picker
    Then Admin should see number of Class value is added automatically

  @AddNewClassPopup
  Scenario: Check weekend dates are disabled in calendar
    When Admin clicks date picker
    Then Admin should see weekends dates are disabled to select

  @AddNewClassPopup
  Scenario: Check if class is created when only optional fields are entered with valid data 
    When Admin skips to add value in mandatory field and enter only the optional field
    Then Admin should see error message below the test field and the field will be highlighted in red color

  @AddNewClassPopup
  Scenario: check if class is created when invalid data is entered in all of the fields    
    When Admin enters invalid data in all of the  fields in the form and clicks on save button
    Then Admin gets error message and class is not created

  @AddNewClassPopup
  Scenario: Empty form submission
    Given Admin is on the Class Popup window
    When Admin clicks on save button without entering data
    Then Class will not  created and Admin gets error message

  @AddNewClassPopup
  Scenario: Validate Cancel icon on class Details form
    Given Admin is on the Class Popup window
    When Admin clicks Cancel Icon on Class Details form
    Then Class Details popup window should be closed without saving

  @AddNewClassPopup
  Scenario: Validate Save button on Class Details form
    Given Admin is on the Class Popup window
    When Admin clicks save button
    Then Admin can see the class details popup closed and adding new class
