package com.xebia.meetup.screenplay.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Created by jochum on 15/08/16.
 */
public class MessagesPage extends PageObject {
    public static Target NEW_MESSAGE_BUTTON = Target.the("new message button").located(By.id("messaging-new"));

}
