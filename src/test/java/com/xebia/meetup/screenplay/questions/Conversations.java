package com.xebia.meetup.screenplay.questions;

import net.serenitybdd.screenplay.Question;

public class Conversations {
    public static Question<String> mostRecentConversationPartner() {
        return new MostRecentConversationPartner();
    }
}
