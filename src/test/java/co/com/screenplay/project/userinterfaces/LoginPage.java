/**
 * @author Hernan J
 * @created 03/22/2026 12:08 p. m.
 */
package co.com.screenplay.project.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static final Target BTN_LOGIN = Target.the("botón de login in")
            .located(By.id("login2"));
    public static final Target TXT_LOGIN_USERNAME = Target.the("Input username Login in")
            .located(By.id("loginusername"));
    public static final Target TXT_LOGIN_PASSWORD = Target.the("Input passsword Login in")
            .located(By.id("loginpassword"));
    public static final Target BTN_LOGIN_IN = Target.the("botón de enviar registro Login")
            .located(By.xpath("//button[text()='Log in']"));
    public static final Target LBL_LOGIN_USER = Target.the("Label con usuario que inicio login")
            .located(By.id("nameofuser"));
}