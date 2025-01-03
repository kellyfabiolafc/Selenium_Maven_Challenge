package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.example.pages.InventoryPage;
import com.example.utils.BaseTest;

public class LoginTest extends BaseTest {

    /**
     * Verifica que se muestre el mensaje de error correspondiente
     * cuando el usuario intenta iniciar sesión sin proporcionar un nombre de usuario y contraseña.
     */
    @Test
    public void testEmptyLogin() {
        loginPage.login("", "");
        assertEquals("Epic sadface: Username is required", loginPage.getErrorMessage());
    }

    /**
     * Verifica que se muestre el mensaje de error correspondiente
     * cuando el usuario intenta iniciar sesión con credenciales inválidas.
     */
    @Test
    public void testInvalidLogin() {
        loginPage.login("standard_user", "wrong_password");
        assertEquals("Epic sadface: Username and password do not match any user in this service", loginPage.getErrorMessage());
    }

    /**
     * Verifica que el inicio de sesión sea exitoso cuando se proporcionan
     * credenciales válidas y que el usuario sea redirigido a la página de inventario.
     */
    @Test
    public void testSuccessfulLogin() {
        loginPage.login("standard_user", "secret_sauce");
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    /**
     * Verifica que el usuario pueda cerrar sesión correctamente
     * después de iniciar sesión y que sea redirigido a la página de inicio.
     */
    @Test
    public void testLogout() {
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.logout();
        assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());
    }

}
