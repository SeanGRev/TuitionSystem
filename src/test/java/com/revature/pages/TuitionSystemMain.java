package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TuitionSystemMain {

	public WebDriver driver;
	
	@FindBy(id = "requestPageLink")
	public WebElement requestLink;
	
	@FindBy(id = "reimbursementPageLink")
	public WebElement reimbursementLink;
	
	@FindBy(id = "eventPageLink")
	public WebElement eventLink;
	
	public TuitionSystemMain(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
