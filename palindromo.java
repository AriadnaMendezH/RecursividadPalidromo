public class palidromo {

    /**
     * Método Wrapper (Público) 🎁
     * Prepara y limpia la entrada, e inicia la recursión con los parámetros necesarios.
     * 
     * @param palabra La cadena a verificar
     * @return true si es palíndromo, false en caso contrario
     */
    public static boolean esPalindromo(String palabra) {
        // Validación de caso nulo
        if (palabra == null) {
            return false;
        }

        // Limpieza de datos: convierte a minúsculas y elimina espacios 🧼
        String textoLimpio = palabra.toLowerCase().replace(" ", "");

        // Delegación de la recursión al método auxiliar con los índices iniciales
        return esPalindromoAux(textoLimpio, 0, textoLimpio.length() - 1);
    }

    /**
     * Método Auxiliar (Privado y Recursivo) 🔄
     * Realiza la comparación recursiva carácter por carácter desde los extremos hacia el centro.
     * 
     * @param texto Cadena de texto a evaluar (ya procesada)
     * @param inicio Índice del extremo izquierdo
     * @param fin Índice del extremo derecho
     * @return true si las letras restantes forman un palíndromo
     */
    private static boolean esPalindromoAux(String texto, int inicio, int fin) {
        // CASO BASE 1: Éxito 🟢
        // Los índices se cruzaron (palabra de longitud par) o quedaron en la misma posición (longitud impar).
        if (inicio >= fin) {
            return true;
        }

        // CASO BASE 2: Fallo 🔴
        // Si los caracteres en los extremos actuales no coinciden, se detiene la recursión.
        if (texto.charAt(inicio) != texto.charAt(fin)) {
            return false;
        }

        // PASO RECURSIVO 🔁
        // Las letras coincidieron; avanzamos el índice izquierdo y retrocedemos el derecho.
        return esPalindromoAux(texto, inicio + 1, fin - 1);
    }

    // Método principal de prueba para verificar el funcionamiento 🧪
    public static void main(String[] args) {
        String[] pruebas = {
            "reconocer",
            "oso",
            "Anita lava la tina",
            "Java",
            "Aibofobia"
        };

        System.out.println("--- PRUEBA DE PALÍNDROMOS ---");
        for (String texto : pruebas) {
            boolean resultado = esPalindromo(texto);
            System.out.printf("¿\"%s\" es palíndromo? -> %b%n", texto, resultado);
        }
    }
}
