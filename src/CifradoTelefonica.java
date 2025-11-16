import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * Demostración de Criptosistema Simétrico (AES-256) en Telefónica
 * 
 * Este programa simula cómo Telefónica protege datos sensibles de clientes
 * usando cifrado simétrico AES (Advanced Encryption Standard)
 * 
 * @author Camilo
 * @version 1.0
 */
public class CifradoTelefonica {
    
    // Algoritmo de cifrado usado por Telefónica
    private static final String ALGORITMO = "AES";
    
    /**
     * Método principal que demuestra el proceso completo
     */
    public static void main(String[] args) {
        try {
            System.out.println("=================================================");
            System.out.println("  SISTEMA DE CIFRADO SIMÉTRICO - TELEFÓNICA");
            System.out.println("=================================================\n");
            
            // PASO 1: Datos sensibles del cliente (sin cifrar)
            String datosSensibles = "Cliente: Camilo Pineros | DNI: 12345678 | Teléfono: +57 315 1234567";
            System.out.println("📄 DATOS ORIGINALES (sin protección):");
            System.out.println("   " + datosSensibles);
            System.out.println();
            
            // PASO 2: Generar clave simétrica (la misma para cifrar y descifrar)
            System.out.println("🔑 GENERANDO CLAVE SIMÉTRICA AES-256...");
            SecretKey claveSecreta = generarClaveAES();
            String claveEnBase64 = Base64.getEncoder().encodeToString(claveSecreta.getEncoded());
            System.out.println("   Clave generada: " + claveEnBase64.substring(0, 20) + "...");
            System.out.println("   ⚠️  Esta clave debe ser compartida de forma segura");
            System.out.println();
            
            // PASO 3: CIFRAR los datos
            System.out.println("🔒 CIFRANDO DATOS...");
            String datosCifrados = cifrar(datosSensibles, claveSecreta);
            System.out.println("   Datos cifrados: " + datosCifrados.substring(0, 40) + "...");
            System.out.println("   ✅ Datos protegidos - ilegibles sin la clave");
            System.out.println();
            
            // PASO 4: DESCIFRAR los datos (usando la misma clave)
            System.out.println("🔓 DESCIFRANDO DATOS...");
            String datosDescifrados = descifrar(datosCifrados, claveSecreta);
            System.out.println("   Datos descifrados: " + datosDescifrados);
            System.out.println("   ✅ Datos recuperados exitosamente");
            System.out.println();
            
            // PASO 5: Verificación
            System.out.println("=================================================");
            if (datosSensibles.equals(datosDescifrados)) {
                System.out.println("✅ VERIFICACIÓN EXITOSA");
                System.out.println("   Los datos originales y descifrados coinciden");
            } else {
                System.out.println("❌ ERROR: Los datos no coinciden");
            }
            System.out.println("=================================================");
            
            // Información adicional sobre el sistema
            mostrarCaracteristicasSistema();
            
        } catch (Exception e) {
            System.err.println("❌ Error en el proceso de cifrado: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Genera una clave AES de 256 bits
     * Esta es la ÚNICA clave usada tanto para cifrar como descifrar
     */
    private static SecretKey generarClaveAES() throws Exception {
        KeyGenerator generadorClaves = KeyGenerator.getInstance(ALGORITMO);
        generadorClaves.init(256); // AES-256 (clave de 256 bits)
        return generadorClaves.generateKey();
    }
    
    /**
     * Cifra un texto usando la clave simétrica
     * 
     * @param textoPlano Texto sin cifrar
     * @param clave Clave simétrica
     * @return Texto cifrado en Base64
     */
    private static String cifrar(String textoPlano, SecretKey clave) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.ENCRYPT_MODE, clave); // Modo CIFRADO
        byte[] bytesCifrados = cipher.doFinal(textoPlano.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(bytesCifrados);
    }
    
    /**
     * Descifra un texto usando la MISMA clave simétrica
     * 
     * @param textoCifrado Texto cifrado en Base64
     * @param clave La MISMA clave usada para cifrar
     * @return Texto descifrado (original)
     */
    private static String descifrar(String textoCifrado, SecretKey clave) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.DECRYPT_MODE, clave); // Modo DESCIFRADO (misma clave)
        byte[] bytesDescifrados = cipher.doFinal(Base64.getDecoder().decode(textoCifrado));
        return new String(bytesDescifrados, "UTF-8");
    }
    
    /**
     * Muestra las características del criptosistema simétrico
     */
    private static void mostrarCaracteristicasSistema() {
        System.out.println("\n📊 CARACTERÍSTICAS DEL SISTEMA:");
        System.out.println("┌─────────────────────────────────────────────────┐");
        System.out.println("│ • Tipo: Criptosistema SIMÉTRICO (clave privada)│");
        System.out.println("│ • Algoritmo: AES-256                            │");
        System.out.println("│ • Número de claves: 1 (compartida)             │");
        System.out.println("│ • Tamaño de clave: 256 bits                     │");
        System.out.println("│ • Velocidad: Alta (eficiente)                   │");
        System.out.println("│ • Uso en Telefónica:                            │");
        System.out.println("│   - Cifrado de bases de datos                   │");
        System.out.println("│   - Protección de comunicaciones internas       │");
        System.out.println("│   - Datos de clientes en reposo                 │");
        System.out.println("│   - Backups cifrados                            │");
        System.out.println("└─────────────────────────────────────────────────┘");
        
        System.out.println("\n⚠️  DESAFÍO DEL CIFRADO SIMÉTRICO:");
        System.out.println("   La clave debe compartirse de forma segura entre");
        System.out.println("   emisor y receptor. Si la clave es interceptada,");
        System.out.println("   toda la seguridad se compromete.");
    }
}
