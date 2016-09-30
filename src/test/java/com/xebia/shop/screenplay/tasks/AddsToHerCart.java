package com.xebia.shop.screenplay.tasks;

import com.xebia.shop.screenplay.ui.Product;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Created by jochum on 30/09/16.
 */
public class AddsToHerCart implements Task {

    private String[] products;

    public AddsToHerCart(String... products) {
        this.products = products;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (String product : products) {
            actor.attemptsTo(
                    Click.on(Product.ADD_TO_CART.of(product))
            );
        }
    }

    public static Performable theProducts(String... products) {
        return instrumented(AddsToHerCart.class, products);
    }

}
