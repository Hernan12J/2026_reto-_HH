/**
 * @author Hernan J
 * @created 03/22/2026 12:57 p. m.
 */
package co.com.screenplay.project.questions;
import co.com.screenplay.project.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class LoginResult implements Question<String> {

    public static LoginResult userName() {
        return new LoginResult();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(LoginPage.LBL_LOGIN_USER).answeredBy(actor);
    }
}