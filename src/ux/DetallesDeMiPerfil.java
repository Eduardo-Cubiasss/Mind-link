/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Database.Procesos_almacenados;
import Database.Terapeutas;
import Database.Usuarios;
import Ui.JP0048_S3_RH;
import Ui.JP025_S3_RH;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class DetallesDeMiPerfil implements ActionListener {

    private JPanel JPContenido;
    private JP025_S3_RH vista25;
    private Usuarios modelUsers;
    private Procesos_almacenados proceso;
    private HabilitarPaneles PanelesManager;
    private Inicializador init;
    private Terapeutas modelTerap;
    private JP0048_S3_RH vistaJP048;

    public DetallesDeMiPerfil(JPanel JPContenido, JP025_S3_RH vista25, Usuarios modelUsers, Procesos_almacenados proceso, HabilitarPaneles PanelesManager,
            Inicializador init, Terapeutas modelTerap, JP0048_S3_RH vistaJP048) {
        this.JPContenido = JPContenido;
        this.vista25 = vista25;
        this.modelUsers = modelUsers;
        this.proceso = proceso;
        this.vistaJP048 = vistaJP048;
        this.modelTerap = modelTerap;
        this.PanelesManager = PanelesManager;
        this.init = init;
        this.vista25.getBtn04_JF025_S3_RH().addActionListener(this);
        this.vista25.getBtn05_JF025_S3_RH().addActionListener(this);
        this.vista25.getBtnotrasconfig().addActionListener(this);
        this.vista25.getBtn1_JF025_S3_RH().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista25.getBtn04_JF025_S3_RH()) {
            modelUsers.setContraseña(vista25.getTxtContraseñaActual_JF025_S3_RH().getText());
            modelUsers.setContrafake(vista25.getTxtContraNueva_JF025_S3_RH().getText());
            proceso.Acercademi(modelUsers, 2);

        } else if (e.getSource() == vista25.getBtn05_JF025_S3_RH()) {
            modelUsers.setDescripcion(vista25.getTxtDescrip_JF025_S3_RH().getText());
            proceso.Acercademi(modelUsers, 3);
        } else if (e.getSource() == vista25.getBtnotrasconfig()) {
            vistaJP048.getBtn02_JF048_S3_RH().setVisible(false);
            init.mostrarOcultarPanel("panelPrimerUso");

        } else if (e.getSource() == vista25.getBtn1_JF025_S3_RH()) {
            vistaJP048.getBtn02_JF048_S3_RH().setVisible(true);
            if (modelTerap.getIDTerapeuta() == 0) {
                init.mostrarOcultarPanel("panelMenuSec");
            } else {
                init.mostrarOcultarPanel("panelMenuTp");
            }

        }
    }

}
