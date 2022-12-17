package com.cucumber.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import com.seleniumpagefactory.SeleniumPageFactoryPractice;
import com.util.Contants;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef {
	
	WebDriver driver;
	SeleniumPageFactoryPractice pf;
	
	@Given("open any browser")
	public void open_any_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		SeleniumWait.getImplicitWait(driver, 3); 
	}

	@And("go to application URL")
	public void go_to_application_URL() {
		driver.navigate().to(Contants.URL);
		ScreenShot.getScreenShot(driver, "Home page");
		pf = new SeleniumPageFactoryPractice(driver); 
	   
	}
	
	@When("click signin button")
	public void click_signin_button() {
		SeleniumWait.getExplicitWait(driver, pf.getSigninbtn().get(0),3);
		HighLighter.getColor(driver, pf.getSigninbtn().get(0));
		pf.getSigninbtn().get(0).click(); 
		ScreenShot.getScreenShot(driver, "Login page");
	}

	@And("put Email")
	public void put_Email() {
		HighLighter.getColor(driver, pf.getEmail());
		pf.getEmail().click();
		pf.getEmail().sendKeys(Contants.user);  
	    
	}

	@And("put password")
	public void put_password() {
		HighLighter.getColor(driver, pf.getPassword());
		pf.getPassword().click();
		pf.getPassword().sendKeys(Contants.password);
	    
	}

	@And("click second signin button")
	public void click_second_signin_button() {
		HighLighter.getColor(driver, pf.getSecondsigninbtn());
		pf.getSecondsigninbtn().click();
		ScreenShot.getScreenShot(driver, "Login Validation");
	    
	}

	@Then("validate login was successful")
	public void validate_login_was_successful() {
		boolean status =pf.getWelcome().get(0).isDisplayed();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(status);
		sa.assertAll();
	    
	}


	
}
