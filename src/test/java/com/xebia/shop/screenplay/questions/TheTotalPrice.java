package com.xebia.shop.screenplay.questions;

import com.xebia.shop.screenplay.ui.ProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

/**
 * Created by jochum on 30/09/16.
 */
public class TheTotalPrice implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ProductPage.TOTAL_PRICE).viewedBy(actor).asString();
    }
}
