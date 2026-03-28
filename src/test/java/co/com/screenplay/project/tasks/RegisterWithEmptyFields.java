/**
 * @author Hernan J
 * @created 03/28/2026 12:31 p. m.
 */
package co.com.screenplay.project.tasks;
import co.com.screenplay.project.userinterfaces.RegisterPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RegisterWithEmptyFields implements Task {

    public static RegisterWithEmptyFields attempt() {
        return Tasks.instrumented(RegisterWithEmptyFields.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(RegisterPage.BTN_SIGNUP),
                WaitUntil.the(RegisterPage.TXT_USERNAME, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(RegisterPage.BTN_SUBMIT)
        );

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            String mensaje = alert.getText();
            actor.remember("registerError", mensaje);

            alert.accept();

        } catch (Exception e) {
            actor.remember("registerError", "NO_ALERT");
            System.out.println("Alert no apareció en CI (Register Empty)");
        }
    }
}