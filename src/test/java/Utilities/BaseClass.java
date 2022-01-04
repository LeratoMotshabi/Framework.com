package Utilities;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;




public class BaseClass  {
	
	ReadProperties config = new ReadProperties();
	Logger log;
	
	public static WebDriver driver;
	
	
	@BeforeSuite
	public void setup()
	{
		PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/test/resources/Properties/Log4j.properties");
		
		log = Logger.getLogger("opening broswer");
		
		if(config.browser().equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if(config.browser().equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if(config.browser().equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.get(config.url());
		log.info("Opened "+config.browser() + " broswer");
		
		
	}
	
	
public String Screenshot(WebDriver driver,String screenShotName) throws IOException {
		
	 //create a string variable which will be unique always
    String df = new SimpleDateFormat("yyyyMMddhhss").format(new Date());
    
    //create object variable of TakeScreenshot class  
    TakesScreenshot ts = (TakesScreenshot)driver;
    
    //create File object variable which holds the screen shot reference 
    File source = ts.getScreenshotAs(OutputType.FILE);
    
    //store the screen shot path in path variable. Here we are storing the screenshots under screenshots folder 
    String path = System.getProperty("user.dir") + "/test-output/screenshots/" + screenShotName + df + ".png";
    
    //create another File object variable which points(refer) to the above stored path variable
    File destination = new File(path);
    
    //use FileUtils class method to save the screen shot at desired path
    FileUtils.copyFile(source, destination);
    
    //return the path where the screen shot is saved 
    return path;
		
	}



	
	
}
