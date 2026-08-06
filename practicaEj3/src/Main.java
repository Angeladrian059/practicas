import estrategias.*;
import modelos.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmpresaMensajeria empresa = new EmpresaMensajeria();

        int opcion;

        do {

            System.out.println("\n========= MENÚ =========");
            System.out.println("1. Registrar paquete");
            System.out.println("2. Mostrar paquetes");
            System.out.println("3. Buscar paquete");
            System.out.println("4. Actualizar paquete");
            System.out.println("5. Eliminar paquete");
            System.out.println("6. Reporte de ingresos");
            System.out.println("7. Contar envíos por tipo");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Destinatario: ");
                    String destinatario = sc.nextLine();

                    System.out.print("Remitente: ");
                    String remitente = sc.nextLine();

                    System.out.print("Dirección destino: ");
                    String direccion = sc.nextLine();

                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();

                    System.out.print("Peso (kg): ");
                    double peso = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Contenido: ");
                    String contenido = sc.nextLine();

                    System.out.print("Número de guía: ");
                    String guia = sc.nextLine();

                    System.out.println("\nTipo de envío");
                    System.out.println("1. Estándar");
                    System.out.println("2. Express");
                    System.out.println("3. Internacional");
                    System.out.print("Opción: ");

                    int tipo = sc.nextInt();
                    sc.nextLine();

                    Paquete paquete;

                    switch (tipo) {

                        case 1:

                            paquete = new PaqueteEstandar(
                                    destinatario,
                                    remitente,
                                    direccion,
                                    telefono,
                                    peso,
                                    contenido,
                                    guia,
                                    new EnvioEstandar());

                            break;

                        case 2:

                            paquete = new PaqueteExpress(
                                    destinatario,
                                    remitente,
                                    direccion,
                                    telefono,
                                    peso,
                                    contenido,
                                    guia,
                                    new EnvioExpress());

                            break;

                        default:

                            paquete = new PaqueteInternacional(
                                    destinatario,
                                    remitente,
                                    direccion,
                                    telefono,
                                    peso,
                                    contenido,
                                    guia,
                                    new EnvioInternacional());

                    }

                    empresa.registrarPaquete(paquete);

                    break;

                case 2:

                    empresa.mostrarPaquetes();

                    break;

                case 3:

                    System.out.print("Número de guía: ");

                    empresa.buscarPaquete(sc.nextLine());

                    break;

                case 4:

                    System.out.println("=== ACTUALIZAR PAQUETE ===");

                    System.out.print("Número de guía: ");
                    guia = sc.nextLine();

                    System.out.print("Nuevo destinatario: ");
                    destinatario = sc.nextLine();

                    System.out.print("Nuevo remitente: ");
                    remitente = sc.nextLine();

                    System.out.print("Nueva dirección: ");
                    direccion = sc.nextLine();

                    System.out.print("Nuevo teléfono: ");
                    telefono = sc.nextLine();

                    System.out.print("Nuevo peso: ");
                    peso = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Nuevo contenido: ");
                    contenido = sc.nextLine();

                    System.out.println("Tipo");
                    System.out.println("1. Estándar");
                    System.out.println("2. Express");
                    System.out.println("3. Internacional");

                    tipo = sc.nextInt();
                    sc.nextLine();

                    switch (tipo) {

                        case 1:

                            paquete = new PaqueteEstandar(
                                    destinatario,
                                    remitente,
                                    direccion,
                                    telefono,
                                    peso,
                                    contenido,
                                    guia,
                                    new EnvioEstandar());

                            break;

                        case 2:

                            paquete = new PaqueteExpress(
                                    destinatario,
                                    remitente,
                                    direccion,
                                    telefono,
                                    peso,
                                    contenido,
                                    guia,
                                    new EnvioExpress());

                            break;

                        default:

                            paquete = new PaqueteInternacional(
                                    destinatario,
                                    remitente,
                                    direccion,
                                    telefono,
                                    peso,
                                    contenido,
                                    guia,
                                    new EnvioInternacional());

                    }

                    empresa.actualizarPaquete(paquete);

                    break;

                case 5:

                    System.out.print("Número de guía: ");

                    empresa.eliminarPaquete(sc.nextLine());

                    break;

                case 6:

                    empresa.reporteIngresos();

                    break;

                case 7:

                    empresa.contarTipos();

                    break;

                case 8:

                    System.out.println("Programa finalizado.");

                    break;

                default:

                    System.out.println("Opción inválida.");

            }

        } while (opcion != 8);

        sc.close();

    }

}