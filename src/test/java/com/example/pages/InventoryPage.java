package com.example.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class InventoryPage {
    private WebDriver driver;

    @FindBy(css = "button[name='add-to-cart-sauce-labs-backpack']")
    private WebElement addToCartButton;

    @FindBy(css = "a.shopping_cart_link")
    private WebElement cartLink;

    // Definir los elementos con @FindBy
    @FindBy(css = ".bm-burger-button")
    private WebElement menuButton; // Botón que abre el sidebar

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink; // Enlace de logout
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public void goToCart() {
        cartLink.click();
    }
    // // Métodos de la página
    // public void logout() {
    //     menuButton.click(); // Hacer clic en el botón que abre el sidebar
    //     logoutLink.click(); // Hacer clic en el enlace de logout
    // }
        // Métodos de la página
    public void logout() {
        // Espera hasta que el botón del menú sea clickeable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(menuButton));

        menuButton.click(); // Hacer clic en el botón de menú

        // Esperar a que el enlace de logout sea clickeable
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));

        // Hacer clic en logout
        logoutLink.click();
    }

    // // Método para desplazarse hasta el elemento
   
}