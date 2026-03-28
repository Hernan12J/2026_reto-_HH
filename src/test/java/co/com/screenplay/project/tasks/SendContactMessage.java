/**
 * @author Hernan J
 * @created 03/28/2026 10:03 a. m.
 */
package co.com.screenplay.project.tasks;
import co.com.screenplay.project.userinterfaces.ContactPage;
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

public class SendContactMessage implements Task {

    public static SendContactMessage now() {
        return Tasks.instrumented(SendContactMessage.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(ContactPage.BTN_CONTACT),
                WaitUntil.the(ContactPage.TXT_CONTACT_EMAIL, isVisible()).forNoMoreThan(5).seconds(),
                Enter.theValue("test@mail.com").into(ContactPage.TXT_CONTACT_EMAIL),
                Enter.theValue("Hernan").into(ContactPage.TXT_CONTACT_NAME),
                Enter.theValue("Mensaje de prueba").into(ContactPage.TXT_MESSAGE),
                Click.on(ContactPage.BTN_SEND_MESSAGE)
        );

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            String mensaje = alert.getText();
            actor.remember("contactAlert", mensaje);

            alert.accept();

        } catch (Exception e) {
            actor.remember("contactAlert", "NO_ALERT");
            System.out.println("Alert no apareció en CI (Contact)");
        }
    }
}