/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Vista.VistaContinente;
import Vista.VistaPrincipal;
import Vista.VistaSeleccion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Estudiante
 */

public class ControladorPrincipal implements ActionListener {

    private VistaPrincipal vPrincipal;
    private VistaContinente vContinente;
    private VistaSeleccion vSeleccion;

    public ControladorPrincipal(VistaPrincipal vPrincipal, VistaContinente vContinente, VistaSeleccion vSeleccion) {

        this.vPrincipal = vPrincipal;
        this.vContinente = vContinente;
        this.vSeleccion = vSeleccion;

        actionListener(this);

    }

    public void actionListener(ActionListener control) {

        this.vPrincipal.menuSalir.addActionListener(this);
        this.vPrincipal.menuContinente.addActionListener(this);
        this.vPrincipal.menuSeleccion.addActionListener(this);
        
        
        this.vSeleccion.menuAtras.addActionListener(control);
        this.vContinente.menuAtras.addActionListener(control);

    }

    public void inciar() {

        vPrincipal.setTitle("Principal");
        vPrincipal.setLocationRelativeTo(null);
        vContinente.setTitle("Continente");
        vContinente.setLocationRelativeTo(null);
        vSeleccion.setTitle("Seleccion");
        vSeleccion.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vPrincipal.menuContinente) {
            vContinente.setVisible(true);
            vPrincipal.dispose();
        }

        if (e.getSource() == vPrincipal.menuSeleccion) {
            vSeleccion.setVisible(true);
            vPrincipal.setVisible(false);
        }

        if (e.getSource() == vPrincipal.menuSalir) {
            System.exit(0);
        }
        
        if(e.getSource() == vSeleccion.menuAtras){
            vPrincipal.setVisible(true);
            vSeleccion.dispose();
        }
        
        if(e.getSource() == vContinente.menuAtras){
            vPrincipal.setVisible(true);
            vContinente.dispose();
        }
        if(e.getSource()==vPrincipal.btnMostrar){
            
        }

    }

}
