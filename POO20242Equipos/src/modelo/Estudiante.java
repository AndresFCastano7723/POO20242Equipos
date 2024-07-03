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

    public void setPromTotal(float promTotal) {
        this.promTotal = promTotal;
    }

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

    public void crearPrueba(int a) {
        Validacion v = new Validacion();
        int cnt = a;
        String n;
        float nt;
        for (int i = 0; i < cnt; i++) {
            n = vw.pedirInfo("Ingrese nombre de la prueba #" + (i + 1) + ":");
            do{
                nt = vw.pedirDecimales("Ingrese nota de la prueba #" + (i + 1) + ":");
            }while(!v.validarNota(nt));            
            Prueba pr = new Prueba(n, nt);
            pruebas.add(pr);
        }
    }

    public void promediar() {
        float sum = 0;
        int ct = 0;
        for (Prueba pr : pruebas) {
            sum += pr.getNota();
            ct++;
        }
        float prom = sum / ct;
        String msg ="Promedio de pruebas: "+prom+"\nPromedio General: "+this.prmGeneral;
        vw.mostrarRes(msg);
        float promT = (prom+this.prmGeneral)/2;
        setPromTotal(promT);
    }

}
