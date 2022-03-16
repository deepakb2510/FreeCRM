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
#
#
@tag
Feature: Verification of create a company functionality
  I want to use this template for my feature file
  
Background: User is on FreeCRM page 

  @tag1
  Scenario: To validate whether redirection happens to create companies form after clicking on create.
    Given User is Logged in and is in Companies Module
    And User clicks on create
    Then Create Company form should open

  @tag2
  Scenario Outline: To validate if the user has entered details in the all mandatory fields 
    Given User is Logged in and is in Companies Module
    And User clicks on create
    And User Fills the Company Name as <"<title>">

    Examples: 
      |title| 
      |Capgemini| 
      
   @tag3
   Scenario Outline: To validate if the user has entered details in the all mandatory fields 
    Given User is Logged in and is in Companies Module
    And User clicks on create
    And User Fills the Company Name as <"<title>">
