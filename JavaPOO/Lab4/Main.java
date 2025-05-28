package com.unal;

public class Main {
    public static void main(String[] args) {
        // 1. Progresión base: empieza en 6 y avanza de uno en uno
        Progresion progBase = new Progresion(6);
        System.out.println("Progresión base desde 6:");
        progBase.imprimirP(5);
        System.out.println();

        // 2. Progresión aritmética: empieza en 7 y se incrementa en 3
        Aritmetica progArit = new Aritmetica(3, 7);
        System.out.println("Progresión aritmética desde 7, incremento 3:");
        progArit.imprimirP(6);
        System.out.println();

        // 3. Progresión geométrica: empieza en 3 con base 6
        Geometrica progGeo = new Geometrica(6, 3);
        System.out.println("Progresión geométrica desde 3, base 6:");
        progGeo.imprimirP(5);
        System.out.println();

        // 4. Progresión de Fibonacci: primeros 10 términos
        Fibonacci progFibo = new Fibonacci();
        System.out.println("Progresión de Fibonacci (10 primeros términos):");
        progFibo.imprimirP(10);
        System.out.println();
    }
}