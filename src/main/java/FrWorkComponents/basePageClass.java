package FrWorkComponents;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrWorkComponents.annotattions.FndBy;

public abstract class basePageClass extends starter {
	
	//Global Object that would be 
	public  custFunctions actions = new custFunctions();
	 
	public static By name = By.xpath("//input[@id=@text]");
	
	@FindBy(xpath="//ul[contains(@class,'navbar')]//a[text()='About us']")
	public WebElement homepage_aboutuslnk;
	@FindBy(xpath="//ul[contains(@class,'navbar')]//a[text()='Selenium']")
	public WebElement homepage_seleniumlnk;
	@FindBy(xpath="//ul[contains(@class,'navbar')]//a[text()='API Testing']")
	public WebElement homepage_apitestinglnk;
	@FindBy(xpath="//ul[contains(@class,'navbar')]//a[text()='JMETER']")
	public WebElement homepage_jmeterlnk;
	@FindBy(xpath="//ul[contains(@class,'navbar')]//a[text()='MANUAL TESTING']")
	public WebElement homepage_manualtestinglnk;
	@FindBy(xpath="//ul[contains(@class,'navbar')]//a[text()='VIDEO TUTORIALS']")
	public WebElement homepage_videotutlnk;
	@FindBy(xpath="//ul[contains(@class,'navbar')]//a[text()='Resources']")
	public WebElement homepage_Resourceslnk;
	
	
	public static  WebElement getModifiedWebElement(By name){
		
		String xpath =name.toString();
		xpath.replace("@text", "venakt");
		return testParams.getDriver().findElement(name);
		 
		
		 
	}
	
	public abstract void pageCondition() throws IOException;
	
	public basePageClass(){
		PageFactory.initElements(getDriver(), this);
		
	}
	

}
