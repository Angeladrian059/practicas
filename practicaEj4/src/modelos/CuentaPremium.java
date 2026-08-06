package modelos;

import estrategias.PlanSuscripcion;

public class CuentaPremium extends CuentaUsuario {

    public CuentaPremium(String correoElectronico,
                         String nombreUsuario,
                         String telefono,
                         String pais,
                         int mesesActivo,
                         PlanSuscripcion plan) {

        super(correoElectronico,
                nombreUsuario,
                telefono,
                pais,
                mesesActivo,
                plan);
    }

    @Override
    public String getTipoPlan() {
        return "Premium";
    }
}