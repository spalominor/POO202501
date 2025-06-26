package com.unal;

public class Main {
    public static void main(String[] args) {
        // 2. Progresión aritmética: empieza en 7 y se incrementa en 3
        Progresion progArit = new Aritmetica(3, 5);
        System.out.println("Progresión aritmética desde 5, incremento 3:");
        progArit.imprimirP(3);
        System.out.println();

        // 3. Progresión geométrica: empieza en 3 con base 6
        Progresion progGeo = new Geometrica(2, 3);
        System.out.println("Progresión geométrica desde 3, base 2:");
        progGeo.imprimirP(3);
        System.out.println();

        // 4. Progresión de Fibonacci: primeros 10 términos
        Progresion progFibo = new Fibonacci();
        System.out.println("Progresión de Fibonacci (10 primeros términos):");
        progFibo.imprimirP(10);
        System.out.println();

        // 1. Crear un círculo de radio 2
        Shape circulo = new Circulo(2);

        // Imprimir resultados del círculo
        System.out.println("Círculo de radio 2:");
        System.out.println("Área: " + circulo.calcularArea());
        System.out.println("Perímetro: " + circulo.calcularPerimetro());
        System.out.println();

        // 2. Crear un rectángulo de base 5 y altura 10
        Shape rectangulo = new Rectangulo(5, 10);

        // Imprimir resultados del rectángulo
        System.out.println("Rectángulo de base 5 y altura 10:");
        System.out.println("Área: " + rectangulo.calcularArea());
        System.out.println("Perímetro: " + rectangulo.calcularPerimetro());
        System.out.println();

        // 3. Crear un triángulo rectángulo con base 2 y altura 3
        Shape triangulo = new Triangulo(2, 3);

        // Imprimir resultados del triángulo
        System.out.println("Triángulo rectángulo de base 2 y altura 3:");
        System.out.println("Área: " + triangulo.calcularArea());
        System.out.println("Perímetro: " + triangulo.calcularPerimetro());
    }
}