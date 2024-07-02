package modelo;

import java.util.ArrayList;
import vista.Presentacion;

public class Estudiante {

    Presentacion vw = new Presentacion();
    private String nombre;
    private int id;
    private float prmGeneral;
    ArrayList<Prueba> pruebas = new ArrayList<>();
    private float promTotal;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrmGeneral() {
        return prmGeneral;
    }

    public void setPrmGeneral(float prmGeneral) {
        this.prmGeneral = prmGeneral;
    }

    public float getPromTotal() {
        return promTotal;
    }

    public Estudiante(String nombre, int id, float prmGeneral) {
        this.nombre = nombre;
        this.id = id;
        this.prmGeneral = prmGeneral;
    }

    public void crearPrueba() {
        int cnt = vw.pedirEntero("Ingrese la cantidad de pruebas:");
        String n;
        float nt;
        for (int i = 0; i < cnt; i++) {
            n = vw.pedirInfo("Ingrese nombre de la prueba #" + (i + 1) + ":");
            nt = vw.pedirDecimales("Ingrese nota de la prueba #" + (i + 1) + ":");
            Prueba pr = new Prueba(n, nt);
            pruebas.add(pr);
        }
    }

    public float promediar() {
        float sum = 0;
        int ct = 1;
        for (int i = 0; i < pruebas.size(); i++) {
            sum += pruebas.get(i).getNota();
            ct++;
        }
        this.promTotal= ((sum/ct)+this.prmGeneral)/2;
        return this.promTotal;
    }

}
