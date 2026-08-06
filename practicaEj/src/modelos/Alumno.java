package models;

import database.Conexion;

import java.sql.*;
import java.util.ArrayList;

public class Alumno {

    private int id;
    private String matricula;
    private String nombre;
    private int edad;
    private String sexo;
    private String correo;

    public Alumno() {
    }

    // Constructor sin id
    public Alumno(String matricula, String nombre, int edad, String sexo, String correo) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.correo = correo;
    }
}