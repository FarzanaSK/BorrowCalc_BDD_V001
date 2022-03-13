Feature: Borrow Calculation

Background:
	Given User Launch Chrome browser 
	And Navigate to the URL "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow"

Scenario: TC001_To check successful borrow estimate calculation 
	 
	When User selects the Application type as Single
	And User selects Number of Dependants as 0 
	And User selects Property you would like to buy as Home to live in 
	And User enters Your annual income as "80000"
	And User enters Your annual other income as "10000"
	And User enters Monthly living expenses as "100"
	And User enters Current home loan monthly repayments as "0"
	And User enters Other loan monthly repayments as "100"
	And User enters Other monthly commitments as "0"
	And User enters Total credit limits as "10000"
	And User clicks on the Work out how much i could borrow button
	Then We estimate you could borrow should display 482000
	And close the browser     
	
Scenario: TC002_To Check if all the fields get cleared on clicking the StartOver button
	 
	When User selects the Application type as Single
	And User selects Number of Dependants as 0 
	And User selects Property you would like to buy as Home to live in 
	And User enters Your annual income as "80000"
	And User enters Your annual other income as "10000"
	And User enters Monthly living expenses as "100"
	And User enters Current home loan monthly repayments as "0"
	And User enters Other loan monthly repayments as "100"
	And User enters Other monthly commitments as "0"
	And User enters Total credit limits as "10000"
	And User clicks on the Work out how much i could borrow button
	Then We estimate you could borrow should display 482000
	When Click on the Start Over button  
	And close the browser 
	
	
Scenario: TC003_To Check if all the fields get cleared on clicking the StartOver button
	
	When User enters Monthly living expenses as "1" 
	And User clicks on the Work out how much i could borrow button
	Then The message "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500." is displayed
	And close the browser  
	
	
	
	
	 


 
