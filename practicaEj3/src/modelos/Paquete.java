package modelos;

import estrategias.EstrategiaEnvio;

public abstract class Paquete {

    private int id;
    private String destinatario;
    private String remitente;
    private String direccionDestino;
    private String telefono;
    private double pesoKg;
    private String contenido;
    private String numeroGuia;

    // Strategy
    private EstrategiaEnvio estrategiaEnvio;

    public Paquete(String destinatario,
                   String remitente,
                   String direccionDestino,
                   String telefono,
                   double pesoKg,
                   String contenido,
                   String numeroGuia,
                   EstrategiaEnvio estrategiaEnvio) {

        if (pesoKg <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor que cero.");
        }

        this.destinatario = destinatario;
        this.remitente = remitente;
        this.direccionDestino = direccionDestino;
        this.telefono = telefono;
        this.pesoKg = pesoKg;
        this.contenido = contenido;
        this.numeroGuia = numeroGuia;
        this.estrategiaEnvio = estrategiaEnvio;
    }

    public double obtenerCostoEnvio() {
        return estrategiaEnvio.calcularCosto(pesoKg);
    }

    public abstract String getTipoEnvio();

    // GETTERS

    public int getId() {
        return id;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getRemitente() {
        return remitente;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public String getTelefono() {
        return telefono;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public String getContenido() {
        return contenido;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    // SETTERS

    public void setId(int id) {
        this.id = id;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public void mostrarDatos() {

        System.out.println("---------------------------");
        System.out.println("ID: " + id);
        System.out.println("Destinatario: " + destinatario);
        System.out.println("Remitente: " + remitente);
        System.out.println("Dirección: " + direccionDestino);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Contenido: " + contenido);
        System.out.println("Peso: " + pesoKg + " kg");
        System.out.println("Guía: " + numeroGuia);
        System.out.println("Tipo: " + getTipoEnvio());
        System.out.println("Costo: $" + obtenerCostoEnvio());
    }
}