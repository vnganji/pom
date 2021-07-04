package Way2AutomationPages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Exceptions.usrexceptions;
import FrWorkComponents.basePageClass;
import FrWorkComponents.testParams;
import Utilities.MessageTypes;
import Utilities.TestReprorter;

public class homePage extends basePageClass {

@FindBy(xpath=("//input[@name='q2']"))
public WebElement googleSearch_input;

@FindBy(xpath=("//input[@value='Google Search']"))
public WebElement googleSearch_btn;


	public homePage() {
		super();
		PageFactory.initElements(getDriver(), this);
	}

	public void validateSearchEdit() throws IOException {

		actions.setText(googleSearch_input, "search input field on google page", "wipro");

	}

	@Override
	public void pageCondition() throws IOException {
		boolean page_exist = true;
		try {
			wait = new WebDriverWait(getDriver(), 20);
			wait.until(ExpectedConditions.visibilityOf(googleSearch_input));
			
		} catch (Exception e) {
			page_exist = false;
			usrexceptions.traceException(e, "Home Page Search Button");
		}

		if (page_exist) {
			try {
				TestReprorter.log(testParams.getTcdesc(), testParams.getAlmid(), "home page displayed", MessageTypes.Pass, 0);
			} catch (IOException e) {
			}
		}
		else
		{
			try {
				TestReprorter.log(testParams.getTcdesc(), testParams.getAlmid(), "home page not displayed", MessageTypes.Fail, 1);
			} catch (IOException e) {
			}
		}
			
	}

}
