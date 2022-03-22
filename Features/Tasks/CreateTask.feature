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
Feature: Verification of a create a new task functionality
  I want to use this template for my feature file
  
  @tag1
  Scenario: To validate that redirection happens to the task details page if the create task button is clicked and user is able to create a task successfully
    Given User is on the tasks page
    And User clicks on the create tasks button
    Then User is redirected to the create tasks page

	@tag2
	Scenario: To validate if the user has entered details in the all mandatory field
		Given User is on the tasks page
		And User clicks on the create tasks button
		And User enters the title of the task with <"<tasktitle>">
		And User clicks on the save button in task module
		Then User is redirected to the task details page which is created
    Examples: 
      |tasktitle|
      |demo7|
		
	@tag4
	Scenario: To check that user has to enter all the mandatory fields
		Given User is on the tasks page
		And User clicks on the create tasks button
		And User clicks on the save button in task module
		Then User is displayed a warning text in task module
