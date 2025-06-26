package com.unal;

public class Circulo implements Shape {
    private double radio;
    double pi = 3.14;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return pi * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * pi * radio;
    }
}
