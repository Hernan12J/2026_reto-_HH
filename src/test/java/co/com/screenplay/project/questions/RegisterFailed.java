/**
 * @author Hernan J
 * @created 03/28/2026 12:32 p. m.
 */
package co.com.screenplay.project.questions;

import co.com.screenplay.project.userinterfaces.RegisterPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class RegisterFailed implements Question<Boolean> {

    public static RegisterFailed withEmptyFields() {
        return new RegisterFailed();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        String alert = actor.recall("alertMessage");

        if (!"NO_ALERT".equals(alert)) {
            return alert.toLowerCase().contains("please fill out");
        }

        return Visibility.of(RegisterPage.TXT_USERNAME).answeredBy(actor);
    }
}