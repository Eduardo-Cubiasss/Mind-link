/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Database.Empleado;
import Database.Incapacidades;
import Database.Procesos_almacenados;
import Ui.JP018_S2_AF;
import Ui.JP019_1_S2_RH;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class SolicitudesAprobadas2 implements ActionListener {

    private JPanel JPContenido;
    private JP018_S2_AF vista18;
    private HabilitarPaneles PanelesManager;
    private Inicializador init;
    private DefaultTableModel tableModel;
    private Empleado modelEmpleado;
    private Procesos_almacenados procesos;
    private Incapacidades modelPermiso;
    private JP019_1_S2_RH vista19;

    public SolicitudesAprobadas2(JPanel JPContenido, JP018_S2_AF vista18, HabilitarPaneles PanelesManager, Inicializador init,
            Empleado modelEmpleado, Procesos_almacenados procesos, Incapacidades modelPermiso, JP019_1_S2_RH vista19) {
        this.modelEmpleado = modelEmpleado;
        this.procesos = procesos;
        this.modelPermiso = modelPermiso;
        this.vista19 = vista19;
        this.JPContenido = JPContenido;
        this.vista18 = vista18;
        this.init = init;
        this.PanelesManager = PanelesManager;
        this.vista18.getBtn4_JF018_S2().addActionListener(this);
        String[] columnTitles = {"Id", "Nombres", "Asunto"};

        tableModel = new DefaultTableModel(columnTitles, 0);
        vista18.getjTable1().setModel(tableModel);
        vista18.getjTable1().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = vista18.getjTable1().getSelectedRow();

                if (filaSeleccionada != -1) {
                    Object valorIDUsuario = vista18.getjTable1().getValueAt(filaSeleccionada, 0);

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

        if (e.getSource() == vista18.getBtn4_JF018_S2()) {
            try {
                procesos.viewpermiso(modelEmpleado, modelPermiso);
                vista19.setLblAsunto(modelPermiso.getAsunto());
                vista19.getLbNotas().setText(modelPermiso.getMensaje());
                vista19.LbNotas.setEnabled(false);
                // Obtén el valor int que deseas mostrar

                init.mostrarOcultarPanel("panelSolicitudesRechazadas");

            } catch (Exception ex) {
                // Captura la excepción y muestra un mensaje de error
                JOptionPane.showMessageDialog(null, "Error al ver el expediente del paciente, seleccione un paciente por favor", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            }

            //Botón para abrir solicitud
        }

    }

}
