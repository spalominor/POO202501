package com.unal;

/**
 * Clase que representa una dirección física detallada.
 */
public class Direccion {

    // Nombre de la calle
    private String calle;

    // Nomenclatura o número
    private String nomenclatura;

    // Barrio de residencia
    private String barrio;

    // Ciudad correspondiente
    private String ciudad;

    // Nombre del edificio
    private String edificio;

    // Número de apartamento
    private String apto;

    /**
     * Constructor vacío
     */
    public Direccion() {
    }

    /**
     * Establece la calle
     *
     * @param calle Nombre de la calle
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Retorna la calle
     *
     * @return Nombre de la calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece la nomenclatura
     *
     * @param nomenclatura Número o nomenclatura
     */
    public void setNomenclatura(String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }

    /**
     * Retorna la nomenclatura
     *
     * @return Nomenclatura
     */
    public String getNomenclatura() {
        return nomenclatura;
    }

    /**
     * Establece el barrio
     *
     * @param barrio Barrio de residencia
     */
    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    /**
     * Retorna el barrio
     *
     * @return Barrio
     */
    public String getBarrio() {
        return barrio;
    }

    /**
     * Establece la ciudad
     *
     * @param ciudad Ciudad correspondiente
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Retorna la ciudad
     *
     * @return Ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece el edificio
     *
     * @param edificio Nombre del edificio
     */
    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    /**
     * Retorna el edificio
     *
     * @return Edificio
     */
    public String getEdificio() {
        return edificio;
    }

    /**
     * Establece el apartamento
     *
     * @param apto Número de apartamento
     */
    public void setApto(String apto) {
        this.apto = apto;
    }

    /**
     * Retorna el apartamento
     *
     * @return Apartamento
     */
    public String getApto() {
        return apto;
    }

    /**
     * Retorna la dirección completa como cadena legible
     *
     * @return Dirección concatenada
     */
    @Override
    public String toString() {
        return calle + ", " + nomenclatura + ", " + barrio + ", " +
                ciudad + ", " + edificio + ", Apto " + apto;
    }
}

