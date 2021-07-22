package com.revature.steps;

import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;

import com.revature.pages.TuitionSystemMain;
import com.revature.runners.TuitionSystemRunner;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;

public class TuitionSystemStepImpl {

	public static TuitionSystemMain tuitionSystemMain = TuitionSystemRunner.tuitionSystemMain;
	public static WebDriver driver = TuitionSystemRunner.driver;

	@Given("^The Guest is on the Tuition System Main Page$")
	public void the_Guest_is_on_the_Tuition_System_Main_Page() throws Throwable {
		driver.get("file:///C:/Users/seanl/Documents/STSworkspace/TuitionSystem/JScript/index.html");
	}
	
	@When("^The Guest clicks Go To The Requests Page$")
	public void the_Guest_clicks_Go_To_The_Requests_Page() throws Throwable {
	    tuitionSystemMain.requestLink.click();
	}
	
	@Then("^The Guest should be on the Requests page$")
	public void the_Guest_should_be_on_the_Requests_page() throws Throwable {
		assertEquals("Requests Page", driver.getTitle());
	}

	@When("^The Guest clicks Go To The Reimbursements Page$")
	public void the_Guest_clicks_Go_To_The_Reimbursements_Page() throws Throwable {
	    tuitionSystemMain.reimbursementLink.click();
	}

	@Then("^The Guest Should be on the Reimbursements page$")
	public void the_Guest_Should_be_on_the_Reimbursements_page() throws Throwable {
	    assertEquals("Reimbursements Page", driver.getTitle());
	}
	
	@When("^The Guest clicks Go To The Events Page$")
	public void the_Guest_clicks_Go_To_The_Events_Page() throws Throwable {
	    tuitionSystemMain.eventLink.click();
	}

	@Then("^The Guest Should be on the Events page$")
	public void the_Guest_Should_be_on_the_Events_page() throws Throwable {
		assertEquals("Events Page", driver.getTitle());
	}
	
}
