package com.unal;

import java.util.Objects;

/**
 * Representa un usuario con identificador y nombre.
 */
public class Usuario {
    private int id;
    private String nombre;

    /**
     * Constructor principal del usuario.
     *
     * @param id     Identificador único del usuario.
     * @param nombre Nombre del usuario.
     */
    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Retorna el ID del usuario.
     *
     * @return ID del usuario.
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna el nombre del usuario.
     *
     * @return Nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Imprime la información del usuario por consola.
     */
    public void mostrarInformacion() {
        System.out.println("ID: " + id + ", Nombre: " + nombre);
    }

    /**
     * Convierte el usuario en una línea de texto en formato CSV.
     *
     * @return Cadena con los campos separados por comas.
     */
    public String toCSV() {
        return id + "," + nombre;
    }

    /**
     * Crea un usuario a partir de una línea en formato CSV.
     *
     * @param linea Línea de texto con el formato "id,nombre".
     * @return Objeto Usuario con los datos cargados, o null si hay error.
     */
    public static Usuario fromCSV(String linea) {
        // Verificar que la línea no esté vacía
        if (linea == null || linea.trim().isEmpty()) {
            System.out.println("Línea vacía o nula.");
            return null;
        }

        // Separar por coma
        String[] partes = linea.split(",");

        // Validar que tenga dos partes
        if (partes.length != 2) {
            System.out.println("Formato incorrecto: " + linea);
            return null;
        }

        try {
            // Convertir ID a entero
            int id = Integer.parseInt(partes[0].trim());

            // Obtener nombre
            String nombre = partes[1].trim();

            return new Usuario(id, nombre);

        } catch (NumberFormatException e) {
            System.out.println("ID inválido en línea: " + linea);
            return null;
        }
    }
}

