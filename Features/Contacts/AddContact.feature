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
Feature: Verification of add contact(s) functionality.
  I want to use this template for my feature file
  
Background: User is logged into FreeCRM and on the Contacts page 

  @tag1
  Scenario: To validate that redirection happens to the Contact creation page if the create Contact button is clicked


    Given User is on the Contacts page
    And User clicks on the Create button
    Then User is redirected to the Create New Contact page

	@tag2
	Scenario: To validate whether Contact can be saved with null values.
		Given User is on the Contact page
		And User clicks on the Create button
		And User clicks on Save		
	  Then Error message appears stating "The field First Name is required.The field Last Name is required"
      
	@tag3
	Scenario: To validate whether the user has entered First Name and Last Name.
		Given User is on the Contact page
		And User clicks on the Create button
		And User enters First Name and Last Name with <"<firstname>"> and <"<lastname>">
		Then Contact detail page should appear with the First Name and Last Name


    Examples: 
      | First Name  | Last Name |
      | Anusmita    | Sarkar    |
   
   @tag4
	Scenario: To validate whether the user is able to select Company from the already created Companies.
		Given User is on the Create Contact page
		And User selects Company
		Then Selected Company appears 


    Examples: 
      | Company |
      | Anusmita|
     
	  
	  @tag5
	  Scenario: To validate whether phone number has 10 digits.
		Given User is on the Create Contact page and has entered the mandatory fields
		And User enters Phone Number
		And User clicks on Save
		Then Contact details are getting saved even if  valid details are not entered by the user

    Examples: 
      | Phone Number  |
      | 87878787968787|
      
    @tag6
	  Scenario: To validate whether the user can add social channel link after selection of the social channel
		Given User is on the Create Contact page
		And User selects Social Channel
		And User enters profile url with <"<url>">
		Then Profile url appears in textbox

    Examples: 
      | Profile url                                   |
      | https://www.facebook.com/anusmita.sarkar.190/ |
	  
	  @tag7
	Scenario: To validate that the user can has an option to make the access public or private if required after entering the mandatory fields.
		Given User is on the Create Contact page
		And User clicks on access button
		Then The button color turns red and the private access is displayed and if it is public and the button turns green in color.

    
    @tag8
	Scenario: To validate whether the Contact detail page appears after giving the mandatory fields and clicking on Save
		Given User is on the Create Contact page
		And User clicks on Save
		Then User is redirected to the Contact detail page
   
   @tag9
     Scenario: To validate whether the user can Cancel the creation of Contact if required.
		Given User is on the Create Contact page
		And User clicks on Cancel		
	  Then User is redirected to the Contacts page 
///failed test cases??
//should i mention img name in table?
// checl line 58 lang
///bugs will be dealt later
///leave image
// write all the steps in every test case or continue from the last test case