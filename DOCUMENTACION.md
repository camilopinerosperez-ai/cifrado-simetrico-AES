# Documentación Técnica - Cifrado Simétrico AES-256

## Índice
1. [Introducción](#introducción)
2. [Fundamentos de AES](#fundamentos-de-aes)
3. [Implementación en Java](#implementación-en-java)
4. [Casos de Uso en Telefónica](#casos-de-uso-en-telefónica)
5. [Mejores Prácticas](#mejores-prácticas)

---

## Introducción

El **Advanced Encryption Standard (AES)** es un algoritmo de cifrado simétrico adoptado por el gobierno de EE.UU. como estándar en 2001. Es ampliamente utilizado en todo el mundo para proteger información clasificada y datos sensibles.

### ¿Por qué AES-256?

- **256 bits de seguridad** = 2^256 combinaciones posibles
- Resistente a ataques de fuerza bruta (tomaría billones de años)
- Aprobado por la NSA para información TOP SECRET
- Implementación eficiente en hardware y software

---

## Fundamentos de AES

### Características Técnicas

| Propiedad | Valor |
|-----------|-------|
| Tipo | Cifrado de bloque simétrico |
| Tamaño de bloque | 128 bits (16 bytes) |
| Tamaños de clave | 128, 192, 256 bits |
| Rondas (256 bits) | 14 rondas |
| Modo de operación | ECB, CBC, CTR, GCM, etc. |

### Proceso de Cifrado (Simplificado)

1. **KeyExpansion:** La clave de 256 bits se expande en varias subclaves
2. **Ronda inicial:** XOR con la primera subclave
3. **Rondas principales (x13):**
   - SubBytes: Sustitución byte a byte
   - ShiftRows: Desplazamiento de filas
   - MixColumns: Mezcla de columnas
   - AddRoundKey: XOR con subclave
4. **Ronda final:** Similar pero sin MixColumns

### Principio de Funcionamiento

```
Texto Plano → [AES con Clave] → Texto Cifrado
Texto Cifrado → [AES con MISMA Clave] → Texto Plano
```

---

## Implementación en Java

### Estructura del Código

#### 1. Generación de Clave

```java
KeyGenerator generadorClaves = KeyGenerator.getInstance("AES");
generadorClaves.init(256); // Clave de 256 bits
SecretKey claveSecreta = generadorClaves.generateKey();
```

**¿Qué hace esto?**
- Crea un generador de claves AES
- Especifica 256 bits de longitud
- Genera una clave aleatoria y segura

#### 2. Proceso de Cifrado

```java
Cipher cipher = Cipher.getInstance("AES");
cipher.init(Cipher.ENCRYPT_MODE, clave);
byte[] bytesCifrados = cipher.doFinal(textoPlano.getBytes("UTF-8"));
String textoCifrado = Base64.getEncoder().encodeToString(bytesCifrados);
```

**Paso a paso:**
1. Obtiene instancia del cifrador AES
2. Inicializa en modo CIFRADO con la clave
3. Procesa el texto plano y obtiene bytes cifrados
4. Codifica en Base64 para facilitar almacenamiento/transmisión

#### 3. Proceso de Descifrado

```java
Cipher cipher = Cipher.getInstance("AES");
cipher.init(Cipher.DECRYPT_MODE, clave); // MISMA clave
byte[] bytesDescifrados = cipher.doFinal(Base64.getDecoder().decode(textoCifrado));
String textoOriginal = new String(bytesDescifrados, "UTF-8");
```

**Clave del éxito:**
- Se usa la **MISMA** clave que en el cifrado
- El proceso es reversible solo con la clave correcta

---

## Casos de Uso en Telefónica

### 1. Cifrado de Bases de Datos

**Escenario:** Millones de registros de clientes almacenados

```java
// Ejemplo conceptual
for (Cliente cliente : baseDatos) {
    String datosOriginales = cliente.toString();
    String datosCifrados = cifrar(datosOriginales, claveDB);
    almacenar(datosCifrados);
}
```

**Ventajas:**
- Si alguien roba el disco duro, los datos son ilegibles
- Cumplimiento con GDPR y normativas de privacidad

### 2. Comunicaciones entre Sistemas

**Escenario:** Sistema A necesita enviar datos a Sistema B

```
Sistema A: Datos → [Cifrar con Clave Compartida] → Red
Red: Transmisión del texto cifrado (seguro)
Sistema B: Texto cifrado → [Descifrar con Clave Compartida] → Datos
```

### 3. Backups Cifrados

**Escenario:** Respaldos nocturnos de información crítica

```java
byte[] backup = crearBackup();
byte[] backupCifrado = cifrar(backup, claveMaestra);
guardarEnNube(backupCifrado);
```

**Beneficio:** Incluso si el proveedor de nube es comprometido, los datos permanecen seguros

---

## Mejores Prácticas

### ✅ HACER

1. **Usar claves fuertes**
   - Mínimo 128 bits, recomendado 256 bits
   - Generadas criptográficamente (no contraseñas de usuario)

2. **Proteger la clave**
   - NUNCA hardcodear en el código fuente
   - Usar gestores de claves (HSM, KMS)
   - Rotar claves periódicamente

3. **Usar modos seguros**
   - Preferir GCM (Galois/Counter Mode) sobre ECB
   - GCM proporciona autenticación adicional

4. **Usar IV (Vector de Inicialización)**
   ```java
   Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
   // Genera IV aleatorio
   ```

### ❌ NO HACER

1. **NO usar ECB (Electronic Codebook)**
   - Patrones visibles en datos cifrados
   - Vulnerable a análisis de patrones

2. **NO derivar claves de contraseñas simples**
   ```java
   // ❌ MAL
   String clave = "password123";
   
   // ✅ BIEN
   SecretKey clave = generarClaveAES();
   ```

3. **NO compartir claves por canales inseguros**
   - NO por email sin cifrar
   - NO por mensajería instantánea
   - Usar intercambio de claves Diffie-Hellman o RSA

4. **NO reutilizar IVs**
   - Cada operación de cifrado debe usar un IV único

---

## Combinación con Cifrado Asimétrico

### El Problema

Cifrado simétrico es rápido pero compartir la clave es difícil.

### La Solución: Cifrado Híbrido

```
1. Alice genera clave AES (simétrica)
2. Alice cifra el mensaje con AES
3. Alice cifra la clave AES con la clave pública RSA de Bob
4. Alice envía: [Mensaje cifrado con AES] + [Clave AES cifrada con RSA]
5. Bob descifra la clave AES con su clave privada RSA
6. Bob descifra el mensaje con la clave AES
```

**Resultado:** Lo mejor de ambos mundos
- Velocidad de AES para datos grandes
- Seguridad de RSA para intercambio de claves

---

## Medidas de Seguridad Adicionales

### 1. Salt (Sal Criptográfica)

```java
// Agrega aleatoriedad única a cada cifrado
byte[] salt = new byte[16];
SecureRandom.getInstanceStrong().nextBytes(salt);
```

### 2. HMAC (Hash-based Message Authentication Code)

```java
// Verifica que el mensaje no fue alterado
Mac hmac = Mac.getInstance("HmacSHA256");
hmac.init(claveHMAC);
byte[] firma = hmac.doFinal(textoCifrado);
```

### 3. Key Derivation Functions (KDF)

```java
// Convierte contraseña en clave criptográfica fuerte
SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
PBEKeySpec spec = new PBEKeySpec(password, salt, 65536, 256);
SecretKey tmp = factory.generateSecret(spec);
SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");
```

---

## Rendimiento

### Benchmarks Típicos

| Operación | Velocidad Aproximada |
|-----------|---------------------|
| Cifrado | 500-1000 MB/s en hardware moderno |
| Descifrado | 500-1000 MB/s en hardware moderno |
| Generación de clave | < 1 ms |

### Optimizaciones

1. **Hardware Acceleration:** Usar instrucciones AES-NI del procesador
2. **Batch Processing:** Cifrar múltiples bloques simultáneamente
3. **Threading:** Paralelizar operaciones independientes

---

## Referencias

1. NIST FIPS 197 - Advanced Encryption Standard
2. RFC 3826 - The Advanced Encryption Standard (AES) Cipher Algorithm
3. Java Cryptography Architecture (JCA) Reference Guide
4. OWASP Cryptographic Storage Cheat Sheet

---

## Glosario

- **Clave Simétrica:** La misma clave para cifrar y descifrar
- **Texto Plano:** Datos sin cifrar (legibles)
- **Texto Cifrado:** Datos cifrados (ilegibles sin la clave)
- **IV (Initialization Vector):** Valor aleatorio para aumentar seguridad
- **Base64:** Codificación para representar bytes en texto
- **ECB:** Electronic Codebook - modo inseguro de AES
- **GCM:** Galois/Counter Mode - modo seguro y recomendado
- **Salt:** Datos aleatorios agregados antes del cifrado

---

*Última actualización: Noviembre 2025*
