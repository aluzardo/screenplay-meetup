package com.xebia.shop.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Created by jochum on 30/09/16.
 */
public class CartItem {

    public static Target AMOUNT = Target.the("amount in cart")
                                .locatedBy("/tr[data-product-name=\"{0}\"]/td/span[data-e2e-id=\"cart-product-decrease-quantity\"]/..");
    public static Target DECREASE_BUTTON = Target.the("decrease button")
            .locatedBy("[data-product-name=\"{0}\"] [data-e2e-id=\"cart-product-decrease-quantity\"]");
    public static Target INCREASE_BUTTON = Target.the("increase button")
            .locatedBy("[data-product-name=\"{0}\"] [data-e2e-id=\"cart-product-increase-quantity\"]");

}
