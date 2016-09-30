package com.xebia.shop.screenplay.tasks;

import com.xebia.shop.screenplay.ui.ProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

/**
 * Created by jochum on 30/09/16.
 */
public class OpenTheWebshop implements Task {

    ProductPage theProductPage;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // TODO: use the "Open" action to open the Product Page
                Open.browserOn()
        );
    }
}