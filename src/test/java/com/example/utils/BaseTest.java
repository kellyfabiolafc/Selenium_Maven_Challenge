package com.example.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;

import com.example.pages.CartPage;
import com.example.pages.CheckoutPage;
import com.example.pages.InventoryPage;
import com.example.pages.LoginPage;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;
    protected CartPage cartPage ;
    protected CheckoutPage checkoutPage ;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\CRISTEL\\Desktop\\Qa\\web automation\\demo\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

   /**
 * Simula una pausa utilizando FluentWait.
 * Este método puede ser utilizado en cualquier prueba para ralentizar el flujo de ejecución.
 *
 * @param milliseconds Tiempo en milisegundos para la pausa simulada.
 */
protected void fluentWaitForAction(int milliseconds) {
    FluentWait<WebDriver> wait = new FluentWait<>(driver)
        .withTimeout(Duration.ofMillis(milliseconds))
        .pollingEvery(Duration.ofMillis(500)); // Revisa cada 500ms
    wait.until(webDriver -> {
        try {
            Thread.sleep(milliseconds); // Introduce una pausa real
            return true; // Termina la espera
        } catch (InterruptedException e) {
            return false; // Si algo falla, termina la espera
        }
    });
}
}