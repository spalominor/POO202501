"""
Módulo que define progresiones numéricas: base, aritmética, geométrica y
Fibonacci.
"""

class Progresion:
    """
    Clase base para progresiones numéricas.
    """

    def __init__(self, valor: int = 0):
        """
        Inicializa la progresión con un valor inicial.

        Args:
            valor (int): Valor inicial de la progresión. Por defecto 0.
        """
        # Valor actual de la progresión
        self.valor = valor

    def avanzar(self):
        """
        Avanza al siguiente valor en la progresión.

        Esta versión incrementa de uno en uno.
        """
        # Incrementa el valor en uno
        self.valor += 1

    def sig_valor(self) -> int:
        """
        Devuelve el valor actual y luego avanza.

        Returns:
            int: El valor actual antes de avanzar.
        """
        # Guarda el valor actual
        temp = self.valor

        # Avanza al siguiente
        self.avanzar()

        # Devuelve el valor anterior al avance
        return temp

    def imprimir_p(self, n: int):
        """
        Imprime los primeros n valores de la progresión.

        Args:
            n (int): Cantidad de valores a imprimir.
        """
        # Itera n veces para imprimir los valores
        for _ in range(n):
            print(self.sig_valor(), end=" ")

        # Salto de línea al final
        print()


class Aritmetica(Progresion):
    """
    Clase que representa una progresión aritmética.
    """

    def __init__(self, inicio: int, incremento: int):
        """
        Inicializa la progresión aritmética.

        Args:
            inicio (int): Valor inicial.
            incremento (int): Incremento entre términos.
        """
        # Llama al constructor de la clase base
        super().__init__(inicio)

        # Guarda el incremento
        self.incremento = incremento

    def avanzar(self):
        """
        Avanza al siguiente valor de la progresión aritmética.
        """
        # Suma el incremento al valor actual
        self.valor += self.incremento


class Geometrica(Progresion):
    """
    Clase que representa una progresión geométrica.
    """

    def __init__(self, inicio: int, base: int):
        """
        Inicializa la progresión geométrica.

        Args:
            inicio (int): Valor inicial.
            base (int): Base multiplicativa.
        """
        # Llama al constructor base
        super().__init__(inicio)

        # Guarda la base multiplicativa
        self.base = base

    def avanzar(self):
        """
        Avanza al siguiente valor de la progresión geométrica.
        """
        # Multiplica el valor actual por la base
        self.valor *= self.base


class Fibonacci(Progresion):
    """
    Clase que representa una progresión de Fibonacci.
    """

    def __init__(self):
        """
        Inicializa la progresión de Fibonacci.
        """
        # Primer valor (previo) = 0
        self.prev = 0

        # Valor actual = 0 (primer término)
        super().__init__(0)

    def avanzar(self):
        """
        Calcula el siguiente término de Fibonacci.
        """
        # Si el valor es 0, establecemos el segundo término como 1
        if self.valor == 0:
            self.valor = 1
            return

        # Calcula la suma del valor actual y anterior
        sig = self.prev + self.valor

        # Actualiza el valor previo
        self.prev = self.valor

        # Establece el nuevo valor actual
        self.valor = sig
        
        
def main():
    """
    Ejecuta ejemplos de cada tipo de progresión.
    """
    # 1. Progresión base desde 6
    print("Progresión base desde 6:")
    prog_base = Progresion(6)
    prog_base.imprimir_p(5)

    # 2. Progresión aritmética: inicio 7, incremento 3
    print("Progresión aritmética desde 7, incremento 3:")
    prog_ari = Aritmetica(7, 3)
    prog_ari.imprimir_p(6)

    # 3. Progresión geométrica: inicio 3, base 6
    print("Progresión geométrica desde 3, base 6:")
    prog_geo = Geometrica(3, 6)
    prog_geo.imprimir_p(5)

    # 4. Progresión de Fibonacci (10 primeros términos)
    print("Progresión de Fibonacci:")
    prog_fibo = Fibonacci()
    prog_fibo.imprimir_p(10)


if __name__ == "__main__":
    main()

