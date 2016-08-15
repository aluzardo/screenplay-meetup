package com.xebia.meetup.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * Created by jochum on 15/08/16.
 */
public class IsConversationPartner implements Question<Boolean> {

    private String partner;

    public static Question<Boolean> with(String username) {
        return new IsConversationPartner(username);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return null;
    }

    private IsConversationPartner(String partner) {
        this.partner = partner;
    }
}
