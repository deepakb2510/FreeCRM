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
Feature: Verification of edit the deal functionality
  I want to use this template for my feature file

  @tag1
  Scenario: To validate that the details page of the selected deal is opened when the user clicks on the edit deals option
    Given User is on the deals page
    And User clicks on the edit button
    Then User is redirected to edit deal page

  @tag2
  Scenario: To validate if the edited details are saved for the deal which was edited by the user
  	Given User is on the edit deal page
    And User enters the description of the deal with <"<descdeals>">
    And User enters completion details with <"<completiondeals>">
    And User on the save button
    Then User is redirected to deal details page and is able to see the changes made

    Examples: 
      | descdeals     | completiondeals |
      | this is demo5 |       80        |
