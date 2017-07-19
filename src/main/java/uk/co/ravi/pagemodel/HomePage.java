/*
 * @author Ravi Kunaparaju  
 */
package uk.co.ravi.pagemodel;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import uk.co.ravi.utils.*;

public class HomePage{
	private final WebDriver driver;
	ObjectRepository obj= new ObjectRepository();
	Support support;
	String env = AppProperties.get("environment");
	
	public HomePage(WebDriver driver){		
		 this.driver=(WebDriver) driver;
		 support = PageFactory.initElements(driver, Support.class);
	 }
	public void waitForHomePageLoaded(){
		support.wait_for_element_exists(obj.homePage);
	}	
	
	public void enterSearchText(String text){
		support.enter_text(obj.searchBox, text);
	}
	
	public void clickSearchButton(){
		support.click(obj.searchButton);
	}

	public boolean assertSearchSuccess(String expectedText){
		String searchResultText = driver.findElement(By.xpath(obj.searchResults)).getText();
		if (searchResultText.equalsIgnoreCase(expectedText)){
			return true;
		}else{
			return false;
		}
	}
	
	public void selectAproductFromDropdown(){
		support.click(obj.catMenuJewellery);
		support.click(obj.productAnklet);
	}
	
	public boolean assertProductFromMenuSelection(){
		if (support.element_exists(obj.menuSearchResult)){
			return true;
		}else{
			return false;
		}
	}
	
	public void selectProductByIcon(){
		try{
		support.wait_for_element_exists(obj.productIconClothing);
		}catch(ElementNotVisibleException e){
			support.scrollUntilElementExists(obj.productIconClothing, 10);
		}
		support.click(obj.productIconClothing);
	}
	
	public boolean assertProductFromIconSelection(){
		if (support.element_exists(obj.menuSearchResult)){
			return true;
		}else{
			return false;
		}
	}
}
