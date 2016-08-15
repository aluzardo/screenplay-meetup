package com.xebia.meetup.screenplay.questions;

import com.xebia.meetup.screenplay.ui.MessagesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class MostRecentConversationPartner implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(MessagesPage.MOST_RECENT_CONVERSATION_PARTNER).viewedBy(actor).asString();
    }
}
