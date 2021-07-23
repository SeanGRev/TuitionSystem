@tag
Feature: The Webpage Links Work

	Scenario: 
		Given The Guest is on the Tuition System Main Page
		When The Guest clicks Go To The Requests Page
		Then The Guest should be on the Requests page
		
	Scenario:
		Given The Guest is on the Tuition System Main Page
		When The Guest clicks Go To The Reimbursements Page
		Then The Guest Should be on the Reimbursements page

	Scenario:
		Given The Guest is on the Tuition System Main Page
		When The Guest clicks Go To The Events Page
		Then The Guest Should be on the Events page
		
	Scenario Outline: The Guest tries to search for a Request by ID
		Given The Guest is on the Tuition System Main Page
		When The Guest clicks Go To The Requests Page
		When The User types in "<idValue>" in the Request ID input
		When The User clicks Get Data
		Then The table below should not be null
		
		Examples:
			| idValue |
			| 1 |
			
		Scenario Outline: The Guest tries to search for a Reimbursement by ID
		Given The Guest is on the Tuition System Main Page
		When The Guest clicks Go To The Reimbursements Page
		When The User types in "<ridValue>" in the Reimbursement ID input
		When The User clicks Get Data for Reimbursement
		Then The reimbursement table below should not be null
		
		Examples:
			| ridValue |
			| 1 |
			
		Scenario Outline: The Guest tries to search for a Event by ID
		Given The Guest is on the Tuition System Main Page
		When The Guest clicks Go To The Events Page
		When The User types in "<eidValue>" in the Event ID input
		When The User clicks Get Data for Event
		Then The event table below should not be null
		
		Examples:
			| eidValue |
			| 1 |
