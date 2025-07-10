class Usuario:
    def __init__(self, id_: int, nombre: str):
        """
        Inicializa un usuario.

        Args:
            id_ (int): Identificador único del usuario.
            nombre (str): Nombre del usuario.
        """
        self.id = id_
        self.nombre = nombre

    def to_csv(self) -> str:
        """
        Convierte el usuario a una línea en formato CSV.

        Returns:
            str: Línea con los atributos separados por comas.
        """
        return f"{self.id},{self.nombre}"

    @classmethod
    def from_csv(cls, linea: str):
        """
        Crea un usuario desde una línea CSV.

        Args:
            linea (str): Línea en formato CSV ("id,nombre").

        Returns:
            Usuario | None: Instancia del usuario, o None si hubo error.
        """
        if not linea or linea.strip() == "":
            print("Línea vacía o nula.")
            return None

        partes = linea.strip().split(",")

        if len(partes) != 2:
            print(f"Formato incorrecto: {linea}")
            return None

        try:
            id_ = int(partes[0].strip())
            nombre = partes[1].strip()
            return cls(id_, nombre)
        except ValueError:
            print(f"ID inválido en línea: {linea}")
            return None

    def mostrar_informacion(self):
        """
        Imprime por consola la información del usuario.
        """
        print(f"ID: {self.id}, Nombre: {self.nombre}")



class Agenda:
    def __init__(self, capacidad: int):
        """
        Inicializa la agenda con una capacidad fija.

        Args:
            capacidad (int): Máximo número de usuarios.
        """
        self.registro = [None] * capacidad
        self.no_reg = 0

    def agregar(self, usuario: Usuario) -> bool:
        """
        Agrega un usuario si no existe y hay espacio disponible.

        Args:
            usuario (Usuario): Usuario a agregar.

        Returns:
            bool: True si se agregó, False si ya existía o está llena.
        """
        if self.buscar(usuario.id) != -1 or self.no_reg >= len(self.registro):
            return False
        self.registro[self.no_reg] = usuario
        self.no_reg += 1
        return True

    def buscar(self, id_: int) -> int:
        """
        Busca la posición de un usuario por su ID.

        Args:
            id_ (int): ID a buscar.

        Returns:
            int: Índice del usuario o -1 si no se encuentra.
        """
        for i in range(self.no_reg):
            if self.registro[i].id == id_:
                return i
        return -1

    def eliminar(self, id_: int) -> bool:
        """
        Elimina un usuario por su ID.

        Args:
            id_ (int): ID del usuario.

        Returns:
            bool: True si se eliminó, False si no se encontró.
        """
        pos = self.buscar(id_)
        if pos == -1:
            return False

        for i in range(pos, self.no_reg - 1):
            self.registro[i] = self.registro[i + 1]

        self.registro[self.no_reg - 1] = None
        self.no_reg -= 1
        return True

    def mostrar(self):
        """
        Muestra todos los usuarios de la agenda.
        """
        for i in range(self.no_reg):
            usuario = self.registro[i]
            print(f"Nombre: {usuario.nombre}, ID: {usuario.id}")

    def mostrar_usuario(self, id_: int):
        """
        Muestra un usuario específico por ID.

        Args:
            id_ (int): ID del usuario.
        """
        pos = self.buscar(id_)
        if pos != -1:
            self.registro[pos].mostrar_informacion()
        else:
            print("Usuario no encontrado.")

    def to_file(self, nombre_archivo: str = "agenda.txt"):
        """
        Guarda los usuarios en un archivo de texto.

        Args:
            nombre_archivo (str): Nombre del archivo destino.
        """
        try:
            with open(nombre_archivo, "w", encoding="utf-8") as f:
                for i in range(self.no_reg):
                    f.write(self.registro[i].to_csv() + "\n")
            print("Archivo guardado correctamente.")
        except Exception as e:
            print(f"Error al guardar archivo: {e}")

    def importar(self, nombre_archivo: str = "agenda.txt"):
        """
        Carga usuarios desde un archivo CSV.

        Args:
            nombre_archivo (str): Nombre del archivo fuente.
        """
        try:
            with open(nombre_archivo, "r", encoding="utf-8") as f:
                self.no_reg = 0
                for linea in f:
                    usuario = Usuario.from_csv(linea)
                    if usuario and self.no_reg < len(self.registro):
                        self.registro[self.no_reg] = usuario
                        self.no_reg += 1
            print("Archivo importado correctamente.")
        except Exception as e:
            print(f"Error al leer archivo: {e}")


def main():
    # Crear una agenda con capacidad para 5 usuarios
    agenda = Agenda(5)

    # Agregar usuarios
    agenda.agregar(Usuario(1, "Andrea"))
    agenda.agregar(Usuario(2, "Bibi"))
    agenda.agregar(Usuario(3, "Carlos"))
    agenda.agregar(Usuario(4, "Diana"))
    agenda.agregar(Usuario(5, "Eduardo"))

    # Mostrar usuarios actuales
    print("Usuarios actuales:")
    agenda.mostrar()

    # Guardar en archivo
    agenda.to_file()

    # Crear nueva agenda y cargar desde archivo
    nueva_agenda = Agenda(5)
    nueva_agenda.importar()

    # Mostrar importados
    print("\nUsuarios importados:")
    nueva_agenda.mostrar()

    # Eliminar un usuario
    print("\nEliminando usuario con ID 5:")
    nueva_agenda.eliminar(5)
    nueva_agenda.mostrar()

    # Guardar cambios en el archivo
    nueva_agenda.to_file()

if __name__ == "__main__":
    main()