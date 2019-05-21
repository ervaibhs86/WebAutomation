package TestCases;

import PageObjects.MyAccountPagePageObjects;
import PageObjects.PersonalInfoPagePageObjects;
import PageObjects.TShirtsPagePageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Mouse;
import org.testng.Assert;

import MyUtils.BaseClass;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;


public class TShirtsPageTestCases {

	MyAccountPagePageObjects objMyAccPage;
	TShirtsPagePageObjects objTshirtsPage;
	
	private BaseClass base = BaseClass.getInstance();
	WebDriver driver = base.openBrowser();
	
	@Before
	public void baseMethod()
	{
		base = BaseClass.getInstance();
		driver = base.openBrowser();
		objTshirtsPage=new TShirtsPagePageObjects(driver);
		objMyAccPage = new MyAccountPagePageObjects(driver);
	}
	
	@When("^User Adds the TShirt to his cart$")
	public void user_Adds_the_TShirt_to_his_cart() throws Throwable {
		MyUtils.HelperClass.explicitWait(driver, objTshirtsPage.tShirtImage);
		objTshirtsPage.inStockLabel.click();
		MyUtils.HelperClass.explicitWait(driver, objTshirtsPage.addToCartBtn);
		objTshirtsPage.addToCartBtn.click();
	}
	
	@When("^User confirms the checkout$")
	public void user_confirms_the_checkout() throws Throwable {
		MyUtils.HelperClass.explicitWait(driver,objTshirtsPage.proceedToChkOutBtn);
		objTshirtsPage.proceedToChkOutBtn.click();
		objTshirtsPage.cnfrmChkOutBtn.click();
	}

	@When("^Proceeds with the checkout process with confirmation of the shipping and payment details$")
	public void proceeds_with_the_checkout_process_with_confirmation_of_the_shipping_and_payment_details() throws Throwable {
		
		//Confirm the address
		objTshirtsPage.cnfrmAddress.click();
		
		//Check the check box for terms n conditions and confirm the shipping
		objTshirtsPage.cnfrmChkBox.click();
		objTshirtsPage.cnfrmShippingBtn.click();
		
		//Confirm the payment by Chequeue
		objTshirtsPage.payByChequeue.click();
		objTshirtsPage.finalConfirmation.click();
	}
	
	@Then("^User should be able to verify the order in order history table$")
	public void user_should_be_able_to_verify_the_order_in_order_history_table() throws Throwable {
	    objTshirtsPage.backToOrdersLink.click();
	    Assert.assertTrue(objTshirtsPage.orderHistory.isDisplayed(), "User is able to verify the order in order history table");
	    objTshirtsPage.signOutLink.click();
	}
}