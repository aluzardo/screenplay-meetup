package com.xebia.shop.pageobjects.features;

import com.xebia.shop.pageobjects.steps.ActorSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by jochum on 30/09/16.
 */
@RunWith(SerenityRunner.class)
@WithTag("PageObjects")
public class AddProductToCartTest {

    @Managed
    WebDriver driver;

    @Steps
    ActorSteps anna;

    @Test
    public void add_one_product_to_the_cart() {
        // GIVEN
        anna.opened_the_webshop();

        // WHEN
        anna.adds_to_the_cart("Specification by Example");

        // THEN
        anna.has_this_amount_of_products_in_the_cart(1);
        anna.has_a_cart_with_total_cost("€ 795.00");
    }

}