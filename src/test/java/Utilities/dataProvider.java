package Utilities;

import org.testng.annotations.DataProvider;

public class dataProvider {
	
	@DataProvider(name="Login Data")
	public Object[][] LoginData(){
		return new Object[][] {
				{"InvalidUSer","uvujAmE"},
				{"mngr356545","InvalidPassword"},
				{"InvalidUSer","InvalidPassword"},
				{"mngr377675","pYnEsym"}
				
		};
	}
	
	
	
}
