package com.seleniumpagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPageFactoryPractice {

	WebDriver driver;
	public SeleniumPageFactoryPractice (WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	
	@FindBy (xpath="(//*[@class='authorization-link'])")
	private List <WebElement> signinbtn;
	@FindBy (xpath="(//*[@id='email'])")
	private WebElement email;
	@FindBy (xpath="(//*[@title='Password'])")
	private WebElement password;
	@FindBy (xpath="(//*[@class='action login primary'])")
	private WebElement secondsigninbtn;
	@FindBy (xpath="//*[@class='greet welcome']")
	private List <WebElement> welcome;
	
	public List<WebElement> getSigninbtn() {
		return signinbtn;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getSecondsigninbtn() {
		return secondsigninbtn;
	}
	public List<WebElement> getWelcome() {
		return welcome;
	}
	
	

}
