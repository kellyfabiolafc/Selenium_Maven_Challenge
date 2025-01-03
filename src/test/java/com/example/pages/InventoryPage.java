package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InventoryPage {
    private WebDriver driver;

    @FindBy(css = "button[name='add-to-cart-sauce-labs-backpack']")
    private WebElement addToCartButton;

    @FindBy(css = "a.shopping_cart_link")
    private WebElement cartLink;

    @FindBy(css = ".bm-burger-button")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    @FindBy(css = ".product_sort_container")
    private WebElement sortDropdown; // Dropdown para ordenar productos

    @FindBy(css = ".inventory_item_name")
    private List<WebElement> productNames; // Lista de nombres de productos

    @FindBy(css = ".inventory_item_price")
    private List<WebElement> productPrices; // Lista de precios de productos

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Añade un producto al carrito por su nombre.
     */
    public void addProductToCart(String productName) {
        String addToCartButtonSelector = String.format("button[name='add-to-cart-%s']", productName.toLowerCase().replace(" ", "-"));
        WebElement addToCartButton = driver.findElement(By.cssSelector(addToCartButtonSelector));
        addToCartButton.click();
    }

    /**
     * Navega al carrito.
     */
    public CartPage goToCart() {
        cartLink.click();
        return new CartPage(driver);
    }

    /**
     * Realiza logout del usuario.
     */
    public void logout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(menuButton));
        menuButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        logoutLink.click();
    }

    /**
     * Cambia el orden de los productos en la página de inventario.
     */
    public void sortProductsBy(String criteria) {
        Select dropdown = new Select(sortDropdown);
        dropdown.selectByVisibleText(criteria);
    }

    /**
     * Verifica si los productos están ordenados por el criterio especificado.
     */
    public boolean isSortedBy(String criteria) {
        if (criteria.equalsIgnoreCase("Price (low to high)")) {
            for (int i = 0; i < productPrices.size() - 1; i++) {
                double price1 = Double.parseDouble(productPrices.get(i).getText().replace("$", ""));
                double price2 = Double.parseDouble(productPrices.get(i + 1).getText().replace("$", ""));
                if (price1 > price2) {
                    return false;
                }
            }
        }
        // Agregar otras validaciones de orden si es necesario
        return true;
    }
}
