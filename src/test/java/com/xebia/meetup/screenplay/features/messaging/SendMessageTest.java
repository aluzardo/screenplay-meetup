package com.xebia.meetup.screenplay.features.messaging;

import com.xebia.meetup.screenplay.abilities.Authenticate;
import com.xebia.meetup.screenplay.questions.Conversations;
import com.xebia.meetup.screenplay.tasks.BrowseToTheMessagesPage;
import com.xebia.meetup.screenplay.tasks.LogOut;
import com.xebia.meetup.screenplay.tasks.login.OpenTheLoginPageAndLogin;
import com.xebia.meetup.screenplay.tasks.messaging.DraftANewMessage;
import com.xebia.meetup.screenplay.tasks.messaging.SendTheMessage;
import com.xebia.meetup.utils.Credentials;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import net.thucydides.core.annotations.WithTag;
import org.openqa.selenium.WebDriver;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
@WithTag("Screenplay")
public class SendMessageTest {
    Actor anna = Actor.named("Anna");
    String otherUser = "Screenplay Meetup";

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps OpenTheLoginPageAndLogin openTheLoginPageAndLogin;
    @Steps BrowseToTheMessagesPage browseToTheMessagesPage;
    @Steps SendTheMessage sendTheMessage;
    @Steps LogOut logOut;

    @Before
    public void login() {
        Credentials c = Credentials.getInstance();
        anna.can(BrowseTheWeb.with(herBrowser))
                .can(Authenticate.withCredentials(c.getUsername(), c.getPassword()));
        anna.attemptsTo(openTheLoginPageAndLogin);
    }

    @Test
    public void start_a_conversation_by_sending_a_message() {
        givenThat(anna).wasAbleTo(browseToTheMessagesPage);

        when(anna).attemptsTo(DraftANewMessage.forUser(otherUser).withText("This Is A Test Message"));
        and(anna).wasAbleTo(sendTheMessage);

        then(anna).attemptsTo(browseToTheMessagesPage);
        and(anna).should(eventually(seeThat(Conversations.mostRecentConversationPartner(), containsString(otherUser))));
    }

    @After
    public void logout() {
        anna.attemptsTo(logOut);
    }
}
