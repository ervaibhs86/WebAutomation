package MyUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//Helper class for common operations
public class HelperClass {

	//defining a static(Class) variable to store the path of the source folder
			static String path=System.getProperty("user.dir");
		
			//Creating a function to get data from config file.
			@SuppressWarnings("finally")
			public static String getDataFromConfig(String key) throws IOException
			{
				String configValue=null;
				Properties prop=new Properties();
				FileReader objFile=new FileReader(path+"\\Config.properties");
				prop.load(objFile);
				//using a try block, incase the key is not available in the config file
				try
				{
					configValue=prop.getProperty(key);
				}
				catch(Exception ex)
				{
					//Print a message and fail the scenario if the key is not present in the config file.
					Assert.fail("Given key was not found in the config file");
				}
				finally
				{
					//return the value for the key
					return(configValue);
				}
			}

			//Creating a function to read data from excel file
			public static String getDataFromExcel(String excelName, String property) throws IOException
			{
				String excelValue=null;
				File myFile=new File(path+"\\"+excelName+".xls");
				FileInputStream fis=new FileInputStream(myFile);
				HSSFWorkbook myWorkBook= new HSSFWorkbook(fis);
				
				Sheet mySheet=myWorkBook.getSheet("Sheet1");
				
				int rowCount=mySheet.getLastRowNum()-mySheet.getFirstRowNum();
				int lastRow=mySheet.getFirstRowNum()+rowCount;
				
				for(int i=mySheet.getFirstRowNum();i<=lastRow;i++)
				{
					Row myRow=mySheet.getRow(i);
					int firstCell=myRow.getFirstCellNum();
					if(myRow.getCell(firstCell).getStringCellValue().equals(property))
					{
						excelValue=myRow.getCell(firstCell+1).getStringCellValue();
						break;
					}
				}
				return excelValue;
			}
			
			//Creating a function for defining explicit wait for the elements in the application
			public static boolean explicitWait(WebDriver driver, WebElement element){
				boolean status = true;
				try{
					WebDriverWait wait = new WebDriverWait(driver, 60);
					wait.until(ExpectedConditions.visibilityOf(element));
					wait.until(ExpectedConditions.elementToBeClickable(element));
				}catch(Exception e){
					status = false;
					System.out.println("Unable to wait for the element "+element);
					System.out.println("Exception occured - "+e.getMessage());
				}
				return status;
			}
}