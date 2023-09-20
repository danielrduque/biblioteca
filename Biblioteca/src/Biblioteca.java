import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;

    public Biblioteca() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
        prestamos = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void realizarPrestamo(int idUsuario, int idLibro, Date fechaPrestamo, Date fechaDevolucion) {
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        Libro libro = buscarLibroPorId(idLibro);

        if (usuario != null && libro != null) {
            Prestamo prestamo = new Prestamo(idUsuario, libro, fechaPrestamo, fechaDevolucion);
            prestamos.add(prestamo);
        }
    }

    public List<Prestamo> obtenerLibrosPrestadosHastaFecha(Date fecha) {
        List<Prestamo> librosPrestados = new ArrayList<>();
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getFechaDevolucion().after(fecha)) {
                librosPrestados.add(prestamo);
            }
        }
        return librosPrestados;
    }

    public List<Prestamo> obtenerLibrosConMulta(Date fecha) {
        List<Prestamo> librosConMulta = new ArrayList<>();
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getFechaDevolucion().before(fecha)) {
                long diasRetraso = calcularDiasRetraso(prestamo.getFechaDevolucion(), fecha);
                double multa = diasRetraso > 3 ? diasRetraso * prestamo.getLibro().getMultaPorDia() : 0;
                if (multa > 0) {
                    prestamo.setMulta(multa);
                    librosConMulta.add(prestamo);
                }
            }
        }
        return librosConMulta;
    }

    public List<Usuario> obtenerUsuariosConLibrosPrestados() {
        List<Usuario> usuariosConLibrosPrestados = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            for (Prestamo prestamo : prestamos) {
                if (prestamo.getIdUsuario() == usuario.getId()) {
                    usuariosConLibrosPrestados.add(usuario);
                    break;
                }
            }
        }
        return usuariosConLibrosPrestados;
    }

    public Usuario buscarUsuarioPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    public Libro buscarLibroPorId(int id) {
        for (Libro libro : libros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    private long calcularDiasRetraso(Date fechaDevolucion, Date fechaActual) {
        long diferenciaMillis = fechaActual.getTime() - fechaDevolucion.getTime();
        return diferenciaMillis / (24 * 60 * 60 * 1000);
    }
}
