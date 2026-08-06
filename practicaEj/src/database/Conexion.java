package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String SERVER = "localhost";
    private static final String PORT = "1433";
    private static final String DATABASE = "Escuela";
    private static final String USER = "sa";
    private static final String PASSWORD = "TU_CONTRASEÑA";

    public static Connection conectar() {

        Connection conexion = null;
