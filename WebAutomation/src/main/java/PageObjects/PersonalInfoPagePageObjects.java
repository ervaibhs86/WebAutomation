package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PersonalInfoPagePageObjects {

		//Defining a driver to identify the elements and drive the test execution
		WebDriver driver;

		//Creating a constructor to initialize the elements of login page
		public PersonalInfoPagePageObjects(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,  this);
		}

		//FirstName TextBox
		@FindBy(how=How.ID, using="firstname")
		public WebElement firstNameTextBox;
		
		//Old password text Box
		@FindBy(how=How.ID, using="old_passwd")
		public WebElement oldPswdTextBox;
				
		//Save Button
		@FindBy(how=How.XPATH, using="//span[contains(text(),'Save')]")
		public WebElement saveBtn;
		
		//Success Message
		@FindBy(how=How.XPATH, using="//p[@class='alert alert-success']")
		public WebElement successMsg;
		
		//Name for the logged in user
		@FindBy(how=How.XPATH, using="//a[@class='account']")
		public WebElement loggedInUser;
		
		//Sign-out link
		@FindBy(how=How.XPATH, using="//a[@class='logout'][@title='Log me out']")
		public WebElement signOutLink;
}