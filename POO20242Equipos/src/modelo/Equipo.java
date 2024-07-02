package modelo;

import java.util.ArrayList;

public class Equipo {

    private String nombre;
    private int id;
    ArrayList<Estudiante> jugador = new ArrayList<>();

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public Equipo(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

}
