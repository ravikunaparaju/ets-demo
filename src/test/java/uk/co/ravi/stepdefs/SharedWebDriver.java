/*
 * @author Ravi Kunaparaju  
 */
package uk.co.ravi.stepdefs;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.uiautomation.ios.IOSCapabilities;
import uk.co.ravi.utils.AppProperties;

public class SharedWebDriver extends EventFiringWebDriver {
	private static WebDriver driver;
	
	static {
		try {
			String browser = AppProperties.get("browser");
			String env = AppProperties.get("environment");
			if(env.equalsIgnoreCase("local")){
				switch (browser) {
				
	            case "ie":  	System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+ "/src/test/resources/IEDriverServer.exe");
	            				driver = new InternetExplorerDriver();
	            				driver.manage().window().maximize();
	            				break;
	            case "chrome":  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")	+ "/src/test/resources/chromedriver");
								driver = new ChromeDriver();
								driver.manage().window().maximize();
								break;
	            case "firefox": System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/src/test/resources/geckodriver");
								driver = new FirefoxDriver();
								driver.manage().deleteAllCookies();
								driver.manage().window().maximize();
								break;
	            case "safari":	driver = new SafariDriver();	
								driver.manage().window().maximize();
								break;
				}
			}else if(env.equalsIgnoreCase("remote")){
				DesiredCapabilities capabilities;
				switch(browser){
				case "firefox":	System.setProperty("webdriver.gecko.driver","c://Users//openr//Desktop//Ravi//geckodriver.exe");
								capabilities = DesiredCapabilities.firefox();
								capabilities.setBrowserName("firefox");
								capabilities.setPlatform(org.openqa.selenium.Platform.ANY);					
								driver = new RemoteWebDriver(new URL("http://192.168.2.49:4444/wd/hub"), capabilities);
								driver.manage().window().maximize();
								break;
				case "chrome":	capabilities = DesiredCapabilities.chrome();
								capabilities.setBrowserName("chrome");
								capabilities.setPlatform(org.openqa.selenium.Platform.WINDOWS);
								driver = new RemoteWebDriver(new URL("http://192.168.2.49:4444/wd/hub"), capabilities);
								driver.manage().window().maximize();
								break;
				case "ie":		capabilities = DesiredCapabilities.internetExplorer();
								capabilities.setCapability("ignoreProtectedModeSettings", true);
								capabilities.setBrowserName("ie");
								capabilities.setPlatform(org.openqa.selenium.Platform.ANY);
								driver = new RemoteWebDriver(new URL("http://192.168.2.49:4444/wd/hub"), capabilities);
								driver.manage().window().maximize();		
								break;
				}
			}else if(env.equalsIgnoreCase("mobile")){		
				if(browser.equalsIgnoreCase("chrome")){
					ChromeOptions chromeOptions = new ChromeOptions();
				    chromeOptions.setExperimentalOption("androidPackage", "com.android.chrome");
				    chromeOptions.setExperimentalOption("androidDeviceSerial", "7a76ce0a");
				    System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")	+ "/src/test/resources/chromedriver");
				    driver = new ChromeDriver(chromeOptions);
				}
				else if(browser.equalsIgnoreCase("safari")){
					DesiredCapabilities safari = IOSCapabilities.iphone("Safari");
				    RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:5555/wd/hub"), safari);
				    driver.get("http://www.ebay.co.uk/");
				    System.out.println(driver.getTitle());
				    driver.quit();
				}
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				try {
					driver.quit();
				} catch (Exception e) {
					System.out.println(e);
				}
			}

		});
	}
	  
	
	public SharedWebDriver() {
		super(driver);
	}
}
