/**
 * @author Hernan J
 * @created 03/22/2026 1:37 p. m.
 */
package co.com.screenplay.project.tasks;
import co.com.screenplay.project.userinterfaces.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import com.github.javafaker.Faker;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CompletePurchase implements Task {
    Faker faker = new Faker();

    String name = faker.name().firstName();
    String country = faker.address().country();
    String city = faker.address().city();
    String card = faker.finance().creditCard();
    String month = "03";
    String year = "2026";

    public static CompletePurchase on() {
        return Tasks.instrumented(CompletePurchase.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(CartPage.LNK_CART),

                WaitUntil.the(CartPage.BTN_PLACE_ORDER, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(CartPage.BTN_PLACE_ORDER),

                WaitUntil.the(CartPage.TXT_NAME, isVisible()).forNoMoreThan(5).seconds(),

                Enter.theValue(name).into(CartPage.TXT_NAME),
                Enter.theValue(country).into(CartPage.TXT_COUNTRY),
                Enter.theValue(city).into(CartPage.TXT_CITY),
                Enter.theValue(card).into(CartPage.TXT_CARD),
                Enter.theValue(month).into(CartPage.TXT_MONTH),
                Enter.theValue(year).into(CartPage.TXT_YEAR),

                Click.on(CartPage.BTN_PURCHASE),

                WaitUntil.the(CartPage.LBL_CONFIRMATION, isVisible()).forNoMoreThan(10).seconds()
        );

        String mensaje = CartPage.LBL_CONFIRMATION.resolveFor(actor).getText();
        actor.remember("purchaseMessage", mensaje);
    }
}
