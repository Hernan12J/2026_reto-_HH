/**
 * @author Hernan J
 * @created 03/22/2026 1:31 p. m.
 */
package co.com.screenplay.project.tasks;
import co.com.screenplay.project.interactions.HandleAlert;
import co.com.screenplay.project.userinterfaces.ProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddProductToCart implements Task {

    public static AddProductToCart on() {
        return Tasks.instrumented(AddProductToCart.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(ProductPage.LNK_PRODUCT),
                WaitUntil.the(ProductPage.BTN_ADD_TO_CART, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(ProductPage.BTN_ADD_TO_CART),
                HandleAlert.capture()
        );
    }
}