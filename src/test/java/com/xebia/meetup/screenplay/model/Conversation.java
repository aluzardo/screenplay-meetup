package com.xebia.meetup.screenplay.model;

import java.util.List;

/**
 * Created by jochum on 15/08/16.
 */
public class Conversation {
    private String partner;

    public Conversation(String partner) {
        this.partner = partner;
    }

    public String getPartner() {
        return partner;
    }
}
