package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import FrWorkComponents.testParams;

public class TestReprorter {

	public static void log(String TC, String ALMID, String Desc, String Result,int scrCapture) throws IOException {

		TestResultUpdator.UpdateTestResultData(TC, ALMID, Desc, Result);
		if ("Pass".equals(Result)) {
			testParams.getTestReport().log(Status.PASS, Desc);
		}
		if ("Fail".equals(Result)) {
			String path = capture();
			
			if (scrCapture==1)
				testParams.getTestReport().log(Status.FAIL,testParams.getTestReport().addScreenCaptureFromPath(path)+ "Test Failed");
			else
				testParams.getTestReport().log(Status.FAIL, Desc);
			
			Assert.fail(Desc);

			
			
		}
	}
	
	
	public static String capture() throws IOException {
	File scrFile = ((TakesScreenshot) testParams.getDriver()).getScreenshotAs(OutputType.FILE);
	Date d = new Date();
	String fileName = "ScreenShot_" + d.toString().replace(":", "_").replace(" ", "_") + ".png";
	File Dest = new File(System.getProperty("user.dir")+"//screenshots//"+fileName);
	String errflpath = Dest.getAbsolutePath();
	FileUtils.copyFile(scrFile, Dest);
	return errflpath;
	}

}
