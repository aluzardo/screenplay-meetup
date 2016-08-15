package com.xebia.meetup.screenplay.questions;

import com.xebia.meetup.screenplay.ui.HeaderNavigation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.CurrentVisibility;

public class TheUserAvatarIsVisible implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return CurrentVisibility.of(HeaderNavigation.AVATAR).viewedBy(actor).asBoolean();
    }
}
