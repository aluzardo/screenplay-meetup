package com.xebia.shop.screenplay.tasks;

import com.xebia.shop.screenplay.ui.CartItem;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.Text;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Created by jochum on 30/09/16.
 */
public class ChangeTheAmount implements Task {

    private String product;
    private int newAmount;

    @Override
    public <T extends Actor> void performAs(T actor) {
        Integer currentAmount = Text.of(CartItem.AMOUNT.of(product)).viewedBy(actor).asInteger();
        if (currentAmount < newAmount) {
            actor.attemptsTo(
                    IncreaseAmountOfProduct.with(product, newAmount-currentAmount)
            );
        } else if (currentAmount > newAmount) {
            actor.attemptsTo(
                    DecreaseAmountOfProduct.with(product, currentAmount-newAmount)
            );
        }
    }

    public ChangeTheAmount(String product) {
        this.product = product;
    }

    public static ChangeTheAmount of(String productName) {
        return instrumented(ChangeTheAmount.class, productName);
    }

    public Performable to(int number) {
        this.newAmount = number;
        return this;
    }
}
