/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Database.Articulos;
import Database.Procesos_almacenados;
import Ui.JP023_S3_RH;
import java.awt.CardLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;

/**
 *
 * @author 50369
 */
public class Menu_Terapeuta implements ActionListener {

    private JPanel JPContenido;
    private JP023_S3_RH panel;
    private HabilitarPaneles PanelesManager;
    private Articulos modelArt;
    private DocumentosDeApoyo ControllerArt;
    private Procesos_almacenados procesos;
    private Inicializador init;

    public Menu_Terapeuta(JPanel JPContenido, JP023_S3_RH panel, HabilitarPaneles PanelesManager, DocumentosDeApoyo ControllerArt,
            Articulos modelArt, Procesos_almacenados procesos, Inicializador init) {
        this.panel = panel;
        this.JPContenido = JPContenido;
        this.PanelesManager = PanelesManager;
        this.ControllerArt = ControllerArt;
        this.modelArt = modelArt;
        this.procesos = procesos;
        this.init = init;
        this.panel.btn03_JF023_S3_RH.addActionListener(this);
        //this.panel.btn04_JF023_S3_RH.addActionListener(this);
        this.panel.btn05_JF023_S3_RH.addActionListener(this);
        this.panel.btn06_JF023_S3_RH.addActionListener(this);
        //this.panel.btn07_JF023_S3_RH.addActionListener(this);
        this.panel.btn08_JF023_S3_RH.addActionListener(this);
        this.panel.btn09_JF023_S3_RH.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panel.btn03_JF023_S3_RH) {

            init.mostrarOcultarPanel("panelBuscadorPacientes");

            // Código para la acción del botón de ver pacientes
        } //else if (e.getSource() == panel.btn04_JF023_S3_RH) {

            //init.mostrarOcultarPanel("panelDocumentosView");
            //procesos.GenerarDocumentos(modelArt, ControllerArt);
            // Código para la acción del botón de ver documentos de apoyo

        //} 
        else if (e.getSource() == panel.btn05_JF023_S3_RH) {
            // Código para la acción del botón de mi perfil

            init.mostrarOcultarPanel("panelDetallesDeMiPerfil");

        } else if (e.getSource() == panel.btn06_JF023_S3_RH) {

            init.mostrarOcultarPanel("panelRedactarMensaje");

            // Código para la acción del botón Solicitud de incapacidades
        } //else if (e.getSource() == panel.btn07_JF023_S3_RH) {

            //init.mostrarOcultarPanel("panelCreacionDePruebas");

            // Código para la acción del botón Crear Pruebas
        //} 
        else if (e.getSource() == panel.btn08_JF023_S3_RH) {
            init.reiniciarControllers();
            init.mostrarOcultarPanel("panelInicioSesion");

            // Código para la acción del botón cerrar sesion
        } else if (e.getSource() == panel.btn09_JF023_S3_RH) {
            // Ruta completa del archivo PDF
            String rutaPDF = "D:/PTC 2023/Sistemas/System-Java/Clinica_psicologica_Java/src/Reportes/Manual_de_usuario_de_java.pdf";

            try {
                // Crear una instancia de File con la ruta del archivo PDF
                File archivoPDF = new File(rutaPDF);

                // Verificar si el archivo existe
                if (archivoPDF.exists()) {
                    // Abrir el archivo PDF con la aplicación predeterminada
                    Desktop.getDesktop().open(archivoPDF);
                } else {
                    System.out.println("El archivo PDF no existe.");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("Error al abrir el archivo PDF.");
            }
        }

    }
}
