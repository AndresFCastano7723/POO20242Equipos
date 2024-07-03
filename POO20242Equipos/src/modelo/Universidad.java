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
        do{
            id = vw.pedirEntero("Ingrese ID del estudiante:");
        }while(!validarID(id));        
        do {
            pg = vw.pedirDecimales("Ingrese promedio general de la carrera:");
        } while (!v.validarNota(pg));
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

    public void ingresarParticipante() {
        Presentacion vw = new Presentacion();
        int id, aux;
        float pg;
        String n;
        aux = vw.pedirEntero("Ingrese ID del estudiante a participar:");
        for (Estudiante e : est) {
            if (e.getId() == aux) {
                if (e.getPrmGeneral() >= 3.8) {
                    n = e.getNombre();
                    id = e.getId();
                    pg = e.getPrmGeneral();
                    Estudiante estd = new Estudiante(n, id, pg);
                    String shw="Estudiante a participar"
                            + "\n"+ e.getNombre() 
                            +"\n"+e.getId()
                            +"\n"+e.getPrmGeneral();
                    vw.mostrarRes(shw);
                    vw.mostrarRes("Acontinuacion se realizaran 3 pruebas, indique nombre y nota de cada una.");
                    estd.crearPrueba(3);
                    estd.promediar();
                    String msg2=""+e.getNombre()+"\n"+e.getId()+"\nPromedio Total: "+estd.getPromTotal();
                    vw.mostrarRes(msg2);
                }
            }
        }
    }
    
    public void mostrarParticipantes(){
        String msg = "";
        int a = 1;
        for (Estudiante e : part) {
            msg += a + ".\nNombre: " + e.getNombre() + "\t\tID: " + e.getId() + "\nPromedio General: " + e.getPrmGeneral() + "\n";
            a++;
        }
        vw.mostrarRes(msg);
    }

    private boolean validarID(int a) {
        for(Estudiante e : est){
            if(a == e.getId()){
                vw.mostrarRes("ID ya existente.");
                return false;
            }
        }
        return true;
    }
}
