package tarifas;


public class TarifaCamion implements Tarifa {



    @Override
    public double calcular(int horas) {


        return (horas * 4.00) + 5.00;


    }


}