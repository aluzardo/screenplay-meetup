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

    private String product;

    @Override
    public <T extends Actor> void performAs(T actor) {
        // TODO: add all products
        actor.attemptsTo(
                Click.on(Product.ADD_TO_CART.of(product))
        );
    }

    public static AddsToHerCart theProducts(String product) {
        return instrumented(AddsToHerCart.class, product);
    }

    public static AddsToHerCart theProducts(String... products) {
        return theProducts(Arrays.asList(products));
    }

    public static AddsToHerCart theProducts(Collection<String> products) {
        // TODO: fix the constructor call
        return instrumented(AddsToHerCart.class, "");
    }

    // TODO: create a constructor with a collection argument
    public AddsToHerCart(String product) {
        this.product = product;
    }

}