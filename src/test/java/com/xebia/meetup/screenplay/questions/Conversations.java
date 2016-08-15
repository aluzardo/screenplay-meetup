package com.xebia.meetup.screenplay.questions;

import net.serenitybdd.screenplay.Question;

/**
 * Created by jochum on 15/08/16.
 */
public class Conversations {
    public static Question<Boolean> includeConversationWith(String username) {
        return IsConversationPartner.with(username);
    }
}
