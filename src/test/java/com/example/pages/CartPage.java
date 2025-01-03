package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    private WebDriver driver;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(css = ".cart_item")
    private List<WebElement> cartItems; // Lista de productos en el carrito

    @FindBy(css = ".cart_quantity")
    private List<WebElement> cartQuantities; // Lista de cantidades de productos

    @FindBy(css = ".cart_item .inventory_item_name")
    private List<WebElement> productNamesInCart; // Lista de nombres de productos en el carrito

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton; // Botón para continuar comprando

    @FindBy(css = "button[class*='cart_button']")
    private List<WebElement> removeButtons; // Botones para eliminar productos del carrito

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Hace clic en el botón de checkout para proceder al siguiente paso.
     */
    public void checkout() {
        checkoutButton.click();
    }

    /**
     * Devuelve el número total de productos en el carrito.
     */
    public int getTotalItemsInCart() {
        return cartItems.size();
    }

    /**
     * Verifica si un producto específico está en el carrito.
     */
    public boolean isProductInCart(String productName) {
        for (WebElement product : productNamesInCart) {
            if (product.getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Vacía el carrito eliminando todos los productos.
     */
    public void emptyCart() {
        for (WebElement removeButton : removeButtons) {
            removeButton.click();
        }
    }

    /**
     * Devuelve la cantidad de un producto específico en el carrito.
     */
    public int getProductQuantity(String productName) {
        for (int i = 0; i < productNamesInCart.size(); i++) {
            if (productNamesInCart.get(i).getText().equalsIgnoreCase(productName)) {
                return Integer.parseInt(cartQuantities.get(i).getText());
            }
        }
        return 0;
    }

    /**
     * Continúa comprando haciendo clic en el botón de continuar.
     */
    public void continueShopping() {
        continueShoppingButton.click();
    }
    /**
 * Elimina un producto específico del carrito basado en su nombre.
 */
public void removeProductFromCart(String productName) {
    for (int i = 0; i < productNamesInCart.size(); i++) {
        if (productNamesInCart.get(i).getText().equalsIgnoreCase(productName)) {
            // Hacer clic en el botón de eliminar para el producto encontrado
            removeButtons.get(i).click();
            break; // Salir del bucle después de eliminar el producto
        }
    }
}

/**
 * Verifica si el carrito está vacío.
 */
public boolean isCartEmpty() {
    return cartItems.isEmpty(); // Si no hay productos, el carrito está vacío
}

    
}
