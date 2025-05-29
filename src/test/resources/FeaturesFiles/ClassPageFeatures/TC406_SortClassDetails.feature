@ASortClass
Feature: Sort Class Details

  Background: 
    Given Admin Is on the Manage Class Page after login

  Scenario: Sort Class by Batch Name
    When Admin clicks on the Batch Name sort icon
    Then Admin should see Class details are sorted by Batch Name

  @SorttClass
  Scenario: Sort Class by Class topic
    When Admin clicks on the Class topic sort icon
    Then Admin should see Class details are sorted by Class Topic

  @SorttClass
  Scenario: Sort Class by Class Description
    When Admin clicks on the Class Description sort icon
    Then Admin should see Class details are sorted by Class Description

  @SorttClass
  Scenario: Sort Class by Status
    When Admin clicks on the Status sort icon
    Then Admin should see Class details are sorted by Status

  @SorttClass
  Scenario: Sort Class by Class date
    When Admin clicks on the Class Date sort icon
    Then Admin should see Class details are sorted by Class Date

  @SorttClass
  Scenario: Sort Class by staff name
    When Admin clicks on the Staff Name sort icon
    Then Admin should see Class details are sorted by Staff Name
