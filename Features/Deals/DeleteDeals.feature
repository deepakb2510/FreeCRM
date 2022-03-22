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
Feature: Verification of delete deal(s) functionality
  I want to use this template for my feature file

Background: User is logged into FreeCRM and on the Deals page

  @tag1
  Scenario: To validate that the user is able to delete an existing deal
    Given User is on the deals page
    And User clicks on the delete button for the existing deal
    Then A delete confirmation pops up to delete the deal

  @tag2
  Scenario: To validate that the user is able to cancel the deletion process if required
  	Given User is displayed a delete confirmation pop up for deleting the deal
    And User clicks on the cancel button to cancel the deal deletion 
    Then User is redirected to the deals page and the deletion process is cancelled
