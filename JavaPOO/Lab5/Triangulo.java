package com.unal;

public class Triangulo implements Shape {
    protected double base;
    protected double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double calcularArea() {
        return (base * altura) / 2;
    }

    public double calcularPerimetro() {
        double hipotenusa = Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));
        return base + altura + hipotenusa;
    }
}
