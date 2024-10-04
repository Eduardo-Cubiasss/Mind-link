/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Ui.JP007_S2_RH;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class SeccionDeComentarios implements ActionListener{
    private JPanel JPContenido;
    private JP007_S2_RH vista07;
    private HabilitarPaneles PanelesManager;   
    private Inicializador init;

        
    public SeccionDeComentarios(JPanel JPContenido, JP007_S2_RH vista07, HabilitarPaneles PanelesManager, Inicializador init)
    {
        this.JPContenido = JPContenido;
        this.vista07 = vista07;
        this.PanelesManager = PanelesManager;    
        this.init = init;
        this.vista07.getBtn001_JF007_S2_RH().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista07.getBtn001_JF007_S2_RH())
        {
            init.mostrarOcultarPanel("panelMenuAdmin");
            
            //Boton de volver al menú administradooor
        }
    }
    
}
