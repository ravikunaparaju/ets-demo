package uk.co.ravi.utils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author ravikunaparaju
 *
 */
public class Support {
	private final WebDriver driver;
	ObjectRepository obj;
	String browser = AppProperties.get("browser");
	
	public Support(WebDriver driver){		
		 this.driver=(WebDriver) driver;
	 }
	
	public void wait_for_element_exists(String object){
		try{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(object)));
		}catch(NoSuchElementException noelement){
			System.out.println("element not present on the page");
		}catch(TimeoutException timeout){
			System.out.println("element not present on the page");
		} 
	}
	
	public void wait_for_element_clickable(String object){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		@SuppressWarnings("unused")
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(object)));
	}

	
	public void click(String element){
		try{
			this.wait_for_element_exists(element);
		}catch(TimeoutException to){
			System.out.println("Element doesn't load");
			to.getMessage();
		}
		driver.findElement(By.xpath(element)).click();	
	}
	
	
	public void mouseHover(String element){
		Actions actions = new Actions(driver);
		this.wait_for_element_clickable(element);
		WebElement mainMenu = driver.findElement(By.xpath(element));
		actions.moveToElement(mainMenu);
		actions.build().perform();
	}
	
	public void enter_text(String element, String text){
		this.wait_for_element_exists(element);
		driver.findElement(By.xpath(element)).clear();
		driver.findElement(By.xpath(element)).sendKeys(text);
	}
	
	public boolean element_exists(String element){
		try{
			
			driver.findElement(By.xpath(element));
			return true;
		}
			catch(NoSuchElementException e){
				return false;
			}
	}
	
	public boolean element_does_not_exist(String element){
		try{
			driver.findElement(By.xpath(element));
			return false;
		}
		catch(NoSuchElementException e){
			return true;
		}
		catch(TimeoutException to){
			return true;
		}catch(ElementNotVisibleException notVisible){
			return true;
		}
	}
	
	public void screenshot(){
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		try {
			FileUtils.copyFile(scrFile, new File("screenshot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void scrollToElement(String element){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement element1 = driver.findElement(By.xpath(element));
		jse.executeScript("arguments[0].scrollIntoView(true);", element1);
	}
	
	public void scrollUntilElementExists(String element, int n){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		for(int i=0;i<n;i++){
			jse.executeScript("scroll(0, 250);");
			if(this.element_exists(element)){
				break;
			}
		}
		
	}
	
	public void clickElementByJS(String query){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript(query+".click();");
	}
}
