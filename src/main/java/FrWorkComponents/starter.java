package FrWorkComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class starter {

	public static Properties prop = null;
	public static FileInputStream fso = null;
	public static boolean getproperties = false;
	public static String path = System.getProperty("user.dir");
	public  WebDriver driver = null;
	public static WebDriverWait wait = null;
	public static Map<String,String> testdatamap=null;
	public static String url=null;

	public static void getProperties() throws IOException {

		if (!getproperties) {
			fso = new FileInputStream(path + "\\src\\test\\resources\\appication.properties");
			prop = new Properties();
			prop.load(fso);
			getproperties = true;
		}

	}

	public  void initDriver() {

		if (testParams.getbrowser().equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					path + "\\src\\test\\resources\\Executables\\chromedriver.exe");
			driver = new ChromeDriver();
			testParams.setDriver(driver);
			//driver = testParams.getDriver();

		}

	}

	public static WebDriver getDriver() {

		return testParams.getDriver();

	}

	public void setglobalWait() {

		try {

			testParams.getDriver().manage().timeouts().implicitlyWait((Long) prop.get("global.wait"), TimeUnit.SECONDS);

		} catch (Exception E) {
			E.getMessage();
		}

	}

	public void openUrl(String URL) {
		getDriver().manage().window().maximize();
		getDriver().get(URL);

	}

}
