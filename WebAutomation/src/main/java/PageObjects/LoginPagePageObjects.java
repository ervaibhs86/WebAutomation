package PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePageObjects {

		//Defining a driver to identify the elements and drive the test execution
		WebDriver driver;

		//Creating a constructor to initialize the elements of login page
		public LoginPagePageObjects(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,  this);
		}

		//SignIn link
		@FindBy(how=How.XPATH, using="//a[@class='login']")
		public WebElement signInLink;
		
		//UserID text box
		@FindBy(how=How.ID, using="email")
		public WebElement userIdTextBox;
		
		//Password text box
		@FindBy(how=How.ID, using="passwd")
		public WebElement passwordTextBox;
		
		//SignIn Button
		@FindBy(how=How.XPATH, using="//p[@class='submit']//span[1]")
		public WebElement signInBtn;

		//SignOut link
		@FindBy(how=How.XPATH, using="//a[@class='logout']")
		public WebElement signOutLink;
	
		
		//Method to login to the application
		public void loginApp(String strUser, String strPass) throws IOException
		{			
			userIdTextBox.sendKeys(strUser);
			passwordTextBox.sendKeys(strPass);
			signInBtn.click();
		}

}