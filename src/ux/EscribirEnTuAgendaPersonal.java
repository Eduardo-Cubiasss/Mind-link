/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Database.Expedientes;
import Database.Pacientes;
import Database.Procesos_almacenados;
import Database.Terapeutas;
import Ui.JP034_S3_AF;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class EscribirEnTuAgendaPersonal implements ActionListener {

    private JPanel JPContenido;
    private JP034_S3_AF vista34;
    private HabilitarPaneles PanelesManager;
    private Procesos_almacenados Procesos;
    private Terapeutas modelTer;
    private Pacientes modelPacien;
    private Expedientes modelExp;
    private Inicializador init;

    public EscribirEnTuAgendaPersonal(JPanel JPContenido, JP034_S3_AF vista34, HabilitarPaneles PanelesManager, Procesos_almacenados Procesos,
            Terapeutas modelTer, Pacientes modelPacien, Expedientes modelExp, Inicializador init) {
        this.JPContenido = JPContenido;
        this.vista34 = vista34;
        this.PanelesManager = PanelesManager;
        this.Procesos = Procesos;
        this.modelPacien = modelPacien;
        this.modelTer = modelTer;
        this.modelExp = modelExp;
        this.init = init;
        this.vista34.getBtn1_JF034_AF().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista34.getBtn1_JF034_AF()) {
            if ((vista34.getTxtAExpeciente().getText().isEmpty()) || vista34.getTxtAExpeciente().equals(modelExp.getContenido())) {
                init.mostrarOcultarPanel("panelExpedienteDelPaciente");
                // Aquí deberías manejar el caso de que el TextField esté vacío
            } else
            {
                // Aquí puedes continuar con el procesamiento
                modelExp.setContenido(vista34.getTxtAExpeciente().getText());
                Procesos.EscribirExpe(modelPacien, modelTer, modelExp);
                init.mostrarOcultarPanel("panelExpedienteDelPaciente");
            }

            //Botón para volver a un panel anterior
        }
    }

}
