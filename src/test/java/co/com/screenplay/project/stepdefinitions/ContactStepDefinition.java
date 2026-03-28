/**
 * @author Hernan J
 * @created 03/28/2026 10:04 a. m.
 */
package co.com.screenplay.project.stepdefinitions;

import co.com.screenplay.project.questions.ContactResult;
import co.com.screenplay.project.tasks.SendContactMessage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.assertj.core.api.Assertions.assertThat;

public class ContactStepDefinition {
    @Cuando("el envia un mensaje de contacto")
    public void enviarMensajeContacto() {

        theActorInTheSpotlight().attemptsTo(
                SendContactMessage.now()
        );
    }

    @Entonces("deberia ver un mensaje de confirmacion de contacto")
    public void validarMensajeContacto() {

        theActorInTheSpotlight().should(
                seeThat(ContactResult.wasSuccessful())
        );
    }
}
