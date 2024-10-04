/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Ui.Deriv_JP014_S2_AF;
import Ui.JP014_S2_AF;
import Ui.JP039_S3_RH;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author 50369
 */
public class Menu_Secretaria implements ActionListener {

    private JPanel JPContenido;
    private JP039_S3_RH vista39;
    private HabilitarPaneles PanelesManager;
    private CardLayout cardLayout;
    private String panelActual = "vista39";
    private Inicializador init;
    private JP014_S2_AF vista14;
    private Deriv_JP014_S2_AF vista141;
    private SolicitudesDeEmpleados controller14;
    //Declarar Paneles manager

    public Menu_Secretaria(JPanel JPContenido, JP039_S3_RH vista39, HabilitarPaneles PanelesManager, Inicializador init, JP014_S2_AF vista14, Deriv_JP014_S2_AF vista141,
            SolicitudesDeEmpleados controller14) //Ponerlo en la clase para indicar que se espera usar
    {
        this.JPContenido = JPContenido;
        this.vista39 = vista39;
        this.vista14 = vista14;
        this.vista141 = vista141;
        this.controller14 = controller14;
        this.init = init;
        this.PanelesManager = PanelesManager;
        
        //Hacer this a PanelesManager

        this.vista39.getBtn05_JF039_S3_RH().addActionListener(this);
        this.vista39.getBtn06_JF039_S3_RH().addActionListener(this);
        this.vista39.getBtn08_JF039_S3_RH().addActionListener(this);
        this.vista39.getBtn09_JF039_S3_RH().addActionListener(this);
        this.vista39.getBtn06_JF023_S3_RH().addActionListener(this);
        this.vista39.getBtn03_JF005_S2_AF().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista39.getBtn05_JF039_S3_RH()) {

            init.mostrarOcultarPanel("panelDetallesDeMiPerfil");

            //Botón de mi perfil
        } else if (e.getSource() == vista39.getBtn06_JF039_S3_RH()) {
            vista141.getBtnRedactarMensaje().setVisible(true);
            vista141.getjLabel3().setText("Redactar");
            vista141.getjLabel5().setText("Mensaje");
            init.mostrarOcultarPanel("panelSolicitudesDeEmpleados");
            controller14.procesarBtn1_JF014_S2();
            vista14.mostrarOcultarPanel(vista141);

            //Botón de solicitud de incapacidades
        } else if (e.getSource() == vista39.getBtn08_JF039_S3_RH()) {
            init.reiniciarControllers();
            init.mostrarOcultarPanel("panelInicioSesion");

            //Botón de Cerrar Sesión, lleva lleva al login dah
        } else if (e.getSource() == vista39.getBtn09_JF039_S3_RH()) {

            init.mostrarOcultarPanel("panelBuscadorPacientes");

        }else if (e.getSource() == vista39.getBtn06_JF023_S3_RH()) {
            
            init.mostrarOcultarPanel("panelRedactarMensaje");
        }
        else if (e.getSource() == vista39.getBtn03_JF005_S2_AF())
        {
            init.mostrarOcultarPanel("panelCrearCita");
        }
    }
}
