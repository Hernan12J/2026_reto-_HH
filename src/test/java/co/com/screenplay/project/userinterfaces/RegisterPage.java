/**
 * @author Hernan J
 * @created 03/22/2026 1:39 a. m.
 */
package co.com.screenplay.project.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegisterPage {
    public static final Target BTN_SIGNUP = Target.the("botón de registro")
            .located(By.id("signin2"));

    public static final Target TXT_USERNAME = Target.the("campo de usuario")
            .located(By.id("sign-username"));

    public static final Target TXT_PASSWORD = Target.the("campo de contraseña")
            .located(By.id("sign-password"));

    public static final Target BTN_SUBMIT = Target.the("botón de enviar registro")
            .located(By.xpath("//button[text()='Sign up']"));
}
