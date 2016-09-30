package com.xebia.shop.pageobjects.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by jochum on 30/09/16.
 */
@DefaultUrl("http://localhost:9000/#/cart")
public class CartPage extends PageObject {



    public CartProduct getProductByName(String name) {
        return new CartProduct(name);
    }

    public class CartProduct {

        private String name;

        public CartProduct(String name) {
            this.name = name;
        }

        public String getTotalPrice() {
            return getBaseElement().findElement(By.cssSelector("[data-e2e-id=\"cart-product-total-price\"]")).getText();
        }

        public Integer getAmount() {
            String amountText = getBaseElement().findElement(By.cssSelector("[data-e2e-id=\"cart-product-decrease-quantity\"]")).findElement(By.xpath("..")).getText().trim();
            return Integer.parseInt(amountText);
        }

        public void increaseAmount() {
            getBaseElement().findElement(By.cssSelector("[data-e2e-id=\"cart-product-increase-quantity\"]")).click();
        }

        public void decreaseAmount() {
            getBaseElement().findElement(By.cssSelector("[data-e2e-id=\"cart-product-decrease-quantity\"]")).click();
        }

        private WebElement getBaseElement() {
            WebElement product = find(By.cssSelector("[data-product-name=\"" + name + "\"]"));
            if (product == null) throw new RuntimeException("Product could not be found");
            return product;
        }

    }

}
