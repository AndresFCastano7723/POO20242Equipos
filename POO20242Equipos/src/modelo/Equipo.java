package modelo;

import java.util.ArrayList;
import vista.Presentacion;

public class Equipo {
    Presentacion vw = new Presentacion();
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
    
    public void crearJugador(String nombre, int id, float promTotal){
        if(validarPromedio(promTotal)){
            Estudiante e = new Estudiante(nombre, id, promTotal);
            jugador.add(e);
        }
    }
    
    public String mostrarJugadores() {
        String msg = "";
        int a = 1;
        for (Estudiante e : jugador) {
            msg +="["+ a + "] Nombre: " + e.getNombre() + "   ID: " + e.getId() + "   Promedio Total: " + e.getPromTotal()+ "\n";
            a++;
        }
        return msg;
    }
    
    public boolean validarPromedio(float a){
        return a>3.5 && a<=5;
    }

}
