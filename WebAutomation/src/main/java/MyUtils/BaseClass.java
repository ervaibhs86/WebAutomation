package MyUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

    private static BaseClass instance=null;
    private WebDriver driver = null;


    private BaseClass(){

    }

    public WebDriver openBrowser(){

    	if(driver==null)
    	{
    		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\setup\\chromedriver.exe");
    	    driver = new ChromeDriver();
    	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	    driver.manage().window().maximize();           	
    	}
        return driver;
    }

    public static BaseClass getInstance(){
        if(instance==null){
            instance = new BaseClass();
        }
        return instance;
    }
    
    public void setupApplication() throws IOException{
		driver.navigate().to(HelperClass.getDataFromConfig("url"));
	}
	
	public void closeApplication()
	{
		driver.quit();
	}
}