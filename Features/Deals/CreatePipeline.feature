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
Feature: Verification of a create a new deal pipeline functionality
  I want to use this template for my feature file

  Background: User is logged into FreeCRM and on the Deals page

  @tag1
  Scenario: To validate that redirection happens to the pipeline details page if the pipeline button is clicked and user is able to create a pipeline successfully
    Given User is on the deals page
    And User clicks on the create deals button
    Then User is redirected to the create deals page

  @tag2
  Scenario: To validate if the user has selected the field and entered the pipeline name
    Given User is on the create pipeline page
    And User enters the name of the pipeline with <"<pipelinename>">

    Examples:
      | pipelinename |
      | demo5    |

  @tag3
  Scenario: To validate if the user has entered details in the all mandatory field
    Given User is on the create pipeline page
    And User clicks on the create button
    Then User is redirected to the deal pipeline details page which is created
