/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Database.Articulos;
import Database.Contactos;
import Database.Procesos_almacenados;
import Ui.JP011_2_S2_RH;
import Ui.JP027_S3_RH;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class DocumentosDeApoyo implements ActionListener {

    private JPanel JPContenido;
    private HabilitarPaneles PanelesManager;
    private JP027_S3_RH panel;
    private JP011_2_S2_RH Panelmask;
    private Procesos_almacenados procesos;
    private Articulos Docs;
    private Inicializador init;
    private Contactos ModelContactos;
    private DatoRandom random;

    private Icon createCircleIcon(int size, Color color) {
        return new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setColor(color);
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.fillOval(x, y, size, size);
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

    private ImageIcon createResizedImageIcon(byte[] imageData, int maxSize) throws IOException {
        BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(imageData));

        int originalWidth = originalImage.getWidth();
        int originalHeight = originalImage.getHeight();

        int newWidth, newHeight;

        // Calcular las nuevas dimensiones manteniendo la relación de aspecto
        if (originalWidth > originalHeight) {
            // Si el ancho es mayor que la altura
            if (originalWidth > maxSize) {
                double scale = (double) maxSize / originalWidth;
                newWidth = maxSize;
                newHeight = (int) (originalHeight * scale);
            } else {
                newWidth = originalWidth;
                newHeight = originalHeight;
            }
        } else {
            // Si la altura es mayor que el ancho
            if (originalHeight > maxSize) {
                double scale = (double) maxSize / originalHeight;
                newHeight = maxSize;
                newWidth = (int) (originalWidth * scale);
            } else {
                newWidth = originalWidth;
                newHeight = originalHeight;
            }
        }

        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
        g.dispose();

        return new ImageIcon(resizedImage);
    }

    public DocumentosDeApoyo(JPanel JPContenido, HabilitarPaneles PanelesManager, JP027_S3_RH panel, Procesos_almacenados procesos,
            Articulos Docs, Inicializador init, Contactos ModelContactos, DatoRandom random, JP011_2_S2_RH Panelmask) {
        this.JPContenido = JPContenido;
        this.PanelesManager = PanelesManager;
        this.ModelContactos = ModelContactos;
        this.random = random;
        this.Panelmask = Panelmask;
        this.panel = panel;
        this.Docs = Docs;
        this.procesos = procesos;
        this.init = init;
        this.panel.Btn001_JF027_S3_RH.addActionListener(this);
        this.panel.Btn02_JF027_S3_RH.addActionListener(this);
        this.panel.Btn03_JF027_S3_RH.addActionListener(this);
        this.panel.ContenedordeDocs.setLayout(new GridLayout(1, 0));
    }

    public void generarPanelesDeDocumentos(int IDArticulo, String titulo, byte[] imagen) {
        // 1. Crea una instancia del panel de máscara como una plantilla
        JP011_2_S2_RH panelDocumento = new JP011_2_S2_RH();

        // 2. Modifica el contenido dinámico del panel
        panelDocumento.getJL_Titulo_JP011_2_S2_RH().setText(titulo);

        // 3. Establece la imagen en el JLabel
        if (imagen != null && imagen.length > 0) {
            try {
                ImageIcon resizedIcon = createResizedImageIcon(imagen, 361);
                panelDocumento.getJL_Imagen_JP011_2_S2_RH().setIcon(resizedIcon);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        // 4. Establece el IDArticulo en el JLabel Jlb_ID
        panelDocumento.getJlb_ID().setText(String.valueOf(IDArticulo));

        // 5. Configura el JCheckBox según sea necesario
        panelDocumento.getCheck().setSelected(false); // Por defecto, el CheckBox está deseleccionado

        // 6. Cambia el nombre del nuevo panel a uno generado aleatoriamente
        random.DatoRandom(ModelContactos, 10); // Genera un nombre aleatorio de 10 caracteres
        String nombrePanel = ModelContactos.getNumeroRandom();
        panelDocumento.setName(nombrePanel);

        // 7. Agrega el nuevo panel modificado al contenedor de documentos
        this.panel.ContenedordeDocs.add(panelDocumento);
        this.panel.ContenedordeDocs.revalidate(); // Actualiza la disposición
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panel.getBtn001_JF027_S3_RH()) {

            init.mostrarOcultarPanel("panelMenuTp");

            //Botón para volver un panel anterior (menú)
        } else if (e.getSource() == panel.getBtn02_JF027_S3_RH()) {

            init.mostrarOcultarPanel("panelAgregarArticulo");

            //Botón Agregar documento de apoyo
        } else if (e.getSource() == panel.getBtn03_JF027_S3_RH()) {
            panel.ContenedordeDocs.removeAll(); // Esto eliminará todos los componentes dentro del panel
            panel.ContenedordeDocs.revalidate(); // Actualiza el diseño del panel
            panel.ContenedordeDocs.repaint(); // Repinta el panel si es necesario
            procesos.BorrarArticulo(Docs);
            procesos.GenerarDocumentos(Docs, this);
            // Botón eliminar documento de 
        }

    }

}
