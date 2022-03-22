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
Feature: Verification of add filter to deal functionality
  I want to use this template for my feature file
 
Background: User is logged into FreeCRM and on the Deals page  

  @tag1
  Scenario: To validate if the user is able to apply filter(s) on the deals page
    Given User is on the deals page
    And User clicks on the show filters button to filter the deal
    And User selects the type for search the deal
    And User selects an operator for search filter for the deal
    And User enters the value to filter the deal with <"<searchfilterdeals>">
    And User clicks on the filter button to filter the deal
		Then User is able to view the deals with the filters applied

    Examples: 
      | searchfilterdeals  |
      | demo5 |
