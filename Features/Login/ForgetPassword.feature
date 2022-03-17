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
Feature: Verification of Forget Password functionality

Background: User is on FreeCRM page

  @tag1
  Scenario: To validate if the user is redirected when clicked on forget password, where the user is asked to provide his/her email id
    Given User is on login page
    And User clicks on forget password button
    Then Redirection to forget password page

	@tag2
	Scenario: To validate that the email is sent to reset the password
		Given: User is on forget password page
		And: User enters username with <"<username>">
		And: User clicks on reset password button
		Then: A message is displayed stating email is sent
		
		Examples:
		|email|
		|deepak.bhandare.48@gmail.com|
