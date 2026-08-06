package tarifas;


public class TarifaAuto implements Tarifa {



    @Override
    public double calcular(int horas) {


        return horas * 2.00;


    }


}