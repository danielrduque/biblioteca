import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Agregar libros
        Libro libro1 = new Libro(1, "One Piece", "Eiichiro Oda", "Manga", 200);
        Libro libro2 = new Libro(2, "Naruto", "Masashi Kishimoto", "Manga", 200);
        Libro libro3 = new Libro(3, "Hunter x Hunter", "Yoshihiro Togashi", "Manga", 200);
        Libro libro4 = new Libro(4, "Demon Slayer: Kimetsu no Yaiba", "Koyoharu Gotouge", "Manga", 200);
        Libro libro5 = new Libro(5, "Vinland Saga", "Makoto Yukimura", "Manga", 200);

        // Agregar usuarios
        Usuario usuario1 = new Usuario(1, "Legarda", "ID1");
        Usuario usuario2 = new Usuario(2, "Jhon", "ID2");
        Usuario usuario3 = new Usuario(3, "Anderson", "ID3");
        Usuario usuario4 = new Usuario(4, "Patiño", "ID4");

        // Agregar libros al objeto
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarLibro(libro4);
        biblioteca.agregarLibro(libro5);

        // Agregar usuarios al objeto
        biblioteca.agregarUsuario(usuario1);
        biblioteca.agregarUsuario(usuario2);
        biblioteca.agregarUsuario(usuario3);
        biblioteca.agregarUsuario(usuario4);

        // Realizar préstamos
        Date fechaPrestamo1 = new Date();
        Date fechaDevolucion1 = new Date();
        fechaDevolucion1.setDate(fechaDevolucion1.getDate() + 5); // Devolución en 5 días
        biblioteca.realizarPrestamo(usuario1.getId(), libro1.getId(), fechaPrestamo1, fechaDevolucion1);

        Date fechaPrestamo2 = new Date();
        Date fechaDevolucion2 = new Date();
        fechaDevolucion2.setDate(fechaDevolucion2.getDate() - 8); // Devolución con multa
        biblioteca.realizarPrestamo(usuario2.getId(), libro2.getId(), fechaPrestamo2, fechaDevolucion2);

        Date fechaPrestamo3 = new Date();
        Date fechaDevolucion3 = new Date();
        fechaDevolucion3.setDate(fechaDevolucion3.getDate() + 14); // Devolución en 14 días
        biblioteca.realizarPrestamo(usuario2.getId(), libro3.getId(), fechaPrestamo3, fechaDevolucion3);

        Date fechaPrestamo4 = new Date();
        Date fechaDevolucion4 = new Date();
        fechaDevolucion4.setDate(fechaDevolucion4.getDate() + 4); // Devolución en 4 días
        biblioteca.realizarPrestamo(usuario3.getId(), libro4.getId(), fechaPrestamo4, fechaDevolucion4);

        Date fechaPrestamo5 = new Date();
        Date fechaDevolucion5 = new Date();
        fechaDevolucion5.setDate(fechaDevolucion5.getDate() - 10); // Devolución con multa
        biblioteca.realizarPrestamo(usuario4.getId(), libro5.getId(), fechaPrestamo5, fechaDevolucion5);

        // Calcular las listas
        Date fechaActual = new Date();
        List<Prestamo> librosPrestados = biblioteca.obtenerLibrosPrestadosHastaFecha(fechaActual);
        List<Prestamo> librosConMulta = biblioteca.obtenerLibrosConMulta(fechaActual);
        List<Usuario> usuariosConLibrosPrestados = biblioteca.obtenerUsuariosConLibrosPrestados();

        // Imprimir resultados
        System.out.println("Libros prestados a la fecha actual:");
        for (Prestamo prestamo : librosPrestados) {
            Usuario usuario = biblioteca.buscarUsuarioPorId(prestamo.getIdUsuario());
            if (usuario != null) {
                System.out.println("Libro: " + prestamo.getLibro().getTitulo() + ", Usuario: " + usuario.getNombre());
            }
        }

        System.out.println("\nLibros con multa:");
        for (Prestamo prestamo : librosConMulta) {
            Usuario usuario = biblioteca.buscarUsuarioPorId(prestamo.getIdUsuario());
            if (usuario != null) {
                System.out.println("Libro: " + prestamo.getLibro().getTitulo() + ", Multa: $" + prestamo.getMulta() + ", Usuario: " + usuario.getNombre());
            }
        }

        System.out.println("\nUsuarios con libros prestados:");
        for (Usuario usuario : usuariosConLibrosPrestados) {
            System.out.println("Usuario: " + usuario.getNombre());
        }
    }
}



