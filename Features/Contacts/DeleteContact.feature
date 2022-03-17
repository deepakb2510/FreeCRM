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
Feature: Verification of delete contact(s) functionality
  I want to use this template for my feature file

  @tag1
  Scenario: To validate whether the user has an option to delete contact(s) if required.
  
    Given User is on the Contacts page
    And User clicks on required Contact
		And User clicks on the Delete button
		When A delete confirmation pops up
		And User clicks on Delete
    Then Selected Contact(s) are deleted

  @tag2
  Scenario Outline: To validate whether the user is able to Cancel the deletion process if requred.
    Given User is on the Contact page
		And User clicks on the Delete button on the required contact
		When A delete confirmation pops up
		And User clicks on Delete
		And User clicks on Cancel		
	  Then User is redirected to the Contacts page
	  
	  
//ts 35
