package control;

import modelo.*;
import vista.*;

public class Ejecutar {

    public static Presentacion vw = new Presentacion();

    public static void main(String[] args) {

        String n = vw.pedirInfo("Ingrese nombre de la universidad:");
        Universidad ud = new Universidad(n);
        int op;

        do {
            String menu = "Menu\n"
                    + "\n1. Crear estudiante."
                    + "\n2. Crear varios estudiantes."
                    + "\n3. Crear equipo."
                    + "\n4. Mostrar estudiantes."
                    + "\n5. Mostrar equipos."
                    + "\n6. Postular estudiante a interuniversitario."
                    + "\n0. Salir";
            op = vw.pedirEntero(menu);
            switch (op) {
                case 1:
                    ud.crearEstudiante();
                    break;

                case 2:
                    int x;
                    x = vw.pedirEntero("Ingrese la cantidad de estudiantes a crear:");
                    for(int i = 0; i<x;i++){
                        ud.crearEstudiante();
                    }
                    break;
                    
                case 3:
                    ud.crearEquipo();
                    break;

                case 4:
                    ud.mostrarEstudiantes();
                    break;

                case 5:
                    ud.mostrarEquipos();
                    break;
            }
        } while (op != 0);

    }

}
