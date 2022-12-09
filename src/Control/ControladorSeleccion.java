/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import ModeloVO.SeleccionVO;
import ServiciosDao.SeleccionServiciosDao;
import Vista.VistaPrincipal;
import Vista.VistaSeleccion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Estudiante
 */
public class ControladorSeleccion implements ActionListener {

    private SeleccionVO sele;
    private VistaSeleccion vista;
    private SeleccionServiciosDao seleDao;

    public ControladorSeleccion(SeleccionVO sele, VistaSeleccion vista, SeleccionServiciosDao seleDao) {
        this.sele = sele;
        this.vista = vista;
        this.seleDao = seleDao;

        actionListener(this);

    }

    public void actionListener(ActionListener control) {

        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);

        this.vista.menuSalir.addActionListener(this);
        this.vista.menuSelecciones.addActionListener(this);
        this.vista.menuMejorGD.addActionListener(this);
        this.vista.menuMasPG.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //// boton agregar
        if (e.getSource() == vista.btnAgregar) {
            sele.setId(Integer.parseInt(vista.txtId.getText()));
            sele.setNombre(vista.txtNombre.getText());
            sele.setContinente_id(Integer.parseInt(vista.txtContinenteId.getText()));
            sele.setTecnico(vista.txtTecnico.getText());
            sele.setGoles_favor(Integer.parseInt(vista.txtGolesFavor.getText()));
            sele.setGoles_contra(Integer.parseInt(vista.txtGolesContra.getText()));
            sele.setPartidos_ganados(Integer.parseInt(vista.txtPartidosGanados.getText()));
            sele.setPartidos_perdidos(Integer.parseInt(vista.txtPartidosPerdidos.getText()));
            sele.setPartidos_jugados(Integer.parseInt(vista.txtPartidosJugados.getText()));

            if (seleDao.registrar(sele)) {
                JOptionPane.showMessageDialog(null, "Seleccion agregado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar");
                limpiar();
            }
        } //------------------------ fin agregar

        //// boton modificar
        if (e.getSource() == vista.btnModificar) {
            sele.setId(Integer.parseInt(vista.txtId.getText()));
            sele.setNombre(vista.txtNombre.getText());
            sele.setContinente_id(Integer.parseInt(vista.txtContinenteId.getText()));
            sele.setTecnico(vista.txtTecnico.getText());
            sele.setGoles_favor(Integer.parseInt(vista.txtGolesFavor.getText()));
            sele.setGoles_contra(Integer.parseInt(vista.txtGolesContra.getText()));
            sele.setPartidos_ganados(Integer.parseInt(vista.txtPartidosGanados.getText()));
            sele.setPartidos_perdidos(Integer.parseInt(vista.txtPartidosPerdidos.getText()));
            sele.setPartidos_jugados(Integer.parseInt(vista.txtPartidosJugados.getText()));

            if (seleDao.modificar(sele)) {
                JOptionPane.showMessageDialog(null, "Seleccion modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
            }
        } //------------------------ fin modificar

        //// boton eliminar
        if (e.getSource() == vista.btnEliminar) {
            sele.setId(Integer.parseInt(vista.txtId.getText()));
            if (seleDao.eliminar(sele)) {
                JOptionPane.showMessageDialog(null, "Seleccion eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        } //------------------------ fin eliminar

        //// boton buscar
        if (e.getSource() == vista.btnBuscar) {
            sele.setId(Integer.parseInt(vista.txtId.getText()));

            if (seleDao.buscar(sele)) {
                vista.txtId.setText(String.valueOf(sele.getId()));
                vista.txtNombre.setText(sele.getNombre());
                vista.txtContinenteId.setText(String.valueOf(sele.getContinente_id()));
                vista.txtTecnico.setText(sele.getTecnico());
                vista.txtGolesFavor.setText(String.valueOf(sele.getGoles_favor()));
                vista.txtGolesContra.setText(String.valueOf(sele.getGoles_contra()));
                vista.txtPartidosGanados.setText(String.valueOf(sele.getPartidos_ganados()));
                vista.txtPartidosPerdidos.setText(String.valueOf(sele.getPartidos_perdidos()));
                vista.txtPartidosJugados.setText(String.valueOf(sele.getPartidos_jugados()));

            } else {
                JOptionPane.showMessageDialog(null, "Error al buscar");
                limpiar();
            }

        } //------------------------ fin buscar

        if (e.getSource() == vista.btnLimpiar) {
            limpiar();
        }

        if (e.getSource() == vista.menuSalir) {
            System.exit(0);
        }
        
        if(e.getSource()==vista.menuSelecciones){
            seleDao.listaSelecciones();
        }
        if(e.getSource()==vista.menuMejorGD){
            seleDao.seleccionesMejorGD();
        }
        if(e.getSource()==vista.menuMasPG){
            seleDao.seleccionesMayorPG();
        }
        
        
        

    }//fin action

    public void limpiar() {

        vista.txtId.setText(null);
        vista.txtNombre.setText(null);
        vista.txtContinenteId.setText(null);
        vista.txtTecnico.setText(null);
        vista.txtGolesFavor.setText("0");
        vista.txtGolesContra.setText("0");
        vista.txtPartidosGanados.setText("0");
        vista.txtPartidosPerdidos.setText("0");
        vista.txtPartidosJugados.setText("0");

    }

    public void cancelar() {

    }

}
