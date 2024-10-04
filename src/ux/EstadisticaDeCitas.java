/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Ui.JP044_S3_AF;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class EstadisticaDeCitas implements ActionListener{
    private JPanel JPContenido;
    private JP044_S3_AF vista44;
    private Inicializador init;
    
    public EstadisticaDeCitas(JPanel JPContenido, JP044_S3_AF vista44, Inicializador init)
    {
        this.JPContenido = JPContenido;
        this.vista44 = vista44;
        this.init = init;
        this.vista44.getBtn001_JF042_1_S3_AF().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista44.getBtn001_JF042_1_S3_AF())
        {
             init.mostrarOcultarPanel("panelMenuAdmin"); 
            //Botón para volver a un panel anterior
        }
    }
    
}
