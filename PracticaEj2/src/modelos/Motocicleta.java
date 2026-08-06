package modelos;


import tarifas.Tarifa;



public class Motocicleta extends Vehiculo {


    private int cilindrada;

    private boolean cascoGuardado;




    public Motocicleta(
            String placa,
            String marca,
            String modelo,
            String color,
            int anio,
            String propietario,
            int horas,
            Tarifa tarifa,
            int cilindrada,
            boolean cascoGuardado
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


        this.cilindrada = cilindrada;

        this.cascoGuardado = cascoGuardado;


    }




    @Override
    public String getTipo(){

        return "Motocicleta";

    }




    public int getCilindrada(){

        return cilindrada;

    }


}