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
	
	@When("^The User types in \"([^\"]*)\" in the Request ID input$")
	public void the_User_types_in_in_the_Request_ID_input(String arg1) throws Throwable {
	    tuitionSystemMain.requestIdInput.sendKeys(String.valueOf(arg1));
	}

	@When("^The User clicks Get Data$")
	public void the_User_clicks_Get_Data() throws Throwable {
	    tuitionSystemMain.getRequestButton.click();
	}

	@Then("^The table below should not be null$")
	public void the_table_below_should_not_be_null() throws Throwable {
	    assertNotNull(tuitionSystemMain.requestid.getText());
	}

	@When("^The User types in \"([^\"]*)\" in the Reimbursement ID input$")
	public void the_User_types_in_in_the_Reimbursement_ID_input(String arg1) throws Throwable {
		tuitionSystemMain.reimbursementIdInput.sendKeys(String.valueOf(arg1));
	}

	@When("^The User clicks Get Data for Reimbursement$")
	public void the_User_clicks_Get_Data_for_Reimbursement() throws Throwable {
		tuitionSystemMain.getReimbursementButton.click();
	}

	@Then("^The reimbursement table below should not be null$")
	public void the_reimbursement_table_below_should_not_be_null() throws Throwable {
		assertNotNull(tuitionSystemMain.reimbursementid.getText());
	}
	
	@When("^The User types in \"([^\"]*)\" in the Event ID input$")
	public void the_User_types_in_in_the_Event_ID_input(String arg1) throws Throwable {
		tuitionSystemMain.eventIdInput.sendKeys(String.valueOf(arg1));
	}

	@When("^The User clicks Get Data for Event$")
	public void the_User_clicks_Get_Data_for_Event() throws Throwable {
		tuitionSystemMain.getEventButton.click();
	}

	@Then("^The event table below should not be null$")
	public void the_event_table_below_should_not_be_null() throws Throwable {
		assertNotNull(tuitionSystemMain.eventid.getText());
	}
	

	
}
