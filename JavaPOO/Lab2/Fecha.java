package com.unal;

/**
 * Clase que representa una fecha con día, mes y año.
 */
public class Fecha {

    // Día de la fecha
    private int dd;

    // Mes de la fecha
    private int mm;

    // Año de la fecha
    private int aa;

    /**
     * Constructor vacío
     */
    public Fecha() {
    }

    /**
     * Constructor completo
     *
     * @param dd Día
     * @param mm Mes
     * @param aa Año
     */
    public Fecha(int dd, int mm, int aa) {
        this.dd = dd;
        this.mm = mm;
        this.aa = aa;
    }

    /**
     * Establece el día
     *
     * @param dd Día
     */
    public void setDd(int dd) {
        this.dd = dd;
    }

    /**
     * Retorna el día
     *
     * @return Día
     */
    public int getDd() {
        return dd;
    }

    /**
     * Establece el mes
     *
     * @param mm Mes
     */
    public void setMm(int mm) {
        this.mm = mm;
    }

    /**
     * Retorna el mes
     *
     * @return Mes
     */
    public int getMm() {
        return mm;
    }

    /**
     * Establece el año
     *
     * @param aa Año
     */
    public void setAa(int aa) {
        this.aa = aa;
    }

    /**
     * Retorna el año
     *
     * @return Año
     */
    public int getAa() {
        return aa;
    }

    /**
     * Retorna la fecha en formato legible
     *
     * @return Fecha como cadena "dd/mm/aa"
     */
    @Override
    public String toString() {
        return dd + "-" + mm + "-" + aa;
    }
}