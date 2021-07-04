package Utilities;

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

import FrWorkComponents.testParams;




public class ExtentListeners implements ITestListener {

	static Date d = new Date();
	static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";

	private static ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir")+"\\reports\\"+fileName);
	
	
	

	public void onTestStart(ITestResult result) {
		
	
		ExtentTest test = extent.createTest(result.getTestClass().getName()+"     @TestCase : "+result.getMethod().getMethodName());
      
		testParams.setTestReport(test); 
      
	}

	public void onTestSuccess(ITestResult result) {

		
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " PASSED"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testParams.getTestReport().pass(m);
		

	}

	public void onTestFailure(ITestResult result) {

	
		
		
	/*	String excepionMessage=Arrays.toString(result.getThrowable().getStackTrace());
		testParams.getTestReport().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
				+ "</font>" + "</b >" + "</summary>" +excepionMessage.replaceAll(",", "<br>")+"</details>"+" \n");*/
		
	/*	try {

			ExtentManager.captureScreenshot();
			testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName)
							.build());
		} catch (IOException e) {

		}*/
		
		String methodName=result.getMethod().getMethodName();
		String failureLogg="TEST CASE:-"+methodName+"  FAILED";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		testParams.getTestReport().fail(m);

	}

	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"Test Case:- "+ methodName+ " Skipped"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		testParams.getTestReport().skip(m);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

		

	}

	public void onFinish(ITestContext context) {

		if (extent != null) {

			extent.flush();
		}

	}
	
	/*Capture Screenshot in Extent Reports
	Screen Capture along with test execution will help a tester in debugging the test script if there are any issues encountered during test execution. However, it is advisable to capture screenshot only if a test step fails as the images will consume more memory if captured on every test step.

	Screenshots can be captured for each failed step using the below code.

	test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed");
	public static String capture(WebDriver driver) throws IOException {
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	File Dest = new File("src/../ErrImages/" + System.currentTimeMillis()
	+ ".png");
	String errflpath = Dest.getAbsolutePath();
	FileUtils.copyFile(scrFile, Dest);
	return errflpath;
	}
	Code Explanation

	Capture Method:

	#1) getScreenShotAs() method is used to capture the screenshot of the current WebDriver instance and store it in various output forms.

	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	#2) getScreenShotAs method returns a file object which needs to be stored onto a file variable. Please note that casting the web driver instance to Take Screenshot is mandatory if you want to use the method.

	#3) File Dest = new File(“src/../ErrImages/” + System.currentTimeMillis()+ “.png”);

	#4) The above statement creates a folder named ‘ErrImages’ within the ‘src’ folder and stores the file name as the current system time.

	#5) String errflpath = Dest.getAbsolutePath();
	FileUtils.copyFile(scrFile, Dest);
	returnerrflpath;

	#6) The above statements copy the error images to the destination folder.

	Log Method:

	Log method uses the built-in method, addScreenCapture of Extent Test class to fetch the screenshot and append it to the Extent Report.

	test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ “Test Failed”);

	Message recorded on the log method can include detailed message including expected and actual results for debugging purpose.
*/
}
