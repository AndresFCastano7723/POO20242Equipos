package modelo;

import java.util.ArrayList;
import vista.Presentacion;

public class Universidad {

    Presentacion vw = new Presentacion();
    private String nombre;
    ArrayList<Estudiante> part = new ArrayList<>();
    ArrayList<Estudiante> est = new ArrayList<>();
    ArrayList<Equipo> equipo = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Universidad(String nombre) {
        this.nombre = nombre;
    }

    public void crearEstudiante() {
        Validacion v = new Validacion();
        int id, op;
        float pg;
        String n;
        n = vw.pedirInfo("Ingrese nombre del estudiante:");
        id = vw.pedirEntero("Ingrese ID del estudiante:");
        do {
            pg = vw.pedirDecimales("Ingrese promedio general de la carrera:");
        } while (!v.validarPromedio(pg));
        Estudiante e = new Estudiante(n, id, pg);
        est.add(e);

    }

    public void crearEquipo() {
        int id, op;
        String n;
        n = vw.pedirInfo("Ingrese nombre del equipo:");
        id = vw.pedirEntero("Ingrese ID del equipo");
        Equipo eq = new Equipo(n, id);
        equipo.add(eq);

    }

    public void mostrarEstudiantes() {
        String msg = "";
        int a = 1;
        for (Estudiante e : est) {
            msg += a + ".\nNombre: " + e.getNombre() + "\nID: " + e.getId() + "\nPromedio General: " + e.getPrmGeneral() + "\n";
            a++;
        }
        vw.mostrarRes(msg);
    }

    public void mostrarEquipos() {
        String msg = "";
        int a = 1;
        for (Equipo e : equipo) {
            msg += a + ".\nNombre: " + e.getNombre() + "\nID: " + e.getId() + "\n";
            a++;
        }
        vw.mostrarRes(msg);
    }
}
