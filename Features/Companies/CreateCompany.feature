 
@CreateCompany
Feature: Verification of create a company functionality
  I want to use this template for my feature file
  
Background: User is on FreeCRM page 

  @CreatingTheCompany
  Scenario: To validate whether redirection happens to create companies form after clicking on create.
    Given User is Logged in and is in Companies Module
    And User clicks on create in Companies Module
    Then Create Company form should open
#
  @MandartoryField
  Scenario Outline: To validate if the user has entered details in the all mandatory fields 
    Given User is Logged in and is in Companies Module
    And User clicks on create in Companies Module
    And User Fills the Company Name as <"<title>"> in Companies Module
		And User clicks on save in Companies Module
		Then Company data should get saved
    Examples: 
      |title| 
      |Capgemini| 
      
   @CancelCreationOfCompany
   Scenario Outline: To validate whether user is able to cancel the creation of companies is required
   	Given User is Logged in and is in Companies Module
    And User clicks on create in Companies Module
    And User clicks on cancel in Companies Module
    Then Form should close and user should be redirected to the Companies Module
#	
		@UnableToCreateCompany
		Scenario Outline: To validate whether user is able to unable to create company if  Mandatory details not filled.
		Given User is Logged in and is in Companies Module
    And User clicks on create in Companies Module
    And User clicks on save in Companies Module
    Then User should get error stating to enter mandatory details in Companies Module
    #
    
    @ValidMobileNumber 
    Scenario Outline: To validate whether valid mobile number is accpeting only digits in create company
    Given User is Logged in and is in Companies Module
    And User clicks on create in Companies Module
    And User Fills the Company Name as <"<title>"> in Companies Module
    And User Enters Mobile number as <"<number>"> in Companies Module
		And User clicks on save in Companies Module
		Then Company data should get saved
    Examples: 
      |title|number| 
      |Capgemini With Number|9987326348| 
    