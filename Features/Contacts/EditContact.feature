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
Feature: Verification of edit contact(s) functionality.
  I want to use this template for my feature file
  
Background: User is logged into FreeCRM and on the Contacts page 

  @tag1
  Scenario: To validate whether the user is redirected to the Contact detail page  of the selected Contact when the user clicks on the edit button.    Given I want to write a step with precondition
    Given User is on the Contacts page
		And User clicks on the Edit button
		And User enters Middle Name with <"<middlename>">
		And User on the Save button
    Then User is redirected to Contact details page and is able to see the changes made
    
    Examples: 
      | middlename  |
      | samanta     |
    
  @tag2
  Scenario Outline: To validate if the user is able to cancel the edit Contact process if required
    Given User is on the Contact page
		And User clicks on the Edit button on the required contact
		And User clicks on Cancel		
	  Then User is redirected to the Contacts page
	  
	  //tc 100
    