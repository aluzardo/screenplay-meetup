package com.xebia.meetup.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by jochum on 15/08/16.
 */
public class Credentials {

    private Properties props;

    private static Credentials instance;

    private Credentials() {
        this.props = new Properties();
        try {
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("credentials.properties");
            this.props.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Credentials getInstance() {
        if (instance == null) {
            instance = new Credentials();
        }
        return instance;
    }

    public String getUsername() {
        return props.getProperty("meetup.username");
    }

    public String getPassword() {
        return props.getProperty("meetup.password");
    }
}
