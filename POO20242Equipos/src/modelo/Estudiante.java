
package modelo;

public class Estudiante {
    private String nombre;
    private int id;
    private Nota prmGeneral;
    private Prueba pruebas[];
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

    public Nota getPrmGeneral() {
        return prmGeneral;
    }

    public void setPrmGeneral(Nota prmGeneral) {
        this.prmGeneral = prmGeneral;
    }

    public Prueba[] getPruebas() {
        return pruebas;
    }

    public void setPruebas(Prueba[] pruebas) {
        this.pruebas = pruebas;
    }

    public float getPromTotal() {
        return promTotal;
    }

    public void setPromTotal(float promTotal) {
        this.promTotal = promTotal;
    }

    public Estudiante(String nombre, int id, Nota prmGeneral) {
        this.nombre = nombre;
        this.id = id;
        this.prmGeneral = prmGeneral;
    }
    
    
    
    
}
