package com.generic;

import java.sql.DriverManager;
import java.time.Duration;

import javax.swing.text.Highlighter.Highlight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.seleniumpagefactory.SeleniumPageFactoryPractice;
import com.util.Contants;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.Constant;

public class BaseLogin {
	
	public void getLogin(){
		//open a browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		SeleniumWait.getImplicitWait(driver, 3);
		// go to URL
		driver.navigate().to(Contants.URL);
		ScreenShot.getScreenShot(driver, "Home page");
		//explicit wait=WebDriver wait
		SeleniumPageFactoryPractice pf = new SeleniumPageFactoryPractice(driver);
		SeleniumWait.getExplicitWait(driver, pf.getSigninbtn().get(0),3);
		//click sign in
		HighLighter.getColor(driver, pf.getSigninbtn().get(0));
		pf.getSigninbtn().get(0).click();
		//put user
		ScreenShot.getScreenShot(driver, "Login page");
		HighLighter.getColor(driver, pf.getEmail());
		pf.getEmail().click();
		pf.getEmail().sendKeys(Contants.user);
		//put pass
		HighLighter.getColor(driver, pf.getPassword());
		HighLighter.getColor(driver, pf.getPassword(),"green");
		pf.getPassword().click();
		pf.getPassword().sendKeys(Contants.password);
		//click second sign in
		HighLighter.getColor(driver, pf.getSecondsigninbtn());
		pf.getSecondsigninbtn().click();
		ScreenShot.getScreenShot(driver, "Login Validation");
		//validation

		boolean status =pf.getWelcome().get(0).isDisplayed();
		//Assertion = Hard & soft
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(status);//condition =true or false		
		sa.assertAll();//validation
	}
}
