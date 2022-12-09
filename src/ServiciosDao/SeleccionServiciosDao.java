/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosDao;

import ModeloVO.ContinenteVO;
import ModeloVO.SeleccionVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Estudiante
 */
public class SeleccionServiciosDao extends Conexion {

    // =========== METODO REGISTRAR
    public boolean registrar(SeleccionVO seleccion) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "insert into seleccion (id, nombre, continente_id, tecnico, goles_favor, "
                + "goles_contra, partidos_ganados, partidos_perdidos, partidos_jugados) values (?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, seleccion.getId());
            ps.setString(2, seleccion.getNombre());
            ps.setInt(3, seleccion.getContinente_id());
            ps.setString(4, seleccion.getTecnico());
            ps.setInt(5, seleccion.getGoles_favor());
            ps.setInt(6, seleccion.getGoles_contra());
            ps.setInt(7, seleccion.getPartidos_ganados());
            ps.setInt(8, seleccion.getPartidos_perdidos());
            ps.setInt(9, seleccion.getPartidos_jugados());

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    } //------------ FIN REGISTRAR 

    // =========== METODO MODIFICAR
    public boolean modificar(SeleccionVO seleccion) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "update seleccion set nombre=?, continente_id=?, tecnico=?, goles_favor=?, "
                + "goles_contra=?, partidos_ganados=?, partidos_perdidos=?, partidos_jugados=? where id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, seleccion.getNombre());
            ps.setInt(2, seleccion.getContinente_id());
            ps.setString(3, seleccion.getTecnico());
            ps.setInt(4, seleccion.getGoles_favor());
            ps.setInt(5, seleccion.getGoles_contra());
            ps.setInt(6, seleccion.getPartidos_ganados());
            ps.setInt(7, seleccion.getPartidos_perdidos());
            ps.setInt(8, seleccion.getPartidos_jugados());
            ps.setInt(9, seleccion.getId());

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    } //------------ FIN MODIFICAR 

    // =========== METODO ELIMINAR
    public boolean eliminar(SeleccionVO seleccion) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "delete from seleccion where id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, seleccion.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    } //------------ FIN eliminar 

    // =========== METODO BUSCAR
    public boolean buscar(SeleccionVO seleccion) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;

        String sql = "select * from seleccion where id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, seleccion.getId());
            rs = ps.executeQuery();
            if (rs.next()) {
                seleccion.setId(Integer.parseInt(rs.getString("id")));
                seleccion.setNombre(rs.getString("nombre"));
                seleccion.setContinente_id(Integer.parseInt(rs.getString("continente_id")));
                seleccion.setTecnico(rs.getString("tecnico"));
                seleccion.setGoles_favor(Integer.parseInt(rs.getString("goles_favor")));
                seleccion.setGoles_contra(Integer.parseInt(rs.getString("goles_contra")));
                seleccion.setPartidos_ganados(Integer.parseInt(rs.getString("partidos_ganados")));
                seleccion.setPartidos_perdidos(Integer.parseInt(rs.getString("partidos_perdidos")));
                seleccion.setPartidos_jugados(Integer.parseInt(rs.getString("partidos_jugados")));

                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    } //------------ FIN BUSCAR 

    public ArrayList<SeleccionVO> listaSelecciones() {
        try {

            ArrayList<SeleccionVO> selecciones = new ArrayList<>();
            Connection conexion = getConexion();
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("SELECT * FROM seleccion");
            ResultSet rs = consulta.executeQuery();
            String cadena = "";

            while (rs.next()) {

                SeleccionVO s = new SeleccionVO();

                s.setId(rs.getInt("id"));
                s.setNombre(rs.getString("nombre"));
                s.setContinente_id(rs.getInt("continente_id"));
                s.setTecnico(rs.getString("tecnico"));
                s.setGoles_favor(rs.getInt("goles_favor"));
                s.setGoles_contra(rs.getInt("goles_contra"));
                s.setPartidos_ganados(rs.getInt("partidos_ganados"));
                s.setPartidos_perdidos(rs.getInt("partidos_perdidos"));
                s.setPartidos_jugados(rs.getInt("partidos_jugados"));

                cadena = cadena + s.toString() + "\n";

                selecciones.add(s);

            }

            selecciones.toString();
            JOptionPane.showMessageDialog(null, cadena);

            return selecciones;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public ArrayList<SeleccionVO> seleccionesMejorGD() {

        try {

            int mayorGd = 0;
            String cadena = "";

            ArrayList<SeleccionVO> selecciones = new ArrayList<>();
            Connection conexion = getConexion();
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("SELECT * FROM seleccion");
            ResultSet rs = consulta.executeQuery();

            while (rs.next()) {

                SeleccionVO s = new SeleccionVO();
                s.setId(rs.getInt("id"));
                s.setNombre(rs.getString("nombre"));
                s.setContinente_id(rs.getInt("continente_id"));
                s.setTecnico(rs.getString("tecnico"));
                s.setGoles_favor(rs.getInt("goles_favor"));
                s.setGoles_contra(rs.getInt("goles_contra"));
                s.setPartidos_ganados(rs.getInt("partidos_ganados"));
                s.setPartidos_perdidos(rs.getInt("partidos_perdidos"));
                s.setPartidos_jugados(rs.getInt("partidos_jugados"));

                if (mayorGd < s.getGoles_favor() - s.getGoles_contra()) {
                    selecciones.clear();
                    selecciones.add(s);
                    cadena = "";

                    mayorGd = s.getGoles_favor() - s.getGoles_contra();
                }
                if (mayorGd == s.getGoles_favor() - s.getGoles_contra()) {
                    selecciones.add(s);
                    cadena = cadena + s.toString() + "\n";
                }

            }
            System.out.println(selecciones.toString());
            JOptionPane.showMessageDialog(null, cadena);

            return selecciones;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }

    }

    public ArrayList<SeleccionVO> seleccionesMayorPG() {

        try {

            int mayorPG = 0;
            String cadena = "";

            ArrayList<SeleccionVO> selecciones = new ArrayList<>();
            Connection conexion = getConexion();
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("SELECT * FROM seleccion");
            ResultSet rs = consulta.executeQuery();

            while (rs.next()) {

                SeleccionVO s = new SeleccionVO();
                s.setId(rs.getInt("id"));
                s.setNombre(rs.getString("nombre"));
                s.setContinente_id(rs.getInt("continente_id"));
                s.setTecnico(rs.getString("tecnico"));
                s.setGoles_favor(rs.getInt("goles_favor"));
                s.setGoles_contra(rs.getInt("goles_contra"));
                s.setPartidos_ganados(rs.getInt("partidos_ganados"));
                s.setPartidos_perdidos(rs.getInt("partidos_perdidos"));
                s.setPartidos_jugados(rs.getInt("partidos_jugados"));

                if (mayorPG < s.getPartidos_ganados()) {
                    selecciones.clear();
                    selecciones.add(s);
                    cadena = "";

                    mayorPG = s.getPartidos_ganados();
                }
                if (mayorPG == s.getPartidos_ganados()) {
                    selecciones.add(s);
                    cadena = cadena + s.toString() + "\n";
                }

            }
            System.out.println(selecciones.toString());
            JOptionPane.showMessageDialog(null, cadena);

            return selecciones;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }

    }

}
