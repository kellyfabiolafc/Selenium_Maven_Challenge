package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

// import com.example.pages.CartPage;
// import com.example.pages.CheckoutPage;
// import com.example.pages.InventoryPage;
import com.example.utils.BaseTest;
public class PurchaseTests extends BaseTest {
   @Test
    public void testCompletePurchaseFlow() {
        // Login
        loginPage.login("standard_user", "secret_sauce");

        // Agregar producto al carrito
        // InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.goToCart();

        // Proceder al checkout
        // CartPage cartPage = new CartPage(driver);
        cartPage.checkout();

        // Completar el formulario de checkout
        // CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterCheckoutInformation("John", "Doe", "12345");

        // Finalizar la compra
        checkoutPage.finishCheckout();

        // Verificar el mensaje de confirmación
        String confirmationMessage = checkoutPage.getConfirmationMessage();
        assertEquals("Thank you for your order!", confirmationMessage);
        inventoryPage.logout();
        assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());
    }



}