package TestCases;



import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjectModel.LoginPagePOM;
import Utilities.BaseClass;
import Utilities.ReadProperties;
import Utilities.ScreenShot;
import Utilities.dataProvider;


public class LoginPage  extends BaseClass{
	
	
	LoginPagePOM Login;
	public SoftAssert soft;
	Logger log;
	ScreenShot screencapture;
	
	ReadProperties config = new ReadProperties();
	@Test(dataProvider = "Login Data",dataProviderClass = dataProvider.class)
	public void VerifyLogin(String Username, String Password) throws IOException
	{
		
		log = Logger.getLogger("Verifying Login");
		
		Login= new LoginPagePOM(driver);
		soft = new SoftAssert();
		
		Login.Username(Username);
		log.info("Entered username: "+Username);
		
		
		Login.Password(Password);
		log.info("Entered password: "+Password);
		
		Login.Button();
		log.info("Login button clicked");
		System.out.println(" ");
		
		try {
			
			 String actualText= driver.switchTo().alert().getText();
			
			driver.switchTo().alert().accept();
		
			
			soft.assertEquals(actualText, config.ExpectedText());
			
			
			
		} catch (NoAlertPresentException e) {

			
		String ManagerID = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).getText();
		String[] MgrID = ManagerID.split("\\s");
		for(int i = 0;i<MgrID.length;i++)
		{
			System.out.println(MgrID[i]);
		
		}
		
			soft.assertTrue(MgrID[3].equals("mngr377675"));
			
			log.info("Welcome userID: "+MgrID[2]);
			
						
		}
		
		soft.assertAll();
		
	}

}
