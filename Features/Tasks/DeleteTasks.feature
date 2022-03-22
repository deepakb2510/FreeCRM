#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template


@tag
Feature: Verification of delete task(s) functionality
  I want to use this template for my feature file

  @tag1
  Scenario: To validate that the user is able to delete an existing task
    Given User is on the tasks page
    And User clicks on the delete button for the existing task in task module
    And User clicks on the cancel button in task module
    Then User is redirected to the tasks page and the deletion process is cancelled

  @tag2
  Scenario: To validate if the user is able to delete a task
  	Given User is on the tasks page
  	And User clicks on the delete button for the existing task in task module
  	And User clicks on the Delete button in task module
  	Then User is redirected to tasks page and task is deleted
