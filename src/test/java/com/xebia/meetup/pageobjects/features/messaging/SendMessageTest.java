package com.xebia.meetup.pageobjects.features.messaging;

import com.xebia.meetup.pageobjects.steps.MeetUpUserSteps;
import com.xebia.meetup.utils.Credentials;
import net.serenitybdd.junit.runners.SerenityRunner;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
@WithTag("PageObjects")
public class SendMessageTest {

    @Managed
    WebDriver driver;

    @Steps
    MeetUpUserSteps anna;

    private String otherUser = "Screenplay Meetup";

    @Before
    public void login() {
        Credentials c = Credentials.getInstance();
        anna.supplies_credentials(c);
        anna.opens_the_meetup_login_page_and_logs_in();
    }

    @Test
    public void start_a_conversation_by_sending_a_message() {
        // GIVEN
        anna.browses_to_the_messages_page();

        // WHEN
        anna.drafts_a_new_message_for(otherUser).with_text("This Is A Test Message");
        anna.sends_the_message();
        anna.browses_to_the_messages_page();

        // THEN
        anna.should_see_the_most_recent_conversation_is_with(otherUser);
    }

    @After
    public void logout() {
        anna.logs_out();
    }
}
