/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Ui.JP041_1_S3_RH;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class VerMensajeCH implements ActionListener{
    private JPanel JPContenido;
    private JP041_1_S3_RH vista41;
    private HabilitarPaneles PanelesManager;
    private Inicializador init;

    
    public VerMensajeCH(JPanel JPContenido, JP041_1_S3_RH vista41, HabilitarPaneles PanelesManager, Inicializador init)
    {
        this.JPContenido = JPContenido;
        this.vista41 = vista41;
        this.PanelesManager = PanelesManager;
        this.init = init;
        this.vista41.getBtn1_JF041_S3_RH().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista41.getBtn1_JF041_S3_RH())
        {
            
            init.mostrarOcultarPanel("panelVerMensaje");
            
            //Volver un panel anterior
        }
    }
    
}
