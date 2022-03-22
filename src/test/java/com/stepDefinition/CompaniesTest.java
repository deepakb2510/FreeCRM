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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CompaniesTest extends com.runner.FreeCRMRunner{
	public static WebDriver driver;
	Properties prop=new Properties();
	File f=new File("src\\test\\resources\\properties\\properties.xml");
	SAXReader sr=new SAXReader();
	Document d = null;
	String uname, pass;
	
//	File g=new File(".\\datasource\\login.xlsx");
	File g=new File("src\\test\\resources\\datasource\\logincompanies.xlsx");

	FileInputStream fs=null;
	XSSFWorkbook w=null;
	XSSFSheet sheet = null;


@Given("User is Logged in and is in Companies Module")
public void user_is_logged_in_and_is_in_companies_module() throws InterruptedException, IOException {
	fs=new FileInputStream(g);
	w=new XSSFWorkbook(fs);
	sheet=w.getSheetAt(0);
	try {
		d=sr.read(f);
		} catch (DocumentException e) {
				// TODO Auto-generated catch block
		e.printStackTrace();
		}
	String email= d.selectSingleNode("//freecrm//companies//email").getText();
	String password= d.selectSingleNode("//freecrm//companies//pass").getText();
	String submit= d.selectSingleNode("//freecrm//companies//submit").getText();

	System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.navigate().to("https://ui.cogmento.com/");
	Thread.sleep(5000);
	driver.manage().window().maximize();
	uname=sheet.getRow(1).getCell(0).getStringCellValue();
	pass=sheet.getRow(1).getCell(1).getStringCellValue();
	driver.findElement(By.name(email)).sendKeys(uname);
	driver.findElement(By.name(password)).sendKeys(pass);
	driver.findElement(By.xpath(submit)).click();
	Thread.sleep(5000);
	driver.findElement(By.linkText("Companies")).click();
    // 7 | mouseOver | linkText=Companies | 
    {
      WebElement element = driver.findElement(By.linkText("Companies"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
}

@Given("User clicks on create in Companies Module")
public void user_clicks_on_create() {
	String create= d.selectSingleNode("//freecrm//companies//createbtn").getText();

	driver.findElement(By.xpath(create)).click();
	
}

@Then("Create Company form should open")
public void create_company_form_should_open() throws InterruptedException {
	Thread.sleep(3000);
     String form="Create new Company";
 	 String createform= d.selectSingleNode("//freecrm//companies//createform").getText();

     String actual=driver.findElement(By.xpath(createform)).getText();
     assertEquals(actual, form);
     driver.quit();
}

@Given("User Fills the Company Name as <{string}> in Companies Module")
public void user_fills_the_company_name_as(String string) {
	 String companyname= d.selectSingleNode("//freecrm//companies//companyname").getText();

	 driver.findElement(By.xpath(companyname)).sendKeys(string);
		
}

@Given("User clicks on save in Companies Module")
public void user_clicks_on_save() {
	 String companysave= d.selectSingleNode("//freecrm//companies//companysave").getText();

	driver.findElement(By.xpath(companysave)).click();

}

@Then("Company data should get saved")
public void company_data_should_get_saved() throws InterruptedException {
	 String companysavename= d.selectSingleNode("//freecrm//companies//companysavename").getText();

	try {
	WebElement e= driver.findElement(By.xpath(companysavename));
	if(e!=null) {
		System.out.println("Data Saved");
	}
	}
	catch(NullPointerException e){
	System.out.println(e);
	}
	Thread.sleep(4000);
	driver.quit();
}

@Given("User clicks on cancel in Companies Module")
public void user_clicks_on_cancel_button() {
	 String companyformcancel= d.selectSingleNode("//freecrm//companies//companyformcancel").getText();

   driver.findElement(By.xpath(companyformcancel)).click();
}

@Then("Form should close and user should be redirected to the Companies Module")
public void form_should_close_and_user_should_be_redirected_to_the_companies_module() {
     driver.quit();
}

//@Given("User clicks on Save button")
//public void user_clicks_on_save_button() {
//	 String savebtn= d.selectSingleNode("//freecrm//companies//savebtn").getText();
//
//    driver.findElement(By.xpath(savebtn)).click();//savebtn
//}

@Then("User should get error stating to enter mandatory details in Companies Module")
public void user_should_get_error_stating_to_enter_manfatory_details() throws InterruptedException {
	Thread.sleep(1000);	
	String saveerr= d.selectSingleNode("//freecrm//companies//saveerr").getText();

     String err=driver.findElement(By.cssSelector(saveerr)).getText();
     String expected="The field Name is required";//save error
     assertEquals(err, expected);
     driver.quit();
}

@Given("User Enters Mobile number as <{string}> in Companies Module")
public void user_enters_mobile_number_as(String string) {
	 String mobileno= d.selectSingleNode("//freecrm//companies//mobileno").getText();

    	driver.findElement(By.xpath(mobileno)).sendKeys(string);
}



@Given("User clicks on Delete button in Companies Module")
public void user_clicks_on_delete_button() throws InterruptedException {
	Thread.sleep(5000);
	 String delete= d.selectSingleNode("//freecrm//companies//delete").getText();

     driver.findElement(By.xpath(delete)).click();
}

@Given("User clicks on Confirm Delete in Companies Module")
public void user_clicks_on_confirm_delete() throws InterruptedException {
	 String confirmdelete= d.selectSingleNode("//freecrm//companies//confirmdelete").getText();

     Thread.sleep(1000);
     driver.findElement(By.xpath(confirmdelete)).click();//confirmdelete
}

@Then("Company should get deleted and user is back on Companies module")
public void company_should_get_deleted_and_user_is_back_on_companies_module() {
     String s="Companies";
	 String companydashboard= d.selectSingleNode("//freecrm//companies//companydashboard").getText();

     String z=driver.findElement(By.xpath(companydashboard)).getText();
     assertEquals(z, s);
}

//@Given("User clicks on Cancel")
//public void user_clicks_on_cancel() throws InterruptedException {
//			Thread.sleep(1000);	
//			 String deletecancel= d.selectSingleNode("//freecrm//companies//deletecancel").getText();
//
//		     driver.findElement(By.xpath(deletecancel)).click();
//
//}

@Then("Company should not get deleted and user is back on Companies module")
public void company_should_not_get_deleted_and_user_is_back_on_companies_module() {
	String s="Companies";
	 String companysavename= d.selectSingleNode("//freecrm//companies//companysavename").getText();

    String z=driver.findElement(By.xpath(companysavename)).getText();
    assertEquals(z, s);
}

//---------------------------Company FIlter --------------------------------------

@Given("User clicks on Show filter in Companies Module")
public void user_clicks_on_show_filter() {
	 String showfilter= d.selectSingleNode("//freecrm//companies//showfilter").getText();

	driver.findElement(By.cssSelector(showfilter)).click();
}

@Given("user selects appropriate value for Search as <{string}> , Operator as <{string}> and Equals as <{string}> in Companies Module")
public void user_selects_appropriate_value_for_search_as_operator_as_and_equals_as(String string, String string2, String string3) {
	 String search= d.selectSingleNode("//freecrm//companies//search").getText();
	 String selectname= d.selectSingleNode("//freecrm//companies//selectname").getText();
	 String opreator= d.selectSingleNode("//freecrm//companies//opreator").getText();
	 String operatorselect= d.selectSingleNode("//freecrm//companies//operatorselect").getText();
	 String value= d.selectSingleNode("//freecrm//companies//value").getText();

	
	
	driver.findElement(By.cssSelector(search)).click();//search
    // 10 | click | css=.visible > .selected | 
    driver.findElement(By.cssSelector(selectname)).click();//selectname
    // 11 | click | css=.field .default | 
    driver.findElement(By.cssSelector(opreator)).click();//operator
    // 12 | click | css=.visible > .selected > .text | 
    driver.findElement(By.cssSelector(operatorselect)).click();//operatorselect
    // 13 | click | name=value | 
    driver.findElement(By.name(value)).click();//value
    // 14 | type | name=value | Capgemini Worldwide
    driver.findElement(By.name(value)).sendKeys("Capgemini Worldwide");
}

@Given("User clicks on Save Search in Companies Module")
public void user_clicks_on_save_search() {
	 String savesearch= d.selectSingleNode("//freecrm//companies//savesearch").getText();

	driver.findElement(By.cssSelector(savesearch)).click();//savesearch
}

@Then("Filter should get saved and displayed in Filters Dropdown in Companies Module")
public void filter_should_get_saved_and_displayed_in_filters_dropdown() {
    driver.close();
} 

@Given("User clicks on Clear in Companies Module")
public void user_clicks_on_clear() throws InterruptedException {
	Thread.sleep(3000);
	 String clear= d.selectSingleNode("//freecrm//companies//clear").getText();

	driver.findElement(By.cssSelector(clear)).click();
	Thread.sleep(3000);
}

@Then("Filter results should get removed in Companies Module")
public void filter_results_should_get_removed() {
	
    driver.close();
}


//-------------------Filter Companies----------------

//@Given("User clicks selects appropriate filter from the Dropdown")
@Given("User clicks on Search in Companies Module")
public void user_clicks_on_search() {
	 String filtersearch= d.selectSingleNode("//freecrm//companies//filtersearch").getText();

	driver.findElement(By.xpath(filtersearch)).click();	    
}

@Then("Companies should get filtered appropriately")
public void companies_should_get_filtered_appropriately() throws InterruptedException {
	Thread.sleep(5000);
    driver.quit();
}



@Given("User clicks on Cancel button in Companies Module")
public void user_clicks_on_cancel_button_in() throws InterruptedException {
	 String cancelfilter= d.selectSingleNode("//freecrm//companies//cancelfilter").getText();

	Thread.sleep(5000);
    driver.findElement(By.xpath(cancelfilter)).click();
}
}
