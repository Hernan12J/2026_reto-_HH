/**
 * @author Hernan J
 * @created 03/22/2026 1:03 a. m.
 */
package co.com.screenplay.project.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import net.serenitybdd.core.pages.PageObject;

public class HomePage extends PageObject {

    public static final Target NAVBAR = Target.the("navbar principal")
            .located(By.id("nava"));
}
