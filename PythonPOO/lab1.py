def main():
    # Punto 1: Solicitar la longitud del arreglo
    longitud = leer_longitud_arreglo()

    # Punto 2: Llenar el arreglo A con entradas del usuario
    arreglo_a = llenar_arreglo_a(longitud)

    # Imprimir el contenido del arreglo A
    print("Contenido del arreglo A:")
    print(arreglo_a)

    # Punto 3: Generar el arreglo B con valores aleatorios
    arreglo_b = generar_arreglo_b(longitud)

    # Imprimir el contenido del arreglo B
    print("Contenido del arreglo B:")
    print(arreglo_b)

    # Punto 4: Imprimir la suma de los arreglos A y B
    print("Suma de los arreglos A y B:")
    print(sumar_arreglos(arreglo_a, arreglo_b))

    # Punto 5: Imprimir el producto punto de los arreglos A y B
    print("Producto punto entre los arreglos A y B:")
    print(producto_punto(arreglo_a, arreglo_b))

    # Punto 6: Imprimir la suma de los enteros pares en A
    print("Suma de los enteros pares del arreglo A:")
    print(suma_pares(arreglo_a))

    # Punto 7: Imprimir el promedio de los valores en el arreglo B
    print("Promedio de los valores en el arreglo B:")
    print(calcular_promedio(arreglo_b))

    # Punto 8: Imprimir el arreglo C como la unión de A y B
    print("Construir un arreglo C como la unión de A y B:")
    arreglo_c = intercalar_arreglos(arreglo_a, arreglo_b)
    print(arreglo_c)

    # Punto 9: Imprimir el máximo valor en C y su posición
    print("Hallar el máximo valor de C y su posición:")
    max_value, pos = obtener_maximo(arreglo_c)
    print(f"El valor máximo es: {max_value} en la posición: {pos + 1}")


def leer_longitud_arreglo():
    """
    Solicita al usuario la longitud de un arreglo y valida que esté 
    entre 1 y 12. Si la entrada no es válida, se vuelve a solicitar.

    Returns:
        int: Un número entero válido entre 1 y 12.
    """
    while True:
        try:
            # Solicitar al usuario que ingrese la longitud
            entrada = input("Introduce la longitud del arreglo (entre 1 y 12): ")

            # Verificar que la entrada no esté vacía o sea nula
            if not entrada.strip():
                raise ValueError("La entrada no puede ser vacía.")

            # Convertir la entrada a entero
            longitud = int(entrada)

            # Validar que el entero esté en el rango permitido
            if longitud < 1 or longitud > 12:
                raise ValueError("El número debe estar entre 1 y 12.")

            return longitud

        except ValueError as error:
            print(f"Error: {error}")


def llenar_arreglo_a(longitud):
    """
    Llena una lista con valores enteros introducidos por el usuario.

    El método solicita un número entero por cada posición de la lista y
    valida que cada entrada sea numérica y no esté vacía.

    Args:
        longitud (int): Longitud de la lista a llenar.

    Returns:
        list: Lista de enteros con los valores ingresados por el usuario.
    """
    arreglo = []  # Lista vacía para almacenar los valores

    for i in range(longitud):
        while True:
            try:
                # Solicita al usuario el valor para la posición i
                entrada = input(f"Ingresa el valor para A[{i}]: ")

                # Valida que la entrada no esté vacía
                if not entrada.strip():
                    raise ValueError("La entrada no puede estar vacía.")

                # Intenta convertir la entrada a entero
                valor = int(entrada)

                # Si es válido, agregar a la lista
                arreglo.append(valor)
                break

            except ValueError as error:
                # Captura errores de conversión o validación
                print(f"Error: {error}")

    return arreglo


import random

def generar_arreglo_b(longitud):
    """
    Genera una lista de enteros aleatorios entre 1 y 20.

    Args:
        longitud (int): Tamaño de la lista a generar.

    Returns:
        list: Lista con números aleatorios en el rango [1, 20].
    """
    # Genera una lista con números aleatorios entre 1 y 20
    return [random.randint(1, 20) for _ in range(longitud)]


def sumar_arreglos(a, b):
    """
    Realiza la suma elemento a elemento de dos listas de enteros.

    Args:
        a (list): Lista A de enteros.
        b (list): Lista B de enteros.

    Returns:
        list: Lista resultante de sumar a[i] + b[i].
    """
    # Usar comprensión de listas para sumar elementos en paralelo
    return [x + y for x, y in zip(a, b)]


def producto_punto(a, b):
    """
    Calcula el producto punto entre dos listas de enteros.

    Args:
        a (list): Lista A de enteros.
        b (list): Lista B de enteros.

    Returns:
        int: Resultado del producto punto.

    Raises:
        ValueError: Si las listas no tienen la misma longitud.
    """
    if len(a) != len(b):
        raise ValueError("Las listas deben tener la misma longitud")

    # Calcular la suma de los productos de los pares de elementos
    return sum(x * y for x, y in zip(a, b))


def suma_pares(a):
    """
    Calcula la suma de los números pares en una lista.

    Args:
        a (list): Lista de enteros.

    Returns:
        int: Suma de los elementos pares de la lista.
    """
    # Sumar todos los elementos que sean divisibles por 2
    return sum(x for x in a if x % 2 == 0)


def calcular_promedio(a):
    """
    Calcula el promedio de los valores dentro de una lista.

    Args:
        a (list): Lista de enteros.

    Returns:
        float: Promedio de los elementos de la lista.
    """
    if not a:
        return 0.0

    # Calcular y retornar el promedio
    return sum(a) / len(a)


def intercalar_arreglos(a, b):
    """
    Construye una lista C que sea la unión de los elementos de a y b,
    intercalando sus elementos de la forma: [a0, b0, a1, b1, ..., an-1, bn-1].

    Args:
        a (list): Lista A de enteros.
        b (list): Lista B de enteros.

    Returns:
        list: Lista C con los elementos de A y B intercalados.
    """
    # Usar comprensión de listas para intercalar los elementos
    return [elem for pair in zip(a, b) for elem in pair]


def obtener_maximo(c):
    """
    Determina el valor máximo en la lista c y su posición.

    Args:
        c (list): Lista de enteros.

    Returns:
        tuple: Un par donde el primer valor es el valor máximo y el segundo es la posición.
    """
    # Encontrar el valor máximo y su índice
    maximo = max(c)
    posicion = c.index(maximo)

    # Retornar el valor máximo y su posición
    return maximo, posicion


# Llamada a la función principal
if __name__ == "__main__":
    main()
