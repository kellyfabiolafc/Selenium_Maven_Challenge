package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.pages.CartPage;
import com.example.pages.InventoryPage;
import com.example.pages.LoginPage;
import com.example.utils.BaseTest;
public class PurchaseTests extends BaseTest {

    @Test
    public void testPurchaseFlow() {
        loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addToCart();
        inventoryPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.checkout();

        assertEquals("https://www.saucedemo.com/checkout-step-one.html", driver.getCurrentUrl());
    }
}