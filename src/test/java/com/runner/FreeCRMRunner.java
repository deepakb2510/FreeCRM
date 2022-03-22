package com.runner;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
 
import io.cucumber.testng.PickleWrapper;

//import io.cucumber.junit.Cucumber;
 
 

@CucumberOptions(
features="Features",
glue={"com.stepDefinition"},
plugin={"html:target/cucumber-html-report.html", "json:target/cucumber.json","pretty:target/cucumber-pretty.txt","usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml","pretty","html:target/HtmlReports.html"},
dryRun = false,
monochrome = true

 
)
 

public class FreeCRMRunner {
	 
	 private TestNGCucumberRunner testNGCucumberRunner;
	 
	 public static WebDriver connection;
	 
	 @BeforeClass(alwaysRun = true)
	 public void setUpCucumber() {
	 testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	 }
	 
	 @BeforeMethod(alwaysRun = true)
	 public void setUpClass() throws Exception {

//	 String username = System.getenv("LT_USERNAME") == null ? "YOUR LT_USERNAME" : System.getenv("LT_USERNAME"); 
//	 String accesskey = System.getenv("LT_ACCESS_KEY") == null ? "YOUR LT_ACCESS_KEY" : System.getenv("LT_ACCESS_KEY"); 

//	 DesiredCapabilities capability = new DesiredCapabilities(); 
//	 capability.setCapability(CapabilityType.BROWSER_NAME, browser);
//	 capability.setCapability(CapabilityType.VERSION,version);
//	 capability.setCapability(CapabilityType.PLATFORM, platform); 
//	 capability.setCapability("build", "Your Build Name");
//	 System.setProperty("webdriver.chrome.driver", "E:\\Capgemini training\\drivers\\chromedriver_win32\\chromedriver.exe");
//	 connection = new ChromeDriver();
//	  
//	 System.out.println("Conn="+connection);
	}
	 
	 
	 @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "Scenarios")
	 public void Scenario(PickleWrapper pickle,FeatureWrapper cucumberFeature) {
	 testNGCucumberRunner.runScenario(pickle.getPickle());
	 }
	 
	 @DataProvider
	 public Object[][] Scenarios() {
	 return testNGCucumberRunner.provideScenarios();
	 }
	 
	 @AfterClass(alwaysRun = true)
	 public void tearDownClass() throws Exception {
	 testNGCucumberRunner.finish();
 
	 }
}