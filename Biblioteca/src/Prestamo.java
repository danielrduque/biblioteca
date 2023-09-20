import java.util.Date;

public class Prestamo {
    private int idUsuario;
    private Libro libro;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private double multa;

    public Prestamo(int idUsuario, Libro libro, Date fechaPrestamo, Date fechaDevolucion) {
        this.idUsuario = idUsuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.multa = 0;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }
}
