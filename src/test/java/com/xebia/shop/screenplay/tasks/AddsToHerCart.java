package com.xebia.shop.screenplay.tasks;

import com.xebia.shop.screenplay.ui.Product;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.Arrays;
import java.util.Collection;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Created by jochum on 30/09/16.
 */
public class AddsToHerCart implements Task {

    private Collection<String> products;

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (String product : products) {
            actor.attemptsTo(
                    Click.on(Product.ADD_TO_CART.of(product))
            );
        }
    }

    public static AddsToHerCart theProducts(String... products) {
        return theProducts(Arrays.asList(products));
    }

    public static AddsToHerCart theProducts(Collection<String> products) {
        return instrumented(AddsToHerCart.class, products);
    }

    public AddsToHerCart(Collection<String> products) {
        this.products = products;
    }

}
