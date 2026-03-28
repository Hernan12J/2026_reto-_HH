/**
 * @author Hernan J
 * @created 03/28/2026 1:21 a. m.
 */
package co.com.screenplay.project.questions;

import co.com.screenplay.project.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class LoginFailed implements Question<Boolean> {

    public static LoginFailed unsuccessfully() {
        return new LoginFailed();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String text = Text.of(LoginPage.LBL_LOGIN_USER)
                .answeredBy(actor);

        return text == null || text.trim().isEmpty();
    }
}