package TestCases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import MyUtils.BaseClass;
import MyUtils.HelperClass;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import PageObjects.LoginPagePageObjects;
import PageObjects.MyAccountPagePageObjects;
import PageObjects.PersonalInfoPagePageObjects;

public class PersonalInformationPageTestCases {

	MyAccountPagePageObjects objMyAccPage;
	PersonalInfoPagePageObjects objPersonalInfo;
	
	@Before
	public void baseMethod(){
		base = BaseClass.getInstance();
		driver = base.openBrowser();
		objPersonalInfo=new PersonalInfoPagePageObjects(driver);
		objMyAccPage = new MyAccountPagePageObjects(driver);
	}
	
	private BaseClass base = BaseClass.getInstance();
	WebDriver driver = base.openBrowser();
	
	
	@When("^User clicks on the My Personal Information link$")
	public void user_clicks_on_the_My_Personal_Information_link() throws Throwable {
		objMyAccPage.myInfoLink.click();
	}

	@When("^User updates the FirstName$")
	public void user_updates_the_FirstName() throws Throwable {
		String name=HelperClass.getDataFromExcel("TestData","NewName");
		objPersonalInfo.firstNameTextBox.sendKeys(HelperClass.getDataFromExcel("TestData","NewName"));
		objPersonalInfo.firstNameTextBox.clear();
		//Reading data from excel
		objPersonalInfo.firstNameTextBox.sendKeys(HelperClass.getDataFromExcel("TestData","NewName"));
	}

	@When("^User enters his password and clicks on Save$")
	public void user_enters_his_password_and_clicks_on_Save() throws Throwable {
		objPersonalInfo.oldPswdTextBox.sendKeys(HelperClass.getDataFromConfig("password"));
		objPersonalInfo.saveBtn.click();
	}

	@Then("^User gets a confirmation and the FirstName is updated successfully$")
	public void user_gets_a_confirmation_and_the_FirstName_is_updated_successfully() throws Throwable {
		Assert.assertTrue(objPersonalInfo.successMsg.isDisplayed());
		objPersonalInfo.signOutLink.click();
	}
}