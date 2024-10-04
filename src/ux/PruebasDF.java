/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Ui.JP045_S3_RH;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class PruebasDF implements ActionListener{
    private JPanel JPContenido;
    private JP045_S3_RH vista45;
    private HabilitarPaneles PanelesManager;
    private Inicializador init;
    
    public PruebasDF(JPanel JPContenido, JP045_S3_RH vista45, HabilitarPaneles PanelesManager, Inicializador init)
    {
        this.JPContenido = JPContenido;
        this.vista45 = vista45;
        this.PanelesManager = PanelesManager;
                                                                          this.init = init;
        this.vista45.getBtn01_JF045_S3_RH().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vista45.getBtn01_JF045_S3_RH())
        {
            init.mostrarOcultarPanel("panelMenuSec");
            
            //Botón de volver a un panel anterior
        }
    }
    
}
