package com.xebia.shop.pageobjects.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

/**
 * Created by jochum on 30/09/16.
 */
@DefaultUrl("http://localhost:9000/")
public class ProductPage extends PageObject {

    @FindBy(css="[ui-sref=cart]")
    WebElementFacade cartButton;

    @FindBy(css="[data-e2e-id=\"cart-summary-product-count\"]")
    WebElementFacade cartNumberOfItems;

    @FindBy(css="[data-e2e-id=\"cart-summary-total-price\"]")
    WebElementFacade cartTotalPrice;

    public void addProductToCart(String name) {
        WebElement product = find(By.cssSelector("[name=\'" + name + "\']"));
        product.findElement(By.className("btn-primary")).click();
    }

    public Integer getNumberOfItems() {
        return Integer.parseInt(cartNumberOfItems.getText());
    }

    public String getTotalPrice() {
        return cartTotalPrice.getText();
    }

    public void goto_cart() {
        cartButton.click();
    }

}
