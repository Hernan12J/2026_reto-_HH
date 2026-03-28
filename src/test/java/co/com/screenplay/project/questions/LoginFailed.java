/**
 * @author Hernan J
 * @created 03/28/2026 1:21 a. m.
 */
package co.com.screenplay.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class LoginFailed implements Question<Boolean> {

    public static LoginFailed unsuccessfully() {
        return new LoginFailed();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        String alert = actor.recall("alertMessage");

        if (!"NO_ALERT".equals(alert)) {
            return alert.toLowerCase().contains("wrong")
                    || alert.toLowerCase().contains("user");
        }

        try {
            String username = actor.asksFor(LoginResult.userName());
            return username == null || username.trim().isEmpty();
        } catch (Exception e) {
            return true;
        }
    }
}