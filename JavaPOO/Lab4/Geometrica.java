package com.unal;

public class Geometrica extends Progresion {
    protected long base;

    public Geometrica() {
        super(1);
        this.base = 2;
    }

    public Geometrica(long base) {
        super(1);
        this.base = base;
    }

    public Geometrica(long base, long valor) {
        super(valor);
        this.base = base;
    }


    protected void avanzar() {
        valor = valor * base;
    }
}
