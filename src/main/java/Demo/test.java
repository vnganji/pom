package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
	public static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\Executables\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("venkat");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("surya");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("venkat21212222");
		driver.findElement(By.xpath("///input[@name='Passwd']")).sendKeys("venkat21212222");

	}
}
