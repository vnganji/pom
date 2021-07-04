package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Exceptions.usrexceptions;
import FrWorkComponents.basePageClass;

public class easyselenium extends basePageClass {
	

	@FindBy(xpath="//input[@name='first_name']")
	public static WebElement firstname;
	
	
	
	public easyselenium() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void openUrl(String URL, Object... obj) {
		super.openUrl(URL);
		pageCondition();
		
	}

	@Override
	public void pageCondition() {
		

	}
}
