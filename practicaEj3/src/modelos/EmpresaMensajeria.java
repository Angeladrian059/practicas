package modelos;

import database.Conexion;
import estrategias.*;

import java.sql.*;

public class EmpresaMensajeria {

    // ==========================
    // REGISTRAR
    // ==========================

    public void registrarPaquete(Paquete paquete) {

        Connection con = Conexion.conectar();

        String sql = "INSERT INTO Paquete "
                + "(destinatario,remitente,direccionDestino,"
                + "telefono,pesoKg,contenido,numeroGuia,tipoEnvio)"
                + " VALUES(?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, paquete.getDestinatario());
            ps.setString(2, paquete.getRemitente());
            ps.setString(3, paquete.getDireccionDestino());
            ps.setString(4, paquete.getTelefono());
            ps.setDouble(5, paquete.getPesoKg());
            ps.setString(6, paquete.getContenido());
            ps.setString(7, paquete.getNumeroGuia());
            ps.setString(8, paquete.getTipoEnvio());

            ps.executeUpdate();

            System.out.println("Paquete registrado correctamente.");

            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    // ==========================
    // MOSTRAR
    // ==========================

    public void mostrarPaquetes() {

        Connection con = Conexion.conectar();

        String sql = "SELECT * FROM Paquete";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("--------------------------------");

                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Destinatario: " + rs.getString("destinatario"));
                System.out.println("Remitente: " + rs.getString("remitente"));
                System.out.println("Dirección: " + rs.getString("direccionDestino"));
                System.out.println("Teléfono: " + rs.getString("telefono"));
                System.out.println("Peso: " + rs.getDouble("pesoKg"));
                System.out.println("Contenido: " + rs.getString("contenido"));
                System.out.println("Guía: " + rs.getString("numeroGuia"));
                System.out.println("Tipo: " + rs.getString("tipoEnvio"));

            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    // ==========================
    // BUSCAR
    // ==========================

    public void buscarPaquete(String guia) {

        Connection con = Conexion.conectar();

        String sql = "SELECT * FROM Paquete WHERE numeroGuia=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, guia);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Paquete encontrado");

                System.out.println("Destinatario: "
                        + rs.getString("destinatario"));

                System.out.println("Tipo: "
                        + rs.getString("tipoEnvio"));

                System.out.println("Peso: "
                        + rs.getDouble("pesoKg"));

            } else {

                System.out.println("No existe ese paquete.");

            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    // ==========================
    // ACTUALIZAR
    // ==========================

    public void actualizarPaquete(Paquete paquete) {

        Connection con = Conexion.conectar();

        String sql = "UPDATE Paquete SET "
                + "destinatario=?,"
                + "remitente=?,"
                + "direccionDestino=?,"
                + "telefono=?,"
                + "pesoKg=?,"
                + "contenido=?,"
                + "tipoEnvio=? "
                + "WHERE numeroGuia=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, paquete.getDestinatario());
            ps.setString(2, paquete.getRemitente());
            ps.setString(3, paquete.getDireccionDestino());
            ps.setString(4, paquete.getTelefono());
            ps.setDouble(5, paquete.getPesoKg());
            ps.setString(6, paquete.getContenido());
            ps.setString(7, paquete.getTipoEnvio());
            ps.setString(8, paquete.getNumeroGuia());

            ps.executeUpdate();

            System.out.println("Paquete actualizado.");

            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    // ==========================
    // ELIMINAR
    // ==========================

    public void eliminarPaquete(String guia) {

        Connection con = Conexion.conectar();

        String sql = "DELETE FROM Paquete WHERE numeroGuia=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, guia);

            ps.executeUpdate();

            System.out.println("Paquete eliminado.");

            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
        // ==========================
        // REPORTE DE INGRESOS
        // ==========================

        public void reporteIngresos () {

            Connection con = Conexion.conectar();

            String sql = "SELECT * FROM Paquete";

            double total = 0;

            try {

                PreparedStatement ps = con.prepareStatement(sql);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    double peso = rs.getDouble("pesoKg");
                    String tipo = rs.getString("tipoEnvio");

                    EstrategiaEnvio estrategia;

                    switch (tipo) {

                        case "Estándar":
                            estrategia = new EnvioEstandar();
                            break;

                        case "Express":
                            estrategia = new EnvioExpress();
                            break;

                        default:
                            estrategia = new EnvioInternacional();

                    }

                    double costo = estrategia.calcularCosto(peso);

                    System.out.println(
                            rs.getString("numeroGuia")
                                    + " -> $" + costo);

                    total += costo;

                }

                System.out.println("----------------------");
                System.out.println("TOTAL: $" + total);

                rs.close();
                ps.close();
                con.close();

            } catch (Exception e) {

                e.printStackTrace();

            }

        }

        // ==========================
        // CONTAR POR TIPO
        // ==========================

        public void contarTipos () {

            Connection con = Conexion.conectar();

            String sql =
                    "SELECT tipoEnvio, COUNT(*) cantidad "
                            + "FROM Paquete "
                            + "GROUP BY tipoEnvio";

            try {

                PreparedStatement ps = con.prepareStatement(sql);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    System.out.println(
                            rs.getString("tipoEnvio")
                                    + " : "
                                    + rs.getInt("cantidad"));

                }

                rs.close();
                ps.close();
                con.close();

            } catch (Exception e) {

                e.printStackTrace();

            }

        }

    }
