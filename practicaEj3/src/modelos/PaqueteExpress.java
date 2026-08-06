package modelos;

import estrategias.EstrategiaEnvio;

public class PaqueteExpress extends Paquete {

    public PaqueteExpress(String destinatario,
                          String remitente,
                          String direccionDestino,
                          String telefono,
                          double pesoKg,
                          String contenido,
                          String numeroGuia,
                          EstrategiaEnvio estrategiaEnvio) {

        super(destinatario,
                remitente,
                direccionDestino,
                telefono,
                pesoKg,
                contenido,
                numeroGuia,
                estrategiaEnvio);
    }

    @Override
    public String getTipoEnvio() {
        return "Express";
    }

}