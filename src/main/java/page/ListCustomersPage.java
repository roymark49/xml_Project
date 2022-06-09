package page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ListCustomersPage {
	WebDriver driver;
	String first_half_of_xpath = "//tbody/tr[";
	String last_half_of_xpath = "]/td[3]";

	// we created a constructor to hold our driver variable, because when we use the
	// PageFactory() method we declared driver as one of the arguments
	public ListCustomersPage(WebDriver driver) {
		this.driver = driver;
	}

	// element list
	// element list
	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-primary']")
	WebElement IMPORT_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[2]/div/div/div[1]/a[3]")
	WebElement EXPORT_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[1]/a[1]")
	WebElement ADD_CUSTOMER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"foo_filter\"]")
	WebElement SEARCH_BOX_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[text()='List Customers']")
	WebElement LIST_CUSTOMERS_MENU;
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement ALERT_WINDOW_OK_ELEMENT;

	public void clickOnListCustomersmenu() {
		LIST_CUSTOMERS_MENU.click();

	}

	public void verifyListCustomersPage(String expectedText) {
		Assert.assertEquals(IMPORT_ELEMENT.getText(), expectedText, "Wrong page");
	}

	public void verifyInsertedNameAndDeleteButton(String foundname) {

		// customized xpath needed to find an element that is shifting inside a table

		String last_half_of_xpath_delete_button = "]/td[7]/a[2]";

		for (int i = 1; i <= 5;) {
			String name = driver.findElement(By.xpath(first_half_of_xpath + i + last_half_of_xpath)).getText();

			if (name.contains(foundname)) {
				System.out.println(name);
				System.out.println("Name found");
				// clicking on the corresponding delete button when we find our matched data
				// inside the table
				driver.findElement(By.xpath(first_half_of_xpath + i + last_half_of_xpath_delete_button)).click();

				// waiting for the alert popup to load
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				// clicking on the OK button of the alert box
				ALERT_WINDOW_OK_ELEMENT.click();
			}
			// break is needed to break out of the loop, when the if condition is met
			break;
		}

	}

	public void clickAddCustomerButtonOnListCustomer() {
		ADD_CUSTOMER_ELEMENT.click();
	}
	String enteredName;
	public void insertSearchBarOnListCustomer() {
		enteredName = AddContactPage.getEnteredName();
		SEARCH_BOX_ELEMENT.sendKeys(enteredName);
	}
	public void verifyInsertedNameOnSearchBar() {
		
		for(int i=1; i<=5; i++) {
			String insertedName = driver.findElement(By.xpath(first_half_of_xpath + i + last_half_of_xpath)).getText();
		
		if(insertedName.contains(enteredName)) {
			System.out.println(enteredName);
			System.out.println("Name Found");
		}
	}
}

}
