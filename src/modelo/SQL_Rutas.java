package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQL_Rutas extends Conexion {

    public boolean anadirRuta(Rutas ruta) {

        PreparedStatement ps = null;

        Connection con = getConexion();

        String sql = "INSERT INTO ruta (origen, destino, hora, fecha, id_conductor, id_autobus) VALUES (?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, ruta.getOrigen());
            ps.setString(2, ruta.getDestino());
            ps.setString(3, ruta.getHora());
            ps.setString(4, ruta.getFecha());
            ps.setInt(5, ruta.getId_conductor());
            ps.setInt(6, ruta.getId_autobus());

            ps.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SQL_Rutas.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }

    }

    public int obtenerRutaID(int idConductor, String fechaPartida) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT id_ruta FROM ruta WHERE id_conductor =? AND fecha =?";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, idConductor);
            ps.setString(2, fechaPartida);
            rs = ps.executeQuery();

            if (rs.next()) {
                return (rs.getInt("id_ruta"));
            }

        } catch (SQLException ex) {
            System.err.println("Error: " + ex);

            return 0;
        }

        return 0;
    }

    public int soloObtenerIDRuta(String origen, String destino, String fecha, String hora) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT id_ruta FROM ruta WHERE origen =? AND destino =? AND fecha =? AND hora=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, origen);
            ps.setString(2, destino);
            ps.setString(3, fecha);
            ps.setString(4, hora);
            rs = ps.executeQuery();

            if (rs.next()) {
                return (rs.getInt("id_ruta"));
            }

        } catch (SQLException ex) {
            System.err.println("Error: " + ex);

            return 0;
        }

        return 0;

    }

}
