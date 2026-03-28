/**
 * @author Hernan J
 * @created 03/28/2026 12:41 a. m.
 */
package co.com.screenplay.project.tasks;
import co.com.screenplay.project.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginInvalidUser implements Task {

    public static LoginInvalidUser attempt() {
        return Tasks.instrumented(LoginInvalidUser.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(LoginPage.BTN_LOGIN),
                WaitUntil.the(LoginPage.TXT_LOGIN_USERNAME, isVisible()).forNoMoreThan(5).seconds(),
                Enter.theValue("usuarioFake").into(LoginPage.TXT_LOGIN_USERNAME),
                Enter.theValue("passFake").into(LoginPage.TXT_LOGIN_PASSWORD),
                Click.on(LoginPage.BTN_LOGIN_IN)
        );
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            String mensaje = alert.getText();
            System.out.println("ALERTA: " + mensaje);

            actor.remember("alertMessage", mensaje);

            alert.accept();

        } catch (Exception e) {
            System.out.println("Alert no apareció (CI/CD comportamiento)");

            actor.remember("alertMessage", "NO_ALERT");
        }
    }
}