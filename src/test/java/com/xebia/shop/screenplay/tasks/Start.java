package com.xebia.shop.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Created by jochum on 30/09/16.
 */
public class Start implements Task {

    @Steps OpenTheWebshop openTheWebshop;

    private String[] products;

    public Start() {
        this.products = new String[0];
    }

    public Start(String... products) {
        this.products = products;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                openTheWebshop,
                AddsToHerCart.theProducts(products)
        );
    }

    public static Performable withEmptyCart() {
        return instrumented(Start.class);
    }

    public static Performable withCartContaining(String... products) {
        return instrumented(Start.class, products);
    }
}
