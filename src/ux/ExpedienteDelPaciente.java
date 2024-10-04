/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Database.AgendasPersonales;
import Database.Contactos;
import Database.Expedientes;
import Database.Genero;
import Database.Pacientes;
import Database.Procesos_almacenados;
import Database.Usuarios;
import Ui.JP0048_S3_RH;
import Ui.JP031_S3_RHG;
import Ui.JP034_S3_AF;
import Ui.JP035_1_S3_RH;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class ExpedienteDelPaciente implements ActionListener {

    private JPanel JPContenido;
    private Usuarios modelUsers;
    private JP031_S3_RHG vistaJP031;
    private JP035_1_S3_RH vista35;
    private JP034_S3_AF vista34;
    private Procesos_almacenados Procesos;
    private HabilitarPaneles PanelesManager;
    private Contactos modelContactos;
    private Pacientes modelPaciente;
    private AgendasPersonales modelAgendas;
    private Expedientes modelExp;
    private Inicializador init;

    public ExpedienteDelPaciente(JPanel JPContenido, Pacientes modelPaciente, Usuarios modelUsers, JP031_S3_RHG vistaJP031,
            Procesos_almacenados Procesos, HabilitarPaneles PanelesManager, Contactos modelContactos, JP035_1_S3_RH vista35,
            AgendasPersonales modelAgendas, Expedientes modelExp, JP034_S3_AF vista34, Inicializador init) {
        this.JPContenido = JPContenido;
        this.PanelesManager = PanelesManager;
        this.modelPaciente = modelPaciente;
        this.modelUsers = modelUsers;
        this.vistaJP031 = vistaJP031;
        this.vista35 = vista35;
        this.vista34 = vista34;
        this.Procesos = Procesos;
        this.modelAgendas = modelAgendas;
        this.modelContactos = modelContactos;
        this.modelExp = modelExp;
        this.init = init;
        this.vistaJP031.getBtn01_JP031_S3_RH().addActionListener(this);
        this.vistaJP031.getBtn1_JF031_S3_RH().addActionListener(this);
        this.vistaJP031.getBtn2_JF031_S3_RH1().addActionListener(this);
        this.vistaJP031.getBtn3_JF031_S3_RH2().addActionListener(this);
        this.vistaJP031.getBtn4_JF031_S3_RH().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vistaJP031.getBtn01_JP031_S3_RH()) {
            modelPaciente.setMensajito(vistaJP031.getTxtEscribirMensaje_JP031_S3_RH().getText());
            System.out.println("Vamos a vel " + modelPaciente.getMensajito());
            Procesos.viewpaciente(modelPaciente, modelUsers, modelContactos, 2);

        } else if (e.getSource() == vistaJP031.getBtn4_JF031_S3_RH()) {

            //recetitas pa lokitos
            init.mostrarOcultarPanel("panelRecetarMedicamentos");

        } else if (e.getSource() == vistaJP031.getBtn3_JF031_S3_RH2()) {
            Procesos.VerNotasPac(modelPaciente, modelAgendas);
            vista35.getLbNotas().setText(modelAgendas.getContenido());
            vista35.LbNotas.setEnabled(false);

            init.mostrarOcultarPanel("panelVisualizarNotas");

            //pa visualizar notitas
        } else if (e.getSource() == vistaJP031.getBtn2_JF031_S3_RH1()) {
            Procesos.VerExpe(modelExp, modelPaciente);
            vista34.getTxtAExpeciente().setText(modelExp.getContenido());

            //Escribir en agenda
            init.mostrarOcultarPanel("panelEscribirEnTuAgendaPersonal");

        }
        else if (e.getSource() == vistaJP031.getBtn1_JF031_S3_RH())
        {
            init.mostrarOcultarPanel("panelBuscadorPacientes");
        }
    }

}
