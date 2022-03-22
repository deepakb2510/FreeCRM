 

@tag
Feature: Verification of add filter to task functionality
  I want to use this template for my feature file
 
  @tag1
  Scenario: To validate if the user is able to apply filter(s) on the tasks page
    Given User is on the tasks page
    And User clicks on the show filters button in task module
    And User selects the type for search in task module
    And User selects an operator for search filter in task module
    And User enters the value with <"<searchfiltertasks>"> in Task module
    And User clicks on the filter button in task module
    And User clicks on the clear button in task module
		Then User is able to view the tasks with the filters applied
    

    Examples: 
      | searchfiltertasks  |
      | demo5 |
	

