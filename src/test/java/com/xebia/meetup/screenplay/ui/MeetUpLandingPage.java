package com.xebia.meetup.screenplay.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("http://www.meetup.com")
public class MeetUpLandingPage extends PageObject {
    public static Target LOGIN_LINK = Target.the("login link").located(By.cssSelector("#authItem a[href*=\"login\"]"));
}
