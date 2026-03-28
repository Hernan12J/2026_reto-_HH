/**
 * @author Hernan J
 * @created 03/28/2026 9:48 a. m.
 */
package co.com.screenplay.project.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ContactPage {
        public static final Target BTN_CONTACT = Target.the("botón de contact")
                .located(By.xpath("//a[text()='Contact']"));
        public static final Target TXT_CONTACT_EMAIL = Target.the("Input de contact email")
            .located(By.id("recipient-email"));
        public static final Target TXT_CONTACT_NAME = Target.the("Input de contact name")
            .located(By.id("recipient-name"));
        public static final Target TXT_MESSAGE = Target.the("Input de MENSSAGE")
            .located(By.id("message-text"));
    public static final Target BTN_SEND_MESSAGE = Target.the("botón de enviar mensaje")
            .located(By.xpath("//button[text()='Send message']"));
}
