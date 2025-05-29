@home
Feature: Home Page Validations for LMS

  Background: 
    Given Admin is logged in to LMS Portal
    
  Scenario: Verify LMS title
    Given Admin is in Homepage 
    When Admin enter valid data in all field and  clicks login button
    Then Admin should see "LMS - Learning Management System" as the title