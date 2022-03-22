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
Feature: Verification of Login page functionality

Background: User is on FreeCRM page
	@tag1
  Scenario: To validate if the user has not entered any credentials.
    Given User is on Login page
    And User Clicks on login button
    Then Invalid request message should appear
    
  @tag2
  Scenario: To validate if user has entered only username
  	Given User is on Login page 
    And User enters only username with <"<username>"> 	
    And User Clicks on login button
    Then Invalid request message should appear
    
    Examples:
    	|username|
    	|deepak.bhandare.48@gmail.com|
    	
 
  @tag3
  Scenario: To validate if user has entered only password
  	Given User is on Login page
    And User enters only password with <"<password>">
    And User Clicks on login button
    Then Invalid request message should appear
 
    Examples: 
      |password|   
      |Deepak@2000| 
 
  @tag4
  Scenario: To validate if the user has entered the valid credentials and redirection happens to the home page.
    Given User is on Login page
    And User enters username with <"<username>"> 	
    And User enters password with <"<password>">
    And User Clicks on login button
    Then UseR is logged in
 
    Examples: 
      |username|password|   
      |deepak.bhandare.48@gmail.com|Deepak@2000|  
       
