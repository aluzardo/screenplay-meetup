package com.xebia.meetup.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Created by jochum on 15/08/16.
 */
public class UserMenu {
    public static Target AVATAR = Target.the("avatar").located(By.id("headerAvatar"));

    public static Target SHOW_DROPDOWN = Target.the("show dropdown menu").located(By.cssSelector("#nav-profile a"));
    public static Target LOGOUT_LINK = Target.the("logout").located(By.cssSelector("#nav-account-links a[href*=\"logout\"]"));
}
