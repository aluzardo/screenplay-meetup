package com.xebia.meetup.screenplay.questions;

import com.xebia.meetup.screenplay.model.Conversation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

/**
 * Created by jochum on 15/08/16.
 */
public class ConversationList implements Question<List<Conversation>> {
    @Override
    public List<Conversation> answeredBy(Actor actor) {
        return null;
    }
}
