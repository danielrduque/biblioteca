public class Usuario {
    private int id;
    private String nombre;
    private String numeroIdentificacion;

    public Usuario(int id, String nombre, String numeroIdentificacion) {
        this.id = id;
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }
}
