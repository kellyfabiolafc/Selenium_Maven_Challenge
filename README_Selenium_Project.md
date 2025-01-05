
# Selenium Test Automation Project

Este proyecto implementa un conjunto de pruebas automatizadas para la página web de SauceDemo utilizando Selenium WebDriver con Java y el framework JUnit 5.

## Estructura del Proyecto

El proyecto está organizado de la siguiente manera:

```
Selenium_Maven_Challenge
├── pom.xml
├── README_Selenium_SauceDemo.md
└── src
    └── test
        └── java
            └── com
                └── example
                    ├── pages
                    │   ├── CartPage.java
                    │   ├── CheckoutPage.java
                    │   ├── InventoryPage.java
                    │   └── LoginPage.java
                    ├── utils
                    │   └── BaseTest.java
                    ├── CartTest.java
                    ├── LoginTest.java
                    └── PurchaseTests.java
```

### Descripción de las Clases

#### Main (Clases de Página - Page Object Model)
- **LoginPage.java**: Contiene métodos para realizar acciones en la página de inicio de sesión (login).
- **InventoryPage.java**: Representa la página de inventario. Contiene métodos para manejar el carrito de compras y el logout.
- **CartPage.java**: Define los métodos para proceder al checkout desde el carrito.
- **CheckoutPage.java**: Contiene los métodos para ingresar la información del cliente, finalizar la compra y verificar el mensaje de confirmación.

#### Test (Clases de Prueba)
- **LoginTest.java**: Verifica los flujos de inicio de sesión y cierre de sesión.
- **CartTest.java**: Valida la funcionalidad del carrito de compras, como añadir productos.
- **PurchaseTests.java**: Prueba el flujo completo de compra, incluyendo el checkout y la verificación del mensaje de éxito.

## Pruebas Implementadas

### LoginTest
- **testEmptyLogin**: Verifica que aparezca un mensaje de error cuando se intenta iniciar sesión con campos vacíos.
- **testInvalidLogin**: Valida que se muestre un mensaje de error al ingresar credenciales incorrectas.
- **testSuccessfulLogin**: Confirma que el usuario puede iniciar sesión exitosamente con credenciales válidas.
- **testLogout**: Verifica que el usuario pueda cerrar sesión correctamente.

### CartTest
- **testAddToCart**: Prueba que un producto se pueda añadir al carrito desde la página de inventario.
- **testCartBadgeUpdates**: Valida que el contador del carrito se actualice correctamente al agregar productos.

### PurchaseTests
- **testCompletePurchaseFlow**: Verifica el flujo completo de compra, incluyendo añadir productos al carrito, proceder al checkout, finalizar la compra y verificar el mensaje de confirmación.

## Requisitos Previos

- [Java JDK 11 o superior](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/)
- [Google Chrome](https://www.google.com/chrome/) y [ChromeDriver](https://chromedriver.chromium.org/)

## Configuración

1. Clona este repositorio.
2. Asegúrate de tener configurado Maven en tu máquina.
3. Ejecuta `mvn clean install` para instalar las dependencias.

## Ejecución de las Pruebas

Ejecuta las pruebas usando el siguiente comando:

```bash
mvn test
```

## Contribuciones

Si deseas contribuir a este proyecto, realiza un fork del repositorio, crea una rama con tus cambios y envía un pull request.

---

¡Gracias por revisar este proyecto!
