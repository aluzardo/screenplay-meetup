package com.xebia.shop.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Created by jochum on 30/09/16.
 */
public class Product {
    public static Target ADD_TO_CART = Target.the("add product to cart button")
            .locatedBy("[name=\"{0}\"] .btn-primary");
}