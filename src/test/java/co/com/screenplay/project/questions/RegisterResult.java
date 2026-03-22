/**
 * @author Hernan J
 * @created 03/22/2026 12:51 p. m.
 */
package co.com.screenplay.project.questions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class RegisterResult implements Question<String> {

    public static RegisterResult message() {
        return new RegisterResult();
    }

    @Override
    public String answeredBy(Actor actor) {
        return actor.recall("alertMessage");
    }
}