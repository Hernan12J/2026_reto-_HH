/**
 * @author Hernan J
 * @created 03/22/2026 1:31 p. m.
 */
package co.com.screenplay.project.userinterfaces;
import net.serenitybdd.screenplay.targets.Target;

public class ProductPage {

    public static final Target LNK_PRODUCT = Target.the("producto Samsung galaxy s6")
            .locatedBy("//a[text()='Samsung galaxy s6']");
    public static final Target BTN_ADD_TO_CART = Target.the("botón add to cart")
            .locatedBy("//a[text()='Add to cart']");
}
