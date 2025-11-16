# 🔐 Sistema de Cifrado Simétrico - Telefónica

[![Java](https://img.shields.io/badge/Java-17+-orange.svg)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Encryption](https://img.shields.io/badge/Encryption-AES--256-green.svg)](https://en.wikipedia.org/wiki/Advanced_Encryption_Standard)

Demostración práctica de criptosistema simétrico utilizando **AES-256** para la protección de datos sensibles en el contexto de telecomunicaciones, específicamente aplicado a Telefónica.

## 📋 Descripción del Proyecto

Este proyecto implementa un sistema de cifrado simétrico basado en el algoritmo **AES (Advanced Encryption Standard)** con claves de 256 bits. El código simula cómo empresas de telecomunicaciones como Telefónica protegen información confidencial de sus clientes utilizando criptografía de clave privada.

### 🎯 Objetivos

- Demostrar el funcionamiento del cifrado simétrico en un caso de uso real
- Explicar las características y limitaciones de los criptosistemas de clave privada
- Ilustrar la importancia de la seguridad en el manejo de datos sensibles
- Proporcionar código educativo claro y bien documentado

## 🔑 ¿Qué es el Cifrado Simétrico?

El **cifrado simétrico** (o de clave privada) es un sistema criptográfico que utiliza **la misma clave** tanto para cifrar como para descifrar información.

### Características Principales

| Característica | Descripción |
|---------------|-------------|
| **Número de Claves** | Una sola clave compartida |
| **Algoritmo** | AES-256 (256 bits = 2^256 combinaciones) |
| **Velocidad** | Muy rápida (ideal para grandes volúmenes) |
| **Seguridad** | Alta si la clave se mantiene secreta |
| **Desafío** | Distribución segura de la clave |

## 🚀 Características del Sistema

✅ **Cifrado AES-256:** Estándar industrial de máxima seguridad  
✅ **Código Educativo:** Completamente comentado en español  
✅ **Demostración Práctica:** Cifra y descifra datos de ejemplo  
✅ **Verificación:** Comprueba la integridad de los datos  
✅ **Casos de Uso Reales:** Aplicado al sector telecomunicaciones  

## 📦 Requisitos

- **Java JDK:** 8 o superior
- **IDE recomendado:** IntelliJ IDEA, NetBeans, Eclipse, o VS Code
- **Sistema Operativo:** Windows, Linux, o macOS

## 🛠️ Instalación y Uso

### 1. Clonar el Repositorio

```bash
git clone https://github.com/TU_USUARIO/cifrado-simetrico-telefonica.git
cd cifrado-simetrico-telefonica
```

### 2. Compilar el Proyecto

```bash
javac src/CifradoTelefonica.java
```

### 3. Ejecutar el Programa

```bash
java -cp src CifradoTelefonica
```

### 4. Usando IntelliJ IDEA

1. Abre IntelliJ IDEA
2. **File** → **Open** → Selecciona la carpeta del proyecto
3. Navega a `src/CifradoTelefonica.java`
4. Click derecho → **Run 'CifradoTelefonica.main()'**

## 📊 Ejemplo de Salida

```
=================================================
  SISTEMA DE CIFRADO SIMÉTRICO - TELEFÓNICA
=================================================

📄 DATOS ORIGINALES (sin protección):
   Cliente: Juan Pérez | DNI: 12345678 | Teléfono: +57 300 1234567

🔑 GENERANDO CLAVE SIMÉTRICA AES-256...
   Clave generada: YwtYxu2bd3YL8dipTFOC...
   ⚠️  Esta clave debe ser compartida de forma segura

🔒 CIFRANDO DATOS...
   Datos cifrados: BIcTdlzfHeANpi3W2CwDyh6c9vQ1u+WEIkCvWgae...
   ✅ Datos protegidos - ilegibles sin la clave

🔓 DESCIFRANDO DATOS...
   Datos descifrados: Cliente: Juan Pérez | DNI: 12345678 | Teléfono: +57 300 1234567
   ✅ Datos recuperados exitosamente

=================================================
✅ VERIFICACIÓN EXITOSA
   Los datos originales y descifrados coinciden
=================================================
```

## 🏢 Aplicaciones en Telefónica

El cifrado simétrico se utiliza en diversos procesos críticos:

### 1. **Protección de Bases de Datos** 📊
- Información personal de clientes
- Registros de llamadas y mensajes
- Datos de facturación

### 2. **Comunicaciones Internas** 💬
- Intercambio entre sistemas
- Sincronización de datos entre centros

### 3. **Backups Cifrados** 💾
- Copias de seguridad protegidas
- Archivos históricos

### 4. **VPN Corporativa** 🌐
- Conexiones remotas de empleados
- Acceso seguro a sistemas internos

### 5. **Dispositivos IoT** 📡
- Routers y modems
- Sistemas de monitoreo

## ⚖️ Ventajas y Desventajas

### ✅ Ventajas

- **Velocidad:** Extremadamente rápido para grandes volúmenes
- **Eficiencia:** Bajo consumo computacional
- **Escalabilidad:** Funciona en millones de dispositivos
- **Seguridad:** Muy seguro si la clave es protegida

### ⚠️ Desventajas

- **Distribución de claves:** Compartir la clave de forma segura es complejo
- **Escalabilidad limitada:** En redes grandes, gestionar claves es difícil
- **Punto único de fallo:** Si la clave se compromete, todo está en riesgo

## 🔬 Conceptos Técnicos

### Proceso de Cifrado

```java
SecretKey clave = generarClaveAES();  // Genera clave de 256 bits
Cipher cipher = Cipher.getInstance("AES");
cipher.init(Cipher.ENCRYPT_MODE, clave);
byte[] cifrado = cipher.doFinal(textoPlano.getBytes());
```

### Proceso de Descifrado

```java
cipher.init(Cipher.DECRYPT_MODE, clave);  // MISMA clave
byte[] descifrado = cipher.doFinal(textoCifrado);
String textoOriginal = new String(descifrado);
```

## 📚 Recursos Educativos

- **NIST FIPS 197:** [Advanced Encryption Standard (AES)](https://nvlpubs.nist.gov/nistpubs/FIPS/NIST.FIPS.197.pdf)
- **Java Cryptography Architecture:** [Oracle JCA Guide](https://docs.oracle.com/javase/8/docs/technotes/guides/security/crypto/CryptoSpec.html)
- **Wikipedia AES:** [Advanced Encryption Standard](https://es.wikipedia.org/wiki/Advanced_Encryption_Standard)

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Si deseas mejorar este proyecto:

1. Haz un **Fork** del repositorio
2. Crea una rama para tu función (`git checkout -b feature/nueva-funcionalidad`)
3. Haz commit de tus cambios (`git commit -m 'Agregar nueva funcionalidad'`)
4. Push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Abre un **Pull Request**

## 👨‍💻 Autor

**Camilo** - Ingeniero Electrónico  
Estudiante de Especialización en Desarrollo de Software - UNIMINUTO  
Desarrollador en Telefónica

## 📄 Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

## 🙏 Agradecimientos

- **UNIMINUTO** - Por el apoyo académico
- **Telefónica** - Por el contexto empresarial real
- **Comunidad Java** - Por las librerías de criptografía

## 📧 Contacto

¿Preguntas o sugerencias? Abre un **Issue** en este repositorio.

---

⭐ Si este proyecto te fue útil, ¡no olvides darle una estrella!

**Keywords:** Criptografía, Cifrado Simétrico, AES-256, Java, Seguridad Informática, Telefónica, Telecomunicaciones
