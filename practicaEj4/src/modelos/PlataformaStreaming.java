package modelos;

import database.Conexion;
import estrategias.*;

import java.sql.*;

public class PlataformaStreaming {

    // ==========================
    // REGISTRAR
    // ==========================

    public void registrarUsuario(CuentaUsuario cuenta){

        Connection con = Conexion.conectar();

        String sql = "INSERT INTO CuentaUsuario "
                + "(correoElectronico,nombreUsuario,"
                + "telefono,pais,mesesActivo,tipoPlan)"
                + " VALUES(?,?,?,?,?,?)";

        try{

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, cuenta.getCorreoElectronico());
            ps.setString(2, cuenta.getNombreUsuario());
            ps.setString(3, cuenta.getTelefono());
            ps.setString(4, cuenta.getPais());
            ps.setInt(5, cuenta.getMesesActivo());
            ps.setString(6, cuenta.getTipoPlan());

            ps.executeUpdate();

            System.out.println("Usuario registrado correctamente.");

            ps.close();
            con.close();

        }catch(Exception e){

            e.printStackTrace();

        }

    }

    // ==========================
    // MOSTRAR
    // ==========================

    public void mostrarUsuarios(){

        Connection con = Conexion.conectar();

        String sql = "SELECT * FROM CuentaUsuario";

        try{

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                System.out.println("----------------------------");

                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Correo: " + rs.getString("correoElectronico"));
                System.out.println("Usuario: " + rs.getString("nombreUsuario"));
                System.out.println("Teléfono: " + rs.getString("telefono"));
                System.out.println("País: " + rs.getString("pais"));
                System.out.println("Meses: " + rs.getInt("mesesActivo"));
                System.out.println("Plan: " + rs.getString("tipoPlan"));

            }

            rs.close();
            ps.close();
            con.close();

        }catch(Exception e){

            e.printStackTrace();

        }

    }

    // ==========================
    // BUSCAR
    // ==========================

    public void buscarUsuario(String correo){

        Connection con = Conexion.conectar();

        String sql = "SELECT * FROM CuentaUsuario WHERE correoElectronico=?";

        try{

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, correo);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                System.out.println("Usuario encontrado");

                System.out.println("Nombre: "
                        + rs.getString("nombreUsuario"));

                System.out.println("Plan: "
                        + rs.getString("tipoPlan"));

                System.out.println("Meses: "
                        + rs.getInt("mesesActivo"));

            }else{

                System.out.println("No existe.");

            }

            rs.close();
            ps.close();
            con.close();

        }catch(Exception e){

            e.printStackTrace();

        }

    }

    // ==========================
    // ACTUALIZAR
    // ==========================

    public void actualizarUsuario(CuentaUsuario cuenta){

        Connection con = Conexion.conectar();

        String sql = "UPDATE CuentaUsuario SET "
                + "nombreUsuario=?,"
                + "telefono=?,"
                + "pais=?,"
                + "mesesActivo=?,"
                + "tipoPlan=? "
                + "WHERE correoElectronico=?";

        try{

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, cuenta.getNombreUsuario());
            ps.setString(2, cuenta.getTelefono());
            ps.setString(3, cuenta.getPais());
            ps.setInt(4, cuenta.getMesesActivo());
            ps.setString(5, cuenta.getTipoPlan());
            ps.setString(6, cuenta.getCorreoElectronico());

            ps.executeUpdate();

            System.out.println("Usuario actualizado.");

            ps.close();
            con.close();

        }catch(Exception e){

            e.printStackTrace();

        }

    }

    // ==========================
    // ELIMINAR
    // ==========================

    public void eliminarUsuario(String correo){

        Connection con = Conexion.conectar();

        String sql = "DELETE FROM CuentaUsuario WHERE correoElectronico=?";

        try{

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, correo);

            ps.executeUpdate();

            System.out.println("Usuario eliminado.");

            ps.close();
            con.close();

        }catch(Exception e){

            e.printStackTrace();

        }

    }
    // ==========================
    // REPORTE DE INGRESOS
    // ==========================

    public void reporteIngresos(){

        Connection con = Conexion.conectar();

        String sql = "SELECT * FROM CuentaUsuario";

        double total = 0;

        try{

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                int meses = rs.getInt("mesesActivo");
                String tipo = rs.getString("tipoPlan");

                PlanSuscripcion plan;

                switch(tipo){

                    case "Basico":
                        plan = new PlanBasico();
                        break;

                    case "Estandar":
                        plan = new PlanEstandar();
                        break;

                    default:
                        plan = new PlanPremium();

                }

                double costo = plan.calcularCosto(meses);

                System.out.println(
                        rs.getString("correoElectronico")
                                + " -> $" + costo);

                total += costo;

            }

            System.out.println("--------------------");
            System.out.println("TOTAL: $" + total);

            rs.close();
            ps.close();
            con.close();

        }catch(Exception e){

            e.printStackTrace();

        }

    }

    // ==========================
    // CONTAR PLANES
    // ==========================

    public void contarPlanes(){

        Connection con = Conexion.conectar();

        String sql = "SELECT tipoPlan, COUNT(*) cantidad "
                + "FROM CuentaUsuario "
                + "GROUP BY tipoPlan";

        try{

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                System.out.println(
                        rs.getString("tipoPlan")
                                + " : "
                                + rs.getInt("cantidad"));

            }

            rs.close();
            ps.close();
            con.close();

        }catch(Exception e){

            e.printStackTrace();

        }

    }

}