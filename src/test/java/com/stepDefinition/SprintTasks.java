package com.stepDefinition;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
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
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SprintTasks {
	public static WebDriver driver;
	
	Properties prop=new Properties();
	File f=new File("src\\test\\resources\\properties\\properties.xml");
	SAXReader sr=new SAXReader();
	Document d = null;
	
	String uname, pass;
	File g=new File("src\\test\\resources\\datasource\\Tasksdata.xlsx");
	
	FileInputStream fs=null;
	XSSFWorkbook w=null;
	XSSFSheet sheet = null;
	
	@Given("User is on the tasks page")
	public void user_is_on_the_tasks_page() throws IOException, InterruptedException {
		
		fs=new FileInputStream(g);
		w=new XSSFWorkbook(fs);
		sheet=w.getSheetAt(0);
		
		try {
			d=sr.read(f);
		} 
		catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		
		try {
			driver.navigate().to("https://ui.cogmento.com/");
			driver.manage().window().maximize();
			
			uname = sheet.getRow(1).getCell(0).getStringCellValue();
			pass = sheet.getRow(1).getCell(1).getStringCellValue();
			
			String username =  d.selectSingleNode("//freecrm//login//username").getText();
			String psw =  d.selectSingleNode("//freecrm//login//psw").getText();
			String submit =  d.selectSingleNode("//freecrm//login//submit").getText();
			
			String taskshomepage =  d.selectSingleNode("//freecrm//login//taskspage").getText();
			
			Thread.sleep(5000);
		    driver.findElement(By.xpath(username)).sendKeys(uname);
		    driver.findElement(By.name(psw)).sendKeys(pass);
		    driver.findElement(By.xpath(submit)).click();
		    assertEquals(driver.getTitle(),"Cogmento CRM");
		    Thread.sleep(5000);
			
			driver.findElement(By.xpath(taskshomepage)).click();
		}
		catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// ----------------------------------------------------- Create task feature ---------------------------------------------------------
	
	@Given("User clicks on the create tasks button")
	public void user_clicks_on_the_create_tasks_button() {
		String createbutton =  d.selectSingleNode("//freecrm//createtask//createbutton").getText();
	    driver.findElement(By.xpath(createbutton)).click();	    
	}
	
	@Then("User is redirected to the create tasks page")
	public void user_is_redirected_to_the_create_tasks_page() {
		assertEquals(driver.getTitle(),"Cogmento CRM");	 
		driver.quit();
	}
	
	@Given("User is on the create task page")
	public void user_is_on_the_create_task_page() {
		assertEquals(driver.getTitle(),"Cogmento CRM");	    
	}
	
	@Given("User enters the title of the task with <{string}>")
	public void user_enters_the_title_of_the_task_with(String string) throws InterruptedException {
		Thread.sleep(3000);
		String title =  d.selectSingleNode("//freecrm//createtask//title").getText();
	    driver.findElement(By.xpath(title)).sendKeys(string);	    
	}
	
	@Given("User clicks on the save button in task module")
	public void user_clicks_on_the_save_button() {
		String save =  d.selectSingleNode("//freecrm//createtask//save").getText();
	    driver.findElement(By.xpath(save)).click();
	}
	
	@Then("User is redirected to the task details page which is created")
	public void user_is_redirected_to_the_task_details_page_which_is_created() throws InterruptedException {
		assertEquals(driver.getTitle(),"Cogmento CRM");
		Thread.sleep(3000);
		String taskshomepage =  d.selectSingleNode("//freecrm//login//taskspage").getText();

		driver.findElement(By.xpath(taskshomepage)).click();
		driver.quit();
	}
	
	@Then("User is displayed a warning text in task module")
	public void user_is_displayed_a_warning_text() throws InterruptedException {
	    Thread.sleep(3000);
	    String warning = d.selectSingleNode("//freecrm//createtask//warning").getText();
	    String err = driver.findElement(By.xpath(warning)).getText();
	    String expected = "The field Title is required";
	    assertEquals(err,expected);
	    driver.quit();
	}
	
//	//----------------------------------------------------- Edit task feature ----------------------------------------------
	
	@Given("User clicks on the edit button in task module")
	public void user_clicks_on_the_edit_button() throws InterruptedException {
		Thread.sleep(3000);
//	    driver.findElement(By.xpath("//a[normalize-space()='demo5']")).click();
//	    Thread.sleep(3000);
//	    driver.findElement(By.xpath("//button[@class='ui icon button']//i[@class='edit icon']")).click();
//		String edit = d.selectSingleNode("//freecrm//edittask//edit").getText();
	    driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/table/tbody/tr[1]/td[7]/a[2]/button")).click();
	    Thread.sleep(3000);
	}

	@Then("User is redirected to edit task page")
	public void user_is_redirected_to_edit_task_page() {
		assertEquals(driver.getTitle(),"Cogmento CRM");	
		driver.quit();
	}

	@Given("User enters the description of the task with <{string}>")
	public void user_enters_the_description_of_the_task_with(String string) {
		
		String description =  d.selectSingleNode("//freecrm//edittask//description").getText();
		driver.findElement(By.xpath(description)).clear();
		driver.findElement(By.xpath(description)).sendKeys(string);
		
	}

	@Given("User enters completion details with <{string}>")
	public void user_enters_completion_details_with(String string) {
		String completion =  d.selectSingleNode("//freecrm//edittask//completion").getText();
		driver.findElement(By.xpath(completion)).sendKeys(string);	    
	}

	@Then("User is redirected to task details page and is able to see the changes made")
	public void user_is_redirected_to_task_details_page_and_is_able_to_see_the_changes_made() {
		assertEquals(driver.getTitle(),"Cogmento CRM");
		String taskshomepage =  d.selectSingleNode("//freecrm//login//taskspage").getText();
		driver.findElement(By.xpath(taskshomepage)).click();
		driver.quit();
	}
	
	//----------------------------------------------------- Delete task feature ----------------------------------------------
	
	@Given("User clicks on the delete button for the existing task in task module")
	public void user_clicks_on_the_delete_button_for_the_existing_task() throws InterruptedException {
		Thread.sleep(3000);
//		String delete =  d.selectSingleNode("//freecrm//deletetask//delete").getText();
	    driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/table/tbody/tr[1]/td[7]/div/button")).click();	    
	}

	@Given("User is displayed a delete confirmation pop up")
	public void user_is_displayed_a_delete_confirmation_pop_up() {
		assertEquals(driver.getTitle(),"Cogmento CRM");	    
	}

	@Given("User clicks on the cancel button in task module")
	public void user_clicks_on_the_cancel_button() throws InterruptedException {
		Thread.sleep(3000);
		String cancel =  d.selectSingleNode("//freecrm//deletetask//cancel").getText();
	    driver.findElement(By.xpath(cancel)).click();	    
	}

	@Then("User is redirected to the tasks page and the deletion process is cancelled")
	public void user_is_redirected_to_the_tasks_page_and_the_deletion_process_is_cancelled() {
//		String taskshomepage =  d.selectSingleNode("//freecrm//login//taskspage").getText();
//	    assertEquals(driver.findElement(By.xpath(taskshomepage)),"Tasks");	
		assertEquals(driver.getTitle(),"Cogmento CRM");	
	    driver.quit();
	}
	
	@Given("User clicks on the Delete button in task module")
	public void user_clicks_on_the_delete_button() throws InterruptedException {
		Thread.sleep(3000);
		//String delete_pop =  d.selectSingleNode("//freecrm//deletetask//delete_pop").getText();
		driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[3]/button[2]/i[1]")).click();
	}
	@Then("User is redirected to tasks page and task is deleted")
	public void user_is_redirected_to_tasks_page_and_task_is_deleted() {
		assertEquals(driver.getTitle(),"Cogmento CRM");	
		driver.quit();
	}
	
//	//----------------------------------------------------- Filter task feature ----------------------------------------------
//	
	@Given("User is on the tasks home page")
	public void user_is_on_the_tasks_home_page() {
		assertEquals(driver.getTitle(),"Cogmento CRM");
	}
	
	@Given("User clicks on the show filters button in task module")
	public void user_clicks_on_the_show_filters_button() throws InterruptedException {
		String filter =  d.selectSingleNode("//freecrm//filtertask//filter").getText();
	    driver.findElement(By.xpath(filter)).click();
	    Thread.sleep(3000);
	}

	@Given("User selects the type for search in task module")
	public void user_selects_the_type_for_search() {
		String search =  d.selectSingleNode("//freecrm//filtertask//search").getText();
		driver.findElement(By.xpath(search)).sendKeys("Title");
//		
//		String search_click =  d.selectSingleNode("//freecrm//filtertask//search_click").getText();
//	    driver.findElement(By.xpath(search_click)).click();	
	}

	@Given("User selects an operator for search filter in task module")
	public void user_selects_an_operator_for_search_filter() {
		String type =  d.selectSingleNode("//freecrm//filtertask//type").getText();
		driver.findElement(By.xpath(type)).click();	
	}

	@Given("User enters the value with <{string}> in Task module")
	public void user_enters_the_value_with(String string) throws InterruptedException {
		String value =  d.selectSingleNode("//freecrm//filtertask//value").getText();
	    driver.findElement(By.xpath(value)).sendKeys(string);
	    Thread.sleep(3000);	    
	}

	@Given("User clicks on the filter button in task module")
	public void user_clicks_on_the_filter_button() {
		String filter_search =  d.selectSingleNode("//freecrm//filtertask//filter_search").getText();
	    driver.findElement(By.xpath(filter_search)).click();	    
	}

	@Given("User clicks on the clear button in task module")
	public void user_clicks_on_the_clear_button() throws InterruptedException {
		String clear_filter =  d.selectSingleNode("//freecrm//filtertask//clear_filter").getText();
		Thread.sleep(3000);
	    driver.findElement(By.xpath(clear_filter)).click();
	}
	
	@Then("User is able to view the tasks with the filters applied")
	public void user_is_able_to_view_the_tasks_with_the_filters_applied() throws InterruptedException {
		assertEquals(driver.getTitle(),"Cogmento CRM");
		//assertEquals(driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/table/tbody/tr/td[2]/a")).getText(),"demo5");
	    driver.quit();
	}
}
