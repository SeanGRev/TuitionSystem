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
	
	@FindBy(id = "RequestIdInput")
	public WebElement requestIdInput;
	
	@FindBy(id = "getRequestButton")
	public WebElement getRequestButton;
	
	@FindBy(id = "requestid")
	public WebElement requestid;
	
	@FindBy(id = "ReimbursementIdInput")
	public WebElement reimbursementIdInput;
	
	@FindBy(id = "getReimbursementButton")
	public WebElement getReimbursementButton;
	
	@FindBy(id = "reimbursementid")
	public WebElement reimbursementid;
	
	@FindBy(id = "EventIdInput")
	public WebElement eventIdInput;
	
	@FindBy(id = "getEventButton")
	public WebElement getEventButton;
	
	@FindBy(id = "eventid")
	public WebElement eventid;
	
	public TuitionSystemMain(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
