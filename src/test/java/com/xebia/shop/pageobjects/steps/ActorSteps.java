package com.xebia.shop.pageobjects.steps;

import com.xebia.shop.pageobjects.pages.CartPage;
import com.xebia.shop.pageobjects.pages.ProductPage;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by jochum on 30/09/16.
 */
public class ActorSteps {

    ProductPage productPage;
    CartPage cartPage;


    public void opened_the_webshop() {
        productPage.open();
    }

    public void adds_to_the_cart(String... products) {
        for (String product : products) {
            productPage.addProductToCart(product);
        }
    }

    public void has_this_amount_of_products_in_the_cart(int number) {
        assertThat(productPage.getNumberOfItems(), is(number));
    }

    public void has_a_cart_with_total_cost(String costs) {
        assertThat(productPage.getTotalPrice(), is(costs));
    }

    public void has_a_cart_with(String... products) {
        opened_the_webshop();
        adds_to_the_cart(products);
    }

    public void views_her_cart() {
        productPage.goto_cart();
    }

    public void changes_the_amount_for_product(String product, int amount) {
        CartPage.CartProduct item = cartPage.getProductByName(product);
        if (amount > item.getAmount()) {
            increase_amount_by(item, amount-item.getAmount());
        } else if (item.getAmount() > amount) {
            decrease_amount_by(item, item.getAmount()-amount);
        }
    }

    private void increase_amount_by(CartPage.CartProduct item, int delta) {
        for (int i = 0; i < delta; i++) {
            item.increaseAmount();
        }
    }

    private void decrease_amount_by(CartPage.CartProduct item, int delta) {
        for (int i = 0; i < delta; i++) {
            item.decreaseAmount();
        }
    }
}
