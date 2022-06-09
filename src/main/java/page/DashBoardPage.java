package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashBoardPage {
	WebDriver driver;
	// Constructor

	public DashBoardPage(WebDriver driver) {
		driver = this.driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2")
	WebElement DASHBOARD_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/a/span[1]")
	WebElement CUSTOMER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")
	WebElement ADD_CUSTOMER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a")
	WebElement LIST_CUSTOMER_ELEMENT;

	public void varifyDashboardHeader(String dashboard) {
		Assert.assertEquals(DASHBOARD_HEADER_ELEMENT.getText(), dashboard, "Wrong Page!!");
	}

	public void clickCustomerButton() {
		CUSTOMER_ELEMENT.click();
	}

	public void clickAddCustomerButton() {
		ADD_CUSTOMER_ELEMENT.click();
	}

}
