/**
 * @author Hernan J
 * @created 03/22/2026 1:45 p. m.
 */
package co.com.screenplay.project.stepdefinitions;

import co.com.screenplay.project.questions.LoginResult;
import co.com.screenplay.project.tasks.LoginUser;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.containsString;

public class LoginStepDefinition {

    @Cuando("el inicia sesion con usuario {string} y contrasena {string}")
    public void login(String username, String password) {

        theActorInTheSpotlight().attemptsTo(
                LoginUser.withCredentials(username, password)
        );
    }
    @Entonces("el deberia ver su nombre de usuario en la pagina")
    public void validarLogin() {
        theActorInTheSpotlight().should(
                seeThat(
                        LoginResult.userName(),
                        containsString("Test2cre2g2")
                )
        );
    }
}
