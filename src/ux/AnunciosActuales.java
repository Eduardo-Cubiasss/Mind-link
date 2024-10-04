/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Database.Anuncios;
import Database.Procesos_almacenados;
import Ui.JP011_S2_RH;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.TransferHandler;

/**
 *
 * @author LENOVO
 */
public class AnunciosActuales implements ActionListener {

    private JPanel JPContenido;
    private JP011_S2_RH vista11;
    private HabilitarPaneles PanelesManager;
    private Anuncios modelAnuncios;
    private Procesos_almacenados procesos;
    private JScrollPane scrollPane;
    private Inicializador init;

    private ImageIcon createResizedImageIcon(byte[] imageData, int width, int height) throws IOException {
        BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(imageData));
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();
        return new ImageIcon(resizedImage);
    }

    public void apilarComponentesEnBoxLayout(Date fecha, String titulo, byte[] imagenData) {
        try {
            // Obtén el PanelAnuncioView existente desde vista11
            JPanel panelAnuncioView = vista11.getPanelAnuncioView();

            // Crear un JPanel para cada registro con bordes redondeados
            JPanel registroPanel = new JPanel();
            registroPanel.setLayout(new BoxLayout(registroPanel, BoxLayout.Y_AXIS));

            registroPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

            // Agregar el título al registroPanel si no es nulo ni está vacío
            if (titulo != null && !titulo.isEmpty()) {
                JLabel lblTitulo = new JLabel(titulo);
                registroPanel.add(lblTitulo);
            }

            // Verificar si imagenData no es nulo y tiene contenido
            if (imagenData != null && imagenData.length > 0) {
                // Redimensionar la imagen antes de agregarla al registroPanel
                ImageIcon resizedIcon = createResizedImageIcon(imagenData, 200, 200); // Cambia las dimensiones según tus necesidades
                JLabel lblImagen = new JLabel(resizedIcon);
                registroPanel.add(lblImagen);
            }

            // Agregar la fecha al registroPanel si no es nula
            if (fecha != null) {
                JLabel lblFecha = new JLabel("Fecha: " + fecha.toString());
                registroPanel.add(lblFecha);
            }

            // Agregar el registroPanel al PanelAnuncioView
            panelAnuncioView.add(registroPanel);

            // Actualizar el PanelAnuncioView
            panelAnuncioView.revalidate();
            panelAnuncioView.repaint();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public AnunciosActuales(JPanel JPContenido, JP011_S2_RH vista11, HabilitarPaneles PanelesManager, Anuncios modelAnuncios, Procesos_almacenados procesos, Inicializador init) {
        this.JPContenido = JPContenido;
        this.vista11 = vista11;
        this.modelAnuncios = modelAnuncios;
        this.PanelesManager = PanelesManager;
        this.procesos = procesos;
       this.init = init;
        this.vista11.getBtn1_JF011_S2_RH().addActionListener(this);
        this.vista11.getBtn3_JF011_S2_RH().addActionListener(this);
        scrollPane = new JScrollPane(vista11.getPanelAnuncioView());
        vista11.getPanelAnuncioView().setLayout(new BoxLayout(vista11.getPanelAnuncioView(), BoxLayout.Y_AXIS));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JPContenido.add(scrollPane);
        vista11.getTxt_imagen().setEditable(false);
        vista11.getTxt_imagen().setTransferHandler(new TransferHandler() {
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
                            vista11.getTxt_imagen().setText(filePath);
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
        if (e.getSource() == vista11.getBtn1_JF011_S2_RH()) {
            
            init.mostrarOcultarPanel("panelCreacionDeAnuncios"); 
            
            //Pa volver al menú de admin gr
        } else if (e.getSource() == vista11.getBtn3_JF011_S2_RH()) {
            //Pa guardar todos los cambios hechos
            modelAnuncios.setTitulo(vista11.getTxtNombre().getText());
            String imagePath = vista11.getTxt_imagen().getText(); // Obtener la ruta de la imagen desde el campo de texto

            try {
                // Lee el archivo de imagen y conviértelo en un arreglo de bytes
                FileInputStream fis = new FileInputStream(new File(imagePath));
                byte[] imageData = new byte[(int) new File(imagePath).length()];
                fis.read(imageData);
                fis.close();

                // Establece el arreglo de bytes en el modelo de empleado
                modelAnuncios.setImagen(imageData);

                // Luego, realiza la inserción en la base de datos utilizando el modelo actualizado
                boolean insercionExitosa = procesos.AgregarAnuncio(modelAnuncios);

                if (insercionExitosa) {
                    // La inserción se realizó con éxito, puedes mostrar un mensaje al usuario
                    JOptionPane.showMessageDialog(vista11, "Imagen de perfil guardada con éxito en la base de datos.");
                } else {
                    // La inserción falló, muestra un mensaje de error si es necesario
                    JOptionPane.showMessageDialog(vista11, "Error al guardar la imagen de perfil en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

}
