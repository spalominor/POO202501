package com.unal;

abstract class Progresion {
    protected long valor;

    public Progresion() {
        this.valor = 0;
    }

    public Progresion(long valor) {
        this.valor = valor;
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
        System.out.println();
    }

    public abstract void avanzar();
}
