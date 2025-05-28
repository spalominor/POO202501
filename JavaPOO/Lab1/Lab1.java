/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package un.lab1;

// Importa la clase Scanner para leer datos desde la entrada estándar
import java.util.Scanner;

// Importa la clase Random para crear números aleatorios
import java.util.Random;

// Importar para imprimir arreglos legibles
import java.util.Arrays;

/**
 *
 * @author S&N
 */
public class Lab1 {

    public static void main(String[] args) {
        // Llama al método que obtiene la longitud del arreglo
        // Realizar el punto 1
        int longitud = leerLongitudArreglo();

        // Llama al método que construye el arreglo A con entrada por consola
        int[] arregloA = llenarArregloA(longitud);

        // Imprime el contenido del arreglo A. Punto 2
        System.out.println("Contenido del arreglo A:");
        System.out.println(Arrays.toString(arregloA));

        // Generar el arregloB según las instrucciones dadas
        int[] arregloB = generarArregloB(longitud);

        // Imprimir el contenido del arrglo B. Punto 3
        System.out.println("Contenido del arreglo B:");
        System.out.println(Arrays.toString(arregloB));

        // Imprimir el resultado del punto 4
        System.out.println("Suma de los arreglos A y B:");
        System.out.println(Arrays.toString(sumarArreglos(arregloA, arregloB)));

        // Imprimir el resultado del punto 5
        System.out.println("Producto punto entre los arreglos A y B:");
        System.out.println(productoPunto(arregloA, arregloB));

        // Imprimir el resultado del punto 6
        System.out.println("Suma de los enteros pares del arreglo A");
        System.out.println(sumaPares(arregloA));

        // Imprimir el resultado del punto 7
        System.out.println("Promedio de los valores en el arreglo B:");
        System.out.println(calcularPromedio(arregloB));

        //Imprimir el resultado del punto 8
        System.out.println("Construir un arreglo C como la unión de A y B:");
        int[] arregloC = intercalarArreglos(arregloA, arregloB);
        System.out.println(Arrays.toString(arregloC));

        //Imprimir el resultado del punto 9
        System.out.println("Hallar el máximo valor de C y su posición");
        int[] info = obtenerMaximo(arregloC);
        int max = info[0];
        int pos = info[1] + 1;
        System.out.println(
                "El valor Máximo es: " + max + " en la posición: " + pos);
    }

    /**
     * Solicita al usuario ingresar la longitud de un arreglo y valida que esté
     * entre 1 y 12. Si la entrada no es válida, la vuelve a solicitar.
     *
     * @return Un número entero válido entre 1 y 12.
     */
    public static int leerLongitudArreglo() {
        Scanner scan = new Scanner(System.in);
        int lengthArray = 0;

        while (true) {
            try {
                System.out.println(
                        "Introduce la longitud del arreglo (entre 1 y 12): ");
                String entry = scan.nextLine();

                if (entry == null || entry.trim().isEmpty()) {
                    throw new IllegalArgumentException(
                        "La entrada no puede ser nula o vacía."
                    );
                }

                lengthArray = Integer.parseInt(entry);

                if (lengthArray < 1 || lengthArray > 12) {
                    throw new IllegalArgumentException(
                        "El número debe estar entre 1 y 12."
                    );
                }

                break;

            } catch (NumberFormatException e) {
                System.out.println("Error: Debes introducir un número entero");

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        return lengthArray;
    }


    /**
     * Llena un arreglo con valores enteros introducidos por el usuario.
     *
     * El método solicita un número entero por cada posición del arreglo
     * y valida que cada entrada sea numérica.
     *
     * @param longitud Longitud del arreglo a llenar.
     * @return Arreglo de enteros con los valores ingresados.
     */
    public static int[] llenarArregloA(int longitud) {

        // Crea un objeto Scanner para leer desde consola
        Scanner scan = new Scanner(System.in);

        // Crea el arreglo de tamaño especificado
        int[] arreglo = new int[longitud];

        // Recorre cada posición para llenarla
        for (int i = 0; i < longitud; i++) {
            while (true) {
                try {
                    // Solicita el valor para la posición actual
                    System.out.print("Ingresa el valor para A[" + i + "]: ");

                    // Lee la entrada como texto
                    String entrada = scan.nextLine();

                    // Valida que no esté vacía
                    if (entrada == null || entrada.trim().isEmpty()) {
                        throw new IllegalArgumentException(
                            "La entrada no puede ser nula o vacía."
                        );
                    }

                    // Intenta convertir a entero y guardar
                    arreglo[i] = Integer.parseInt(entrada);

                    // Si es válido, sale del bucle
                    break;

                } catch (NumberFormatException e) {
                    // Error si no se puede convertir a entero
                    System.out.println("Error: Debes introducir un número entero.");

                } catch (IllegalArgumentException e) {
                    // Muestra el mensaje de validación fallida
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }

        // Retorna el arreglo con los valores ingresados
        return arreglo;
    }


    /**
     * Genera un arreglo de enteros aleatorios entre 1 y 20.
     *
     * @param longitud Tamaño del arreglo a generar.
     * @return Arreglo con números aleatorios en el rango [1, 20].
     */
    public static int[] generarArregloB(int longitud) {

        // Importa java.util.Random en la parte superior del archivo

        // Crea un objeto Random para generar los números aleatorios
        Random random = new java.util.Random();

        // Crea el arreglo de tamaño especificado
        int[] B = new int[longitud];

        // Llena el arreglo con valores aleatorios entre 1 y 20
        for (int i = 0; i < longitud; i++) {
            B[i] = random.nextInt(20) + 1;
        }

        // Retorna el arreglo generado
        return B;
    }


    /**
     * Realiza la suma elemento a elemento de dos arreglos enteros.
     *
     * @param A Arreglo A de enteros.
     * @param B Arreglo B de enteros.
     * @return Arreglo resultante de sumar A[i] + B[i].
     */
    public static int[] sumarArreglos(int[] A, int[] B) {

        // Definir la longitud del arreglo (ambos tienen misma longitud)
        int longitud = A.length;

        // Crear el nuevo arreglo con el resultado
        int[] S = new int[longitud];

        // Iterar por cada posición y sumar los valores
        for (int i = 0; i < longitud; i++) {
            S[i] = A[i] + B[i];
        }

        // Retornar el arreglo resultado
        return S;
    }


    /**
     * Calcula el producto punto entre dos arreglos A y B.
     *
     * @param A Arreglo A de enteros.
     * @param B Arreglo B de enteros.
     * @return Resultado del producto punto.
     */
    public static int productoPunto(int[] A, int[] B) {

        // Validar si ambos arreglos tienen la misma longitud
        if (A.length != B.length) {
            throw new IllegalArgumentException(
                    "Los arreglos deben tener la misma longitud"
            );
        }

        // Definir la longitud del arreglo (ambos tienen misma longitud)
        int longitud = A.length;

        // Crear una nueva variable entera que almacene el resultado
        int productoPunto = 0;

        // Iterar por cada posición de cada arreglo y hacer el producto
        for (int i = 0; i < longitud; i++) {
            productoPunto += A[i] * B[i];
        }

        // Retornar el valor obtenido
        return productoPunto;
    }


    /**
     * Calcula la suma de los números pares en un arreglo.
     *
     * @param A Arreglo de enteros.
     * @return Suma de los elementos pares del arreglo.
     */
    public static int sumaPares(int[] A) {

        // Inicializar la variable para almacenar la suma
        int suma = 0;

        // Iterar por cada elemento del arreglo dado
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                suma += A[i];
            }
        }

        // Retornar el valor acumulado
        return suma;
    }


    /**
     * Calcular el promedio de los valores dentro de un arreglo.
     *
     * @param A Arreglo de enteros.
     * @return Promedio de los elementos del arreglo.
     */
    public static double calcularPromedio(int[] A) {

        // Inicializar la variable para almacenar la suma
        int suma = 0;

        // Iterar por cada elemento del arreglo dado
        for (int i = 0; i < A.length; i++) {
            suma += A[i];
        }

        // Calcular el promedio dado la suma y la longitud del arreglo
        double promedio = (double) suma / A.length;

        // Retornar el valor calculado
        return promedio;
    }


    /**
     * Construir un arreglo C que sea la unión de los elementos de A y B,
     * intercalando sus elementos de la forma: [a0, b0, a1, b1, ..., an-1, bn-1].
     *
     * @param A Arreglo de enteros A.
     * @param B Arreglo de enteros B.
     * @return Arreglo C con los elementos de A y B intercalados.
     */
    public static int[] intercalarArreglos(int[] A, int[] B) {

        // Inicializar el arreglo C con el doble de tamaño que A o B
        int n = A.length; // Suponemos que A y B tienen la misma longitud
        int[] C = new int[2 * n];

        // Iterar sobre los arreglos A y B
        for (int i = 0; i < n; i++) {
            // Colocar el elemento de A en la posición 2 * i
            C[2 * i] = A[i];
            // Colocar el elemento de B en la posición 2 * i + 1
            C[2 * i + 1] = B[i];
        }

        // Retornar el arreglo C
        return C;
    }


    /**
     * Determina el valor máximo en el arreglo C y su posición en el arreglo.
     *
     * @param C Arreglo de enteros.
     * @return Un arreglo de dos elementos, donde el primer valor es el valor máximo
     *         y el segundo valor es la posición en el arreglo C.
     */
    public static int[] obtenerMaximo(int[] C) {

        // Inicializar variables para el valor máximo y su posición
        int maximo = C[0];
        int posicion = 0;

        // Iterar por los elementos del arreglo C para encontrar el valor máximo
        for (int i = 1; i < C.length; i++) {
            if (C[i] > maximo) {
                // Actualizar el valor máximo
                maximo = C[i];

                // Actualizar la posición
                posicion = i;
            }
        }

        // Retornar el valor máximo y su posición como un arreglo
        return new int[] {maximo, posicion};
    }
}

