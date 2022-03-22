
package com.stepDefinition;

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

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
public class Calendar {
	public static WebDriver driver;
	Properties prop=new Properties();
	File f=new File("src\\test\\resources\\properties\\properties.xml");
	SAXReader sr=new SAXReader();
	Document d = null;
	String uname, password, etitle, desc;
 
	File g=new File("src\\test\\resources\\datasource\\Calendar.xlsx");

	FileInputStream fs=null;
	XSSFWorkbook w=null;
	XSSFSheet sheet = null;
@Given("User is on the event page")
public void user_is_on_the_event_page() throws IOException, InterruptedException {
    // Write code here that turns the phrase above into concrete actions
	fs=new FileInputStream(g);
	w=new XSSFWorkbook(fs);
	sheet=w.getSheetAt(0);
	try {
		d=sr.read(f);
		} catch (DocumentException e) {
				// TODO Auto-generated catch block
		e.printStackTrace();
		}
    // Write code here that turns the phrase above into concrete actions
	System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.navigate().to("https://ui.cogmento.com/");
	driver.manage().window().maximize();
	Thread.sleep(3000);
	uname=sheet.getRow(1).getCell(0).getStringCellValue();
	password=sheet.getRow(1).getCell(1).getStringCellValue();
	String email= d.selectSingleNode("//freecrm//login//email").getText();
	String pass= d.selectSingleNode("//freecrm//login//pass").getText();
	Thread.sleep(3000);
	driver.findElement(By.xpath(email)).sendKeys(uname);
	Thread.sleep(3000);
	
	driver.findElement(By.name(pass)).sendKeys(password);
String submit= d.selectSingleNode("//freecrm//login//submit").getText();
	
	try {
		driver.findElement(By.xpath(submit)).click();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	Thread.sleep(3000);
	
	
	
	
	
	String cal = d.selectSingleNode("//freecrm//calendar//cal").getText();
	driver.findElement(By.xpath(cal)).click();
    Thread.sleep(3000);
}

@Given("User clicks on the create event button")
public void user_clicks_on_the_create_event_button() {
    // Write code here that turns the phrase above into concrete actions
	String create = d.selectSingleNode("//freecrm//calendar//create").getText();
	driver.findElement(By.xpath(create)).click();
}

@Then("User is redirected to the create event page")
public void user_is_redirected_to_the_create_event_page() {
    // Write code here that turns the phrase above into concrete actions
    WebElement var=driver.findElement(By.xpath("//div[@class='ui header item mb5 light-black']"));
    if (var!=null) {
    	System.out.println("User is on Create New Event page");
    }
}

@Given("User is on the create event page")
public void user_is_on_the_create_event_page() throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
	Thread.sleep(3000);
}

@Given("User enters the title of the event with <{string}>")
public void user_enters_the_title_of_the_event_with(String string) {
    // Write code here that turns the phrase above into concrete actions
//etitle=sheet.getRow(1).getCell(2).getStringCellValue();
//String title= d.selectSingleNode("//freecrm//calendar//title").getText();
//
//driver.findElement(By.cssSelector(title)).sendKeys(etitle);
 //driver.findElement(By.xpath("//input[@name='title']")).sendKeys(string);
//String title = d.selectSingleNode("//freecrm//calendar//title").getText();
driver.findElement(By.xpath("//input[@name='title']")).sendKeys(string);


}

@Then("User is able to create event")
public void user_is_able_to_create_event() throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
    Thread.sleep(3000);
}

@Given("User clicks on the save button")
public void user_clicks_on_the_save_button() throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
//	String save = d.selectSingleNode("//freecrm//calendar//save").getText();
//	driver.findElement(By.xpath(save)).click();
	driver.findElement(By.xpath("//i[@class='save icon']")).click();
    Thread.sleep(3000);

}

@Then("User is redirected to the event details page which is created")
public void user_is_redirected_to_the_event_details_page_which_is_created() throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
	Thread.sleep(3000);
	//driver.findElement(By.cssSelector("a:nth-child(3) > .ui")).click();
   WebElement var1=driver.findElement(By.xpath("//div[@class='ui header item mb5 light-black']"));
    if (var1!=null) {
    	System.out.println("User is on Created Event page");
    }
    driver.findElement(By.xpath("//*[@id=\"main-nav\"]/div[2]/a/i")).click();
}
}


