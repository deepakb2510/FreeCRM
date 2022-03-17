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
  Scenario: To validate that the user can filter the contacts based on various criterias.
    Given User is on the Contacts page
    And User clicks on the show filters button
    And User selects the type for search
    And User selects an operator for search filter
    And User enters the value with <"<searchfiltercontacts>">

    Examples: 
      | searchfiltercontacts  |
      | anusmita |
	
	@tag2
	Scenario: To validate whether the correct contacts have appeared according to the filter criteria.
		Given User is on the Contacts page 
		And User clicks on the appropriate filter from the dropdown menu
		And User clicks on clear
		Then User is able to view the Contacts with the filters applied

	@tag3
	Scenario: To validate whether user is able to remove filters if required.		
		Given User is on the contacts page 
		And User clicks on the filter button
		Then The filter applied gets removed if clicked on clear.	
    
//tc108