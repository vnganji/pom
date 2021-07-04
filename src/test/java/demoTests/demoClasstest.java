package demoTests;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import Exceptions.usrexceptions;
import FrWorkComponents.baseTestClass;
import FrWorkComponents.commonProperties;
import FrWorkComponents.testParams;
import Pages.demoClassPage;
import Utilities.MessageTypes;
import Utilities.TestReprorter;
import Utilities.dataProvider;
import Way2AutomationPages.homePage;

public class demoClasstest extends baseTestClass {

	commonProperties cp = new commonProperties().getInstance();
	
	@aboutTest(desc = "demotest3", almid = "12378")
	@Test(enabled = true,groups={"smoke"})
	public void test3() throws IOException  {

		try{
		openUrl(cp.url);
		homePage hp1 = new homePage();
		hp1.validateSearchEdit();
		}catch (Exception e){
			usrexceptions.traceException(e, "test3");}
		}
	
	@aboutTest(desc = "demotest3", almid = "12378")
	@Test(enabled = true,groups={"regression"})
	public void test4() throws IOException  {

		try{
		openUrl("https://www.google.com");
		homePage hp1 = new homePage();
		hp1.validateSearchEdit();
		}catch (Exception e){
			usrexceptions.traceException(e, "test3");}
		}
		

	}

