package TestCases;

import org.junit.Assert;
import PageObjects.LoginPagePageObjects;
import PageObjects.MyAccountPagePageObjects;
import MyUtils.BaseClass;
import MyUtils.HelperClass;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;

public class LoginPageTestCases{
	private BaseClass base;
	WebDriver driver;
	LoginPagePageObjects objLoginPage;
	MyAccountPagePageObjects objMyAccPage;
	 
	@Before
	public void baseMethod(){
		base = BaseClass.getInstance();
		driver = base.openBrowser();
		objLoginPage = new LoginPagePageObjects(driver);
		objMyAccPage = new MyAccountPagePageObjects(driver);
	}
	 
	 

	// Setting up drive and launching the application before every scenario
	//@Before
	@Given("^A global driver is used for entire test$")
	public void a_global_driver_is_used_for_entire_test() throws Throwable {
		base.setupApplication();
	}

	@Given("^User is on the home page$")
	public void User_is_on_the_home_page() throws Throwable {

		// Click on the Sign-In link on the home page
		objLoginPage.signInLink.click();
	}

	@When("^User enters the UserName and password and clicks on the SignIn button")
	public void User_enters_the_UserName_and_password_and_clicks_on_the_SignIn_button() throws Throwable
	{
		// Login to the application using credentials from the config file(As it is a comman functionality, moved it to the MyUtils helper class).
		objLoginPage.loginApp(HelperClass.getDataFromConfig("userName"), HelperClass.getDataFromConfig("password"));
	}
	
	@Then("^User is able to login to the shopping site Successfully")
	public void User_is_able_to_login_to_the_shopping_site_Successfully() throws Throwable
	{
		// If user is logged in successfully, Check the signout link and display a success message
		Assert.assertTrue(objLoginPage.signOutLink.isDisplayed());
	}
	
	@When("^User navigates to the TShirts page$")
	public void user_navigates_to_the_TShirts_page() throws Throwable {
		objMyAccPage.menuBar.click();
		HelperClass.explicitWait(driver, objMyAccPage.tshirtsLink);
		objMyAccPage.tshirtsLink.click();
	}

}
