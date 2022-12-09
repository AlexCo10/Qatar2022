/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundialqatar;

import Control.ControladorContinente;
import Control.ControladorPrincipal;
import Control.ControladorSeleccion;
import ModeloVO.ContinenteVO;
import ModeloVO.SeleccionVO;
import ServiciosDao.ContinenteServiciosDao;
import ServiciosDao.SeleccionServiciosDao;
import Vista.VistaContinente;
import Vista.VistaPrincipal;
import Vista.VistaSeleccion;

/**
 *
 * @author Estudiante
 */
public class MundialQatar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ContinenteVO  continente = new ContinenteVO();
        SeleccionVO seleccion = new SeleccionVO();
        ContinenteServiciosDao continenteDao = new ContinenteServiciosDao();
        SeleccionServiciosDao seleccionDao = new SeleccionServiciosDao();
        
        Vista.VistaPrincipal VPri = new VistaPrincipal();
        VistaContinente VContinente = new VistaContinente();
        VistaSeleccion VSeleccion = new VistaSeleccion();
        
        ControladorContinente controlContinente = new ControladorContinente(continente, VContinente, continenteDao);
        ControladorSeleccion controlSeleccion = new ControladorSeleccion(seleccion, VSeleccion, seleccionDao);
        
        ControladorPrincipal controlPri = new ControladorPrincipal(VPri, VContinente, VSeleccion);
        
        controlPri.inciar();
        
        VPri.setVisible(true);
        
        
        
    }
    
}
