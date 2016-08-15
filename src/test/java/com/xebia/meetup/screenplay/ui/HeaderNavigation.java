package com.xebia.meetup.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HeaderNavigation {
    public static Target MESSAGES = Target.the("messages menu item").located(By.cssSelector("#nav-messages a"));

    public static Target ACCOUNT_DROPDOWN = Target.the("account dropdown menu").located(By.cssSelector("#nav-profile a"));
    public static Target AVATAR = Target.the("avatar").located(By.id("headerAvatar"));

    public static class AccountDropdown {
        public static Target LOGOUT_LINK = Target.the("logout").located(By.cssSelector("#nav-account-links a[href*=\"logout\"]"));
    }
}
