package com.unal;

/**
 * Clase que representa un usuario del sistema.
 */
public class Usuario {

    // Nombre completo del usuario
    private String nombre;

    // Identificación del usuario
    private long id;

    // Fecha de nacimiento del usuario
    private Fecha fecha_nacimiento;

    // Ciudad donde nació el usuario
    private String ciudad_nacimiento;

    // Teléfono de contacto
    private long tel;

    // Correo electrónico del usuario
    private String email;

    // Dirección física del usuario
    private Direccion dir;

    /**
     * Constructor vacío
     */
    public Usuario() {
    }

    /**
     * Constructor parcial con nombre e id
     *
     * @param nombre Nombre del usuario
     * @param id     Identificación del usuario
     */
    public Usuario(String nombre, long id) {
        this.nombre = nombre;
        this.id = id;
    }

    /**
     * Establece el nombre del usuario
     *
     * @param nombre Nombre completo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna el nombre del usuario
     *
     * @return Nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece la identificación
     *
     * @param id Número de identificación
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Retorna la identificación
     *
     * @return ID
     */
    public long getId() {
        return id;
    }

    /**
     * Establece la fecha de nacimiento
     *
     * @param fecha_nacimiento Objeto Fecha
     */
    public void setFecha_nacimiento(Fecha fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     * Retorna la fecha de nacimiento
     *
     * @return Objeto Fecha
     */
    public Fecha getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * Establece la ciudad de nacimiento
     *
     * @param ciudad_nacimiento Nombre de ciudad
     */
    public void setCiudad_nacimiento(String ciudad_nacimiento) {
        this.ciudad_nacimiento = ciudad_nacimiento;
    }

    /**
     * Retorna la ciudad de nacimiento
     *
     * @return Ciudad
     */
    public String getCiudad_nacimiento() {
        return ciudad_nacimiento;
    }

    /**
     * Establece el número de teléfono
     *
     * @param tel Número de contacto
     */
    public void setTel(long tel) {
        this.tel = tel;
    }

    /**
     * Retorna el número de teléfono
     *
     * @return Teléfono
     */
    public long getTel() {
        return tel;
    }

    /**
     * Establece el email
     *
     * @param email Correo electrónico
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna el email
     *
     * @return Correo electrónico
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece la dirección del usuario
     *
     * @param dir Objeto Direccion
     */
    public void setDir(Direccion dir) {
        this.dir = dir;
    }

    /**
     * Retorna la dirección del usuario
     *
     * @return Objeto Direccion
     */
    public Direccion getDir() {
        return dir;
    }

    /**
     * Retorna toda la información del usuario en formato legible
     *
     * @return Información completa del usuario
     */
    @Override
    public String toString() {
        return "Usuario: " + nombre + "\n" +
                "ID: " + id + "\n" +
                "Fecha de nacimiento: " + fecha_nacimiento + "\n" +
                "Ciudad de nacimiento: " + ciudad_nacimiento + "\n" +
                "Teléfono: " + tel + "\n" +
                "Email: " + email + "\n" +
                "Dirección: " + dir;
    }
}
