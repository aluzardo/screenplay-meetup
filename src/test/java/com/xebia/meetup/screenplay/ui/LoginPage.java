package com.xebia.meetup.screenplay.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

/**
 * Created by jochum on 15/08/16.
 */
@DefaultUrl("https://secure.meetup.com/login/")
public class LoginPage extends PageObject {
    public static Target USERNAME_FIELD = Target.the("username field").located(By.id("email"));
    public static Target PASSWORD_FIELD = Target.the("password field").located(By.id("password"));
    public static Target LOGIN_BUTTON = Target.the("login button").located(By.name("submitButton"));
}
