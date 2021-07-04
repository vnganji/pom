package FrWorkComponents;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class testParams {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public static ThreadLocal<String> tcdesc = new ThreadLocal<String>();
	public static ThreadLocal<String> almid = new ThreadLocal<String>();
	public static ThreadLocal<String> module = new ThreadLocal<String>();
	public static ThreadLocal<String> browser = new ThreadLocal<String>();
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<Integer> failstatus = new ThreadLocal<Integer>();
	
	
	public static String getbrowser() {
		return browser.get();
	}
	public static void setbrowser(String browsername) {
		 browser.set(browsername);
	}
	public static Integer getFailstatus() {
		return failstatus.get();
	}

	public static void setFailstatus(Integer failstat) {
		failstatus.set(failstat);
	}

	public static ExtentTest getTestReport() {
		return testReport.get();
	}

	public static void setTestReport(ExtentTest testRep) {
		testReport.set(testRep);
	}

	public static void setDriver(WebDriver dr) {

		driver.set(dr);

	}

	public static WebDriver getDriver() {

		return driver.get();

	}

	public static String getTcdesc() {
		return tcdesc.get();
	}

	public static void setTcdesc(String tc) {
		tcdesc.set(tc);}

	public static String  getAlmid() {
		return almid.get();
	}

	public static void setAlmid(String id) {
		almid.set(id);
	}

	public static void setModule(String mod) {
		module.set(mod);
		
	}
	
	public static String getModule() {
		return module.get();
		// TODO Auto-generated method stub
		
	}
	
	

}
