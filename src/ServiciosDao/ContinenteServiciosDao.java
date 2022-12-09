/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosDao;

import ModeloVO.ContinenteVO;
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
public class ContinenteServiciosDao extends Conexion {

    // =========== METODO REGISTRAR
    public boolean registrar(ContinenteVO continente) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "insert into continente (id, nombre) values (?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, continente.getId());
            ps.setString(2, continente.getNombre());

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    } //------------ FIN REGISTRAR 

    // =========== METODO MODIFICAR
    public boolean modificar(ContinenteVO continente) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "update continente set nombre=? where id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, continente.getNombre());
            ps.setInt(2, continente.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    } //------------ FIN MODIFICAR 

    // =========== METODO ELIMINAR
    public boolean eliminar(ContinenteVO continente) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "delete from continente where id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, continente.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    } //------------ FIN eliminar 

    // =========== METODO BUSCAR
    public boolean buscar(ContinenteVO continente) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;
        String sql = "select * from continente where id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, continente.getId());
            rs = ps.executeQuery();
            if (rs.next()) {
                continente.setId(Integer.parseInt(rs.getString("id")));
                continente.setNombre(rs.getString("nombre"));

                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    } //------------ FIN BUSCAR 

    public ArrayList<ContinenteVO> listaContinentes() {

        try {

            ArrayList<ContinenteVO> continentes = new ArrayList<>();
            Connection conexion = getConexion();
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("SELECT * FROM continente");
            ResultSet rs = consulta.executeQuery();
            
            String cadena="";

            while (rs.next()) {
                ContinenteVO n = new ContinenteVO();

                n.setId(rs.getInt("id"));
                n.setNombre(rs.getString("nombre"));
                
                System.out.println(n.toString());
                
                cadena=cadena+n.toString()+"\n";

                continentes.add(n);

            }
            
            JOptionPane.showMessageDialog(null, cadena);
            
            

            return continentes;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }//lista continentes

    

}
