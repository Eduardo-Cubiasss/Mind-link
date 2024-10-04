/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Database.Contactos;
import Database.Pacientes;
import Database.Procesos_almacenados;
import Database.Secretarias;
import Database.Terapeutas;
import Database.Usuarios;
import Ui.JP024_S3_AF;
import Ui.JP031_S3_RHG;
import Ui.JP043_1_S3_RH;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ux.Resultado;

/**
 *
 * @author 50369
 */
public class BuscadorPacientes implements ActionListener {

    private JPanel JPContenido;
    private Pacientes modelPacientes;
    private HabilitarPaneles PanelesManager;
    private JP024_S3_AF vistaJP024;
    private Procesos_almacenados procesos;
    private DefaultTableModel tableModel;
    private Resultado resultado;
    private Usuarios modelUsuers;
    private Contactos modelContacto;
    private JP031_S3_RHG vistaJP031;
    private Secretarias modelSec;
    private Inicializador init;
    private JP043_1_S3_RH vista43;

    public BuscadorPacientes(JPanel JPContenido, Pacientes modelPacientes, JP024_S3_AF vistaJP024, HabilitarPaneles PanelesManager, Procesos_almacenados procesos,
            Resultado resultado, Usuarios modelUsuers, Contactos modelContacto, JP031_S3_RHG vistaJP031, Inicializador init, JP043_1_S3_RH vista43,
            Secretarias modelSec) {
        this.JPContenido = JPContenido;
        this.modelPacientes = modelPacientes;
        this.PanelesManager = PanelesManager;
        this.vistaJP024 = vistaJP024;
        this.resultado = resultado;
        this.procesos = procesos;
        this.modelUsuers = modelUsuers;
        this.modelContacto = modelContacto;
        this.vistaJP031 = vistaJP031;
         this.init = init;
         this.modelSec = modelSec;
         this.vista43 = vista43;
        this.vistaJP024.getBtn1_JF024().addActionListener(this);
        this.vistaJP024.getBtn3_JF024().addActionListener(this);
        this.vistaJP024.getBtnVer().addActionListener(this);

        String[] columnTitles = {"Id", "Nombres", "Apellidos"};

        tableModel = new DefaultTableModel(columnTitles, 0);
        vistaJP024.getJTable1().setModel(tableModel);

        vistaJP024.getJTable1().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = vistaJP024.getJTable1().getSelectedRow();

                if (filaSeleccionada != -1) {
                    Object valorIDUsuario = vistaJP024.getJTable1().getValueAt(filaSeleccionada, 0);

                    if (valorIDUsuario != null) {
                        int IDUsuario = Integer.parseInt(valorIDUsuario.toString());
                        modelPacientes.setIDpaciente(IDUsuario);
                        System.out.println(IDUsuario);
                    }
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaJP024.getBtn1_JF024()) {
            String textoBusqueda = vistaJP024.getTxtBuscar_JP024() != null ? vistaJP024.getTxtBuscar_JP024().getText() : null;

            if (textoBusqueda != null && !textoBusqueda.isEmpty()) {
                System.out.println(textoBusqueda);
                actualizarTablaConResultadosDeBusqueda(textoBusqueda);
            } else {
                JOptionPane.showMessageDialog(null, "El JTextField de búsqueda esta vacío.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                // Puedes realizar otras acciones apropiadas aquí si es necesario
            }
        } else if (e.getSource() == vistaJP024.getBtnVer()) {
            try {
                procesos.viewpaciente(modelPacientes, modelUsuers, modelContacto, 1);
                vistaJP031.setJL_Correo_JF031_S3_RH(modelContacto.getCorreo());
                // Obtén el valor int que deseas mostrar
                int valorInt = modelPacientes.getFnacimiento();

                // Convierte el valor int a una cadena (String)
                String valorStr = String.valueOf(valorInt);

                // Establece la cadena en el JLabel
                vistaJP031.setJL_Edad_JF031_S3_RH(valorStr);

                vistaJP031.setJL_Nombre_JF031_S3_RH(modelPacientes.getNombre());
                init.mostrarOcultarPanel("panelExpedienteDelPaciente"); 

            } catch (Exception ex) {
                // Captura la excepción y muestra un mensaje de error
                JOptionPane.showMessageDialog(null, "Error al ver el expediente del paciente, seleccione un paciente por favor", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else if (e.getSource() == vistaJP024.getBtn3_JF024())
        {
            if(modelPacientes.isSeñal() == true)
            {
                vista43.setTxtID_JP043_S3_RH(String.valueOf(modelPacientes.getIDpaciente()));
                init.mostrarOcultarPanel("panelCrearCita");
            }
            else if(modelSec.getIDSecretaria()== 0)
            {
            init.mostrarOcultarPanel("panelMenuTp");
            }
            else
            {
            init.mostrarOcultarPanel("panelMenuSec");
            }
        }
    }

    private void actualizarTablaConResultadosDeBusqueda(String textoBusqueda) {
        // Borra todas las filas existentes en el modelo
        tableModel.setRowCount(0);

        // Aquí debes realizar la consulta a la base de datos
        // y obtener los resultados que coincidan con el texto de búsqueda
        List<Resultado> resultados = procesos.Pacientes(modelPacientes, 1, textoBusqueda);

        for (Resultado resultado : resultados) {
            tableModel.addRow(new Object[]{resultado.getIdPaciente(), resultado.getNombre(), resultado.getApellido()});
        }
    }
}
