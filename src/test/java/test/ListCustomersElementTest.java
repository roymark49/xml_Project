package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashBoardPage;
import page.ListCustomersPage;
import page.LoginPage;
import util.BrowserFactory;

public class ListCustomersElementTest {
WebDriver driver;
	
	@Test
	@Parameters({"USERNAME", "PASSWORD", "FULLNAME", "COMPANY", "EMAIL", "PHONE", "ADDRESS", "CITY", "STATE", "ZIP", "COUNTRY"})
	
	public void validUserShouldBeAbleToAddContactonListCustomer(String USERNAME,String PASSWORD, String FULLNAME, String COMPANY, String EMAIL, String PHONE, String ADDRESS, String CITY, String STATE, String ZIP,String COUNTRY) {
		
		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(USERNAME);
		loginPage.insertPassword(PASSWORD);
		loginPage.clickLoginButton();
		
		//calling from DashboardPage and performing all the necessary actions
		DashBoardPage dashboardPage = PageFactory.initElements(driver, DashBoardPage.class);
		dashboardPage.varifyDashboardHeader("Dashboard");
		
		dashboardPage.clickCustomerButton();
		
		ListCustomersPage listCustomersPage = PageFactory.initElements(driver, ListCustomersPage.class);
		listCustomersPage.clickOnListCustomersmenu();
		listCustomersPage.clickAddCustomerButtonOnListCustomer();
		
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
		
		listCustomersPage.clickOnListCustomersmenu();
		listCustomersPage.insertSearchBarOnListCustomer();
		listCustomersPage.verifyInsertedNameOnSearchBar();
		}
}
