/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Ui.JP037_S3_RH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class CambiosPruebasActuales implements ActionListener{
    private JPanel JPContenido;
    private JP037_S3_RH vista37;
    private Inicializador init;
    
    public CambiosPruebasActuales(JPanel JPContenido, JP037_S3_RH vista37, Inicializador init)
    {
        this.JPContenido = JPContenido;
        this.vista37 = vista37;
        this.init = init;
        this.vista37.getBtn1_JF037_S3_RH().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vista37.getBtn1_JF037_S3_RH())
        {
            
            //Botón de volver al panel anterior
        }
    }
    
}
