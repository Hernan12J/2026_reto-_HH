/**
 * @author Hernan J
 * @created 03/22/2026 12:51 p. m.
 */
package co.com.screenplay.project.questions;

import co.com.screenplay.project.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class RegisterResult implements Question<Boolean> {

    public static RegisterResult isSuccessful() {
        return new RegisterResult();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        String alert = actor.recall("alertMessage");

        if (!"NO_ALERT".equals(alert)) {
            return alert.toLowerCase().contains("sign up successful");
        }

        return Visibility.of(HomePage.NAVBAR).answeredBy(actor);
    }
}