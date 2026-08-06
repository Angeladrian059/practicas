package modelos;

import estrategias.PlanSuscripcion;

public abstract class CuentaUsuario {

    private int id;
    private String correoElectronico;
    private String nombreUsuario;
    private String telefono;
    private String pais;
    private int mesesActivo;

    private PlanSuscripcion plan;

    public CuentaUsuario(String correoElectronico,
                         String nombreUsuario,
                         String telefono,
                         String pais,
                         int mesesActivo,
                         PlanSuscripcion plan) {

        if (mesesActivo <= 0) {
            throw new IllegalArgumentException(
                    "Los meses deben ser mayores que cero");
        }

        this.correoElectronico = correoElectronico;
        this.nombreUsuario = nombreUsuario;
        this.telefono = telefono;
        this.pais = pais;
        this.mesesActivo = mesesActivo;
        this.plan = plan;
    }

    public double obtenerTotalAPagar() {
        return plan.calcularCosto(mesesActivo);
    }

    public abstract String getTipoPlan();

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getPais() {
        return pais;
    }

    public int getMesesActivo() {
        return mesesActivo;
    }
}