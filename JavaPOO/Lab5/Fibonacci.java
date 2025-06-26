package com.unal;

public class Fibonacci extends Progresion {
    protected long prev;

    public Fibonacci() {
        super(0);
        this.prev = 0;
    }

    public void avanzar() {
        if (this.valor == 0) {
            this.valor = 1;
            return;
        }
        long sig = this.prev + this.valor;
        this.prev = this.valor;
        this.valor = sig;
    }
}