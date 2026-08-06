package estrategias;

public class EnvioInternacional implements EstrategiaEnvio{

    @Override
    public double calcularCosto(double pesoKg){

        return (pesoKg * 6) + 10;

    }

}