package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Base {
	
	//Initialize the driver at Global Level
	public WebDriver driver;
	public Properties prop;
	
public WebDriver initializeDriver() throws IOException
	
{
prop =new Properties();
FileInputStream fis= new FileInputStream("C:\\Users\\561877\\workspace\\TestingFramework\\src\\main\\java\\resources\\data.properties");
prop.load(fis);
String browserName = prop.getProperty("browser");
System.out.println(browserName);
		 
if (browserName.equals("chrome"))
{
System.setProperty("webdriver.chrome.driver", "C:\\Users\\561877\\chromedriver.exe");
ChromeOptions  options = new ChromeOptions();
options.addArguments("headless");
driver= new ChromeDriver(options);
} 

else if (browserName.equals("IE"))
{
System.setProperty("webdriver.ie.driver", "C:\\Users\\561877\\IEDriverServer.exe");  
driver=new InternetExplorerDriver();
}

else if (browserName.equals("firefox"))
{
System.setProperty("webdriver.gecko.driver", "C:\\Users\\561877\\geckodriver.exe");
driver = new FirefoxDriver();
}

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;

}

/**public WebDriver Login()

{	
	driver.get(prop.getProperty("url"));
	
	return driver;
}
 * @return 
 * @throws IOException **/

public String getScreenshot(String testCaseName, WebDriver driver) throws IOException

{
	
	TakesScreenshot ts= (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;
}
		
}


