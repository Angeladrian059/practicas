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
            switch (opcion) {

                case 1:

                    Alumno alumno = new Alumno();

                    System.out.print("Matrícula: ");
                    alumno.setMatricula(sc.nextLine());

                    System.out.print("Nombre: ");
                    alumno.setNombre(sc.nextLine());

                    System.out.print("Edad: ");
                    alumno.setEdad(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Sexo (M/F): ");
                    alumno.setSexo(sc.nextLine());

                    System.out.print("Correo: ");
                    alumno.setCorreo(sc.nextLine());

                    alumno.save();

                    break;

                case 2:

                    ArrayList<Alumno> lista = Alumno.getAll();

                    if (lista.isEmpty()) {

                        System.out.println("No hay alumnos registrados.");

                    } else {

                        for (Alumno a : lista) {

                            System.out.println("--------------------------------");
                            System.out.println("ID: " + a.getId());
                            System.out.println("Matrícula: " + a.getMatricula());
                            System.out.println("Nombre: " + a.getNombre());
                            System.out.println("Edad: " + a.getEdad());
                            System.out.println("Sexo: " + a.getSexo());
                            System.out.println("Correo: " + a.getCorreo());

                        }

                    }

                    break;

                case 3:

                    System.out.print("Ingrese la matrícula del alumno: ");
                    String matricula = sc.nextLine();

                    Alumno actualizar = Alumno.findByMatricula(matricula);

                    if (actualizar == null) {

                        System.out.println("Alumno no encontrado.");

                    } else {

                        System.out.print("Nuevo nombre: ");
                        actualizar.setNombre(sc.nextLine());

                        System.out.print("Nueva edad: ");
                        actualizar.setEdad(sc.nextInt());
                        sc.nextLine();

                        System.out.print("Nuevo sexo: ");
                        actualizar.setSexo(sc.nextLine());

                        System.out.print("Nuevo correo: ");
                        actualizar.setCorreo(sc.nextLine());

                        actualizar.update();

                    }

                    break;

                case 4:

                    System.out.print("Ingrese la matrícula del alumno: ");
                    String eliminar = sc.nextLine();

                    Alumno.deleteByMatricula(eliminar);

                    break;

                case 5:

                    Alumno.countBySexo();

                    break;

                case 6:

                    System.out.println("Programa finalizado.");

                    break;

                default:

                    System.out.println("Opción no válida.");

            }

        } while (opcion != 6);


    }

}

