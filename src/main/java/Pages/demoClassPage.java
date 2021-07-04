package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrWorkComponents.basePageClass;
import FrWorkComponents.testParams;

public class demoClassPage extends basePageClass {
	
	@FindBy(xpath="//input[@id=@test]")
	public WebElement abc;

	public demoClassPage(){
		super();
		PageFactory.initElements(driver, this);
		
	}
	
	public void login(){
		
		driver.get(url);
	}
	
	
	
	public void testdemo(){
		actions.filltestdata(testParams.getModule(), testParams.getAlmid());
		System.out.println(testdatamap.get("uname"));
	}

	@Override
	public void pageCondition() {
		// TODO Auto-generated method stub
		
	}

}
