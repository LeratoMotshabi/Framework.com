package Utilities;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentListeners extends BaseClass implements ITestListener {

	static Date d = new Date();
	static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
	
private static ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir")+"/test-output/Extent Reports/"+fileName);
	
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
		
    public void onFinish(ITestContext  Result) 					
    {		
    	if (extent != null) {

			extent.flush();
    	}
    }		

   	
    public void onStart(ITestContext  Result)					
    {		
            		
    }		

   		
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result)					
    {		
    		
    }		

   		
    		
    public void onTestFailure(ITestResult Result) 					
    {		
    	
    	String exceptionMessage = Arrays.toString(Result.getThrowable().getStackTrace());
    	//String message = e.getMessage();
    	
    	testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
				+ "</font>" + "</b >" + "</summary>" +exceptionMessage.replaceAll(",", "<br>")+"</details>"+" \n");
    	
		
    	
    	String failureLogg="TEST CASE FAILED";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		testReport.get().log(Status.FAIL, m);
	
	
    }		

    		
    public void onTestSkipped(ITestResult Result)					
    {		
   		
    	
    	
    }		

    
    public void onTestStart(ITestResult Result)					
    {		
    	ExtentTest test = extent.createTest(Result.getTestClass().getName() + "@Test case"+ Result.getMethod().getMethodName());
    	testReport.set(test);
    }		

    		
    public void onTestSuccess(ITestResult Result)					
    {		
    				String  methodName = Result.getMethod().getMethodName();
    				String text = "<b>" + "TEST CASE:: " +methodName.toUpperCase()+" PASSED"+"</b>";
    				
    				Markup m = MarkupHelper.createLabel(text, ExtentColor.GREEN);
    				testReport.get().pass(m);
    }		

	}

