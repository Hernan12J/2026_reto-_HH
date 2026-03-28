/**
 * @author Hernan J
 * @created 03/22/2026 1:45 p. m.
 */
package co.com.screenplay.project.stepdefinitions;


import co.com.screenplay.project.questions.LoginFailed;
import co.com.screenplay.project.questions.LoginResult;
import co.com.screenplay.project.tasks.LoginInvalidUser;
import co.com.screenplay.project.tasks.LoginUser;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.containsString;

public class LoginStepDefinition {

    @Cuando("el inicia sesion con credenciales validas")
    public void login() {
        theActorInTheSpotlight().attemptsTo(
                LoginUser.withEnvironmentCredentials());
    }
    @Entonces("el deberia ver su nombre de usuario en la pagina")
    public void validarLogin() {

        String username = System.getenv("USER_DEMO");

        theActorInTheSpotlight().should(
                seeThat(
                        LoginResult.userName(),
                        containsString(username)
                )
        );
    }
    @Cuando("el inicia sesion con credenciales invalidas")
    public void loginInvalido() {

        theActorInTheSpotlight().attemptsTo(
                LoginInvalidUser.attempt());
    }

    @Entonces("deberia ver un mensaje de error en el login")
    public void validarErrorLogin() {

        theActorInTheSpotlight().should(
                seeThat(LoginFailed.unsuccessfully())
        );
    }
}
