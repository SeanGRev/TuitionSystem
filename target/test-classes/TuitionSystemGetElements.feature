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
