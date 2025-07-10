package com.unal;

/**
 * Clase principal para probar la Agenda.
 */
public class Main {
    public static void main(String[] args) {
        // Crear una agenda con capacidad 5
        Agenda agenda = new Agenda(5);

        // Agregar 5 usuarios
        agenda.agregar(new Usuario(1, "Andrea"));
        agenda.agregar(new Usuario(2, "Bibi"));
        agenda.agregar(new Usuario(3, "Carlos"));
        agenda.agregar(new Usuario(4, "David"));
        agenda.agregar(new Usuario(5, "Esteban"));

        // Mostrar la agenda actual
        agenda.mostrar();

        // Guardar en archivo
        agenda.toFile();

        // Crear nueva agenda y cargar desde archivo
        Agenda nuevaAgenda = new Agenda(5);
        nuevaAgenda.importar();

        // Mostrar los usuarios importados
        nuevaAgenda.mostrar();

        // Eliminar un usuario de la agenda
        nuevaAgenda.eliminar(5);

        // Mostrar el resultado
        nuevaAgenda.mostrar();

        // Guardar la información
        nuevaAgenda.toFile();
    }
}
