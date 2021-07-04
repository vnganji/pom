package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Exceptions.usrexceptions;
import FrWorkComponents.basePageClass;

public class homePage extends basePageClass {
	

	@FindBy(id="username")
	public static WebElement username;
	
	
	
	public homePage() {
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
