package com.stepDefinition;

import static org.junit.Assert.assertEquals;

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
//
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CreateDeals {

	public static WebDriver driver;
	
	//-----
	
	Properties prop=new Properties();
	File f=new File("src\\test\\resources\\properties\\properties.xml");
	SAXReader sr = new SAXReader();
	Document d = null;
	String uname, password, dealsTitle, dealDesc;
	File g=new File("src\\test\\resources\\datasource\\deals.xlsx");
	
	FileInputStream fs = null;
	XSSFWorkbook w = null;
	XSSFSheet sheet = null;
	
	//------
	
	
	@Given("User is on the deals page")
	public void user_is_on_the_deals_page() throws InterruptedException, IOException {
	    // Write code here that turns the phrase above into concrete actions
//		
		//--------------
		fs =new FileInputStream(g);
		w = new XSSFWorkbook(fs);
		sheet = w.getSheetAt(0);
		try {
			d=sr.read(f);
			} catch (DocumentException e) {
					// TODO Auto-generated catch block
			e.printStackTrace();
			}
		//--------------
		
		
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		
		//-------
		try {
			driver.navigate().to("https://ui.cogmento.com/");
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//-------
		
//		driver.navigate().to("https://ui.cogmento.com/");
//		driver.manage().window().maximize();
	
		Thread.sleep(10000);
		uname = sheet.getRow(1).getCell(0).getStringCellValue();
		String email = d.selectSingleNode("//freecrm//login//email").getText();
		Thread.sleep(2000);
		driver.findElement(By.xpath(email)).sendKeys(uname);
		
		password = sheet.getRow(1).getCell(1).getStringCellValue();
		Thread.sleep(2000);
		String pass= d.selectSingleNode("//freecrm//login//pass").getText();
		driver.findElement(By.name(pass)).sendKeys(password);
		
//	    driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div/div[1]/div/input")).sendKeys("atharvamahamunitemp@gmail.com");
//	    driver.findElement(By.name("password")).sendKeys("thunderStorm#123");
//	    driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]")).click();
	    assertEquals(driver.getTitle(),"Cogmento CRM");
	    
	    Thread.sleep(2000);
	    String submit = d.selectSingleNode("//freecrm//login//submit").getText();
		driver.findElement(By.xpath(submit)).click();
		
		Thread.sleep(2000);
		String dealBtn = d.selectSingleNode("//freecrm//deals//dealbtn").getText();
		driver.findElement(By.xpath(dealBtn)).click();
	}
	

	// -------- Create Deal ----------
//	
	@Given("User clicks on the create deals button")
	public void user_clicks_on_the_create_deals_button() throws InterruptedException {
		
		Thread.sleep(3000);
		String createBtn = d.selectSingleNode("//freecrm//deals//createbtn").getText();
		driver.findElement(By.xpath(createBtn)).click();
		
	}
//
	@Then("User is redirected to the create deals page")
	public void user_is_redirected_to_the_create_deals_page() throws InterruptedException {
		Thread.sleep(2000);
		assertEquals(driver.getTitle(),"Cogmento CRM");
	}
//
	@Given("User is on the create deal page")
	public void user_is_on_the_create_deal_page() throws InterruptedException {
		Thread.sleep(2000);
		assertEquals(driver.getTitle(),"Cogmento CRM");
	}
//
	@Given("User enters the title of the deal with <{string}>")
	public void user_enters_the_title_of_the_deal_with(String string) throws InterruptedException {
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='title']")).sendKeys(string);
	}
//
	@Given("User clicks on the save button to create the deal")
	public void user_clicks_on_the_save_button() throws InterruptedException {

		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@class='ui linkedin button']")).click();
	}
//
	@Then("User is redirected to the deal details page which is created")
	public void user_is_redirected_to_the_task_details_page_which_is_created() throws InterruptedException {
		assertEquals(driver.getTitle(),"Cogmento CRM");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"main-nav\"]/div[5]/a/i")).click();
		
		driver.quit();
	}

//	// ----------- Edit Deal --------------
//	
////	
		@Given("User clicks on the edit button to edit the deal")
		public void user_clicks_on_the_edit_button() throws InterruptedException {
			Thread.sleep(3000);
		    driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div[2]/table/tbody/tr[2]/td[8]/a[2]/button")).click();
		}
//	
		@Then("User is redirected to edit deal page")
		public void user_is_redirected_to_edit_deal_page() {
			assertEquals(driver.getTitle(),"Cogmento CRM");
		}
//
		@Given("User is on the edit deal page")
		public void user_is_on_the_edit_deal_page() {
			assertEquals(driver.getTitle(),"Cogmento CRM");
		}
//
		@Given("User enters the description of the deal with <{string}>")
		public void user_enters_the_description_of_the_deal_with(String string) throws InterruptedException {
			
			Thread.sleep(5000);
			driver.findElement(By.xpath("//textarea[@name='description']")).clear();

			driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(string);
		}
		
//	
		@Given("User clicks on the save button to save the edited deal")
		public void user_on_the_save_button() throws InterruptedException {
			driver.findElement(By.xpath("//button[@class='ui linkedin button']")).click();
			Thread.sleep(3000);
		}
//	
		@Then("User is redirected to deal details page and is able to see the changes made")
		public void user_is_redirected_to_deal_details_page_and_is_able_to_see_the_changes_made() {
			assertEquals(driver.getTitle(),"Cogmento CRM");
//				driver.findElement(By.xpath("//*[@id=\"main-nav\"]/div[5]/a/i")).click();
		
			 driver.quit();
		}
	
//	
	// ----------- Delete Deal -------------
	
	@Given("User clicks on the delete button for the existing deal")
	public void user_clicks_on_the_delete_button_for_the_existing_deal() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div[2]/table/tbody/tr[1]/td[8]/div/button")).click();
	}
//
	@Then("A delete confirmation pops up to delete the deal")
	public void a_delete_confirmation_pops_up() throws InterruptedException {
		Thread.sleep(2000);
		assertEquals(driver.getTitle(),"Cogmento CRM");
	}
//
	@Given("User is displayed a delete confirmation pop up for deleting the deal")
	public void user_is_displayed_a_delete_confirmation_pop_up(){
		assertEquals(driver.getTitle(),"Cogmento CRM");
	}
//
	@Given("User clicks on the cancel button to cancel the deal deletion")
	public void user_clicks_on_the_cancel_button() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='ui black button']")).click();
	}
//
	@Then("User is redirected to the deals page and the deletion process is cancelled")
	public void user_is_redirected_to_the_deals_page_and_the_deletion_process_is_cancelled() throws InterruptedException {
		Thread.sleep(2000);
//		assertEquals(driver.findElement(By.xpath("//*[@id=\"dashboard-toolbar\"]/div[1]/text()")).getText(),"Deals");
	
		driver.quit();
	}

	
	
//	
	
	// ----------- Filter Deal ------------
	
//	@Given("User is on the deals page")
//	public void user_is_on_the_deals_page1() throws InterruptedException {
//		Thread.sleep(3000);
//		assertEquals(driver.getTitle(),"Cogmento CRM");
////		assertEquals("Cogmento CRM","Cogmento CRM");
//	}
//
	@Given("User clicks on the show filters button to filter the deal")
	public void user_clicks_on_the_show_filters_button() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[normalize-space()='Show Filters']")).click();
//	    Thread.sleep(3000);
	}
//
	@Given("User selects the type for search the deal")
	public void user_selects_the_type_for_search() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='search']")).sendKeys("Title");
	    driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/form/div[2]/div/div/div[1]/div/div[2]/div[1]")).click();
	}
//
	@Given("User selects an operator for search filter for the deal")
	public void user_selects_an_operator_for_search_filter() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[normalize-space()='Operator']")).click();
	}
//
	@Given("User enters the value to filter the deal with <{string}>")
	public void user_enters_the_value_with(String string) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Value']")).sendKeys(string);
//	    
	}
	
	@Given("User clicks on the filter button to filter the deal")
	public void user_clicks_on_the_filter_button() throws InterruptedException {
		 Thread.sleep(3000);
		 //
	    driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/form/div[1]/div[2]/div/button[5]")).click();
	    
	}

	@Then("User is able to view the deals with the filters applied")
	public void user_is_able_to_view_the_deals_with_the_filters_applied() throws InterruptedException {
	    //assertEquals(driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/table/tbody/tr/td[2]/a")).getText(),"demo5");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//i[@class='ban small icon']")).click();
	    driver.quit();
	}
	
}


