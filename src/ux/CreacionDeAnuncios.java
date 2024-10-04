/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Database.Anuncios;
import Database.Procesos_almacenados;
import Ui.JP006_S2_AF;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class CreacionDeAnuncios implements ActionListener{
    private JPanel JPContenido;
    private JP006_S2_AF vista06;
      private HabilitarPaneles PanelesManager;   
      private Procesos_almacenados procesos;
      private AnunciosActuales AnunciosController;
      private Anuncios modelAnuncio;
      private EliminarAnunciosActuales AnuncioControllerEli;
      private Inicializador init;
   
    public CreacionDeAnuncios(JPanel JPContenido, JP006_S2_AF vista06, HabilitarPaneles PanelesManager, AnunciosActuales AnunciosController, Anuncios modelAnuncio, Procesos_almacenados procesos,
            EliminarAnunciosActuales AnuncioControllerEli, Inicializador init)
    {
        this.procesos = procesos;
        this.JPContenido = JPContenido;
        this.vista06 = vista06;
        this.PanelesManager = PanelesManager;        
        this.AnunciosController = AnunciosController;
        this.modelAnuncio = modelAnuncio;
        this.init = init;
        this.AnuncioControllerEli = AnuncioControllerEli;
        this.vista06.getBtn001_JF006_S2_AF().addActionListener(this);
        this.vista06.getBtn2_JF006_S2_AF().addActionListener(this);
        this.vista06.getBtn3_JF006_S2_AF().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista06.getBtn001_JF006_S2_AF())
        {
            
            init.mostrarOcultarPanel("panelMenuAdmin"); 

             
            //Boton de la casita, es para devolverte al menú de administrador
        }
        else if (e.getSource() == vista06.getBtn2_JF006_S2_AF())
        {   
            init.mostrarOcultarPanel("panelAnunciosActuales"); 
            
            // Botón de agregar anuncios
        }
        else if (e.getSource() == vista06.getBtn3_JF006_S2_AF())
        {
            
            init.mostrarOcultarPanel("panelEliminarAnunciosActuales"); 
           
            //Botón de eliminar anuncios
        }
    }
    
}
