/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Database.Articulos;
import Database.Procesos_almacenados;
import Database.Terapeutas;
import Ui.JP030_S3_AF;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

/**
 *
 * @author LENOVO
 */
public class ActualizarArticulo implements ActionListener {

    private JPanel JPContenido;
    private JP030_S3_AF vista30;
    private Articulos modelArticulo;
    private Procesos_almacenados procesos;
    private Terapeutas modelTer;
    private Inicializador init;

    public ActualizarArticulo(JPanel JPContenido, JP030_S3_AF vista30, Articulos modelArticulo, Procesos_almacenados procesos, Terapeutas modelTer, Inicializador init) {
        this.JPContenido = JPContenido;
        this.procesos = procesos;
        this.modelTer = modelTer;
        this.modelArticulo = modelArticulo;
        this.vista30 = vista30;
                this.init = init;
        this.vista30.getBtn1_JF028_S3_AF().addActionListener(this);
        this.vista30.getBtn2_JF028_S3_AF().addActionListener(this);
        this.vista30.getBtn3_JF028_S3_AF().addActionListener(this);
        this.vista30.getBtn4_JF028_S3_AF().addActionListener(this);
        vista30.getTxt_imagen().setEditable(false);
        vista30.getTxt_imagen().setTransferHandler(new TransferHandler() {
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
                            vista30.getTxt_imagen().setText(filePath);
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
        if (e.getSource() == vista30.getBtn1_JF028_S3_AF()) {
            
                        init.mostrarOcultarPanel("panelCreacionDeAnuncios"); 

            //Botón para volver a un panel anterior
            
            
            
        } else if (e.getSource() == vista30.getBtn2_JF028_S3_AF()) {
            
            
            //Botón para actualizar el contenido del articulo}
            modelArticulo.setTitulo(vista30.getTxtTitulo().getText());
            modelArticulo.setDescripcion(vista30.getTxtDescripcion_JP030_S3_AF().getText());
            //modelArticulo.setImagen(vista30.get);
            procesos.AgregarArticulo(modelArticulo, modelTer, 2);
        } else if (e.getSource() == vista30.getBtn3_JF028_S3_AF()) {
            
            
            //Botón para editar el titulo del ariticulo
        } else if (e.getSource() == vista30.getBtn4_JF028_S3_AF()) {
            
            
            
            //Botón para guardar los cambios
            String imagePath = vista30.getTxt_imagen().getText(); // Obtener la ruta de la imagen desde el campo de texto

        try {
            // Lee el archivo de imagen y conviértelo en un arreglo de bytes
            FileInputStream fis = new FileInputStream(new File(imagePath));
            byte[] imageData = new byte[(int) new File(imagePath).length()];
            fis.read(imageData);
            fis.close();

            // Establece el arreglo de bytes en el modelo de artículo
            modelArticulo.setImagen(imageData);

            // Luego, realiza la inserción en la base de datos utilizando el modelo actualizado
            boolean insercionExitosa = procesos.AgregarArticulo(modelArticulo, modelTer, 2);

            if (insercionExitosa) {
                // La inserción se realizó con éxito, puedes mostrar un mensaje al usuario
                JOptionPane.showMessageDialog(vista30, "Imagen de artículo guardada con éxito en la base de datos.");
            } else {
                // La inserción falló, muestra un mensaje de error si es necesario
                JOptionPane.showMessageDialog(vista30, "Error al guardar la imagen de artículo en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        }
    }

}
