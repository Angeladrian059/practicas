package modelos;

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
    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    // REGISTRAR ALUMNO
    // ============================

    public void save() {

        String sql = "INSERT INTO alumno(matricula,nombre,edad,sexo,correo) VALUES(?,?,?,?,?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, matricula);
            ps.setString(2, nombre);
            ps.setInt(3, edad);
            ps.setString(4, sexo);
            ps.setString(5, correo);

            ps.executeUpdate();

            System.out.println("Alumno registrado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    // ============================
    // BUSCAR POR MATRICULA
    // ============================

    public static Alumno findByMatricula(String matriculaBuscar) {

        Alumno alumno = null;

        String sql = "SELECT * FROM alumno WHERE matricula=?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, matriculaBuscar);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                alumno = new Alumno();

                alumno.setId(rs.getInt("id"));
                alumno.setMatricula(rs.getString("matricula"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setEdad(rs.getInt("edad"));
                alumno.setSexo(rs.getString("sexo"));
                alumno.setCorreo(rs.getString("correo"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alumno;

    }
// MOSTRAR TODOS
    // ============================

    public static ArrayList<Alumno> getAll() {

        ArrayList<Alumno> lista = new ArrayList<>();

        String sql = "SELECT * FROM alumno";

        try (Connection con = Conexion.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                Alumno alumno = new Alumno();

                alumno.setId(rs.getInt("id"));
                alumno.setMatricula(rs.getString("matricula"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setEdad(rs.getInt("edad"));
                alumno.setSexo(rs.getString("sexo"));
                alumno.setCorreo(rs.getString("correo"));

                lista.add(alumno);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;

    }
    // ============================
    // ACTUALIZAR
    // ============================

    public void update() {

        String sql = "UPDATE alumno SET nombre=?,edad=?,sexo=?,correo=? WHERE matricula=?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setInt(2, edad);
            ps.setString(3, sexo);
            ps.setString(4, correo);
            ps.setString(5, matricula);

            ps.executeUpdate();

            System.out.println("Alumno actualizado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}