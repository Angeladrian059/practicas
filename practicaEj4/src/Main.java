import estrategias.*;
import modelos.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PlataformaStreaming plataforma = new PlataformaStreaming();

        int opcion;

        do {

            System.out.println("\n========== PLATAFORMA STREAMING ==========");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Mostrar usuarios");
            System.out.println("3. Buscar usuario");
            System.out.println("4. Actualizar usuario");
            System.out.println("5. Eliminar usuario");
            System.out.println("6. Reporte de ingresos");
            System.out.println("7. Contar planes");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Correo electrónico: ");
                    String correo = sc.nextLine();

                    System.out.print("Nombre de usuario: ");
                    String nombre = sc.nextLine();

                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();

                    System.out.print("País: ");
                    String pais = sc.nextLine();

                    System.out.print("Meses contratados: ");
                    int meses = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\nTipo de Plan");
                    System.out.println("1. Básico");
                    System.out.println("2. Estándar");
                    System.out.println("3. Premium");
                    System.out.print("Opción: ");

                    int tipo = sc.nextInt();
                    sc.nextLine();

                    CuentaUsuario cuenta;

                    switch (tipo) {

                        case 1:

                            cuenta = new CuentaBasica(
                                    correo,
                                    nombre,
                                    telefono,
                                    pais,
                                    meses,
                                    new PlanBasico());

                            break;

                        case 2:

                            cuenta = new CuentaEstandar(
                                    correo,
                                    nombre,
                                    telefono,
                                    pais,
                                    meses,
                                    new PlanEstandar());

                            break;

                        default:

                            cuenta = new CuentaPremium(
                                    correo,
                                    nombre,
                                    telefono,
                                    pais,
                                    meses,
                                    new PlanPremium());

                    }

                    plataforma.registrarUsuario(cuenta);

                    break;

                case 2:

                    plataforma.mostrarUsuarios();

                    break;

                case 3:

                    System.out.print("Correo electrónico: ");

                    plataforma.buscarUsuario(sc.nextLine());

                    break;

                case 4:

                    System.out.print("Correo electrónico: ");
                    correo = sc.nextLine();

                    System.out.print("Nuevo nombre: ");
                    nombre = sc.nextLine();

                    System.out.print("Nuevo teléfono: ");
                    telefono = sc.nextLine();

                    System.out.print("Nuevo país: ");
                    pais = sc.nextLine();

                    System.out.print("Meses contratados: ");
                    meses = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Tipo de Plan");
                    System.out.println("1. Básico");
                    System.out.println("2. Estándar");
                    System.out.println("3. Premium");

                    tipo = sc.nextInt();
                    sc.nextLine();

                    switch (tipo) {

                        case 1:

                            cuenta = new CuentaBasica(
                                    correo,
                                    nombre,
                                    telefono,
                                    pais,
                                    meses,
                                    new PlanBasico());

                            break;

                        case 2:

                            cuenta = new CuentaEstandar(
                                    correo,
                                    nombre,
                                    telefono,
                                    pais,
                                    meses,
                                    new PlanEstandar());

                            break;

                        default:

                            cuenta = new CuentaPremium(
                                    correo,
                                    nombre,
                                    telefono,
                                    pais,
                                    meses,
                                    new PlanPremium());

                    }

                    plataforma.actualizarUsuario(cuenta);

                    break;

                case 5:

                    System.out.print("Correo electrónico: ");

                    plataforma.eliminarUsuario(sc.nextLine());

                    break;

                case 6:

                    plataforma.reporteIngresos();

                    break;

                case 7:

                    plataforma.contarPlanes();

                    break;

                case 8:

                    System.out.println("Programa finalizado.");

                    break;

                default:

                    System.out.println("Opción inválida.");

            }

        } while (opcion != 8);



    }

}