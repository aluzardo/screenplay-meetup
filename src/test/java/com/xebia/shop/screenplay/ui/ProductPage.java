package com.xebia.shop.screenplay.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

/**
 * Created by jochum on 30/09/16.
 */
@DefaultUrl("http://localhost:9000/")
public class ProductPage extends PageObject {

    // TODO: define the targets
    public static Target NUMBER_OF_ITEMS = Target.the("number of items in the cart")
            .located(By.cssSelector(""));
    public static Target TOTAL_PRICE = Target.the("total price of items in the cart")
            .located(By.cssSelector(""));

}