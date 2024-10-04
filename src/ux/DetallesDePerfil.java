/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Database.Empleado;
import Ui.JP010_S2_AF;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class DetallesDePerfil implements ActionListener {

    private JPanel JPContenido;
    private JP010_S2_AF vista10;
    private HabilitarPaneles PanelesManager;
    private Empleado modelEmpleado;
    private Inicializador init;

    public DetallesDePerfil(JPanel JPContenido, JP010_S2_AF vista10, HabilitarPaneles PanelesManager, Empleado modelEmpleado, Inicializador init) {
        this.JPContenido = JPContenido;
        this.vista10 = vista10;
        this.init = init;
        this.PanelesManager = PanelesManager;
        this.modelEmpleado = modelEmpleado;
        
        this.vista10.getBtn1_JF010_AF().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if (e.getSource() == vista10.getBtn1_JF010_AF()) {
            
             init.mostrarOcultarPanel("panelBuscadorDeEmpleados"); 

           
            // Esto es para volver al menú de administrador
        }
    }
}
