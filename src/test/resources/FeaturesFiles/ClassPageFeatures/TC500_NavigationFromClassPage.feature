@Navigation
Feature: Navigation Validation from Manage Class to other Pages
  
  Scenario: Class link on navigation bar
    When Admin clicks on Class link on Manage Class page
    Then Admin is redirected to class page

  @Navigation
  Scenario: Class link to other page on navigation bar
    When Admin clicks on any page link on Manage Class page
    Then Admin is redirected to which page link they clicked.

  @Navigation
  Scenario: Logout link on navigation bar
    When Admin clicks on Logout link on Manage class page
    Then Admin is redirected to Login page
