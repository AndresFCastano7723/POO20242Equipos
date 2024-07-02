
package modelo;

public class Equipo {
    private String nombre;
    private int id;
    private Estudiante participante[];

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setParticipante(Estudiante[] participante) {
        this.participante = participante;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public Estudiante[] getParticipante() {
        return participante;
    }

    public Equipo(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }
    
}
