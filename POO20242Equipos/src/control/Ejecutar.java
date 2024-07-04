package control;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.*;
import vista.*;

public class Ejecutar {

    public static Presentacion vw = new Presentacion();

    public static void main(String[] args) {

        String n = vw.pedirInfo("Ingrese nombre de la universidad:");
        Universidad ud = new Universidad(n);
        int op;

        do {
            String menu = "Menu"
                    + "\n 1. Crear estudiante."
                    + "\n 2. Crear varios estudiantes."
                    + "\n 3. Crear equipo."
                    + "\n 4. Mostrar estudiantes."
                    + "\n 5. Mostrar equipos."
                    + "\n 6. Postular estudiante a interuniversitario."
                    + "\n 7. Mostrar participantes."
                    + "\n 8. Enviar participantes a equipos."
                    + "\n 9. Guardar información."
                    + "\n10. Cargar información."
                    + "\n 0. Salir";
            op = vw.pedirEntero(menu);
            switch (op) {
                case 1:
                    ud.crearEstudiante();
                    break;

                case 2:
                    int x;
                    x = vw.pedirEntero("Ingrese la cantidad de estudiantes a crear:");
                    for (int i = 0; i < x; i++) {
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

                case 6:
                    ud.ingresarParticipante();
                    break;

                case 7:
                    ud.mostrarParticipantes();
                    break;

                case 8:
                    ud.ingresaraEquipos();
                    break;

                case 9:
                    ud.almacenarTP();
                    break;

                case 10: 
                    ud.cargarTP();
                    break;
            }
        } while (op != 0);
        if (op == 0) {

        }

    }

}
