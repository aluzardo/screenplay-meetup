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
public class ManageCartTest {
    @Managed
    WebDriver driver;

    @Steps
    ActorSteps anna;

    @Test
    public void add_one_product_to_the_cart() {
        // GIVEN
        anna.has_a_cart_with("Testing 3.0", "Test Driven Development (TDD)", "Specification by Example");
        anna.views_her_cart();

        // WHEN
        anna.changes_the_amount_for_product("Test Driven Development (TDD)", 4);

        // THEN
        anna.has_a_cart_with_total_cost("€ 3,570.00");
    }
}
