 
 
  
@CompanyFilter
Feature: Verification of add filter to company functionality
  I want to use this template for my feature file
  
Background: User is on FreeCRM page 

  @AddFilters
  Scenario: To validate whether user is able to add new filters.
    Given User is Logged in and is in Companies Module
    And User clicks on Show filter in Companies Module
    And user selects appropriate value for Search as <"<search>"> , Operator as <"<operator>"> and Equals as <"<equals>"> in Companies Module
    And User clicks on Save Search in Companies Module
    Then Filter should get saved and displayed in Filters Dropdown in Companies Module
    
    Examples: 
    |search|operator|equals|
    |Name|Equals|Capgemini Worldwide|
   
   @ApplyFilters
   Scenario: To validate whether user is able to apply filters on companies added to view them
  	Given User is Logged in and is in Companies Module
  	And User clicks on Show filter in Companies Module
  	And user selects appropriate value for Search as <"<search>"> , Operator as <"<operator>"> and Equals as <"<equals>"> in Companies Module
  	And User clicks on Search in Companies Module
  	Then Companies should get filtered appropriately
  	 
    
  
    
    
    @RemoveFilters
    Scenario: To validate whether user is able to remove filters if required.
    Given User is Logged in and is in Companies Module
  	And User clicks on Show filter in Companies Module
  	And user selects appropriate value for Search as <"<search>"> , Operator as <"<operator>"> and Equals as <"<equals>"> in Companies Module
  	And User clicks on Search in Companies Module
    And User clicks on Clear in Companies Module
    Then Filter results should get removed in Companies Module
     