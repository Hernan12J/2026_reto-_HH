/**
 * @author Hernan J
 * @created 03/22/2026 12:13 a. m.
 */
package co.com.screenplay.project.runners;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "co.com.screenplay.project.stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class RunnerDemoBlaze {
}
