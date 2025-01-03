package com.example;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import com.example.pages.CartPage;
import com.example.pages.InventoryPage;
import com.example.utils.BaseTest;

public class CartTest extends BaseTest {

    /**
     * Verifica que el usuario pueda modificar el orden de los productos en la página de inventario
     * seleccionando diferentes criterios de orden (ejemplo: precio bajo-alto).
     */
    @Test
    public void testModifyProductOrder() {
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.sortProductsBy("Price (low to high)"); // Método que selecciona el orden
        assertTrue(inventoryPage.isSortedBy("Price (low to high)"), "Los productos no están ordenados correctamente.");
    }

    /**
     * Verifica que el usuario pueda añadir varios productos al carrito 
     * y que los productos seleccionados aparezcan correctamente en el carrito.
     */
    @Test
    public void testAddMultipleProductsToCart() {
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.addProductToCart("Sauce Labs Bike Light");

        CartPage cartPage = inventoryPage.goToCart();
        assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"), "El producto 'Sauce Labs Backpack' no está en el carrito.");
        assertTrue(cartPage.isProductInCart("Sauce Labs Bike Light"), "El producto 'Sauce Labs Bike Light' no está en el carrito.");
    }

    /**
     * Verifica que el usuario pueda ver los productos en el carrito, 
     * modificar las cantidades y eliminar productos si es necesario.
     */
    @Test
    public void testVerifyAndModifyCart() {
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart("Sauce Labs Backpack");

        CartPage cartPage = inventoryPage.goToCart();
        assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"), "El producto 'Sauce Labs Backpack' no está en el carrito.");

        cartPage.removeProductFromCart("Sauce Labs Backpack");
        assertTrue(cartPage.isCartEmpty(), "El carrito no está vacío después de eliminar el producto.");
    }
}
