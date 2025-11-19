
---

# Conversor de Monedas 💱


Aplicación de consola desarrollada en Java que permite convertir montos entre diferentes divisas utilizando la API **ExchangeRate API**.  
Este proyecto fue creado como parte de un challenge para practicar:

- Programación orientada a objetos
    
- Manejo de paquetes y arquitectura por capas
    
- Consumo de APIs externas usando `HttpClient`
    
- Parseo de JSON con **Gson**
    
- Uso de variables de entorno con **Dotenv**
    


## 🚀 Características


- Conversión entre varias monedas (USD, ARS, BRL, COP)
    
- Menú interactivo por consola
    
- Consumo de una API real de tasas de cambio
    
- Arquitectura modular: **app → servicios → modelo → externo → dto**
    
- Manejo seguro de la API Key mediante `.env`
    



## 📦 Arquitectura del proyecto


El proyecto está dividido en capas para favorecer la modularidad y el desac acoplamiento:

```
com.nicolaciar.conversormonedas
 ├── app
 │    ├── Principal.java         → Entrada del programa (UI por consola)
 │    └── Menu.java              → Renderización del menú
 │
 ├── servicios
 │    └── Conversion.java        → Lógica de negocio
 │
 ├── modelo
 │    ├── Divisa.java            → Enum de monedas soportadas
 │    └── TasaDeCambio.java      → Modelo interno
 │
 ├── externo
 │    ├── Conversor.java         → Interfaz para obtener tasas
 │    └── ConsultaAPIConversor.java → Implementación que consulta la API externa
 │
 └── dto
      └── TasaDeCambioDto.java   → DTO del JSON recibido desde la API
```



## 🌐 API utilizada


Este proyecto usa la API de:

### **ExchangeRate API ([https://www.exchangerate-api.com/](https://www.exchangerate-api.com/))**

Endpoint utilizado:

```
https://v6.exchangerate-api.com/v6/{API_KEY}/pair/{FROM}/{TO}
```

Ejemplo:

```
https://v6.exchangerate-api.com/v6/MiClaveAPI/pair/USD/ARS
```

Respuesta típica:

```json
{
  "result": "success",
  "base_code": "USD",
  "target_code": "ARS",
  "conversion_rate": 1405.00
}
```



## 🔐 Configuración del archivo `.env`


Para proteger tu API key, este proyecto usa **Dotenv**.

Debés crear un archivo `.env` en el directorio raíz del proyecto:

```
API_KEY_CONVERSOR=TU_API_KEY_AQUI
```




## ▶️ Cómo ejecutar el proyecto


1. Clonar el repositorio:
    

```bash
git clone https://github.com/tuusuario/conversor-monedas.git
```

2. Crear el archivo `.env` con tu API Key.
    
3. Ejecutar el programa desde el IDE o desde la terminal:
    

```bash
mvn clean compile exec:java
```

o si usás IntelliJ:

**Run → Run 'Principal'**



## 🤖 Dependencias


En el `pom.xml` se usan:

- **Gson** → parseo de JSON
    
- **Dotenv Java** → manejo de variables de entorno
    
- **HttpClient (JDK 11+)** → para llamadas HTTP

Para agregar estas dependencias, pegar lo siguiente en el `pom.xml`:

```xml
<dependencies>
	<!-- https://mvnrepository.com/artifact/com.google.code.gson/gson -->
	<dependency>
		<groupId>com.google.code.gson</groupId>
		<artifactId>gson</artifactId>
		<version>2.13.2</version>
	</dependency>

	<dependency>
		<groupId>io.github.cdimascio</groupId>
		<artifactId>java-dotenv</artifactId>
		<version>5.2.2</version>
	</dependency>
</dependencies>
```



## 🧪 Ejemplo de uso


```
*************************************
Sea bienvenido/a al Conversor de Moneda =]

1) Dólar ==> Peso argentino
2) Peso argentino ==> Dólar
3) Dólar ==> Real brasileño
4) Real brasileño ==> Dólar
5) Dólar ==> Peso colombiano
6) Peso colombiano ==> Dólar
7) Salir

Elija una opción válida:
```

Entrada:

```
1
Ingrese el monto que desea convertir: 10
```

Salida:

```
10.00 [USD] equivalen a 14050.00 [ARS]
```



## 🧑‍💻 Autor

**Nicolas Laciar**  
Estudiante de Ciencias de la Computación | Desarrollador Backend Jr



## 📄 Licencia

MIT License

---
