package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TShirtsPagePageObjects {

	//Defining a driver to identify the elements and drive the test execution
	WebDriver driver;

	//Creating a constructor to initialize the elements of login page
	public TShirtsPagePageObjects(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,  this);
	}

	//T-Shirt image
	@FindBy(how=How.XPATH, using="//img[@alt='Faded Short Sleeve T-shirts']")
	public WebElement tShirtImage;
	
	//In-stock label
	@FindBy(how=How.XPATH, using="//span[@class='available-now']")
	public WebElement inStockLabel;
	
	//Add To Cart Button
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Add to cart')]")
	public WebElement addToCartBtn;

	//Proceed to Checkout Button
	@FindBy(how=How.XPATH, using="//div[@class='button-container']//a[@title='Proceed to checkout']/span[contains(text(),'Proceed to checkout')]")
	public WebElement proceedToChkOutBtn;

	//Confirmation button
	@FindBy(how=How.XPATH, using="//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']")
	public WebElement cnfrmChkOutBtn;
	
	//Confirm Address button
	@FindBy(how=How.XPATH, using="//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
	public WebElement cnfrmAddress;
		
	//Check Box for Confirmation
	@FindBy(how=How.ID, using="cgv")
	public WebElement cnfrmChkBox;
		
	//Confirmation button for shipping
	@FindBy(how=How.XPATH, using="//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
	public WebElement cnfrmShippingBtn;
		
	//Pay by Cheque option
	@FindBy(how=How.CLASS_NAME, using="cheque")
	public WebElement payByChequeue;
	
	//Final Confirmation button
	@FindBy(how=How.XPATH, using="//span[contains(text(),'I confirm my order')]")
	public WebElement finalConfirmation;

	//Back to orders link
	@FindBy(how=How.XPATH, using="//a[@class='button-exclusive btn btn-default']")
	public WebElement backToOrdersLink;
	
	//Order History item
	@FindBy(how=How.XPATH, using="//tr[contains(@class,'first_item')]")
	public WebElement orderHistory;
	
	//Sign-out link
	@FindBy(how=How.XPATH, using="//a[@class='logout'][@title='Log me out']")
	public WebElement signOutLink;	
}