package co.com.screenplay.project.tasks;

import co.com.screenplay.project.userinterfaces.HomePage;
import co.com.screenplay.project.userinterfaces.RegisterPage;
import co.com.screenplay.project.utils.DataGenerator;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RegisterUser implements Task {

    public static RegisterUser withRandomCredentials() {
        return Tasks.instrumented(RegisterUser.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String username = DataGenerator.generateUsername();
        String password = DataGenerator.generatePassword();

        actor.remember("username", username);
        actor.remember("password", password);

        actor.attemptsTo(
                Click.on(RegisterPage.BTN_SIGNUP),
                WaitUntil.the(RegisterPage.TXT_USERNAME, isVisible()).forNoMoreThan(5).seconds(),
                Enter.theValue(username).into(RegisterPage.TXT_USERNAME),
                Enter.theValue(password).into(RegisterPage.TXT_PASSWORD),
                Click.on(RegisterPage.BTN_SUBMIT)
        );

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));

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

        actor.attemptsTo(
                WaitUntil.the(HomePage.NAVBAR, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}