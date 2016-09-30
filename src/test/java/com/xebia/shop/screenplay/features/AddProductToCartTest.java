package com.xebia.shop.screenplay.features;

import com.xebia.shop.screenplay.questions.TheNumberOfProducts;
import com.xebia.shop.screenplay.questions.TheTotalPrice;
import com.xebia.shop.screenplay.tasks.AddsToHerCart;
import com.xebia.shop.screenplay.tasks.OpenTheWebshop;
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
public class AddProductToCartTest {

    Actor anna = Actor.named("Anna");

    @Steps OpenTheWebshop openTheWebshop;
    @Steps TheNumberOfProducts theNumberOfProducts;
    @Steps TheTotalPrice theTotalPrice;

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Before
    public void declare_her_abilities() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void add_one_product_to_the_cart() {
        givenThat(anna).wasAbleTo(openTheWebshop);

        when(anna).attemptsTo(AddsToHerCart.theProducts("Specification by Example"));

        then(anna).should(
                seeThat(theNumberOfProducts, is(1)),
                seeThat(theTotalPrice, is("€ 795.00")));
    }
}
