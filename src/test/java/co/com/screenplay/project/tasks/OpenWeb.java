/**
 * @author Hernan J
 * @created 03/22/2026 12:28 a. m.
 */
package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import co.com.screenplay.project.userinterfaces.HomePage;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OpenWeb implements Task {

    public static OpenWeb on() {
        return Tasks.instrumented(OpenWeb.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("https://www.demoblaze.com/"),
                WaitUntil.the(HomePage.NAVBAR, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}