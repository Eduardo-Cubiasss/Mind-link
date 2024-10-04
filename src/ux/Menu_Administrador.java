/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Ui.Deriv_JP014_S2_AF;
import Ui.JP004_S2_AF;
import Ui.JP014_S2_AF;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author 50369
 */
public class Menu_Administrador implements ActionListener {

    private JPanel JPContenido;
    private JP004_S2_AF panel;
    private PanelHistory panelHistory;
    private HabilitarPaneles PanelesManager;
    private Inicializador init;
    private JP014_S2_AF vista14;
    private Deriv_JP014_S2_AF vista141;
    private SolicitudesDeEmpleados controller14;

    public Menu_Administrador(JPanel JPContenido, JP004_S2_AF panel, HabilitarPaneles PanelesManager, Inicializador init,
            JP014_S2_AF vista14, Deriv_JP014_S2_AF vista141, SolicitudesDeEmpleados controller14) {
        this.JPContenido = JPContenido;
        this.panel = panel;
        this.init = init;
        this.vista14 = vista14;
        this.vista141 = vista141;
        this.controller14 = controller14;
        this.PanelesManager = PanelesManager;

        this.panel.btn01_JF005_S2_AF.addActionListener(this);
        this.panel.btn03_JF005_S2_AF.addActionListener(this);
        this.panel.btn04_JF005_S2_AF.addActionListener(this);
        this.panel.btn08_JF023_S3_RH.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panel.getBtn01_JF005_S2_AF()) {
            // Código para la acción del botón de gestionar persionas 

            init.mostrarOcultarPanel("panelPersonalClinica");

        } else if (e.getSource() == panel.getBtn03_JF005_S2_AF()) {

            init.mostrarOcultarPanel("panelCrearCita");

            // Código para la acción del botón CrearCita 
        } else if (e.getSource() == panel.getBtn04_JF005_S2_AF()) {

            // Código para la acción del botón incapacidades
            vista141.getBtnRedactarMensaje().setVisible(false);
            vista141.getjLabel3().setText("");
            vista141.getjLabel5().setText("");
            init.mostrarOcultarPanel("panelSolicitudesDeEmpleados");
            controller14.procesarBtn1_JF014_S2();
            vista14.mostrarOcultarPanel(vista141);

        }  else if (e.getSource() == panel.getBtn08_JF023_S3_RH()) {
            init.reiniciarControllers();
            // Código para la acción del botón cerrar sesion
            init.mostrarOcultarPanel("panelInicioSesion");

            // Recupera el panel anterior del historial y muéstralo
        }
    }
}
