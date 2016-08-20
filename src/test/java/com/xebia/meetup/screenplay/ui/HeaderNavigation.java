package com.xebia.meetup.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HeaderNavigation {
    public static Target ACCOUNT_DROPDOWN = Target.the("account dropdown menu").located(By.cssSelector("#nav-profile a"));
    public static Target LOGOUT_LINK = Target.the("logout").located(By.cssSelector("#nav-account-links a[href*=\"logout\"]"));

    // TODO: define the Target for the User Avatar
    public static Target AVATAR = null;

}
