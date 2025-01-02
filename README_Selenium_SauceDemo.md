
# Selenium Automation: Sauce Demo

Este proyecto es una suite de automatización web para la aplicación Sauce Demo, diseñado para probar funcionalidades clave como login/logout, navegación y flujos de compra.

## Tecnologías
- **Lenguaje:** Java
- **Framework:** JUnit 5
- **Automatización:** Selenium WebDriver
- **Gestión de dependencias:** Maven
- **Gestión de pruebas:** Jira (simulado en esta versión)
- **Integración Continua:** GitHub Actions

## Características
- Aplicación del patrón Page Object Model (POM).
- Pruebas automatizadas de:
  - Inicio y cierre de sesión.
  - Validación de mensajes de error.
  - Flujo completo de compra.
- Capturas de pantalla en pruebas fallidas.

## Estructura del Proyecto

```bash
selenium-saucedemo-automation/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com.example.pages/    # Clases del Page Object Model
│   │   │   └── utils/                # Clases utilitarias (e.g., helpers, wait utils)
│   └── test/
│       └── java/
│           ├── com.example.tests/    # Clases de pruebas
│
├── pom.xml                           # Configuración de Maven
├── README.md                         # Documentación principal
├── screenshots/                      # Carpeta para capturas de pantalla (pruebas fallidas)
└── docs/                             # Documentos adicionales (e.g., casos de prueba, plan de pruebas)
```

## Cómo Ejecutar

1. Clona este repositorio:
   ```bash
   git clone https://github.com/tuusuario/selenium-saucedemo-automation.git
   ```
2. Abre el proyecto en tu IDE favorito (e.g., IntelliJ, Eclipse).
3. Configura el driver de Chrome en tu máquina.
4. Ejecuta las pruebas:
   ```bash
   mvn clean test
   ```

## Capturas de Pantalla

Incluye capturas de pantalla de tus pruebas automatizadas y resultados exitosos en la carpeta `screenshots/`.

## Uso de Jira

Simula un flujo profesional de trabajo con Jira:
1. Crea historias de usuario y tareas relacionadas.
2. Configura un flujo de trabajo básico: **Backlog → En progreso → En revisión → Completado**.
3. Adjunta evidencias como capturas de pantalla en las historias de usuario.

Ejemplo de historias de usuario:
- **Como tester**, quiero automatizar el inicio de sesión para validar credenciales correctas e incorrectas.
- **Como tester**, quiero automatizar el flujo de compra para garantizar que el carrito de compras funcione correctamente.

## Configuración de GitHub Actions

Este proyecto incluye un archivo de configuración para ejecutar pruebas automáticamente:

```yaml
name: Selenium Tests

on:
  push:
    branches:
      - main

jobs:
  test:
    runs-on: ubuntu-latest

    steps:
    - name: Checkout code
      uses: actions/checkout@v3

    - name: Setup Java
      uses: actions/setup-java@v3
      with:
        java-version: '11'
        distribution: 'temurin'

    - name: Setup ChromeDriver
      uses: nanasess/setup-chromedriver@v1

    - name: Install dependencies
      run: mvn install

    - name: Run tests
      run: mvn test
```

Guarda este archivo en la ruta `.github/workflows/selenium-tests.yml` para habilitar la integración continua.

## Casos de Prueba

Incluye un archivo en la carpeta `docs/` con casos de prueba detallados. Ejemplo:

| ID     | Caso de Prueba               | Entrada                 | Resultado Esperado                                    | Automatizado |
|--------|------------------------------|-------------------------|------------------------------------------------------|--------------|
| TC001  | Login sin credenciales       | Usuario vacío           | Mostrar mensaje: "Epic sadface: Username is required" | Sí           |
| TC002  | Login con contraseña incorrecta | Usuario: standard_user | Mostrar mensaje: "Username and password do not match" | Sí           |

## Publicación en GitHub

1. Sube tu proyecto a un repositorio público en GitHub.
2. Añade una descripción en la página principal del repositorio.

## Portafolio

Destaca este proyecto en tu portafolio personal, incluyendo:

- **Título del Proyecto:** Automatización Sauce Demo con Selenium.
- **Resumen:** Breve descripción del proyecto.
- **Tecnologías Utilizadas:** Java, Selenium, JUnit, Maven, Jira.
- **Enlace al Repositorio:** Agrega un enlace a tu GitHub.
- **Resultados:** Describe tus aprendizajes y los desafíos que resolviste.
