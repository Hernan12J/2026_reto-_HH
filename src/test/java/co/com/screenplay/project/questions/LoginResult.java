/**
 * @author Hernan J
 * @created 03/22/2026 12:57 p. m.
 */
package co.com.screenplay.project.questions;

import co.com.screenplay.project.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.questions.Text;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginResult implements Question<String> {

    public static LoginResult userName() {
        return new LoginResult();
    }

    @Override
    public String answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(LoginPage.LBL_LOGIN_USER, isVisible())
                        .forNoMoreThan(10).seconds()
        );

        return Text.of(LoginPage.LBL_LOGIN_USER).answeredBy(actor);
    }
}