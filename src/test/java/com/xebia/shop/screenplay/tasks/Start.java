package com.xebia.shop.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Steps;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Created by jochum on 30/09/16.
 */
public class Start implements Task {

    @Steps OpenTheWebshop openTheWebshop;

    private Collection<String> products;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                openTheWebshop,
                AddsToHerCart.theProducts(products)
        );
    }

    public static Performable withEmptyCart() {
        return instrumented(Start.class, Collections.EMPTY_LIST);
    }

    public static Performable withCartContaining(String... products) {
        return withCartContaining(Arrays.asList(products));
    }

    public static Performable withCartContaining(Collection<String> products) {
        return instrumented(Start.class, products);
    }

    public Start(Collection<String> products) {
        this.products = products;
    }
}
