package modelos;

import estrategias.PlanSuscripcion;

public class CuentaEstandar extends CuentaUsuario {

    public CuentaEstandar(String correoElectronico,
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
        return "Estandar";
    }
}