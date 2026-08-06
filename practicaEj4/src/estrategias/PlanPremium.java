package estrategias;

public class PlanPremium implements PlanSuscripcion {

    @Override
    public double calcularCosto(int meses) {

        return (meses * 14.0) + 3.0;

    }

}