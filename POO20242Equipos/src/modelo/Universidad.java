package modelo;

import java.util.ArrayList;
import persistencia.ArchivoPlano;
import vista.Presentacion;

public class Universidad {

    Presentacion vw = new Presentacion();
    private String nombre;
    ArrayList<Estudiante> part = new ArrayList<>();
    ArrayList<Estudiante> estudiante = new ArrayList<>();
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
        int id;
        float pg;
        String n;
        n = vw.pedirInfo("Ingrese nombre del estudiante:");
        do {
            id = vw.pedirEntero("Ingrese ID del estudiante:");
        } while (!validarID1(id));
        do {
            pg = vw.pedirDecimales("Ingrese promedio general de la carrera:");
        } while (!v.validarNota(pg));
        Estudiante e = new Estudiante(n, id, pg);
        estudiante.add(e);

    }

    public void crearEquipo() {
        int id;
        String n;
        n = vw.pedirInfo("Ingrese nombre del equipo:");
        id = vw.pedirEntero("Ingrese ID del equipo");
        Equipo eq = new Equipo(n, id);
        equipo.add(eq);

    }

    public void mostrarEstudiantes() {
        String msg = "";
        int a = 1;
        for (Estudiante e : estudiante) {
            msg += a + ".  Nombre: " + e.getNombre() + "   ID: " + e.getId() + "    Promedio General: " + e.getPrmGeneral() + "\n";
            a++;
        }
        vw.mostrarRes(msg);
    }
//
//    public void mostrarEquipos() {
//        String msg = "";
//        int a = 1;
//        for (Equipo e : equipo) {
//            msg += a + ".\nNombre: " + e.getNombre() + "\nID: " + e.getId() + "\n";
//            a++;
//        }
//        vw.mostrarRes(msg);
//    }

    public void ingresarParticipante() {
        int id, aux;
        float pg;
        String n;
        do {
            aux = vw.pedirEntero("Ingrese ID del estudiante a participar:");
        } while (!validarID2(aux));
        for (Estudiante e : estudiante) {
            if (e.getId() == aux) {
                if (e.getPrmGeneral() >= 3.8) {
                    n = e.getNombre();
                    id = e.getId();
                    pg = e.getPrmGeneral();
                    Estudiante estd = new Estudiante(n, id, pg);
                    String shw = """
                               Estudiante a participar
                               """ + e.getNombre()
                            + "\n" + e.getId()
                            + "\n" + e.getPrmGeneral();
                    vw.mostrarRes(shw);
                    vw.mostrarRes("Acontinuacion se realizaran 3 pruebas, indique nombre y nota de cada una.");
                    estd.crearPrueba(3);
                    estd.promediar();
                    part.add(estd);
                    String msg2 = "" + e.getNombre() + "\n" + e.getId() + "\nPromedio Total: " + estd.getPromTotal();
                    vw.mostrarRes(msg2);
                }
            }
        }
    }

    public void mostrarParticipantes() {
        String txt = "";
        int a = 1;
        for (int i = 0; i < part.size(); i++) {
            txt += a + ".  Nombre: " + part.get(i).getNombre() + "   ID: " + part.get(i).getId() + "   Promedio Total: " + part.get(i).getPromTotal() + "\n";
            a++;
        }
        vw.mostrarRes(txt);
    }

    public void ingresaraEquipos() {
        Equipo e1 = equipo.get(0);
        Equipo e2 = equipo.get(1);
        Equipo e3 = equipo.get(2);
        int a, b, c;
        for (a = 0, b = 1, c = 2; c < 15 || b < 15 || a < 15; a += 3, b += 3, c += 3) {
            String nA = part.get(a).getNombre();
            int idA = part.get(a).getId();
            float ptA = part.get(a).getPromTotal();
            String nB = part.get(b).getNombre();//Aquí hay un error :D
            int idB = part.get(b).getId();
            float ptB = part.get(b).getPromTotal();
            String nC = part.get(c).getNombre();
            int idC = part.get(c).getId();
            float ptC = part.get(c).getPromTotal();
            e1.crearJugador(nA, idA, ptA);
            e2.crearJugador(nB, idB, ptB);
            e3.crearJugador(nC, idC, ptC);
        }
    }

    public void mostrarEquipos() {
        String msg = "";
        int a = 1;
        for (Equipo eq : equipo) {
            msg += a + ".  Nombre: " + eq.getNombre() + "  ID: " + eq.getId() + "\nJugadores:\n";
            msg += eq.mostrarJugadores() + "\n\n";
            a++;
        }
        vw.mostrarRes(msg);
    }

    public void almacenarTP() {
        ArrayList<String> lineasEstudiantes = new ArrayList<String>();
        for (Estudiante e : estudiante) {
            lineasEstudiantes.add(e.getNombre() + ";" + e.getId() + ";" + e.getPrmGeneral() + ";" + e.getPromTotal());
        }
        ArchivoPlano.almacenar("estudiantes.csv", lineasEstudiantes);
        
        ArrayList<String> lineasParticipantes = new ArrayList<String>();
        for (Estudiante e : part) {
            lineasParticipantes.add(
                    e.getNombre() + ";" 
                    + e.getId() + ";" 
                    + e.getPrmGeneral() + ";" 
                    + e.getPromTotal() + ";" 
                    + e.getPruebas().get(0).getNombre()+ ";" 
                    + e.getPruebas().get(0).getNota() + ";" 
                    + e.getPruebas().get(1).getNombre() + ";" 
                    + e.getPruebas().get(1).getNota() + ";" 
                    + e.getPruebas().get(2).getNombre() + ";" 
                    + e.getPruebas().get(2).getNota());
        }
        ArchivoPlano.almacenar("participantes.csv", lineasParticipantes);
        
        ArrayList<String> lineasEquipos = new ArrayList<String>();
        for (Equipo eq : equipo) {
            lineasEquipos.add(eq.getNombre() + ";" + eq.getId());
        }
        ArchivoPlano.almacenar("equipos.csv", lineasEquipos);
        vw.mostrarRes("Informacion guardada");
    }
    
    public void cargarTP() {
		ArrayList<String> lineasEstudiantes = ArchivoPlano.cargar("estudiantes.csv");
		for(String linea : lineasEstudiantes) {
			String datos[] = linea.split(";");
                        String n = datos[0];
                        int id = Integer.parseInt(datos[1]);
                        float pg = Float.parseFloat(datos[2]);
                        Estudiante e = new Estudiante(n, id, pg);
                        estudiante.add(e);
		}
		ArrayList<String> lineasParticipantes = ArchivoPlano.cargar("participantes.csv");
		for(String linea : lineasParticipantes) {
			String datos[] = linea.split(";");
			String n = datos[0];
                        int id = Integer.parseInt(datos[1]);
                        float pg = Float.parseFloat(datos[2]);
                        float pt = Float.parseFloat(datos[3]);
                        Estudiante e = new Estudiante(n, id, pg);
                        e.setPromTotal(pt);
                        Prueba pr1 = new Prueba(datos[4], Float.parseFloat(datos[5]));
                        Prueba pr2 = new Prueba(datos[6], Float.parseFloat(datos[7]));
                        Prueba pr3 = new Prueba(datos[8], Float.parseFloat(datos[9]));
                        e.pruebas.add(pr1);
                        e.pruebas.add(pr2);
                        e.pruebas.add(pr3);
                        part.add(e);
		}
                
                ArrayList<String> lineasEquipos = ArchivoPlano.cargar("equipos.csv");
                for(String linea : lineasEquipos){
                    String datos[] = linea.split(";");
                    String n = datos[0];
                    int id = Integer.parseInt(datos[1]);
                    Equipo eq = new Equipo(n, id);
                    equipo.add(eq);
                }
                vw.mostrarRes("Informacion cargada");
	}

    private boolean validarID1(int a) {
        for (Estudiante e : estudiante) {
            if (a == e.getId()) {
                vw.mostrarRes("ID ya existente.");
                return false;
            }
        }
        return true;
    }

    private boolean validarID2(int a) {
        for (Estudiante e : part) {
            if (a == e.getId()) {
                vw.mostrarRes("ID ya existente.");
                return false;
            }
        }
        return true;
    }

    public boolean validarIdEquipo(int a) {
        for (Equipo e : equipo) {
            if (a == e.getId()) {
                return false;
            }
        }
        return true;
    }
}
