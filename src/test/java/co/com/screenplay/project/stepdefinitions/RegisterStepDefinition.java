/**
 * @author Hernan J
 * @created 03/22/2026 12:32 a. m.
 */
package co.com.screenplay.project.stepdefinitions;


import co.com.screenplay.project.questions.RegisterFailed;
import co.com.screenplay.project.questions.RegisterResult;
import co.com.screenplay.project.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.containsString;


public class RegisterStepDefinition {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que {string} abre el sitio web")
    public void abreElSitioWeb(String actor) {
        OnStage.theActorCalled(actor).attemptsTo(
                OpenWeb.on()
        );
    }

    @Cuando("el se registra con credenciales validas")
    public void registroDinamico() {

        theActorInTheSpotlight().attemptsTo(
                RegisterUser.withRandomCredentials()
        );
    }

    @Entonces("el deberia ver un mensaje de registro exitoso")
    public void validaRegistroExitoso() {

        theActorInTheSpotlight().should(
                seeThat(RegisterResult.isSuccessful())
        );
    }

    @Cuando("el intenta registrarse con campos vacios")
    public void registroVacio() {

        theActorInTheSpotlight().attemptsTo(
                RegisterWithEmptyFields.attempt()
        );
    }

    @Entonces("el deberia ver un mensaje de error de registro")
    public void validarRegistroFallido() {

        theActorInTheSpotlight().should(
                seeThat(RegisterFailed.withEmptyFields())
        );
    }

}

