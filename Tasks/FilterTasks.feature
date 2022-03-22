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
Feature: Verification of add filter to task functionality
  I want to use this template for my feature file
 
Background: User is logged into FreeCRM and on the Tasks page  

  @tag1
  Scenario: To validate if the user is able to apply filter(s) on the tasks page
    Given User is on the Tasks page
    And User clicks on the show filters button
    And User selects the type for search
    And User selects an operator for search filter
    And User enters the value with <"<searchfiltertasks>">

    Examples: 
      | searchfiltertasks  |
      | demo5 |
	
	@tag2
	Scenario: To validate that the tasks are displayed according to the filters that are applied by the user
		Given User is on the tasks page 
		And User clicks on the filter button
		Then User is able to view the tasks with the filters applied
		