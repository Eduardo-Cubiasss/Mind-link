/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Ui.JP040_S3_AF;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class VerMensajes implements ActionListener{
    private JPanel JPContenido;
    private JP040_S3_AF vista40;
    private HabilitarPaneles PanelesManager;
    private Inicializador init;
    
    public VerMensajes(JPanel JPContenido, JP040_S3_AF vista40, HabilitarPaneles PanelesManager, Inicializador init)
    {
        this.JPContenido = JPContenido;
        this.vista40 = vista40;
        this.init = init;
        this.PanelesManager = PanelesManager;
        this.vista40.getBtn001_JF042_1_S3_AF().addActionListener(this);
        this.vista40.getjButton1().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista40.getBtn001_JF042_1_S3_AF())
        {
            init.mostrarOcultarPanel("panelMenuSec");
            
            
            //Botón para  volver a un panel anterior
        }
        else if(e.getSource()== vista40.getjButton1())
        {
            init.mostrarOcultarPanel("panelVerMensajeCH");
            
            //Botón para abrir mensaje
        }
    }
    
}
