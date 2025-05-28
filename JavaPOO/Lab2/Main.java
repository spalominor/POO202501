package com.unal;

import java.util.Scanner;

/**
 * Clase principal que solicita datos al usuario y muestra información
 * de un objeto Usuario.
 */
public class Main {

    public static void main(String[] args) {
        // Crear un objeto de tipo Fecha
        Fecha fechaNacimiento = new Fecha(23, 9, 2005);

        // Imprimir la fecha en formato dd-mm-aa
        System.out.println("Fecha de nacimiento: " + fechaNacimiento);

        // Crear un objeto de tipo Direccion
        Direccion direccion = new Direccion();
        direccion.setCalle("Calle 123");
        direccion.setNomenclatura("A Sur");
        direccion.setBarrio("Barrio Alameda");
        direccion.setCiudad("MedaYork");
        direccion.setEdificio("Edificio Alameda");
        direccion.setApto("201");

        // Imprimir la dirección en una sola cadena
        System.out.println("Dirección de residencia: " + direccion);

        // Crear un objeto de tipo Usuario con datos predeterminados
        Usuario usuario = new Usuario();
        usuario.setNombre("Samuel Palomino");
        usuario.setId(1035979728L);
        usuario.setFecha_nacimiento(fechaNacimiento);
        usuario.setCiudad_nacimiento("Medellín");
        usuario.setTel(3167119600L);
        usuario.setEmail("samu@gmail.com");
        usuario.setDir(direccion);

        // Imprimir toda la información del usuario
        System.out.println("Información del Usuario: ");
        System.out.println(usuario);

        // Solicitar información por consola para crear un objeto Usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar nombre
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        // Solicitar ID
        System.out.print("Ingrese el ID: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        // Solicitar fecha de nacimiento
        System.out.print("Ingrese el día de nacimiento: ");
        int dd = scanner.nextInt();
        System.out.print("Ingrese el mes de nacimiento: ");
        int mm = scanner.nextInt();
        System.out.print("Ingrese el año de nacimiento: ");
        int aa = scanner.nextInt();
        Fecha fechaNacimientoUsuario = new Fecha(dd, mm, aa);
        scanner.nextLine(); // Limpiar el buffer del scanner

        // Solicitar ciudad de nacimiento
        System.out.print("Ingrese la ciudad de nacimiento: ");
        String ciudadNacimiento = scanner.nextLine();

        // Solicitar teléfono
        System.out.print("Ingrese el teléfono: ");
        long tel = scanner.nextLong();
        scanner.nextLine(); // Limpiar el buffer del scanner

        // Solicitar email
        System.out.print("Ingrese el email: ");
        String email = scanner.nextLine();

        // Solicitar dirección
        Direccion dirUser = new Direccion();
        System.out.print("Ingrese la calle: ");
        dirUser.setCalle(scanner.nextLine());
        System.out.print("Ingrese la nomenclatura: ");
        dirUser.setNomenclatura(scanner.nextLine());
        System.out.print("Ingrese el barrio: ");
        dirUser.setBarrio(scanner.nextLine());
        System.out.print("Ingrese la ciudad: ");
        dirUser.setCiudad(scanner.nextLine());
        System.out.print("Ingrese el edificio: ");
        dirUser.setEdificio(scanner.nextLine());
        System.out.print("Ingrese el apartamento: ");
        dirUser.setApto(scanner.nextLine());

        // Crear el objeto Usuario con la información proporcionada
        Usuario usuarioConsola = new Usuario(nombre, id);
        usuarioConsola.setFecha_nacimiento(fechaNacimientoUsuario);
        usuarioConsola.setCiudad_nacimiento(ciudadNacimiento);
        usuarioConsola.setTel(tel);
        usuarioConsola.setEmail(email);
        usuarioConsola.setDir(dirUser);

        // Imprimir toda la información del usuario creado desde consola
        System.out.println("\nInformación del Usuario creado desde consola: ");
        System.out.println(usuarioConsola);

        // Cerrar el scanner
        scanner.close();
    }
}