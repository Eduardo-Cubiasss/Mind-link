/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Database.Empleado;
import Database.Incapacidades;
import Database.Procesos_almacenados;
import Ui.Deriv_JP014_S2_AF;
import Ui.JP015_1_S2_RH;
import Ui.JP016_S2_AF;
import Ui.JP019_1_S2_RH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 50369
 */
public class Recibidos_Deriv implements ActionListener {

    private JPanel JPContenido;
    private Deriv_JP014_S2_AF vista141;
    private HabilitarPaneles PanelesManager;
    private Inicializador init;
    private DefaultTableModel tableModel;
    private Empleado modelEmpleado;
    private Procesos_almacenados procesos;
    private Incapacidades modelPermiso;
    private JP015_1_S2_RH vista15;

    public Recibidos_Deriv(JPanel JPContenido, Deriv_JP014_S2_AF vista141, HabilitarPaneles PanelesManager, Inicializador init,
            Empleado modelEmpleado, Procesos_almacenados procesos, Incapacidades modelPermiso, JP015_1_S2_RH vista15) {
        this.modelEmpleado = modelEmpleado;
        this.procesos = procesos;
        this.modelPermiso = modelPermiso;
        this.vista15 = vista15;
        this.JPContenido = JPContenido;
        this.vista141 = vista141;
        this.init = init;
        this.PanelesManager = PanelesManager;
        this.vista141.getBtn4_JF014_S2().addActionListener(this);
        this.vista141.getBtnRedactarMensaje().addActionListener(this);

        String[] columnTitles = {"Id", "Nombres", "Asunto"};

        tableModel = new DefaultTableModel(columnTitles, 0);
        vista141.getjTable1().setModel(tableModel);
        vista141.getjTable1().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = vista141.getjTable1().getSelectedRow();

                if (filaSeleccionada != -1) {
                    Object valorIDUsuario = vista141.getjTable1().getValueAt(filaSeleccionada, 0);

                    if (valorIDUsuario != null) {
                        int IDUsuario = Integer.parseInt(valorIDUsuario.toString());
                        modelEmpleado.setIDUsuario(IDUsuario);
                        System.out.println(IDUsuario);
                    }
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista141.getBtn4_JF014_S2()) {
            try {
                procesos.viewpermiso(modelEmpleado, modelPermiso);
                vista15.setLblAsunto(modelPermiso.getAsunto());
                vista15.setLbNotasText(modelPermiso.getMensaje());
                vista15.LbNotas.setEnabled(false);
                // Obtén el valor int que deseas mostrar

                init.mostrarOcultarPanel("panelNuevaSolicitudDeEmpleado");

            } catch (Exception ex) {
                // Captura la excepción y muestra un mensaje de error
                JOptionPane.showMessageDialog(null, "Error al ver el expediente del paciente, seleccione un paciente por favor", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            }

            //Botón para abrir un mensaje seleccionado
        } else if (e.getSource() == vista141.getBtnRedactarMensaje()) {
            init.mostrarOcultarPanel("panelRedactarMensaje");
            // Botón para redactar un permiso
        }

    }

}
