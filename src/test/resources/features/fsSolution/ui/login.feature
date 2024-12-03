@Ui @logInPage
Feature: Login page validation

  Background:
    Given user open "getProp.Browser" browser
    Then user navigate to URL "getProp.FlairstechSolution"

  Scenario: Positive Scenario - Login to FlairstechSolution website with correct credentials
    When validate user is on "login" page
    And user set the username: "Admin"
    And user set the Password: "admin123"
    Then user click on "Login" button
    And user Click on Admin tab on the left side menu
    And user Get the number of records found
    And user Click on add button
    And user Fill the required data in Admin page
    And Verify that the number of records increased by 1
    And user Search with the username for the new user
    Then user delete the new user
    And Verify that the number of records decreased by 1


