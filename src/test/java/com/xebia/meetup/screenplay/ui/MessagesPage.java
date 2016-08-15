package com.xebia.meetup.screenplay.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MessagesPage extends PageObject {
    public static Target NEW_MESSAGE_BUTTON = Target.the("new message button").located(By.id("messaging-new"));

    public static Target MOST_RECENT_CONVERSATION_PARTNER = Target.the("most recent conversation partner")
            .located(By.cssSelector("li.convoItem:first-child div.convoItem-name"));

    public static class NewMessage {
        public static Target RECIPIENTS = Target.the("recipients field").located(By.cssSelector("#convoNew-view input.recipient-input"));
        public static Target FOUND_MEMBER = Target.the("top matching recipient").located(By.cssSelector("li.member.selected"));
        public static Target MESSAGE_TEXT = Target.the("message textfield").located(By.id("messaging-new-convo"));
        public static Target SEND_BUTTON = Target.the("send message button").located(By.id("messaging-new-send"));
    }
}
