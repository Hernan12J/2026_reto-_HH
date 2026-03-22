/**
 * @author Hernan J
 * @created 03/22/2026 1:40 p. m.
 */
package co.com.screenplay.project.questions;
import co.com.screenplay.project.userinterfaces.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class PurchaseResult implements Question<String> {

    public static PurchaseResult message() {
        return new PurchaseResult();
    }

    @Override
    public String answeredBy(Actor actor) {
        return CartPage.LBL_CONFIRMATION.resolveFor(actor).getText();
    }
}