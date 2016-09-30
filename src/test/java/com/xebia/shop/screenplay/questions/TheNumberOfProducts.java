package com.xebia.shop.screenplay.questions;

import com.xebia.shop.screenplay.ui.ProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

/**
 * Created by jochum on 30/09/16.
 */
public class TheNumberOfProducts implements Question<Integer> {
    @Override
    public Integer answeredBy(Actor actor) {
        // TODO: return number of items in the cart as an Integer
        return -1;
    }
}