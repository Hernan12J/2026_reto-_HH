/**
 * @author Hernan J
 * @created 03/28/2026 12:55 p. m.
 */
package co.com.screenplay.project.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandleAlert implements Interaction {

    public static HandleAlert capture() {
        return Tasks.instrumented(HandleAlert.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            String mensaje = alert.getText();
            actor.remember("alertMessage", mensaje);

            alert.accept();

        } catch (Exception e) {
            actor.remember("alertMessage", "NO_ALERT");
        }
    }
}
