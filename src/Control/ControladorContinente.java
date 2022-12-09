/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Vista.VistaContinente;
import ModeloVO.ContinenteVO;
import ServiciosDao.ContinenteServiciosDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Estudiante
 */
public class ControladorContinente implements ActionListener {

    private ContinenteVO conti;
    private VistaContinente vista;
    private ContinenteServiciosDao contiDao;

    public ControladorContinente(ContinenteVO conti, VistaContinente vista, ContinenteServiciosDao contiDao) {
        this.conti = conti;
        this.vista = vista;
        this.contiDao = contiDao;

        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);

        this.vista.menuSalir.addActionListener(this);
        this.vista.menuContinentes.addActionListener(this);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //// boton agregar
        if (e.getSource() == vista.btnAgregar) {
            conti.setId(Integer.parseInt(vista.txtId.getText()));
            conti.setNombre(vista.txtNombre.getText());

            if (contiDao.registrar(conti)) {
                JOptionPane.showMessageDialog(null, "Continente agregado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar");
                limpiar();
            }
        } //------------------------ fin agregar

        //// boton modificar
        if (e.getSource() == vista.btnModificar) {
            conti.setId(Integer.parseInt(vista.txtId.getText()));
            conti.setNombre(vista.txtNombre.getText());

            if (contiDao.modificar(conti)) {
                JOptionPane.showMessageDialog(null, "Continente modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
            }
        } //------------------------ fin modificar

        //// boton eliminar
        if (e.getSource() == vista.btnEliminar) {
            conti.setId(Integer.parseInt(vista.txtId.getText()));
            if (contiDao.eliminar(conti)) {
                JOptionPane.showMessageDialog(null, "Continente eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        } //------------------------ fin eliminar

        //// boton buscar
        if (e.getSource() == vista.btnBuscar) {
            conti.setId(Integer.parseInt(vista.txtId.getText()));
            if (contiDao.buscar(conti)) {
                vista.txtId.setText(String.valueOf(conti.getId()));
                vista.txtNombre.setText(conti.getNombre());

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
        if(e.getSource()==vista.menuContinentes){
            contiDao.listaContinentes();
        }
        
        
        
        
        

    }//fin action

    public void limpiar() {

        vista.txtId.setText(null);
        vista.txtNombre.setText(null);

    }

    

}
