/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Database.Administrador;
import Database.Contactos;
import Database.Empleado;
import Database.Procesos_almacenados;
import Database.Usuarios;
import Ui.JP009_S2_RH;
import java.awt.CardLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

/**
 *
 * @author LENOVO
 */
public class AgregarPerfilesDeUsuario implements ActionListener {

    private JPanel JPContenido;
    private Procesos_almacenados procesos;
    private HabilitarPaneles PanelesManager;
    private Empleado modelEmpleado;
    private JP009_S2_RH vista09;
    private Usuarios modelUsers;
    private Administrador modelAdmin;
    private Contactos modelContactos;
    private Inicializador init;

    public AgregarPerfilesDeUsuario(JPanel JPContenido, Procesos_almacenados procesos, HabilitarPaneles PanelesManager, Empleado modelEmpleado, JP009_S2_RH vista09,
            Usuarios modelUsers, Administrador modelAdmin, Contactos modelContactos, Inicializador init) {
        this.JPContenido = JPContenido;
        this.PanelesManager = PanelesManager;
        this.modelEmpleado = modelEmpleado;
        this.modelAdmin = modelAdmin;
        this.modelContactos = modelContactos;
        this.init = init;
        this.procesos = procesos;
        this.vista09 = vista09;
        this.modelUsers = modelUsers;

        this.vista09.getBtn3_JF009_S2_RH1().addActionListener(this);
        this.vista09.getBtn4_JF009_S2_RH().addActionListener(this);
        this.vista09.getBtn1_JF009_S2_RH().addActionListener(this);
        this.vista09.Txt_imagen.setEditable(false);
        this.vista09.Txt_imagen.setTransferHandler(new TransferHandler() {
            @Override
            public boolean canImport(TransferHandler.TransferSupport support) {
                return support.isDataFlavorSupported(DataFlavor.javaFileListFlavor);
            }

            @Override
            public boolean importData(TransferHandler.TransferSupport support) {
                try {
                    Transferable transferable = support.getTransferable();
                    if (transferable.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                        java.util.List<File> files = (java.util.List<File>) transferable.getTransferData(DataFlavor.javaFileListFlavor);
                        if (!files.isEmpty()) {
                            String filePath = files.get(0).getAbsolutePath();
                            // Puedes modificar para que no se use el filePath (o no)
                            vista09.getTxt_imagen().setText(filePath);
                            return true;
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return false;
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista09.getBtn3_JF009_S2_RH1()) {

            modelEmpleado.setUsername(vista09.getTxtNombre_JF009_S2_RH().getText());
            modelEmpleado.setContraseña(vista09.getTxtContraseña_JF009_S2_RH1().getText());
            modelContactos.setCorreo(vista09.getTxtCorreoE_JF009_S2_RH().getText());
            modelEmpleado.setNivel(vista09.getjComboBox1().getSelectedIndex());
            modelEmpleado.setNombre(vista09.getTxNombre_JF009_S2_RH().getText());
            String imagePath = vista09.getTxt_imagen().getText(); // Obtener la ruta de la imagen desde el campo de texto

            try {
                // Lee el archivo de imagen y conviértelo en un arreglo de bytes
                FileInputStream fis = new FileInputStream(new File(imagePath));
                byte[] imageData = new byte[(int) new File(imagePath).length()];
                fis.read(imageData);
                fis.close();

                // Establece el arreglo de bytes en el modelo de empleado
                modelEmpleado.setFotoPerfil(imageData);

                // Luego, realiza la inserción en la base de datos utilizando el modelo actualizado
                boolean insercionExitosa = procesos.AgregarEmpleado(modelAdmin, modelEmpleado, modelUsers, modelContactos);

                if (insercionExitosa) {
                    // La inserción se realizó con éxito, puedes mostrar un mensaje al usuario
                    JOptionPane.showMessageDialog(vista09, "Imagen de perfil guardada con éxito en la base de datos.");
                } else {
                    // La inserción falló, muestra un mensaje de error si es necesario
                    JOptionPane.showMessageDialog(vista09, "Error al guardar la imagen de perfil en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == vista09.getBtn4_JF009_S2_RH()) {
            vista09.getTxtNombre_JF009_S2_RH().setText(""); // Establece el JTextField en blanco
            vista09.getTxtContraseña_JF009_S2_RH().setText(""); // Establece el JTextField en blanco
            vista09.getTxtCorreoE_JF009_S2_RH().setText(""); // Establece el JTextField en blanco
            vista09.getjComboBox1().setSelectedIndex(0); // Establece el JComboBox en su primer elemento (o el que desees)
        } else if (e.getSource() == vista09.getBtn1_JF009_S2_RH()) {
              System.out.println("Esta aqui pero no entra");
              init.mostrarOcultarPanel("panelPersonalClinica"); 
            //Para regresar al anterior
            
        }

    }

}
