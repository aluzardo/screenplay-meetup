package com.xebia.shop.screenplay.tasks;

import com.xebia.shop.screenplay.ui.CartItem;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Created by jochum on 30/09/16.
 */
public class DecreaseAmountOfProduct implements Task {

    private String product;
    private Integer delta;

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i=0; i < delta; i++) {
            // TODO: decrease the amount for the given product
        }
    }

    public DecreaseAmountOfProduct(String product, Integer delta) {
        this.product = product;
        this.delta = delta;
    }

    public static Performable with(String product, Integer delta) {
        return instrumented(DecreaseAmountOfProduct.class, product, delta);
    }


}