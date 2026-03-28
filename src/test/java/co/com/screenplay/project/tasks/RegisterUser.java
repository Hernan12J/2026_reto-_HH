package co.com.screenplay.project.tasks;

import co.com.screenplay.project.interactions.HandleAlert;
import co.com.screenplay.project.userinterfaces.HomePage;
import co.com.screenplay.project.userinterfaces.RegisterPage;
import co.com.screenplay.project.utils.DataGenerator;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RegisterUser implements Task {

    private final String username;
    private final String password;
    private final boolean emptyFields;

    public RegisterUser(String username, String password, boolean emptyFields) {
        this.username = username;
        this.password = password;
        this.emptyFields = emptyFields;
    }

    public static RegisterUser withRandomCredentials() {

        String username = DataGenerator.generateUsername();
        String password = DataGenerator.generatePassword();

        return Tasks.instrumented(RegisterUser.class, username, password, false);
    }

    public static RegisterUser withEmptyFields() {
        return Tasks.instrumented(RegisterUser.class, "", "", true);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        if (!emptyFields) {
            actor.remember("username", username);
            actor.remember("password", password);
        }

        actor.attemptsTo(
                Click.on(RegisterPage.BTN_SIGNUP),
                WaitUntil.the(RegisterPage.TXT_USERNAME, isVisible()).forNoMoreThan(5).seconds()
        );

        if (!emptyFields) {
            actor.attemptsTo(
                    Enter.theValue(username).into(RegisterPage.TXT_USERNAME),
                    Enter.theValue(password).into(RegisterPage.TXT_PASSWORD)
            );
        }

        actor.attemptsTo(
                Click.on(RegisterPage.BTN_SUBMIT),
                HandleAlert.capture()
        );

        if (!emptyFields) {
            actor.attemptsTo(
                    WaitUntil.the(HomePage.NAVBAR, isVisible()).forNoMoreThan(10).seconds()
            );
        }
    }
}