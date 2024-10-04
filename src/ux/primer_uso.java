/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Database.ActividadesLaborales;
import Database.Administrador;
import Database.Clinica;
import Database.Contactos;
import Database.Genero;
import Database.Procesos_almacenados;
import Database.Usuarios;
import Ui.JP002_S1_RHP;
import Ui.JP0048_S3_RH;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author 50369
 */
public class primer_uso implements ActionListener {

    private Administrador modelAdmin;
    private Usuarios modelUsers;
    private JP0048_S3_RH vistaJP048;
    private JPanel JPContenido;
    private Procesos_almacenados Procesos;
    private HabilitarPaneles PanelesManager;
    private Genero modelGenero;
    private Contactos modelContactos;
    private ActividadesLaborales modelActivity;
    private Inicializador init;

    public primer_uso(Administrador modelAdmin, JPanel JPContenido, Usuarios modelUsers, JP0048_S3_RH vistaJP048,
            Procesos_almacenados Procesos, HabilitarPaneles PanelesManager, Genero modelGenero, Contactos modelContactos,
            ActividadesLaborales modelActivity, Inicializador init) {
        this.modelAdmin = modelAdmin;
        this.JPContenido = JPContenido;
        this.modelUsers = modelUsers;
        this.PanelesManager = PanelesManager;
        this.Procesos = Procesos;
        this.modelActivity = modelActivity;
        this.modelContactos = modelContactos;
        this.modelGenero = modelGenero;
        this.vistaJP048 = vistaJP048;
        this.init = init;

        this.vistaJP048.getbtnOmitir().addActionListener(this);
        this.vistaJP048.getbtnEmpecemos().addActionListener(this);
        this.vistaJP048.getBtn02_JF048_S3_RH().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaJP048.getbtnEmpecemos()) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date fechaNacimiento = sdf.parse(vistaJP048.getTxtFechaNa_JP0048().getText());
                if (fechaNacimiento != null) {
                    modelAdmin.setFNacimiento(new java.sql.Date(fechaNacimiento.getTime()));
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor escriba la fecha con numeros y plecas", "Fecha invalida inválido", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Por favor escriba la fecha con numeros y plecas", "Fecha invalida inválido", JOptionPane.INFORMATION_MESSAGE);
            }

            modelAdmin.setDUI(vistaJP048.getTxtDui_JP0048().getText());
            modelGenero.setGenero(vistaJP048.CmbxGenero.getSelectedIndex());
            modelActivity.setActiviadadLaboral(vistaJP048.getTxtActiLabo_JP0048().getText());
            modelContactos.setCorreo(vistaJP048.getTxtCorreoElectronico_jp0048_RH().getText());
            modelContactos.setNumTelefonico(vistaJP048.getTxtNumTel_JP0048().getText());
            Procesos.CRUDprimeruso(modelUsers, modelContactos, modelActivity, modelGenero, 2, modelAdmin);
            modelUsers.setPrimerUso(0);
            Procesos.PrimerUso(modelUsers, 1);

            int Acceso = modelUsers.getAcceso();
            int Nivel = modelUsers.getResultado();
            if (Acceso == 1) {
                switch (Nivel) {
                    case 1:
                        init.mostrarOcultarPanel("panelMenuAdmin");
                        break;
                    case 2:
                        init.mostrarOcultarPanel("panelMenuSec");
                        break;
                    case 3:
                        init.mostrarOcultarPanel("panelMenuTp");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Tu usuario es de tipo paciente, usa la aplicación de móvil para acceder a él por favor", "Usuario inválido", JOptionPane.INFORMATION_MESSAGE);
                        break;
                }

            }
        } else if (e.getSource() == vistaJP048.getbtnOmitir()) {
            modelUsers.setPrimerUso(0);
            Procesos.PrimerUso(modelUsers, 1);

            int Acceso = modelUsers.getAcceso();
            int Nivel = modelUsers.getResultado();
            if (Acceso == 1) {
                switch (Nivel) {
                    case 1:
                        init.mostrarOcultarPanel("panelMenuAdmin");
                        break;
                    case 2:
                        init.mostrarOcultarPanel("panelMenuSec");
                        break;
                    case 3:
                        init.mostrarOcultarPanel("panelMenuTp");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Tu usuario es de tipo paciente, usa la aplicación de móvil para acceder a él por favor", "Usuario inválido", JOptionPane.INFORMATION_MESSAGE);
                        break;
                }
            }
        }
        else if (e.getSource() == vistaJP048.getBtn02_JF048_S3_RH())
        {
            init.reiniciarControllers();
            init.mostrarOcultarPanel("panelInicioSesion");
        }
    }
}
