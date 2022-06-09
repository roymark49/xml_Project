package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {
	
	
	WebDriver driver;
	
	
	
	@Test
	@Parameters({"USERNAME", "PASSWORD"})
	public void validUserShouldBeAbleToLogin(String USERNAME,String PASSWORD) {
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(USERNAME);
		loginPage.insertPassword(PASSWORD);
		loginPage.clickLoginButton();
		
		DashBoardPage dashBoardPage = PageFactory.initElements(driver, DashBoardPage.class);
		dashBoardPage.varifyDashboardHeader("Dashboard");
		
		BrowserFactory.tearDown();
	}
}
