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
Feature: Verification of add filter to Contact functionality
  I want to use this template for my feature file
 
Background: User is logged into FreeCRM and on the Contacts page  

  @tag1
  Scenario: To validate that the user can filter the contacts based on various criterias
    Given User is on the Contacts page and applying filters
    And User clicks on the show filters button
    And User selects the type for search
    And User selects an operator for search filter
    And User enters the value with <"Anusmita">
		And User clicks on the filter button
		Then User is able to view the contacts with the filters applied
	
