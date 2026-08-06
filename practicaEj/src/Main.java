//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import modelos.Alumno;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;
        do {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Registrar alumno");
            System.out.println("2. Mostrar alumnos");
            System.out.println("3. Actualizar alumno");
            System.out.println("4. Eliminar alumno");
            System.out.println("5. Contar hombres y mujeres");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

    }
}