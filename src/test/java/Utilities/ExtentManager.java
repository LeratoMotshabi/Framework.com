package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	
	public static ExtentReports createInstance(String fileNAme) {
	
	ExtentHtmlReporter HtmlReporter = new ExtentHtmlReporter(fileNAme);
	HtmlReporter.config().setTheme(Theme.STANDARD);
	HtmlReporter.config().setDocumentTitle(fileNAme);
	HtmlReporter.config().setReportName(fileNAme);
	HtmlReporter.config().setEncoding("uft-8");
	
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(HtmlReporter);
	return extent;
	
	
	}

	    
	  
		
		
		/*public String  captureScreenshot() {

			Date date = new Date();
			String ScrName = date.toString().replace(" ", "-").replace(":", "-");
			File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scr, new File("./src/main/resources/Screenshot/" +ScrName+ ".png"));
			return ScrName;
		
		}*/
	

	}