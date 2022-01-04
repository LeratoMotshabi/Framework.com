package Utilities;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;


public class ReadProperties {
	
	public static WebDriver driver;
	Properties pro;
	FileInputStream file;
	
	
	public ReadProperties() 
	{
		
		
		try {
			pro = new Properties();
			file = new FileInputStream (System.getProperty("user.dir")+"/src/test/resources/Properties/data.properties");
			pro.load(file);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public String browser()
	{
		String browser = pro.getProperty("browser");
		return browser;
	}
	
	public String Username()
	{
		String username = pro.getProperty("username");
		return username;
	}
	
	public String Password()
	{
		String password = pro.getProperty("password");
		return password;
	}
	public String url()
	{
		String url = pro.getProperty("url");
		return url;
	}
	public String ExpectedText()
	{
		String expected = pro.getProperty("ExpectedText");
		return expected;
	}
	

}
