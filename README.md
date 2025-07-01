# Pruebas Automatizadas API PetStore Swagger

Este proyecto contiene pruebas automatizadas para la tienda de mascotasusando la API pública de [Swagger PetStore](https://petstore.swagger.io/v2).  
Las pruebas se implementan en Java 8+, usando Maven, Rest Assured y TestNG.

---

## 📦 Requisitos

- Java 8 o superior
- Maven 3.6+
- Conexión a internet

---

## 🚀 Instalación

1. **Clona el repositorio:**
   ```sh
   git clone https://github.com/tu-usuario/petstore-api-test.git
   cd petstore-api-test
   ```

2. **Instala dependencias y compila el proyecto:**
   ```sh
   mvn clean compile
   ```

---

## 🧪 Ejecución de las pruebas

Ejecuta todas las pruebas con:

```sh
mvn test
```

Esto ejecutará los siguientes casos de prueba independientes:

1. Crear un usuario
2. Login con el usuario creado
3. Listar mascotas disponibles
4. Consultar detalles de una mascota
5. Crear una orden de compra
6. Logout del usuario


## 📊 Ejemplo de ejecución y resultados esperados

Al ejecutar `mvn test`, deberías ver una salida similar a la siguiente:

```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.perfDog.api.CreateUserTest
[INFO] Test crear usuario: OK
Running com.perfDog.api.LoginUserTest
[INFO] Test login usuario: OK
Running com.perfDog.api.ListAvailablePetsTest
[INFO] Test listar mascotas disponibles: OK
Running com.perfDog.api.GetPetDetailsTest
[INFO] Test consultar detalles mascota: OK
Running com.perfDog.api.CreateOrderTest
[INFO] Test crear orden: OK
Running com.perfDog.api.LogoutUserTest
[INFO] Test logout usuario: OK

Results:
Tests run: 6, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```

---

## 🔗 Referencias

- [Swagger Petstore API Docs](https://petstore.swagger.io)
- [Rest Assured Documentation](https://rest-assured.io/)
- [TestNG Documentation](https://testng.org/doc/)

---
