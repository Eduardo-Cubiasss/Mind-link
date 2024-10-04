/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Database.Empleado;
import Database.Incapacidades;
import Database.Procesos_almacenados;
import Database.Secretarias;
import Ui.Deriv_JP014_S2_AF;
import Ui.JP014_S2_AF;
import Ui.JP016_S2_AF;
import Ui.JP018_S2_AF;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class SolicitudesDeEmpleados implements ActionListener {

    private JPanel JPContenido;
    private JP014_S2_AF vista14;
    private HabilitarPaneles PanelesManager;
    private JPanel ContenedorPapi;
    private JPanel ContenedorHijo;
    private JP018_S2_AF vista18;
    private JP016_S2_AF vista16;
    private Deriv_JP014_S2_AF vista141;
    private Inicializador init;
    private Procesos_almacenados procesos;
    private Empleado modelEmpleado;
    private Incapacidades modelPermiso;
    private Resultado resultado;
    private Secretarias modelSec; 

    public SolicitudesDeEmpleados(JPanel JPContenido, JP014_S2_AF vista14, HabilitarPaneles PanelesManager, Inicializador init,
            JP018_S2_AF vista18, JP016_S2_AF vista16, Deriv_JP014_S2_AF vista141, Empleado modelEmpleado, Incapacidades modelPermiso, Procesos_almacenados procesos,
            Resultado resultado, Secretarias modelSec) {
        this.modelEmpleado = modelEmpleado;
        this.modelPermiso = modelPermiso;
        this.JPContenido = JPContenido;
        this.procesos = procesos;
        this.resultado = resultado;
        this.vista14 = vista14;
        this.vista18 = vista18;
        this.vista16 = vista16;
        this.vista141 = vista141;
        this.modelSec = modelSec;
        this.init = init;
        this.PanelesManager = PanelesManager;
        this.vista14.getBtn1_JF014_S2().addActionListener(this);
        this.vista14.getBtn2_JF014_S2().addActionListener(this);
        this.vista14.getBtn3_JF014_S2().addActionListener(this);
        this.vista14.getBtn5_JF014_S2().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        {
            if (e.getSource() == vista14.getBtn1_JF014_S2()) {
                // Llama a la query VerSolicitudes con Estado 0
                List<Resultado> resultados = procesos.VerSolicitudes(modelEmpleado, modelPermiso, 0);
                actualizarTablaConResultados(resultados, vista141.getjTable1());
                // Haz algo con los resultados (por ejemplo, mostrarlos en una tabla)
                vista14.mostrarOcultarPanel(vista141);
            } else if (e.getSource() == vista14.getBtn2_JF014_S2()) {
                // Llama a la query VerSolicitudes con Estado 1
                List<Resultado> resultados = procesos.VerSolicitudes(modelEmpleado, modelPermiso, 1);
                actualizarTablaConResultados(resultados, vista16.getjTable1());
                // Haz algo con los resultados (por ejemplo, mostrarlos en una tabla)
                vista14.mostrarOcultarPanel(vista16);
            } else if (e.getSource() == vista14.getBtn3_JF014_S2()) {
                // Llama a la query VerSolicitudes con Estado 2
                List<Resultado> resultados = procesos.VerSolicitudes(modelEmpleado, modelPermiso, 2);
                actualizarTablaConResultados(resultados, vista18.getjTable1());
                // Haz algo con los resultados (por ejemplo, mostrarlos en una tabla)
                vista14.mostrarOcultarPanel(vista18);
            } else if (e.getSource() == vista14.getBtn5_JF014_S2()) {
                if(modelSec.getIDSecretaria() == 0)
                {
                    init.mostrarOcultarPanel("panelMenuAdmin");
                }
                else
                {
                    init.mostrarOcultarPanel("panelMenuSec");
                }
                
            }
        }
    }

    public void procesarBtn1_JF014_S2() {
        // Llama a la query VerSolicitudes con Estado 0
        List<Resultado> resultados = procesos.VerSolicitudes(modelEmpleado, modelPermiso, 0);
        actualizarTablaConResultados(resultados, vista141.getjTable1());
        // Haz algo con los resultados (por ejemplo, mostrarlos en una tabla)
    }

    private void actualizarTablaConResultados(List<Resultado> resultados, JTable jTable) {
        DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
        tableModel.setRowCount(0); // Borra todas las filas existentes en la tabla

        for (Resultado resultado : resultados) {
            Object[] rowData = {resultado.getIdPaciente(), resultado.getNombre(), resultado.getApellido()};
            tableModel.addRow(rowData); // Agrega una fila con los datos de cada resultado
        }
    }

}
