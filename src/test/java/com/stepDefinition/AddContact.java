package com.stepDefinition;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
public class AddContact 
{
	public static WebDriver driver;
	Properties prop=new Properties();
	File f=new File("src\\test\\resources\\properties\\properties.xml");
	SAXReader sr=new SAXReader();
	Document d = null;
	String fname,lname;
	String emailLogin, password;
//	File g=new File(".\\datasource\\contact.xlsx");
	File g=new File("src\\test\\resources\\datasource\\contact.xlsx");


	FileInputStream fs=null;
	XSSFWorkbook w=null;
	XSSFSheet sheet = null;
	@Given("User is on the Contacts page")
	public void user_is_on_the_contacts_page() throws InterruptedException, IOException {
		fs=new FileInputStream(g);
		w=new XSSFWorkbook(fs);
		sheet=w.getSheetAt(0);
		try {
			d=sr.read(f);
			} catch (DocumentException e) {
					// TODO Auto-generated catch block
			e.printStackTrace();
			}
		String email= d.selectSingleNode("//freecrm//contact//email").getText();
		String pass= d.selectSingleNode("//freecrm//contact//pass").getText();
		String login= d.selectSingleNode("//freecrm//contact//login").getText();
		String contactbutton= d.selectSingleNode("//freecrm//contact//contactbutton").getText();

		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to("https://ui.cogmento.com/");
		driver.manage().window().maximize();
		emailLogin=sheet.getRow(1).getCell(0).getStringCellValue();
		password=sheet.getRow(1).getCell(1).getStringCellValue();
		Thread.sleep(5000);
	    driver.findElement(By.xpath(email)).sendKeys(emailLogin);	  //email  
	    driver.findElement(By.name(pass)).sendKeys(password); //pass
//		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div/div[1]/div/input")).sendKeys("sanusmita45@gmail.com");	    
//	    driver.findElement(By.name("password")).sendKeys("Anus@345");
	    Thread.sleep(10000);
	   // driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]")).click();
	    driver.findElement(By.xpath(login)).click(); //login
	    Thread.sleep(3000);
	    driver.findElement(By.xpath(contactbutton)).click(); //contactbutton
	    Thread.sleep(5000);
	    //assertEquals(driver.getTitle(),"Cogmento CRM");
	    Thread.sleep(5000);
	}
		


	

	@Given("User clicks on the Create button")
	public void user_clicks_on_the_create_button() throws InterruptedException {
		String createbutton= d.selectSingleNode("//freecrm//contact//createbutton").getText();

		driver.findElement(By.xpath(createbutton)).click(); //createbutton
		Thread.sleep(3000);
	}

	@Then("User is redirected to the Create New Contact page")
	public void user_is_redirected_to_the_create_new_contact_page() {
		assertEquals(driver.getTitle(),"Cogmento CRM");
		}

	@Given("User is on the Create Contact page")
	public void user_is_on_the_contact_page() {
	}
	
	@Given("User clicks on Save")
	public void user_clicks_on_save() throws InterruptedException {
	    Thread.sleep(3000);


		driver.findElement(By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]")).click(); //save

	}

	@Then("Error message appears stating {string}")
	public void error_message_appears_stating(String string) {
	    //assertEquals(driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/form/div[1]/div[1]/div/label/span")), string);
		String error= d.selectSingleNode("//freecrm//contact//error").getText();

		System.out.println(error);
	}

	@Given("User enters First Name and Last Name with <{string}> and <{string}>")
	public void user_enters_first_name_and_last_name_with_and(String string, String string2) {
		
		lname=string2;
	    driver.findElement(By.name("first_name")).sendKeys(string); //firstname
	    driver.findElement(By.name("last_name")).sendKeys(string2); //lastname

	}

	@Then("Contact detail page should appear with the First Name and Last Name")
	public void contact_detail_page_should_appear_with_the_first_name_and_last_name() throws InterruptedException {
		Thread.sleep(2000);
		
		String error1 = driver.findElement(By.name("first_name")).getText();
		String error2 = driver.findElement(By.name("last_name")).getText();
		if(error1.equals(fname) && error2.equals(lname))
		{
			System.out.println("First name and last name appeared");
		}
		else
		{
			System.out.println("First name and last name did not appear");
		}
	}


	@Given("User selects Company")
	public void user_selects_company() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#main-content > div > div.ui.fluid.container.main-content > form > div:nth-child(2) > div:nth-child(2) > div > div > input")).sendKeys("Capgemini"); //companyname
		
		driver.findElement(By.cssSelector("#main-content > div > div.ui.fluid.container.main-content > form > div:nth-child(2) > div:nth-child(2) > div > div > div.visible.menu.transition > div")).click(); //selectcompany
	}

	@Then("Selected Company appears")
	public void selected_company_appears() {

		String error = driver.findElement(By.cssSelector("#main-content > div > div.ui.fluid.container.main-content > form > div:nth-child(2) > div:nth-child(2) > div > div > input")).getText(); //dispcompany
		System.out.println(error);
	}

	@Given("User is on the Create Contact page and has entered the mandatory fields")
	public void user_is_on_the_create_contact_page_and_has_entered_the_mandatory_fields() {
	    
	}

	@Given("User enters Phone Number")
	public void user_enters_phone_number() throws InterruptedException {
		Thread.sleep(5000);
	    driver.findElement(By.cssSelector("#main-content > div > div.ui.fluid.container.main-content > form > div:nth-child(7) > div:nth-child(2) > div > div > div > div:nth-child(2) > div > input[type=text]")).sendKeys("5656478805577"); //phone

	}

	@Then("Contact details are getting saved even if  valid details are not entered by the user")
	public void contact_details_are_getting_saved_even_if_valid_details_are_not_entered_by_the_user() {
	}



	@Then("User is redirected to the Contact detail page")
	public void user_is_redirected_to_the_contact_detail_page() throws InterruptedException {
		Thread.sleep(3000);
		
	}
	@Given("User clicks on Cancel")
	public void user_clicks_on_cancel() throws InterruptedException {
		

		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"main-nav\"]/div[3]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/a/button")).click();//createbutton
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#dashboard-toolbar > div.ui.right.secondary.pointing.menu.toolbar-container > div > button:nth-child(1)")).click(); //cancelbutton
	}

	@Then("User is redirected to the Contacts page")
	public void user_is_redirected_to_the_contacts_page() {
	    	}
//--------------------------------Filter Contacts--------------------------------------------------


	@Given("User is on the Contacts page and applying filters")
	public void user_is_on_the_contacts_page_and_applying_filters() throws InterruptedException {
	
		Thread.sleep(3000);
	    driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[3]/a")).click(); //contactbutton
	    Thread.sleep(5000);
	}
	@Given("User clicks on the show filters button")
	public void user_clicks_on_the_show_filters_button() throws InterruptedException {
		Thread.sleep(5000);

		driver.findElement(By.cssSelector("#dashboard-toolbar > div.ui.right.secondary.pointing.menu.toolbar-container > div > button:nth-child(2)")).click(); //showfilters
	}

	@Given("User selects the type for search")
	public void user_selects_the_type_for_search() {
		

		driver.findElement(By.xpath("//input[@class='search']")).sendKeys("First Name"); //filterfname
	}

	@Given("User selects an operator for search filter")
	public void user_selects_an_operator_for_search_filter() {

		driver.findElement(By.cssSelector("#main-content > div > div.ui.fluid.container.main-content > form > div.ui.list > div > div > div:nth-child(2) > div")).click();	//operatorclick
	}

	@Given("User enters the value with <{string}>")
	public void user_enters_the_value_with(String string) throws InterruptedException {
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@placeholder='Value']")).sendKeys(string); //filtervalue
	    Thread.sleep(3000);
	}

	@Given("User clicks on the filter button")
	public void user_clicks_on_the_filter_button() throws InterruptedException {
		Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("#main-content > div > div.ui.fluid.container.main-content > form > div.ui.top.attached.menu > div.right.menu > div > button:nth-child(5)")).click(); //filterbutton
		Thread.sleep(5000);

	}

	@Then("User is able to view the contacts with the filters applied")
	public void user_is_able_to_view_the_contacts_with_the_filters_applied() throws InterruptedException 
	{
	    Thread.sleep(1000);
	}

//------------------------------------Edit Contacts----------------------------------
	@Given("User is on the Contacts page and editing the required contact")
	public void user_is_on_the_contacts_page_and_editing_the_required_contact() throws InterruptedException {

		Thread.sleep(5000);
	    driver.findElement(By.xpath("//*[@id=\"main-nav\"]/div[3]/a")).click(); //contactbutton
	}
	@Given("User clicks on the edit button")
	public void user_clicks_on_the_edit_button() throws InterruptedException {
		
	    Thread.sleep(5000);

	    driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/table/tbody/tr[1]/td[8]/a[2]/button")).click(); //edit
	}

	@Then("User is redirected to edit contact page")
	public void user_is_redirected_to_edit_contact_page() {
		assertEquals(driver.getTitle(),"Cogmento CRM");
	}

	@Given("User is on the edit contact page")
	public void user_is_on_the_edit_contact_page() throws InterruptedException {
		assertEquals(driver.getTitle(),"Cogmento CRM");

	}

	@Given("User enters Middle Name with <{string}>")
	public void user_enters_middle_name_with(String string) throws InterruptedException {
		Thread.sleep(5000);
		
		driver.findElement(By.name("middle_name")).sendKeys(string);

	}

	@Given("User on the save button")
	public void user_on_the_save_button() throws InterruptedException {
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[1]/div[2]/div/button[2]")).click(); //esave
		Thread.sleep(3000);
	}

	@Then("User is redirected to Contact details page and is able to see the changes made")
	public void user_is_redirected_to_contact_details_page_and_is_able_to_see_the_changes_made() throws InterruptedException {
	    Thread.sleep(1000);
	}
//-------------------------------Delete Contact
	@Given("User is on the contacts page and wants to delete an existing contact")
	public void user_is_on_the_contacts_page_and_wants_to_delete_an_existing_contact() throws InterruptedException {

		Thread.sleep(10000);

	    driver.findElement(By.cssSelector("#main-nav > div:nth-child(3) > a")).click(); //contactbutton
	}

	@Given("User clicks on the delete button for the existing contact")
	public void user_clicks_on_the_delete_button_for_the_existing_contact() {

		driver.findElement(By.cssSelector("#main-content > div > div.ui.fluid.container.main-content > div > table > tbody > tr:nth-child(1) > td.right.aligned.collapsing.options-buttons-container > div > button")).click(); //deletebutton
	}

	@Given("A delete confirmation pops up")
	public void a_delete_confirmation_pops_up() throws InterruptedException {
	    Thread.sleep(5000);
	}

	@Given("User clicks on Delete")
	public void user_clicks_on_delete() {
	    driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[2]")).click(); //delete
	}

	@Then("The required contact is deleted and user is redirected to the Contacts page")
	public void the_required_contact_is_deleted_and_user_is_redirected_to_the_contacts_page() throws InterruptedException {
	    Thread.sleep(5000);
	}

	@Given("User is on the Contact page and wants to cancel the deletion process")
	public void user_is_on_the_contact_page_and_wants_to_cancel_the_deletion_process() throws InterruptedException {
	    Thread.sleep(1000);
	}

	@Given("User clicks on the delete button on the required contact")
	public void user_clicks_on_the_delete_button_on_the_required_contact() {

		driver.findElement(By.cssSelector("#main-content > div > div.ui.fluid.container.main-content > div > table > tbody > tr:nth-child(1) > td.right.aligned.collapsing.options-buttons-container > div > button")).click(); //deletebutton

	}

	@Given("A delete confirmation pops up after clicking the delete button")
	public void a_delete_confirmation_pops_up_after_clicking_the_delete_button() throws InterruptedException {
	    Thread.sleep(5000);	
	}

	@Given("User clicks on Cancel button")
	public void user_clicks_on_cancel_button() {
	    driver.findElement(By.cssSelector("body > div.ui.page.modals.dimmer.transition.visible.active > div > div.actions > button.ui.black.button")).click(); //canceldelete
	}

	@Then("User is redirected to the Contacts page and the deletion process is cancelled")
	public void user_is_redirected_to_the_contacts_page_and_the_deletion_process_is_cancelled() throws InterruptedException {
	    Thread.sleep(2000);
	}
}