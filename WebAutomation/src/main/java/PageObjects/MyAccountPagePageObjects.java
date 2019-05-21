package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPagePageObjects {

	//Defining a driver to identify the elements and drive the test execution
	WebDriver driver;

	//Creating a constructor to initialize the elements of login page
	public MyAccountPagePageObjects(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//MenuBar
	@FindBy(how=How.ID, using="block_top_menu")
	public WebElement menuBar;
	
	//TShirts link
	@FindBy(how=How.XPATH, using="//div[@id='block_top_menu']//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//li[3]//a[@title='T-shirts']")
	public WebElement tshirtsLink;
	
	//My Personal Info Link
	@FindBy(how=How.XPATH, using="//span[text()='My personal information']")
	public WebElement myInfoLink;
}