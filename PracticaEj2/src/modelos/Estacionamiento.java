package modelos;


import database.Conexion;

import java.sql.*;
import java.util.ArrayList;



public class Estacionamiento {


    private ArrayList<Vehiculo> vehiculos;



    public Estacionamiento(){

        vehiculos = new ArrayList<>();

    }



    // ==========================
    // REGISTRAR VEHICULO
    // ==========================

    public void registrarVehiculo(Vehiculo v){


        Connection con = Conexion.conectar();


        String sql =
                "INSERT INTO Vehiculo " +
                        "(placa,marca,modelo,color,anio,propietario,horasEstacionado,tipo)" +
                        " VALUES (?,?,?,?,?,?,?,?)";



        try{


            PreparedStatement ps =
                    con.prepareStatement(sql);



            ps.setString(1, v.getPlaca());

            ps.setString(2, v.getMarca());

            ps.setString(3, v.getModelo());

            ps.setString(4, v.getColor());

            ps.setInt(5, v.getAnio());

            ps.setString(6, v.getPropietario());

            ps.setInt(7, v.getHorasEstacionado());

            ps.setString(8, v.getTipo());



            ps.executeUpdate();


            System.out.println("Vehiculo registrado correctamente");


        }catch(Exception e){

            e.printStackTrace();

        }


    }





    // ==========================
    // MOSTRAR VEHICULOS
    // ==========================


    public void mostrarVehiculos(){


        Connection con = Conexion.conectar();



        String sql =
                "SELECT * FROM Vehiculo";



        try{


            PreparedStatement ps =
                    con.prepareStatement(sql);



            ResultSet rs =
                    ps.executeQuery();



            while(rs.next()){


                System.out.println("--------------------");


                System.out.println(
                        "ID: "
                                + rs.getInt("id")
                );


                System.out.println(
                        "Placa: "
                                + rs.getString("placa")
                );


                System.out.println(
                        "Marca: "
                                + rs.getString("marca")
                );


                System.out.println(
                        "Modelo: "
                                + rs.getString("modelo")
                );


                System.out.println(
                        "Tipo: "
                                + rs.getString("tipo")
                );


                System.out.println(
                        "Horas: "
                                + rs.getInt("horasEstacionado")
                );



            }



        }catch(Exception e){

            e.printStackTrace();

        }



    }





    // ==========================
    // BUSCAR POR PLACA
    // ==========================


    public void buscarVehiculo(String placa){


        Connection con = Conexion.conectar();


        String sql =
                "SELECT * FROM Vehiculo WHERE placa=?";



        try{


            PreparedStatement ps =
                    con.prepareStatement(sql);



            ps.setString(1, placa);



            ResultSet rs =
                    ps.executeQuery();



            if(rs.next()){


                System.out.println("Vehiculo encontrado");

                System.out.println(
                        rs.getString("marca")
                );

                System.out.println(
                        rs.getString("modelo")
                );

                System.out.println(
                        rs.getString("tipo")
                );


            }
            else{


                System.out.println(
                        "No existe ese vehiculo"
                );


            }



        }catch(Exception e){

            e.printStackTrace();

        }



    }





    // ==========================
    // ACTUALIZAR
    // ==========================


    public void actualizarVehiculo(
            String placa,
            String color,
            int horas
    ){


        Connection con =
                Conexion.conectar();



        String sql =
                "UPDATE Vehiculo SET color=?, horasEstacionado=? WHERE placa=?";



        try{


            PreparedStatement ps =
                    con.prepareStatement(sql);



            ps.setString(1,color);

            ps.setInt(2,horas);

            ps.setString(3,placa);



            ps.executeUpdate();


            System.out.println(
                    "Vehiculo actualizado"
            );



        }catch(Exception e){

            e.printStackTrace();

        }


    }





    // ==========================
    // ELIMINAR
    // ==========================


    public void eliminarVehiculo(String placa){


        Connection con =
                Conexion.conectar();



        String sql =
                "DELETE FROM Vehiculo WHERE placa=?";



        try{


            PreparedStatement ps =
                    con.prepareStatement(sql);



            ps.setString(1, placa);



            ps.executeUpdate();


            System.out.println(
                    "Vehiculo eliminado"
            );


        }catch(Exception e){

            e.printStackTrace();

        }



    }





    // ==========================
    // REPORTE INGRESOS
    // ==========================


    public void reporteIngresos(){


        Connection con =
                Conexion.conectar();



        String sql =
                "SELECT tipo, COUNT(*) cantidad FROM Vehiculo GROUP BY tipo";



        try{


            PreparedStatement ps =
                    con.prepareStatement(sql);



            ResultSet rs =
                    ps.executeQuery();



            while(rs.next()){


                System.out.println(
                        rs.getString("tipo")
                                +
                                " : "
                                +
                                rs.getInt("cantidad")
                                +
                                " vehiculos"
                );


            }



        }catch(Exception e){

            e.printStackTrace();

        }



    }



}