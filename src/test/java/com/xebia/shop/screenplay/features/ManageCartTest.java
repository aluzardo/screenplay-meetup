package com.xebia.shop.screenplay.features;

import com.xebia.shop.screenplay.questions.TheNumberOfProducts;
import com.xebia.shop.screenplay.questions.TheTotalPrice;
import com.xebia.shop.screenplay.tasks.ChangeTheAmount;
import com.xebia.shop.screenplay.tasks.Start;
import com.xebia.shop.screenplay.tasks.ViewTheCart;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by jochum on 30/09/16.
 */
@RunWith(SerenityRunner.class)
@WithTag("Screenplay")
public class ManageCartTest {

    Actor anna = Actor.named("Anna");

    @Steps ViewTheCart viewTheCart;
    @Steps TheNumberOfProducts theNumberOfProducts;
    @Steps TheTotalPrice theTotalPrice;

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Before
    public void declare_her_abilities() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void increase_amount_of_one_product() {
        givenThat(anna).wasAbleTo(Start.withCartContaining("Testing 3.0",
                "Test Driven Development (TDD)",
                "Specification by Example"));
        and(anna).wasAbleTo(viewTheCart);

        when(anna).attemptsTo(ChangeTheAmount.of("Test Driven Development (TDD)").to(4));

        then(anna).should(
                seeThat(theNumberOfProducts, is(6)),
                seeThat(theTotalPrice, is("€ 3,570.00")));
    }
}