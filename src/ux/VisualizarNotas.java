/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Ui.JP035_1_S3_RH;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class VisualizarNotas implements ActionListener{
    private JPanel JPContenido;
    private JP035_1_S3_RH vista35;
    private HabilitarPaneles PanelesManager;
    private Inicializador init;

    public VisualizarNotas(JPanel JPContenido, JP035_1_S3_RH vista35,HabilitarPaneles PanelesManager, Inicializador init)
    {
        this.JPContenido = JPContenido;
        this.vista35 = vista35;
        this.init = init;
        this.PanelesManager = PanelesManager;
        this.vista35.btn1_JF034_AF.setEnabled(true);
        this.vista35.getBtn1_JF034_AF().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vista35.getBtn1_JF034_AF())
        {   
            System.out.println("Sigue sin vovoler whats");
            init.mostrarOcultarPanel("panelExpedienteDelPaciente");
            
            //Botón para volver un panel anterior
        }
    }
    
}

