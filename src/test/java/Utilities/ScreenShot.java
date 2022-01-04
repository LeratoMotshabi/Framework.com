package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class ScreenShot extends BaseClass {
	
	public String Screenshot() throws IOException {
		
		Date date = new Date();
		String ScrName = date.toString().replace(" ", "-").replace(":", "-");
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File("./src/main/resources/Screenshot/" +ScrName+ ".png"));
		return ScrName;
	}

}
