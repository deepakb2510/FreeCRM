
@tag
Feature: Verification of a create a new event functionality
  
Background: User is logged into FreeCRM and on the Calendar page 

    @tag1
  Scenario: To validate that redirection happens to the calendar details page if the create event button is clicked and user is able to create a event successfully
    Given User is on the event page
    And User clicks on the create event button
    Then User is redirected to the create event page

	@tag2
	Scenario: To validate if the user has entered details in the all mandatory field
		Given User is on the create event page
		And User enters the title of the event with <"<eventitle>">
		Then User is able to create event
     Examples: 
      |eventitle| 
      |Sprint2| 
    
   
      
	@tag3
	Scenario: To validate if the user has entered details in the all mandatory field
		Given User is on the create event page
		And User clicks on the save button
		Then User is redirected to the event details page which is created

  