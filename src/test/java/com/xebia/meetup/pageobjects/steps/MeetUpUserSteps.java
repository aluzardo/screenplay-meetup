package com.xebia.meetup.pageobjects.steps;

import com.xebia.meetup.pageobjects.pages.LoginPage;
import com.xebia.meetup.pageobjects.pages.MeetUpLandingPage;
import com.xebia.meetup.pageobjects.pages.HeaderNavigation;
import com.xebia.meetup.pageobjects.pages.MessagesPage;
import com.xebia.meetup.utils.Credentials;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by jochum on 17/08/16.
 */
public class MeetUpUserSteps {

    MeetUpLandingPage meetUpLandingPage;
    LoginPage loginPage;
    HeaderNavigation headerNavigation;
    MessagesPage messagesPage;

    private Credentials credentials;

    @Step
    public void supplies_credentials(Credentials c) {
        this.credentials = c;
    }

    @Step
    public void opens_the_meetup_website() {
        meetUpLandingPage.open();
    }

    @Step
    public void browses_to_the_login_page() {
        meetUpLandingPage.goto_login_page();
    }

    @Step
    public void opens_the_meetup_login_page() {
        loginPage.open();
    }

    @Step
    public void logs_in_with_credentials() {
        loginPage.login_with_credentials(credentials.getUsername(), credentials.getPassword());
    }

    @Step
    public void opens_the_meetup_login_page_and_logs_in() {
        opens_the_meetup_login_page();
        logs_in_with_credentials();
    }

    @Step
    public void logs_in_via_facebook() {
        throw new RuntimeException("Unimplemented method");
    }

    @Step
    public void browses_to_the_messages_page() {
        headerNavigation.goto_messages_page();
    }

    @Step
    public void should_see_the_profile_avatar() {
        assertThat(headerNavigation.avatarIsVisible(), is(true));
    }

    @Step
    public MeetUpUserSteps drafts_a_new_message_for(String otherUser) {
        messagesPage.create_new_message();
        messagesPage.fill_recipients(otherUser);
        return this;
    }

    @Step
    public void with_text(String message) {
        messagesPage.type_message(message);
    }

    @Step
    public void sends_the_message() {
        messagesPage.send_message();
    }

    @Step
    public void should_see_the_most_recent_conversation_is_with(String otherUser) {
        assertThat(messagesPage.most_recent_conversation_partner(), is(otherUser));
    }

    @Step
    public void logs_out() {
        headerNavigation.logout();
    }
}
