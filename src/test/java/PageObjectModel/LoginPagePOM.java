package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPagePOM {
	
	By Username = By.xpath("//input[@name='uid']");
	By Password = By.xpath("//input[@name='password']");
	By Lbutton = By.xpath("//input[@name='btnLogin']");
	
	private WebDriver driver;
	
	public LoginPagePOM(WebDriver driver) 
	{
	this.driver=driver;
	}

	public WebElement Username(String user) 
	{
		WebElement UserID = driver.findElement(Username);
		UserID.sendKeys(user);
		return UserID;
	}
	
	public WebElement Password(String password) 
	{
		WebElement pass = driver.findElement(Password);
		pass.sendKeys(password);
		return pass;
	}
	
	public void Button() 
	{
		driver.findElement(Lbutton).click();
	}
	
	

}
