package com.xebia.shop.screenplay.tasks;

import com.xebia.shop.screenplay.ui.ProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

/**
 * Created by jochum on 30/09/16.
 */
public class ViewTheCart implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ProductPage.CART)
        );
    }
}
