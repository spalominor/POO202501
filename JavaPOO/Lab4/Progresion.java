package com.unal;

public class Progresion {
    protected long valor;

    Progresion() {
        this.valor = 0;
    }

    Progresion(long valor) {
        this.valor = valor;
    }

    protected void avanzar() {
        this.valor++;
    }

    public long sigValor() {
        long temp = this.valor;
        avanzar();
        return temp;
    }

    public void imprimirP(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(sigValor() + " ");
        }
    }
}
