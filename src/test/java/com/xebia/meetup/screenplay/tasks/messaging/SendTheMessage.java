package com.xebia.meetup.screenplay.tasks.messaging;

import com.xebia.meetup.screenplay.ui.MessagesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

/**
 * Created by jochum on 15/08/16.
 */
public class SendTheMessage implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MessagesPage.NewMessage.SEND_BUTTON)
        );
    }
}
