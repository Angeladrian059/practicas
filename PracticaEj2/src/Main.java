import modelos.*;
import tarifas.*;

import java.util.Scanner;



public class Main {


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);


        Estacionamiento estacionamiento =
                new Estacionamiento();



        int opcion;



        do{


            System.out.println("\n====== ESTACIONAMIENTO ======");

            System.out.println("1. Registrar vehiculo");

            System.out.println("2. Mostrar vehiculos");

            System.out.println("3. Buscar vehiculo");

            System.out.println("4. Actualizar vehiculo");

            System.out.println("5. Eliminar vehiculo");

            System.out.println("6. Reporte");

            System.out.println("7. Salir");


            System.out.print("Opcion: ");

            opcion=sc.nextInt();



            switch(opcion){


                case 1:


                    sc.nextLine();


                    System.out.print("Placa: ");
                    String placa=sc.nextLine();


                    System.out.print("Marca: ");
                    String marca=sc.nextLine();


                    System.out.print("Modelo: ");
                    String modelo=sc.nextLine();


                    System.out.print("Color: ");
                    String color=sc.nextLine();


                    System.out.print("Año: ");
                    int anio=sc.nextInt();


                    sc.nextLine();


                    System.out.print("Propietario: ");
                    String propietario=sc.nextLine();


                    System.out.print("Horas: ");
                    int horas=sc.nextInt();



                    System.out.println("Tipo:");

                    System.out.println("1 Automovil");

                    System.out.println("2 Motocicleta");

                    System.out.println("3 Camion");


                    int tipo=sc.nextInt();



                    Vehiculo v;



                    if(tipo==1){


                        v=new Automovil(
                                placa,
                                marca,
                                modelo,
                                color,
                                anio,
                                propietario,
                                horas,
                                new TarifaAuto(),
                                4,
                                true
                        );


                    }

                    else if(tipo==2){


                        v=new Motocicleta(
                                placa,
                                marca,
                                modelo,
                                color,
                                anio,
                                propietario,
                                horas,
                                new TarifaMoto(),
                                250,
                                true
                        );


                    }

                    else{


                        v=new Camion(
                                placa,
                                marca,
                                modelo,
                                color,
                                anio,
                                propietario,
                                horas,
                                new TarifaCamion(),
                                5000,
                                4
                        );


                    }



                    estacionamiento.registrarVehiculo(v);


                    break;




                case 2:

                    estacionamiento.mostrarVehiculos();

                    break;



                case 3:

                    sc.nextLine();

                    System.out.print("Placa: ");

                    estacionamiento.buscarVehiculo(
                            sc.nextLine()
                    );

                    break;




                case 4:

                    sc.nextLine();

                    System.out.print("Placa: ");
                    String p=sc.nextLine();


                    System.out.print("Nuevo color: ");
                    String c=sc.nextLine();


                    System.out.print("Nuevas horas: ");
                    int h=sc.nextInt();



                    estacionamiento.actualizarVehiculo(
                            p,c,h
                    );


                    break;




                case 5:

                    sc.nextLine();

                    System.out.print("Placa: ");

                    estacionamiento.eliminarVehiculo(
                            sc.nextLine()
                    );


                    break;



                case 6:

                    estacionamiento.reporteIngresos();

                    break;



            }



        }while(opcion!=7);



    }


}