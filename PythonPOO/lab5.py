from math import pi, sqrt
from abc import ABC, abstractmethod

# -----------------------------
# Clase abstracta Progresion
# -----------------------------

class Progresion(ABC):
    """Clase base abstracta para progresiones numéricas."""

    def __init__(self, valor=0):
        """Inicializa la progresión con un valor dado o cero por defecto."""
        self.valor = valor

    def sig_valor(self):
        """Devuelve el valor actual y avanza al siguiente."""
        temp = self.valor
        self.avanzar()
        return temp

    def imprimirP(self, n):
        """Imprime los primeros n valores de la progresión."""
        print(" ".join(str(self.sig_valor()) for _ in range(n)))

    @abstractmethod
    def avanzar(self):
        """Método abstracto que define cómo avanza la progresión."""
        pass

# -----------------------------
# Subclases de Progresion
# -----------------------------

class Aritmetica(Progresion):
    """Progresión que suma un incremento constante."""

    def __init__(self, incremento=1, valor=0):
        super().__init__(valor)
        self.incremento = incremento

    def avanzar(self):
        self.valor += self.incremento

class Geometrica(Progresion):
    """Progresión que multiplica por una base constante."""

    def __init__(self, base=2, valor=1):
        super().__init__(valor)
        self.base = base

    def avanzar(self):
        self.valor *= self.base

class Fibonacci(Progresion):
    """Progresión de Fibonacci."""

    def __init__(self):
        super().__init__(0)
        self.prev = 0

    def avanzar(self):
        if self.valor == 0:
            self.valor = 1
        else:
            sig = self.prev + self.valor
            self.prev = self.valor
            self.valor = sig

# -----------------------------
# Interfaz Shape
# -----------------------------

class Shape(ABC):
    """Interfaz para figuras geométricas."""

    @abstractmethod
    def calcular_area(self):
        pass

    @abstractmethod
    def calcular_perimetro(self):
        pass

# -----------------------------
# Clases concretas de Shape
# -----------------------------

class Circulo(Shape):
    """Círculo con radio."""

    def __init__(self, radio):
        self.radio = radio

    def calcular_area(self):
        return pi * self.radio ** 2

    def calcular_perimetro(self):
        return 2 * pi * self.radio

class Rectangulo(Shape):
    """Rectángulo con base y altura."""

    def __init__(self, base, altura):
        self.base = base
        self.altura = altura

    def calcular_area(self):
        return self.base * self.altura

    def calcular_perimetro(self):
        return 2 * (self.base + self.altura)

class TrianguloRectangulo(Shape):
    """Triángulo rectángulo con base y altura."""

    def __init__(self, base, altura):
        self.base = base
        self.altura = altura

    def calcular_area(self):
        return (self.base * self.altura) / 2

    def calcular_perimetro(self):
        hipotenusa = sqrt(self.base ** 2 + self.altura ** 2)
        return self.base + self.altura + hipotenusa

# -----------------------------
# Ejecución principal
# -----------------------------

if __name__ == "__main__":
    print("=== Progresiones ===")

    print("\n1. Progresión aritmética desde 5, incremento 3:")
    arit = Aritmetica(3, 5)
    arit.imprimirP(3)

    print("\n2. Progresión geométrica desde 3, base 2:")
    geo = Geometrica(2, 3)
    geo.imprimirP(3)

    print("\n3. Progresión Fibonacci:")
    fib = Fibonacci()
    fib.imprimirP(10)

    print("\n=== Figuras ===")

    c = Circulo(2)
    print(f"\nCírculo de radio 2:")
    print(f"Área = {c.calcular_area():.2f}")
    print(f"Perímetro = {c.calcular_perimetro():.2f}")

    r = Rectangulo(5, 10)
    print(f"\nRectángulo de base 5 y altura 10:")
    print(f"Área = {r.calcular_area():.2f}")
    print(f"Perímetro = {r.calcular_perimetro():.2f}")

    t = TrianguloRectangulo(2, 3)
    print(f"\nTriángulo rectángulo de base 2 y altura 3:")
    print(f"Área = {t.calcular_area():.2f}")
    print(f"Perímetro = {t.calcular_perimetro():.2f}")
