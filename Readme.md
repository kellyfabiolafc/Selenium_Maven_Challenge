
# SauceDemo Automated Testing Project

Este proyecto contiene un conjunto de pruebas automatizadas para verificar la funcionalidad de la página web [SauceDemo](https://www.saucedemo.com/).

---
## 📝 Descripción

El propósito de este proyecto es validar las principales funcionalidades del sitio web SauceDemo mediante pruebas automatizadas utilizando Selenium WebDriver, JUnit y Java.

Las funcionalidades probadas incluyen:

- **Inicio de sesión:** Validación de credenciales y flujo de autenticación.
- **Carrito de compras:** Agregar, eliminar y modificar productos en el carrito.
- **Proceso de compra:** Completar el flujo de compra y verificar mensajes de confirmación.

---

## Estructura del Proyecto

El proyecto está organizado de la siguiente manera:

```
Selenium_Maven_Challenge
├── pom.xml
├── README.md
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

#### (Clases de Página - Page Object Model)
- **LoginPage.java**: Contiene métodos para realizar acciones en la página de inicio de sesión (login).
- **InventoryPage.java**: Representa la página de inventario. Contiene métodos para manejar el carrito de compras y el logout.
- **CartPage.java**: Define los métodos para proceder al checkout desde el carrito.
- **CheckoutPage.java**: Contiene los métodos para ingresar la información del cliente, finalizar la compra y verificar el mensaje de confirmación.

#### Test (Clases de Prueba)
- **LoginTest.java**: Verifica los flujos de inicio de sesión y cierre de sesión.
- **CartTest.java**: Valida la funcionalidad del carrito de compras, como añadir productos.
- **PurchaseTests.java**: Prueba el flujo completo de compra, incluyendo el checkout y la verificación del mensaje de éxito.

## Pruebas Implementadas

### [LoginTest](https://docs.google.com/spreadsheets/d/1sA2C9FYBEEAw2O3JIAgCHVxtX863FHDF/edit?usp=sharing&ouid=114934668253849322831&rtpof=true&sd=true)
- **testEmptyLogin**: Verifica que aparezca un mensaje de error cuando se intenta iniciar sesión con campos vacíos.
- **testInvalidLogin**: Valida que se muestre un mensaje de error al ingresar credenciales incorrectas.
- **testSuccessfulLogin**: Confirma que el usuario puede iniciar sesión exitosamente con credenciales válidas.
- **testLogout**: Verifica que el usuario pueda cerrar sesión correctamente.
  

### [CartTest](https://docs.google.com/spreadsheets/d/1N0PJu2C1r2RM5Zy-_YmUXwhsiDxufqYZ/edit?usp=sharing&ouid=114934668253849322831&rtpof=true&sd=true)
- **testModifyProductOrder**:  
  Verifica que el usuario pueda modificar el orden de los productos en la página de inventario seleccionando diferentes criterios de orden (ejemplo: precio bajo-alto).  
  Esta prueba garantiza que la funcionalidad de ordenamiento opere correctamente, mostrando los productos en el orden deseado.

- **testAddMultipleProductsToCart**:  
  Valida que el usuario pueda añadir varios productos al carrito desde la página de inventario y que los productos seleccionados se muestren correctamente en el carrito.  
  Esto asegura que la funcionalidad de agregar múltiples productos al carrito sea precisa y confiable.

- **testVerifyAndModifyCart**:  
  Comprueba que el usuario pueda interactuar con los productos en el carrito, incluyendo visualizar los productos añadidos, modificar las cantidades y eliminar productos si es necesario.  
  La prueba asegura que el carrito se comporte como se espera ante estas acciones.

### [PurchaseTests](https://docs.google.com/spreadsheets/d/13xLbPwnWnOYbur4XWpnSI8REGSMH5_iggvxzA3mfAzI/edit?usp=sharing)
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
