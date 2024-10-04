/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Database.Anuncios;
import Database.Procesos_almacenados;
import Ui.JP021_S3_RH;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author LENOVO
 */
public class EliminarAnunciosActuales implements ActionListener {

    private JPanel JPContenido;
    private JP021_S3_RH vista21;
    private HabilitarPaneles PanelesManager;
    private Procesos_almacenados procesos;
    private Anuncios adds;
    private Inicializador init;

    private Icon createCircleIcon(int size, Color color) {
        return new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setColor(color);
                g2d.fill(new Ellipse2D.Double(x, y, size, size));
                g2d.dispose();
            }

            @Override
            public int getIconWidth() {
                return size;
            }

            @Override
            public int getIconHeight() {
                return size;
            }
        };
    }

    private ImageIcon createResizedImageIcon(byte[] imageData, int width, int height) throws IOException {
        BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(imageData));
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();
        return new ImageIcon(resizedImage);
    }

    public void apilarComponentesEnBoxLayout(int IDAnuncio, Date fecha, String titulo, byte[] imagenData) {
        try {
            // Obtén el PanelAnuncioView existente desde vista11
            JPanel panelAnuncioView = vista21.getPanelAnuncioView();

            // Crear un JPanel para cada registro con bordes redondeados
            JPanel registroPanel = new JPanel();
            registroPanel.setLayout(new BoxLayout(registroPanel, BoxLayout.Y_AXIS));

            registroPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

            // Crear un JCheckBox personalizado con un ícono de círculo
            JCheckBox checkBox = new JCheckBox();
            checkBox.setIcon(createCircleIcon(20, Color.BLACK)); // Cambia el tamaño y el color del círculo según tus necesidades
            checkBox.setSelectedIcon(createCircleIcon(20, Color.RED)); // Ícono cuando está seleccionado
            checkBox.setBorderPaintedFlat(true); // Quita el borde de la casilla de verificación
            registroPanel.add(checkBox);

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

            // Asignar un escuchador de eventos para la casilla de verificación
            checkBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (checkBox.isSelected()) {
                        // La casilla de verificación está seleccionada
                        // Puedes realizar acciones con el IDAnuncio aquí
                       adds.setIDAnuncio(IDAnuncio);
                    } else {
                        // La casilla de verificación está deseleccionada
                    }
                }
            });

            // Actualizar el PanelAnuncioView
            panelAnuncioView.revalidate();
            panelAnuncioView.repaint();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public EliminarAnunciosActuales(JPanel JPContenido, JP021_S3_RH vista21, HabilitarPaneles PanelesManager, Procesos_almacenados procesos, Anuncios adds, Inicializador init) {
        this.JPContenido = JPContenido;
        this.vista21 = vista21;
        this.PanelesManager = PanelesManager;
        this.procesos = procesos;
        this.adds = adds;
        this.init = init;
        this.vista21.getBtn1_JF021_S3_RH().addActionListener(this);
        this.vista21.getBtn2_JF021_S3_RH().addActionListener(this);
        this.vista21.getBtn3_JF021_S3_RH().addActionListener(this);

        // Crear un JScrollPane y agregar el panelAnuncioView como su vista
        JPanel panelAnuncioView = vista21.getPanelAnuncioView();
        panelAnuncioView.setLayout(new BoxLayout(panelAnuncioView, BoxLayout.Y_AXIS)); // Establecer BoxLayout vertical
        JScrollPane scrollPane = new JScrollPane(panelAnuncioView);

        // Configurar la política de desplazamiento vertical
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Establecer la altura fija
        scrollPane.setPreferredSize(new Dimension(scrollPane.getPreferredSize().width, 486)); // Cambiar 486 por la altura deseada

        // Agregar el JScrollPane al contenedor principal
        JPContenido.add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       

        
        if (e.getSource() == vista21.getBtn1_JF021_S3_RH()) {
            
             init.mostrarOcultarPanel("panelCreacionDeAnuncios"); 
            
            //Volver un panel anterior
        } else if (e.getSource() == vista21.getBtn2_JF021_S3_RH()) {
            procesos.BorrarAnuncio(adds);
            procesos.GenerarAnunciosEli(adds, this);
            //Eliminar anuncio
        } else if (e.getSource() == vista21.getBtn3_JF021_S3_RH()) {
            //Pos no eliminar y ya
        }
    }

}
