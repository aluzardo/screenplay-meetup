package com.xebia.meetup.screenplay.questions;

import com.xebia.meetup.screenplay.ui.MessagesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.CurrentVisibility;

public class NewMessageWidgetHasLoaded implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return CurrentVisibility.of(MessagesPage.NewMessage.RECIPIENTS).viewedBy(actor).asBoolean();
    }

}
