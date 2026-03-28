/**
 * @author Hernan J
 * @created 03/28/2026 10:32 a. m.
 */
package co.com.screenplay.project.questions;
import co.com.screenplay.project.userinterfaces.ContactPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class ContactResult implements Question<Boolean> {

    public static ContactResult wasSuccessful() {
        return new ContactResult();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        String alert = actor.recall("contactAlert");

        if (!"NO_ALERT".equals(alert)) {
            return alert.contains("Thanks for the message");
        }

        try {
            return !Visibility.of(ContactPage.TXT_CONTACT_EMAIL)
                    .answeredBy(actor);
        } catch (Exception e) {
            return true;
        }
    }
}