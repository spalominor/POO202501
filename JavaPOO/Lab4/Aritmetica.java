package com.unal;

public class Aritmetica extends Progresion {
    protected long incremento;

    public Aritmetica() {
        super();
        this.incremento = 1;
    }

    public Aritmetica(long incremento) {
        super();
        this.incremento = incremento;
    }

    public Aritmetica(long incremento, long valor) {
        super(valor);
        this.incremento = incremento;
    }

    protected void avanzar() {
        this.valor = this.valor + incremento;
    }
}
