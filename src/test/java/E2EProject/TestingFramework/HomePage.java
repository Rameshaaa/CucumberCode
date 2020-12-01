package E2EProject.TestingFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.pageObjectsRepo;
import resources.Base;

public class HomePage extends Base {
	
	public WebDriver driver;
	//public static Logger log = LogManager.getLogger(HomePage.class.getName());
	
	@BeforeTest
	public void BrowserOpening() throws IOException
	
	{
		driver=initializeDriver();
		//log.info("Driver is initiated");
		driver.get(prop.getProperty("url"));
		//log.info("URL is launched");
	}
	
	@Test(dataProvider="getData")
	public void basepageNavigation(String Username, String password, String text) throws IOException
	
	{	
			
		/* Methods can be called Class using inheritance (Ex Base is a class, we called that here using inheritance using extend keyword)
		 * Methods can be called by creating the objects for class and invoking the methods
		 */
		
		pageObjectsRepo hp = new pageObjectsRepo(driver);
		hp.getLogin().click();
		hp.email().sendKeys(Username);
		//log.info("UserName Entered");
		hp.password().sendKeys(password);
		//log.info("Password Entered");
		System.out.println(text);
		hp.submit().click();
		//log.info("Submitted the Login");
		
		
	}
	
	@AfterTest
	public void teardown()
	
	{
		driver.close();
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data= new Object[2][3];
		//1st set of Data passing to the testcase
		data[0][0]="ramesh@gm.com";
		data[0][1]="123456789";
		data[0][2]="1st data entered";
		//2nd set of Data passing to the testcase
		data[1][0]="ramm@yah.com";
		data[1][1]="987654321";
		data[1][2]="2nd data entered";
		
		return data;
	}
	
	

}
