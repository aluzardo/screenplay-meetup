package com.xebia.meetup.screenplay.tasks.messaging;

import com.xebia.meetup.screenplay.ui.MessagesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DraftANewMessage implements Task {

    private final String username;
    private String message;

    public static DraftANewMessage forUser(String username) {
        return instrumented(DraftANewMessage.class, username);
    }

    public DraftANewMessage withText(String message) {
        this.message = message;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MessagesPage.NEW_MESSAGE_BUTTON),
                Enter.theValue(username).into(MessagesPage.NewMessage.RECIPIENTS),
                Click.on(MessagesPage.NewMessage.FOUND_MEMBER),
                Enter.theValue(message).into(MessagesPage.NewMessage.MESSAGE_TEXT)
        );
    }

    protected DraftANewMessage(String username) {
        this.username = username;
    }
}
