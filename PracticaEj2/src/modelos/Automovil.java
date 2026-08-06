package modelos;


import tarifas.Tarifa;



public class Automovil extends Vehiculo {


    private int numeroPuertas;

    private boolean aireAcondicionado;



    public Automovil(
            String placa,
            String marca,
            String modelo,
            String color,
            int anio,
            String propietario,
            int horas,
            Tarifa tarifa,
            int numeroPuertas,
            boolean aireAcondicionado
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


        this.numeroPuertas = numeroPuertas;

        this.aireAcondicionado = aireAcondicionado;


    }



    @Override
    public String getTipo(){

        return "Automovil";

    }



    public int getNumeroPuertas(){

        return numeroPuertas;

    }


}