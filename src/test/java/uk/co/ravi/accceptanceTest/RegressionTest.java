/*
 * @author Ravi Kunaparaju  
 */
package uk.co.ravi.accceptanceTest;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		format = {"pretty","html:target/reports/cucumber-pretty/testreport.html"}, 
		features = {"src/test/resources/features/"},glue="uk.co.ravi.stepdefs",tags="@wip")
public class RegressionTest {

}
