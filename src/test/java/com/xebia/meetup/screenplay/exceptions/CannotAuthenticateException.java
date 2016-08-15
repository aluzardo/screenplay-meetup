package com.xebia.meetup.screenplay.exceptions;

/**
 * Created by jochum on 15/08/16.
 */
public class CannotAuthenticateException extends RuntimeException {

    public CannotAuthenticateException(String name) {
        super("Actor "+ name +" is not able to authenticate.");
    }
}
