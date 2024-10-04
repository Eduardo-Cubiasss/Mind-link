/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Database.Empleado;
import Database.Incapacidades;
import Database.Procesos_almacenados;
import Ui.JP015_1_S2_RH;
import Ui.JP016_S2_AF;
import Ui.JP017_1_S2_RH;
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
public class SolicitudesAprobadas implements ActionListener {

    private JPanel JPContenido;
    private JP016_S2_AF vista16;
    private HabilitarPaneles PanelesManager;
    private Inicializador init;
    private Empleado modelEmpleado;
    private Procesos_almacenados procesos;
    private Incapacidades modelPermiso;
    private JP017_1_S2_RH vista17;
    private DefaultTableModel tableModel;

    public SolicitudesAprobadas(JPanel JPContenido, JP016_S2_AF vista16, HabilitarPaneles PanelesManager, Inicializador init,
           Empleado modelEmpleado, Procesos_almacenados procesos, Incapacidades modelPermiso, JP017_1_S2_RH vista17)
    {
        this.modelEmpleado = modelEmpleado;
        this.procesos = procesos;
        this.modelPermiso = modelPermiso;
        this.vista17 = vista17;
        this.JPContenido = JPContenido;
        this.vista16 = vista16;
        this.init = init;
        this.PanelesManager = PanelesManager;
        this.vista16.getBtn4_JF016_S2().addActionListener(this);

        String[] columnTitles = {"Id", "Nombres", "Asunto"};

        tableModel = new DefaultTableModel(columnTitles, 0);
        vista16.getjTable1().setModel(tableModel);
        vista16.getjTable1().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = vista16.getjTable1().getSelectedRow();

                if (filaSeleccionada != -1) {
                    Object valorIDUsuario = vista16.getjTable1().getValueAt(filaSeleccionada, 0);

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
        if (e.getSource() == vista16.getBtn4_JF016_S2()) {
            try {
                procesos.viewpermiso(modelEmpleado, modelPermiso);
                vista17.setLblAsunto(modelPermiso.getAsunto());
                vista17.getLbNotas().setText(modelPermiso.getMensaje());
                System.out.println("Esto es lo que contiene el mensaje :"+ modelPermiso.getMensaje());
                vista17.LbNotas.setEnabled(false);
                // Obtén el valor int que deseas mostrar

                init.mostrarOcultarPanel("panelSolicitudAprobadaMensaje");

            } catch (Exception ex) {
                // Captura la excepción y muestra un mensaje de error
                JOptionPane.showMessageDialog(null, "Error al ver el permiso de la persona del paciente, seleccione un paciente por favor", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        //Botón para abrir un mensaje seleccionado
    }

}
