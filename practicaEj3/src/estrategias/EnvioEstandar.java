package estrategias;

public class EnvioEstandar implements EstrategiaEnvio{

    @Override
    public double calcularCosto(double pesoKg){

        return pesoKg * 2.0;

    }

}