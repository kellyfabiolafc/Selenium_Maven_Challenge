package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import com.example.pages.CartPage;
import com.example.pages.InventoryPage;
import com.example.utils.BaseTest;

public class CartTest extends BaseTest {

    /**
     * Verifica que el usuario pueda modificar el orden de los productos en la
     * página de inventario
     * seleccionando diferentes criterios de orden (ejemplo: precio bajo-alto).
     */
    @Test
    public void testModifyProductOrder() {
        loginPage.login("standard_user", "secret_sauce");
        fluentWaitForAction(2000); // Pausa de 2 segundos para observar el cambio de orden
        inventoryPage.sortProductsBy("Price (low to high)"); // Método que selecciona el orden
        fluentWaitForAction(2000); // Pausa de 2 segundos para observar el cambio de orden
        assertTrue(inventoryPage.isSortedBy("Price (low to high)"), "Los productos no están ordenados correctamente.");
    }

    /**
     * Verifica que el usuario pueda añadir varios productos al carrito
     * y que los productos seleccionados aparezcan correctamente en el carrito.
     */
    @Test
    public void testAddMultipleProductsToCart() {
        loginPage.login("standard_user", "secret_sauce");
        fluentWaitForAction(2000); // Pausa de 2 segundos para observar el cambio de orden
        // InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.addProductToCart("Sauce Labs Bike Light");
        fluentWaitForAction(1000); // Pausa de 2 segundos para observar el cambio de orden
        inventoryPage.goToCart();
        fluentWaitForAction(2000); // Pausa de 2 segundos para observar el cambio de orden
        assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"),
                "El producto 'Sauce Labs Backpack' no está en el carrito.");
        assertTrue(cartPage.isProductInCart("Sauce Labs Bike Light"),
                "El producto 'Sauce Labs Bike Light' no está en el carrito.");
    }

    /*
     * - El test debe pasar si el carrito refleja los cambios correctamente tras la
     * eliminación de un solo producto.
     */
    @Test
    public void testVerifyAndModifyCart() {
        loginPage.login("standard_user", "secret_sauce");
        fluentWaitForAction(1000); // Pausa para observar cambios
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.addProductToCart("Sauce Labs Bike Light");
        fluentWaitForAction(1000); // Pausa para observar cambios
        inventoryPage.goToCart();

        // Verifica que los productos estén en el carrito
        assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"),
                "El producto 'Sauce Labs Backpack' no está en el carrito.");
        assertTrue(cartPage.isProductInCart("Sauce Labs Bike Light"),
                "El producto 'Sauce Labs Bike Light' no está en el carrito.");

        fluentWaitForAction(2000); // Pausa para observar cambios

        // Elimina un producto del carrito
        cartPage.removeProductFromCart("Sauce Labs Backpack");
        fluentWaitForAction(2000); // Pausa para observar cambios

        // Verifica que el carrito no esté vacío tras eliminar un producto
        assertFalse(cartPage.isCartEmptyAfterRemoval(),
                "El carrito está vacío después de eliminar un producto. Esto no debería suceder.");
    }
}
