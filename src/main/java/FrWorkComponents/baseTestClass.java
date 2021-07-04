package FrWorkComponents;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import Utilities.TestResultUpdator;  



public class baseTestClass extends starter {
	
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface aboutTest{
		
		String desc() default "seleniumtest";
		String almid() default "";
		String module() default "";
		
	}
	
	
	

	@BeforeSuite
	@Parameters("browser")
	public void intilizer(String browser) throws IOException{
	
		getProperties();
		testParams.setbrowser(browser);
		initDriver();
		setglobalWait();
		TestResultUpdator.updateBeforeSuit();
		System.out.println("start");
		
	}
	
	@AfterSuite
	public void tearDown()
	{
		TestResultUpdator.updateAfterSuit();
	}
	
	@BeforeMethod
	public void beforeMethod(Method M) {
		
	
		Annotation ano = M.getAnnotation(aboutTest.class);
		testParams.setTcdesc(((aboutTest) ano).desc());	
		testParams.setAlmid(((aboutTest) ano).almid());	
		testParams.setModule(((aboutTest) ano).module());	
		testParams.setFailstatus(0);
	}
	
	/*@AfterMethod
	public void verifyTestStatus(){
		Integer i =testParams.getFailstatus();
		if (i==i){
			Assert.fail("Test Case Failed");
			
		}
	}
*/

}
