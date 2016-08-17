package com.xebia.meetup.pageobjects.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Created by jochum on 17/08/16.
 */
public class MessagesPage extends PageObject {

    @FindBy(id="messaging-new")
    WebElementFacade newMessageButton;

    @FindBy(css="li.convoItem:first-child div.convoItem-name")
    WebElementFacade mostRecentConversationPartner;

    @FindBy(css="#convoNew-view input.recipient-input")
    WebElementFacade recipientsField;

    @FindBy(css="li.member.selected")
    WebElementFacade foundMember;

    @FindBy(id="messaging-new-convo")
    WebElementFacade messageTextField;

    @FindBy(id="messaging-new-send")
    WebElementFacade sendMessageButton;

    public void create_new_message() {
        newMessageButton.click();
    }

    public void fill_recipients(String otherUser) {
        recipientsField.type(otherUser);
        foundMember.click();
    }

    public void type_message(String message) {
        messageTextField.type(message);
    }

    public void send_message() {
        sendMessageButton.click();
    }

    public String most_recent_conversation_partner() {
        return mostRecentConversationPartner.getText();
    }
}
