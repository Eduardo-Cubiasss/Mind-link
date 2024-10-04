/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Ui.JP047_S3_AF;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class SolicitudesDeIncapacidadRedactar implements ActionListener{
    private JPanel JPContenido;
    private JP047_S3_AF vista47;
    private Inicializador init;
    
    public SolicitudesDeIncapacidadRedactar(JPanel JPContenido, JP047_S3_AF vista47, Inicializador init)
    {
        this.JPContenido = JPContenido;
        this.vista47 = vista47;
        
        this.vista47.getBtn01_JF045_S3_RH().addActionListener(this);
        this.vista47.getjButton1().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista47.getBtn01_JF045_S3_RH())
        {
            
            //Botón para volver a un panel anterior
        }
        else if (e.getSource()== vista47.getjButton1())
        {
            //Botón par redactar un mensaje
        }
    }
    
}
