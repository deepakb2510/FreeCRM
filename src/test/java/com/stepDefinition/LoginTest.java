package com.stepDefinition;

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


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginTest {
	public static WebDriver driver;
	Properties prop=new Properties();
	File f=new File("src\\test\\resources\\properties\\properties.xml");
	SAXReader sr=new SAXReader();
	Document d = null;
	String uname, password;
	File g=new File("src\\test\\resources\\datasource\\login.xlsx");
	
	FileInputStream fs=null;
	XSSFWorkbook w=null;
	XSSFSheet sheet = null;

	@Given("User is on Login page")
	public void user_is_on_login_page() throws InterruptedException, IOException {
		fs=new FileInputStream(g);
		w=new XSSFWorkbook(fs);
		sheet=w.getSheetAt(0);
		try {
			d=sr.read(f);
			} catch (DocumentException e) {
					
			e.printStackTrace();
			}
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		try {
			driver.navigate().to("https://ui.cogmento.com/");
			driver.manage().window().maximize();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Thread.sleep(5000);
	}

	@Given("User Clicks on login button")
	public void user_clicks_on_login_button() throws InterruptedException {
		String submit= d.selectSingleNode("//freecrm//login//submit").getText();
		
		try {
			driver.findElement(By.xpath(submit)).click();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(3000);
	}

	@Then("Invalid request message should appear")
	public void invalid_request_message_should_appear() throws InterruptedException {
		Thread.sleep(2000);		
		String invalid= d.selectSingleNode("//freecrm//login//invalid").getText();
		WebElement warning = driver.findElement(By.xpath(invalid));
		if(warning != null) {
			System.out.println("Warning verified");
		}
		driver.quit();
	}

	@Given("User enters only username with <{string}>")
	public void user_enters_only_username_with(String string) throws InterruptedException {
		
		Thread.sleep(2000);
		uname=sheet.getRow(2).getCell(0).getStringCellValue();
		password=sheet.getRow(2).getCell(1).getStringCellValue();
		String email= d.selectSingleNode("//freecrm//login//email").getText();
		String pass= d.selectSingleNode("//freecrm//login//pass").getText();
		driver.findElement(By.xpath(email)).sendKeys(uname);
		driver.findElement(By.name(pass)).sendKeys(password);
	}

	@Given("User enters only password with <{string}>")
	public void user_enters_only_password_with(String string) throws InterruptedException {
		Thread.sleep(2000);
		uname=sheet.getRow(3).getCell(0).getStringCellValue();
		password=sheet.getRow(3).getCell(1).getStringCellValue();
		String email= d.selectSingleNode("//freecrm//login//email").getText();
		String pass= d.selectSingleNode("//freecrm//login//pass").getText();
		driver.findElement(By.xpath(email)).sendKeys(uname);
		driver.findElement(By.name(pass)).sendKeys(password);
	}

	@Given("User enters username with <{string}>")
	public void user_enters_username_with(String string) throws InterruptedException {
		Thread.sleep(2000);
		uname=sheet.getRow(1).getCell(0).getStringCellValue();
		String email= d.selectSingleNode("//freecrm//login//email").getText();
		driver.findElement(By.xpath(email)).sendKeys(uname);
	}

	@Given("User enters password with <{string}>")
	public void user_enters_password_with(String string) throws InterruptedException {
		password=sheet.getRow(1).getCell(1).getStringCellValue();
		Thread.sleep(2000);
		String pass= d.selectSingleNode("//freecrm//login//pass").getText();
		driver.findElement(By.name(pass)).sendKeys(password);
	}

	@Then("UseR is logged in")
	public void use_r_is_logged_in() {
		String title = driver.getTitle();
		if(title.equals("Cogmento CRM")) {
			System.out.println("User is on login page");
		}
		driver.quit();
	}
}