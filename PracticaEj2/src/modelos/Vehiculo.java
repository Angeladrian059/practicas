package modelos;


import tarifas.Tarifa;


public abstract class Vehiculo {


    private int id;

    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private int anio;
    private String propietario;
    private int horasEstacionado;


    // Agregación
    private Tarifa tarifa;



    public Vehiculo(
            String placa,
            String marca,
            String modelo,
            String color,
            int anio,
            String propietario,
            int horasEstacionado,
            Tarifa tarifa
    ){

        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.anio = anio;
        this.propietario = propietario;
        this.horasEstacionado = horasEstacionado;
        this.tarifa = tarifa;

    }



    public double calcularCostoEstacionamiento(){

        return tarifa.calcular(horasEstacionado);

    }



    public abstract String getTipo();



    // GETTERS

    public int getId(){

        return id;

    }


    public String getPlaca(){

        return placa;

    }


    public String getMarca(){

        return marca;

    }


    public String getModelo(){

        return modelo;

    }


    public String getColor(){

        return color;

    }


    public int getAnio(){

        return anio;

    }


    public String getPropietario(){

        return propietario;

    }


    public int getHorasEstacionado(){

        return horasEstacionado;

    }



    // SETTERS


    public void setId(int id){

        this.id = id;

    }


    public void setMarca(String marca){

        this.marca = marca;

    }


    public void setModelo(String modelo){

        this.modelo = modelo;

    }


    public void setColor(String color){

        this.color = color;

    }


    public void setAnio(int anio){

        this.anio = anio;

    }


    public void setPropietario(String propietario){

        this.propietario = propietario;

    }


    public void setHorasEstacionado(int horas){

        this.horasEstacionado = horas;

    }



    public void mostrarDatos(){


        System.out.println("-------------------------");

        System.out.println("Tipo: " + getTipo());

        System.out.println("Placa: " + placa);

        System.out.println("Marca: " + marca);

        System.out.println("Modelo: " + modelo);

        System.out.println("Color: " + color);

        System.out.println("Año: " + anio);

        System.out.println("Propietario: " + propietario);

        System.out.println("Horas: " + horasEstacionado);

        System.out.println(
                "Costo: $" + calcularCostoEstacionamiento()
        );


    }



}