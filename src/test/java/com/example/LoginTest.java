package com.example;
import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.pages.InventoryPage;
import com.example.utils.BaseTest;

public class LoginTest extends BaseTest{

    @Test
    public void testEmptyLogin() {
        loginPage.login("", "");
        assertEquals("Epic sadface: Username is required", loginPage.getErrorMessage());
    }

    @Test
    public void testInvalidLogin() {
        loginPage.login("standard_user", "wrong_password");
        assertEquals("Epic sadface: Username and password do not match any user in this service", loginPage.getErrorMessage());
    }

    @Test
    public void testSuccessfulLogin() {
        loginPage.login("standard_user", "secret_sauce");
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @Test
    public void testLogout() {
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.logout();
        assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());
    }

}
