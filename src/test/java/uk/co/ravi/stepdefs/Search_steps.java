//@author ravi kunaparaju
package uk.co.ravi.stepdefs;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import uk.co.ravi.pagemodel.*;
import uk.co.ravi.utils.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.sql.Time;
import java.time.Instant;
import org.junit.Assert;

public class Search_steps {
	
	WebDriver driver;
	HomePage mainPage;
	ObjectRepository obj;
	Support support;
	String url = AppProperties.get("envurl");
	long time = Instant.now().toEpochMilli();

	public Search_steps(SharedWebDriver driver){
		this.driver = driver;
		mainPage = PageFactory.initElements(driver, HomePage.class);
		support = PageFactory.initElements(driver, Support.class);
		driver.navigate().to(url);
	}
	
	@Given("^John is viewing the Etsy landing page$")
	public void john_is_viewing_the_Etsy_landing_page() throws Throwable {
	    mainPage.waitForHomePageLoaded();
	}

	@When("^he searches for a product \"([^\"]*)\" from the input box$")
	public void he_searches_for_a_product_from_the_input_box(String arg1) throws Throwable {
	    mainPage.enterSearchText(arg1);
	    mainPage.clickSearchButton();
	}

	@Then("^the result for \"([^\"]*)\" should be displayed$")
	public void the_result_for_should_be_displayed(String arg1) throws Throwable {
		 Assert.assertTrue(mainPage.assertSearchSuccess(arg1));
	}
	
	@When("^he clicks for a product from drop-down menu$")
	public void he_clicks_for_a_product_from_drop_down_menu() throws Throwable {
	    mainPage.selectAproductFromDropdown();
	}

	@Then("^the results for the product should be displayed$")
	public void the_results_for_the_product_should_be_displayed() throws Throwable {
	    Assert.assertTrue(mainPage.assertProductFromMenuSelection());
	}

	@When("^he clicks on a product icon$")
	public void he_clicks_on_a_product_icon() throws Throwable {
	    mainPage.selectProductByIcon();
	}

	@Then("^the results related to the product category are displayed$")
	public void the_results_related_to_the_product_category_are_displayed() throws Throwable {
	    Assert.assertTrue(mainPage.assertProductFromIconSelection());
	}

	
}
