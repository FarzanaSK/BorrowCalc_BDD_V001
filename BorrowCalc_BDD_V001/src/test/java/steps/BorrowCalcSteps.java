package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.BrowserCalc_Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BorrowCalcSteps extends BrowserCalc_Base {

	public BrowserCalc_Base base;
	public JavascriptExecutor je;
	public ChromeOptions options;

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		je = (JavascriptExecutor) driver;
	}

	@Given("Navigate to the URL {string}")
	public void navigate_to_the_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@When("User selects the Application type as Single")
	public void user_selects_the_application_type_as() {
		driver.findElement(By.id("application_type_single")).click();
	}

	@When("User selects Number of Dependants as 0")
	public void user_selects_number_of_dependants_as() {
		WebElement eleDependants = driver.findElement(By.xpath("//select[@title=\"Number of dependants\"]"));
		Select ddDependants = new Select(eleDependants);
		ddDependants.selectByIndex(0);
	}

	@When("User selects Property you would like to buy as Home to live in")
	public void user_selects_property_you_would_like_to_buy_as() {
		WebElement eleProperty = driver.findElement(By.id("borrow_type_home"));
		je.executeScript("arguments[0].scrollIntoView(true);", eleProperty);
	}

	@When("User enters Your annual income as {string}")
	public void user_enters_your_annual_income_as(String income) {
		driver.findElement(By.xpath("//label[contains(text(),\"Your annual income\")]/following::input[1]")).sendKeys(income);
	}

	@When("User enters Your annual other income as {string}")
	public void user_enters_your_annual_other_income_as(String otherincome) {
		driver.findElement(By.xpath("//label[contains(text(),\"Your annual other income (optional)\")]/following-sibling::div/input")).sendKeys(otherincome);
	}

	@When("User enters Monthly living expenses as {string}")
	public void user_enters_monthly_living_expenses_as(String mexpense) {
		driver.findElement(By.id("expenses")).sendKeys(mexpense);
	}

	@When("User enters Current home loan monthly repayments as {string}")
	public void user_enters_current_home_loan_monthly_repayments_as(String hloan) {
		driver.findElement(By.id("homeloans")).sendKeys(hloan);
	}

	@When("User enters Other loan monthly repayments as {string}")
	public void user_enters_other_loan_monthly_repayments_as(String otherloan) {
		driver.findElement(By.xpath("//label[contains(text(),'Other loan monthly repayments')]/following-sibling::div/input")).sendKeys(otherloan);
	}

	@When("User enters Other monthly commitments as {string}")
	public void user_enters_other_monthly_commitments_as(String mcommit) {
		driver.findElement(By.xpath("//label[contains(text(),'Other monthly commitments')]/following-sibling::div/input")).sendKeys(mcommit);
	}

	@When("User enters Total credit limits as {string}")
	public void user_enters_total_credit_limits_as(String climit) {
		driver.findElement(By.xpath("//label[contains(text(),'Total credit card limits')]/following-sibling::div/input")).sendKeys(climit);
	}

	@When("User clicks on the Work out how much i could borrow button")
	public void user_clicks_on_the_work_out_how_much_i_could_borrow_button() throws InterruptedException {

		driver.findElement(By.id("btnBorrowCalculater")).click();
		Thread.sleep(3000);
	}

	@Then("We estimate you could borrow should display {int}")
	public void we_estimate_you_could_borrow_should_display(Integer Amount) {
		String amountdisp = driver.findElement(By.id("borrowResultTextAmount")).getText();
		amountdisp = amountdisp.replaceAll("[^a-zA-Z0-9]", "");

		int a = Integer.parseInt(amountdisp);
		System.out.println(a);
		if (Amount == a) {
			System.out.println("The amount to be borrowed is calculated correctly");

		} else {
			System.out.println("The Amount to be calucated is not displaying properly");
		}
	}
	@When("Click on the Start Over button")
	public void click_on_the_start_over_button() {

		// clicking on Start over
		WebElement eleStartOver = driver.findElement(By.xpath("//div[@class='result__restart']/button/span"));
		je.executeScript("arguments[0].click();", eleStartOver);
		
		// Getting the value of Number of dependants 
		String eleDependants = driver.findElement(By.xpath("//select[@title=\"Number of dependants\"]")).getAttribute("value");
		 
		//System.out.println(eleDependants.getAttribute("value"));

		// Getting the value of Annual Income
		String eleAnnualIncome = driver.findElement(By.xpath("//label[contains(text(),'Your annual income')]/following::input[1]")).getAttribute("value");
		System.out.println(eleAnnualIncome);

		// Getting the value of Other Annual Income
		String eleOtherIncome = driver.findElement(By.xpath("//label[contains(text(),'Your annual other income (optional)')]/following-sibling::div/input")).getAttribute("value");
		System.out.println(eleOtherIncome);

		// Entering Monthly Expenses
		String eleMonthlyExpenses = driver.findElement(By.id("expenses")).getAttribute("value");
		System.out.println(eleMonthlyExpenses);

		// Getting the value of home loans
		String eleHomeLoans = driver.findElement(By.id("homeloans")).getAttribute("value");
		System.out.println(eleHomeLoans);
		Assert.assertEquals(eleHomeLoans, "0");

		// Getting the value of other loans
		String eleOtherLoans = driver.findElement(By.xpath("//label[contains(text(),'Other loan monthly repayments')]/following-sibling::div/input")).getAttribute("value");
		System.out.println(eleOtherLoans);

		// Getting the value of other monthly commitments
		String eleOtherCommitements = driver.findElement(By.xpath("//label[contains(text(),'Other monthly commitments')]/following-sibling::div/input")).getAttribute("value");
		System.out.println(eleOtherCommitements);

		// Getting the value of total credit card limits
		String eleCreditCard = driver.findElement(By.xpath("//label[contains(text(),'Total credit card limits')]/following-sibling::div/input")).getAttribute("value");
		System.out.println(eleCreditCard);

		if ((eleDependants.equals("0"))&&(eleAnnualIncome.equals("0")) && (eleOtherIncome.equals("0")) && (eleCreditCard.equals("0"))
				&& (eleMonthlyExpenses.equals("0")) && (eleHomeLoans.equals("0")) && (eleOtherLoans.equals("0"))
				&& (eleOtherCommitements.equals("0"))) {
			System.out.println("On Clicking the Start Over Button all the fields get cleared");
		}
	}

	@Then("The message {string} is displayed")
	public void the_message_is_displayed(String msg) {
		String eleErrormsg = driver.findElement(By.xpath("//div[@class='borrow__error__text']")).getText();
		System.out.println(eleErrormsg);
		if(msg.equals(eleErrormsg))
		{
			System.out.println("Error Message displayed correctly");
		}
		else
		{
			System.out.println("Error Message is not Correct");	
		}
	}
	@Then("close the browser")
	public void close_the_browser() {
		driver.close();
	}

}
