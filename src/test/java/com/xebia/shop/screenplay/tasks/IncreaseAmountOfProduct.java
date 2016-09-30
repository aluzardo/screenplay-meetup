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
public class IncreaseAmountOfProduct implements Task {

    private String product;
    private Integer delta;

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i=0; i < delta; i++) {
            actor.attemptsTo(
                    Click.on(CartItem.INCREASE_BUTTON.of(product))
            );
        }
    }

    public IncreaseAmountOfProduct(String product, Integer delta) {
        this.product = product;
        this.delta = delta;
    }

    public static Performable with(String product, Integer delta) {
        return instrumented(IncreaseAmountOfProduct.class, product, delta);
    }


}
