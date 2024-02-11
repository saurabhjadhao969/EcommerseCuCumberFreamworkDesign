package factory;

import java.io.FileNotFoundException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.CommonUtils;


public class DriverFactory {
	static  WebDriver  driver = null;
	public static  WebDriver initializeBrowser(String browserName) throws FileNotFoundException {
		
		if(browserName.equals("chrome")) {
			
			  driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			 driver = new FirefoxDriver();
		}
		else if(browserName.equals("edge")) {
			 driver = new EdgeDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));
		return driver;
		
		 		
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

}
