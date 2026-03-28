package co.com.screenplay.project.tasks;

import co.com.screenplay.project.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginUser implements Task {

    private final String username;
    private final String password;

    public LoginUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static LoginUser withEnvironmentCredentials() {

        String username = System.getenv("USER_DEMO");
        String password = System.getenv("PASS_DEMO");

        if (username == null || password == null) {
            throw new IllegalStateException("Las variables de entorno USER_DEMO o PASS_DEMO no están definidas");
        }

        return Tasks.instrumented(LoginUser.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(LoginPage.BTN_LOGIN),
                WaitUntil.the(LoginPage.TXT_LOGIN_USERNAME, isVisible()).forNoMoreThan(5).seconds(),
                Enter.theValue(username).into(LoginPage.TXT_LOGIN_USERNAME),
                Enter.theValue(password).into(LoginPage.TXT_LOGIN_PASSWORD),
                Click.on(LoginPage.BTN_LOGIN_IN),
                WaitUntil.the(LoginPage.LBL_LOGIN_USER, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}