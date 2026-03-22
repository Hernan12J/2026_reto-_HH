/**
 * @author Hernan J
 * @created 03/22/2026 1:47 p. m.
 */
package co.com.screenplay.project.stepdefinitions;

import co.com.screenplay.project.questions.PurchaseResult;
import co.com.screenplay.project.tasks.AddProductToCart;
import co.com.screenplay.project.tasks.CompletePurchase;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.containsString;

public class PurchaseStepDefinition {
    @Cuando("el agrega un producto al carrito")
    public void agregarProducto() {

        theActorInTheSpotlight().attemptsTo(
                AddProductToCart.on()
        );
    }
    @Cuando("el completa la compra")
    public void completarCompra() {

        theActorInTheSpotlight().attemptsTo(
                CompletePurchase.on()
        );
    }
    @Entonces("el deberia ver un mensaje de compra exitosa")
    public void validarCompra() {

        theActorInTheSpotlight().should(
                seeThat(
                        PurchaseResult.message(),
                        containsString("Thank you for your purchase")
                )
        );
    }
}
