package modelos;


import tarifas.Tarifa;



public class Camion extends Vehiculo {


    private double capacidadCarga;

    private int numeroEjes;




    public Camion(
            String placa,
            String marca,
            String modelo,
            String color,
            int anio,
            String propietario,
            int horas,
            Tarifa tarifa,
            double capacidadCarga,
            int numeroEjes
    ){


        super(
                placa,
                marca,
                modelo,
                color,
                anio,
                propietario,
                horas,
                tarifa
        );


        this.capacidadCarga = capacidadCarga;

        this.numeroEjes = numeroEjes;


    }




    @Override
    public String getTipo(){

        return "Camion";

    }





    public double getCapacidadCarga(){

        return capacidadCarga;

    }



}