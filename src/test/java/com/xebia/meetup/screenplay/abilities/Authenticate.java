package com.xebia.meetup.screenplay.abilities;

import com.xebia.meetup.screenplay.exceptions.CannotAuthenticateException;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

/**
 * Created by jochum on 15/08/16.
 */
public class Authenticate implements Ability {

    private final String username;
    private final String password;

    private Authenticate(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String username() { return username; }
    public String password() { return password; }

    public static Authenticate withCredentials(String username, String password) {
        return new Authenticate(username, password);
    }

    public static Authenticate as(Actor actor) {
        if (actor.abilityTo(Authenticate.class) == null) {
            throw new CannotAuthenticateException(actor.getName());
        }
        return actor.abilityTo(Authenticate.class).asActor(actor);
    }

    @Override
    public <T extends Ability> T asActor(Actor actor) {
        return (T) this;
    }
}
