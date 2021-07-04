package Utilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class grid {
	
	@Test
	public void test() throws MalformedURLException{
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.ANY);
		
		RemoteWebDriver driver =new  RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),dc);
		driver.get("www.gmail.com");
		driver.findElement(By.name("q")).sendKeys("venkat");
		
	}
	

}
