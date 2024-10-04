/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Database.Incapacidades;
import Database.Procesos_almacenados;
import Database.Terapeutas;
import Database.Usuarios;
import Ui.JP032_S3_AF;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class RedactarMensaje implements ActionListener{
    private JPanel JPContenido;
    private JP032_S3_AF vista32;
     private HabilitarPaneles PanelesManager;
     private Usuarios modelUsers;
     private Incapacidades modelIncap;
     private Procesos_almacenados procesos;
     private Inicializador init;
     private Terapeutas modelTerap;
    
    
    public RedactarMensaje(JPanel JPContenido, JP032_S3_AF vista32,  HabilitarPaneles PanelesManager, Usuarios modelUsers, Incapacidades modelIncap,
            Procesos_almacenados procesos, Inicializador init, Terapeutas modelTerap)
    {
        this.JPContenido = JPContenido;
        this.vista32 = vista32;
        this.PanelesManager = PanelesManager;  
        this.modelIncap = modelIncap;
        this.modelUsers = modelUsers;
        this.procesos = procesos;
        this.init = init;
        this.modelTerap = modelTerap;
        this.vista32.getBtn1_JF028_S3_AF().addActionListener(this);
        this.vista32.getjButton1().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vista32.getBtn1_JF028_S3_AF())
        {
            if(modelTerap.getIDTerapeuta() == 0)
            {
                 init.mostrarOcultarPanel("panelMenuSec");
            }
            else
            {
                 init.mostrarOcultarPanel("panelMenuTp");
            }
           
           
            //Volver un panel anterior
        }
        else if(e.getSource()== vista32.getjButton1())
        {
            modelIncap.setAsunto(vista32.getTxtAsunto().getText());
            modelIncap.setMensaje(vista32.getTxtDescrip().getText());
            procesos.RedactarPermiso(modelIncap, modelUsers);
            
            //Enviar mensaje
        }
    }
    
}
