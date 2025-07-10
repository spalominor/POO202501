package com.unal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * Clase Agenda que gestiona un arreglo de objetos Usuario.
 */
public class Agenda {
    private Usuario[] registro;
    private int no_reg;

    /**
     * Constructor que inicializa la agenda con capacidad dada.
     *
     * @param capacity Número máximo de usuarios.
     */
    public Agenda(int capacity) {
        registro = new Usuario[capacity];
        no_reg = 0;
    }

    /**
     * Agrega un usuario si no existe y hay espacio disponible.
     *
     * @param u Usuario a agregar.
     * @return true si se agregó correctamente, false en caso contrario.
     */
    public boolean agregar(Usuario u) {
        if (buscar(u.getId()) != -1 || no_reg >= registro.length) {
            return false;
        }
        registro[no_reg] = u;
        no_reg++;
        return true;
    }

    /**
     * Busca la posición de un usuario por su ID.
     *
     * @param id Identificador a buscar.
     * @return Índice del usuario o -1 si no se encuentra.
     */
    public int buscar(int id) {
        for (int i = 0; i < no_reg; i++) {
            if (registro[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param id ID del usuario a eliminar.
     * @return true si se eliminó, false si no se encontró.
     */
    public boolean eliminar(int id) {
        int pos = buscar(id);
        if (pos == -1) {
            return false;
        }

        for (int i = pos; i < no_reg - 1; i++) {
            registro[i] = registro[i + 1];
        }

        registro[no_reg - 1] = null;
        no_reg--;
        return true;
    }

    /**
     * Muestra todos los usuarios almacenados.
     */
    public void mostrar() {
        for (int i = 0; i < no_reg; i++) {
            System.out.println("Nombre: " + registro[i].getNombre() +
                    ", ID: " + registro[i].getId());
        }
    }

    /**
     * Muestra un usuario específico por ID.
     *
     * @param id ID del usuario a mostrar.
     */
    public void mostrarUsuario(int id) {
        int pos = buscar(id);
        if (pos != -1) {
            registro[pos].mostrarInformacion();
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    /**
     * Retorna el número actual de usuarios registrados.
     *
     * @return Número de registros.
     */
    public int getNoReg() {
        return no_reg;
    }

    /**
     * Guarda los usuarios en el archivo "agenda.txt".
     */
    public void toFile() {
        toFile("agenda.txt");
    }

    /**
     * Guarda los usuarios en el archivo *.txt.
     *
     * @param rutaArchivo Ruta del archivo. Por defecto "agenda.txt".
     */
    public void toFile(String rutaArchivo) {
        // Asignar ruta por defecto si es null o vacío
        if (rutaArchivo == null || rutaArchivo.trim().isEmpty()) {
            rutaArchivo = "agenda.txt";
        }

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(rutaArchivo))) {

            for (int i = 0; i < no_reg; i++) {
                writer.write(registro[i].toCSV());
                writer.newLine();
            }

            System.out.println("Archivo guardado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al guardar archivo: " + e.getMessage());
        }
    }

    /**
     * Guarda los usuarios en el archivo "agenda.txt".
     */
    public void importar() {
        importar("agenda.txt");
    }

    /**
     * Carga los usuarios desde el archivo "agenda.txt".
     * Los registros actuales se reemplazan.
     */
    public void importar(String rutaArchivo) {
        // Asignar ruta por defecto si es null o vacío
        if (rutaArchivo == null || rutaArchivo.trim().isEmpty()) {
            rutaArchivo = "agenda.txt";
        }

        try (BufferedReader reader = new BufferedReader(
                new FileReader("agenda.txt"))) {

            no_reg = 0;
            String linea;

            while ((linea = reader.readLine()) != null) {
                Usuario u = Usuario.fromCSV(linea);
                if (u != null && no_reg < registro.length) {
                    registro[no_reg] = u;
                    no_reg++;
                }
            }

            System.out.println("Archivo importado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
    }
}