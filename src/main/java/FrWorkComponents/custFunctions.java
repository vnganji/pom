package FrWorkComponents;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import Exceptions.usrexceptions;
import Utilities.dataProvider;

public class custFunctions extends starter {
	
	public void filltestdata(String Module, String Key){
		
				testdatamap=dataProvider.getExceltestdata(Module,Key);
		
	}
	
	public void setText(WebElement elem, String Desc, String value) throws IOException{
		
	
		try{
			elem.sendKeys(value);
		}catch(Exception e){
			
			usrexceptions.traceException(e,Desc);
		}
		
					
			}
		
	}


