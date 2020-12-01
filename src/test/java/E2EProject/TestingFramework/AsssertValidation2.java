package E2EProject.TestingFramework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.pageObjectsRepo;
import resources.Base;

public class AsssertValidation2 extends Base {
	public WebDriver driver;
	
	@BeforeTest
	public void BrowserOpening() throws IOException
	
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void basepageNavigation() throws IOException
	
	{	
			
		/* Methods can be called Class using inheritance (Ex Base is a class, we called that here using inheritance using extend keyword)
		 * Methods can be called by creating the objects for class and invoking the methods
		 */
		
		pageObjectsRepo hp = new pageObjectsRepo(driver);
		boolean Contact = hp.contact().isDisplayed();
		Assert.assertTrue(Contact);
	}
	
	@AfterTest
	public void teardown()

	
	{
		driver.close();
	}
	
	
}
