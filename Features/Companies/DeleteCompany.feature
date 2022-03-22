 
 
  
@DeleteCompany
Feature: Verification of delete a company functionality
  I want to use this template for my feature file
  
Background: User is on FreeCRM page 

  @Delete
  Scenario: To validate whether user is able to delete company after clicking on delete button/
    Given User is Logged in and is in Companies Module
    And User clicks on Delete button in Companies Module
    And User clicks on Confirm Delete in Companies Module
    Then Company should get deleted and user is back on Companies module

    @CancelDeletion
  Scenario: To validate user is able to cancel the deletion process if required.
    Given User is Logged in and is in Companies Module
    And User clicks on Delete button in Companies Module
    And User clicks on Cancel button in Companies Module
    Then Company should not get deleted and user is back on Companies module