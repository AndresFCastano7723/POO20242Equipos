package modelo;

public class Prueba {

    private String nombre;
    private float nota;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Prueba(String nombre, float nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

}
