package com.stepDefinition;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CompaniesTest extends com.runner.FreeCRMRunner{
	public static WebDriver driver;
@Given("User is on Login page")
public void user_is_on_login_page() {
	System.setProperty("webdriver.chrome.driver", "E:\\Capgemini training\\drivers\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.navigate().to("https://ui.cogmento.com/");
	driver.manage().window().maximize();
	
}

@Given("User enters username with <{string}>")
public void user_enters_username_with(String string) throws InterruptedException {
	 Thread.sleep(5000);
     driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div/div[1]/div/input")).sendKeys(string);
}

@Given("User enters password with <{string}>")
public void user_enters_password_with(String string) {
	 
    driver.findElement(By.name("password")).sendKeys(string);
}

@Given("User Clicks on login button")
public void user_clicks_on_login_button() {
	driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]")).click();
}

@Then("UseR is logged in")
public void use_r_is_logged_in() throws InterruptedException {
    assertEquals(driver.getTitle(),"Cogmento CRM");
    Thread.sleep(5000);
}


}
