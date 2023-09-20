public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private String genero;
    private double multaPorDia;

    public Libro(int id, String titulo, String autor, String genero, double multaPorDia) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.multaPorDia = multaPorDia;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public double getMultaPorDia() {
        return multaPorDia;
    }
}
