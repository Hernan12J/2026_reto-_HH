/**
 * @author Hernan J
 * @created 03/22/2026 1:38 p. m.
 */
package co.com.screenplay.project.userinterfaces;
import net.serenitybdd.screenplay.targets.Target;

public class CartPage {

    public static final Target LNK_CART =
            Target.the("link cart")
                    .locatedBy("//a[text()='Cart']");

    public static final Target BTN_PLACE_ORDER =
            Target.the("botón place order")
                    .locatedBy("//button[text()='Place Order']");

    public static final Target TXT_NAME =
            Target.the("input name")
                    .locatedBy("//input[@id='name']");

    public static final Target TXT_COUNTRY =
            Target.the("input country")
                    .locatedBy("//input[@id='country']");

    public static final Target TXT_CITY =
            Target.the("input city")
                    .locatedBy("//input[@id='city']");

    public static final Target TXT_CARD =
            Target.the("input card")
                    .locatedBy("//input[@id='card']");

    public static final Target TXT_MONTH =
            Target.the("input month")
                    .locatedBy("//input[@id='month']");

    public static final Target TXT_YEAR =
            Target.the("input year")
                    .locatedBy("//input[@id='year']");

    public static final Target BTN_PURCHASE =
            Target.the("botón purchase")
                    .locatedBy("//button[text()='Purchase']");

    public static final Target LBL_CONFIRMATION =
            Target.the("mensaje de confirmación")
                    .locatedBy("//h2[text()='Thank you for your purchase!']");
}