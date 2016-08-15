package com.xebia.meetup.screenplay.questions;

import com.xebia.meetup.screenplay.ui.UserMenu;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.CurrentVisibility;

/**
 * Created by jochum on 15/08/16.
 */
public class TheUserAvatarIsVisible implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return CurrentVisibility.of(UserMenu.AVATAR).viewedBy(actor).asBoolean();
    }
}
