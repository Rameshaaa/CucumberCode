package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageObjectsRepo {
	
	public WebDriver driver;
	
	public pageObjectsRepo(WebDriver driver) {
		
		this.driver=driver;
	}
	
	
	By Login = By.xpath("//span[contains(text(),'Login')]"); 	
	By email = By.xpath("//input[@type='email']");
	By password = By.xpath("//input[@type='password']");
	By submit = By.xpath("//input[@type='submit']");
	By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	By Contact = By.xpath("//a[contains(text(),'')]");
	
public WebElement getLogin()
	
{
	return driver.findElement(Login);
}
	
public WebElement email()
	
{
	return driver.findElement(email);
}

public WebElement password()

{
	return driver.findElement(password);
}

public WebElement submit()

{
	return driver.findElement(submit);
}

public WebElement getTitle()

{
	return driver.findElement(title);
}

public WebElement contact()

{
	return driver.findElement(Contact);
}

}
