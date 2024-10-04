/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Database.Empleado;
import Database.Procesos_almacenados;
import Ui.JP017_1_S2_RH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class VerSolicitudAprobada implements ActionListener {

    private JPanel JPContenido;
    private JP017_1_S2_RH vista17;
    private Inicializador init;
    private Procesos_almacenados procesos;
    private Empleado modelEmpleado;

    public VerSolicitudAprobada(JPanel JPContenido, JP017_1_S2_RH vista17, Inicializador init, Procesos_almacenados procesos, Empleado modelEmpleado) {
        this.procesos = procesos;
        this.modelEmpleado = modelEmpleado;
        this.JPContenido = JPContenido;
        this.vista17 = vista17;
        this.init = init;

        this.vista17.getBtn1_JF017_S2_RH1().addActionListener(this); 
        this.vista17.getBtn2_JF017_S2_RH1().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista17.getBtn1_JF017_S2_RH1()) {
            //Botón para volver a un panel anterior
            init.mostrarOcultarPanel("panelSolicitudesDeEmpleados");
        } else if (e.getSource() == vista17.getBtn2_JF017_S2_RH1()) {
            procesos.ActualizarPermiso(modelEmpleado, 2);
            //Botón para negar solicitud
        }
    }

}
