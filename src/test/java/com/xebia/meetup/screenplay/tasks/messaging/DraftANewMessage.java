package com.xebia.meetup.screenplay.tasks.messaging;

import com.xebia.meetup.screenplay.questions.NewMessageWidgetHasLoaded;
import com.xebia.meetup.screenplay.ui.MessagesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;

public class DraftANewMessage implements Task {

    private final String username;
    private final String message;

    public static Performable forUserWithText(String username, String message) {
        return instrumented(DraftANewMessage.class, username, message);
    }

    @Steps
    NewMessageWidgetHasLoaded newMessageWidgetHasLoaded;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MessagesPage.NEW_MESSAGE_BUTTON)
        );
        actor.should(eventually(seeThat(newMessageWidgetHasLoaded)));
        actor.attemptsTo(
                Enter.theValue(username).into(MessagesPage.NewMessage.RECIPIENTS),
                Click.on(MessagesPage.NewMessage.FOUND_MEMBER),
                Enter.theValue(message).into(MessagesPage.NewMessage.MESSAGE_TEXT)
        );
    }

    protected DraftANewMessage(String username, String message) {
        this.username = username;
        this.message = message;
    }
}
