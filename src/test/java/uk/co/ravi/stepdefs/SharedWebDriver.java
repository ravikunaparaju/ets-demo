/*
 * @author Ravi Kunaparaju  
 */
package uk.co.ravi.stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import uk.co.ravi.utils.AppProperties;

public class SharedWebDriver extends EventFiringWebDriver {
	private static WebDriver driver;
	
	static {
		try {
			String browser = AppProperties.get("browser");
 
			if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/src/test/resources/geckodriver");
				driver = new FirefoxDriver();
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
			}else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")	+ "/src/test/resources/chromedriver");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			} else if (browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+ "/src/test/resources/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
			} else if (browser.equalsIgnoreCase("safari")) {
				driver = new SafariDriver();	
				driver.manage().window().maximize();
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
