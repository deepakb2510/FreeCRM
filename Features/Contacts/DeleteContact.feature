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
#@tag
#Feature: Verification of delete contact(s) functionality
  #I want to use this template for my feature file
#
@tag
Feature: Verification of delete Contact(s) functionality
  I want to use this template for my feature file

Background: User is logged into FreeCRM and on the Contacts page   
@tag1
  Scenario: To validate that the user is able to delete an existing Contact
    Given User is on the contacts page and wants to delete an existing contact
    And User clicks on the delete button for the existing contact
    And A delete confirmation pops up
    And User clicks on Delete
		Then The required contact is deleted and user is redirected to the Contacts page   
	@tag2
  Scenario Outline: To validate whether the user is able to Cancel the deletion process if requred
    Given User is on the Contact page and wants to cancel the deletion process
		And User clicks on the delete button on the required contact
		And A delete confirmation pops up after clicking the delete button
		And User clicks on Cancel button
	  Then User is redirected to the Contacts page and the deletion process is cancelled