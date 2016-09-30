package com.xebia.shop.screenplay.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

/**
 * Created by jochum on 30/09/16.
 */
@DefaultUrl("http://localhost:9000/")
public class ProductPage extends PageObject {

    public static Target CART = Target.the("cart icon").located(By.cssSelector("[ui-sref=cart]"));
    public static Target NUMBER_OF_ITEMS = Target.the("number of items in the cart")
                                                .located(By.cssSelector("[data-e2e-id=\"cart-summary-product-count\"]"));
    public static Target TOTAL_PRICE = Target.the("total price of items in the cart")
                                                .located(By.cssSelector("[data-e2e-id=\"cart-summary-total-price\"]"));

}
