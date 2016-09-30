package com.xebia.shop.screenplay.tasks;

import com.xebia.shop.screenplay.ui.Product;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Created by jochum on 30/09/16.
 */
public class AddsToHerCart implements Task {

    private String product;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // TODO: Use the "Click" action to click on the "Add to cart" button of the product
                Click.on(Product.ADD_TO_CART.of(product))
        );
    }

    public static AddsToHerCart theProducts(String product) {
        return instrumented(AddsToHerCart.class, product);
    }

    public AddsToHerCart(String product) {
        this.product = product;
    }

}