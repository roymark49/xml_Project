package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;


public class AddContactTest {
	WebDriver driver;
	//Connecting my excel file with the project, using object of the Excel Reader
	
	//Test Data coming from Excel file
	
	@Test
	@Parameters({"USERNAME", "PASSWORD", "FULLNAME", "COMPANY", "EMAIL", "PHONE", "ADDRESS", "CITY", "STATE", "ZIP", "COUNTRY"})
	public void userShouldBeAbleToAddContact(String USERNAME,String PASSWORD, String FULLNAME, String COMPANY, String EMAIL, String PHONE, String ADDRESS, String CITY, String STATE, String ZIP,String COUNTRY) {
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(USERNAME);
		loginPage.insertPassword(PASSWORD);
		loginPage.clickLoginButton();
		
		
		//calling from dashboard page and performing all the action(Assertion, click click)
		DashBoardPage dashBoadPage = PageFactory.initElements(driver, DashBoardPage.class);
		dashBoadPage.varifyDashboardHeader("Dashboard");
		dashBoadPage.clickCustomerButton();
		dashBoadPage.clickAddCustomerButton();
		
		
		AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);
		addContactPage.validateAddContactPage("Add Contact");
		addContactPage.insertFullName(FULLNAME);
		addContactPage.selectCompany(COMPANY);
		addContactPage.insertEmail(EMAIL);
		addContactPage.insertPhone(PHONE);
		addContactPage.insertAddress(ADDRESS);
		addContactPage.insertCity(CITY);
		addContactPage.insertState(STATE);
		addContactPage.insertZip(ZIP);
		addContactPage.selectCountry(COUNTRY);
		addContactPage.clickSaveButton();
		addContactPage.validateNewContact("Accounting Summary");
		BrowserFactory.tearDown();
		//Time to validate contact
		
		
		
		
		
		
	}
	
}
