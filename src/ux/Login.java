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
import Database.Empleado;
import Database.Genero;
import Database.Pacientes;
import Database.Procesos_almacenados;
import Database.Secretarias;
import Database.Terapeutas;
import Database.Usuarios;
import Ui.JF_000_S7_GU;
import Ui.JP001_S1_AFP;
import Ui.JP0048_S3_RH;
import Ui.JP025_S3_RH;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.HashSet;

/**
 *
 * @author 50369
 */
public class Login implements ActionListener {

    private Usuarios modelUsers;
    private JPanel JPContenido;
    private Procesos_almacenados Procesos;
    private Genero modelGenero;
    private Contactos modelContactos;
    private ActividadesLaborales modelActivty;
    private Administrador modelAdmin;
    private JP001_S1_AFP panelRegistro;
    private JP0048_S3_RH panelprimeruso;
    private PanelHistory panelHistory;
    private HabilitarPaneles PanelesManager;
    private Hints hint;
    private JF_000_S7_GU vista;
    private JP025_S3_RH panelacercademi;
    private Terapeutas modelTerap;
    private Empleado modelEmpleado;
    private Clinica modelClinica;
    private Secretarias ModelSecret;
    private Inicializador init;
    private Pacientes modelPac;

    public Login(Usuarios modelUsers, JPanel JPContenido, Procesos_almacenados Procesos,
            JP001_S1_AFP panelRegistro, PanelHistory panelHistory, HabilitarPaneles PanelesManager, JF_000_S7_GU vista,
            JP0048_S3_RH panelprimeruso, Genero modelGenero, Contactos modelContactos, ActividadesLaborales modelActivty,
            Administrador modelAdmin, Hints hint, JP025_S3_RH panelacercademi, Terapeutas modelTerap, Empleado modelEmpleado, Clinica modelClinica,
            Secretarias ModelSecret, Inicializador init, Pacientes modelPac) {
        this.modelUsers = modelUsers;
        this.JPContenido = JPContenido;
        this.Procesos = Procesos;
        this.modelPac = modelPac;
        this.panelRegistro = panelRegistro;
        this.panelHistory = panelHistory;
        this.PanelesManager = PanelesManager;
        this.panelprimeruso = panelprimeruso;
        this.modelGenero = modelGenero;
        this.modelContactos = modelContactos;
        this.modelActivty = modelActivty;
        this.modelAdmin = modelAdmin;
        this.vista = vista;
        this.hint = hint;
        this.modelClinica = modelClinica;
        this.panelacercademi = panelacercademi;
        this.modelTerap = modelTerap;
        this.modelEmpleado = modelEmpleado;
        this.ModelSecret = ModelSecret;
        this.init = init;

        this.panelRegistro.getBtn2_JF001_S1_AF().addActionListener(this);
        this.panelRegistro.getBtn3_JF001_S1_AF().addActionListener(this);
        this.panelRegistro.getBtn4_JF001_S1_AF().addActionListener(this);
        // this.panelRegistro.getBtn2_JF001_S1_AF().addKeyListener();

        hint.addHint(panelRegistro.getTxtUsuario_JF001_S1_AF(), "Ingrese su usuario");
        panelRegistro.getPass_JF001_S1_AF().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    accion();
                }
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panelRegistro.getBtn2_JF001_S1_AF()) {
            accion();
        } else if (e.getSource() == panelRegistro.getBtn3_JF001_S1_AF()) {
            vista.mostrarOcultarPanel("panelRegistro");
        } else if (e.getSource() == panelRegistro.getBtn4_JF001_S1_AF()) {
            //PanelesManager.eliminarPanel("panelInicioSesion");
            vista.mostrarOcultarPanel("panelvalCorreo");

        }
    }

    private void accion() {
        reiniciar();
        modelUsers.setUserName(panelRegistro.getTxtUsuario_JF001_S1_AF().getText());
        modelUsers.setContraseña(new String(panelRegistro.getPass_JF001_S1_AF().getPassword()));
        Procesos.Logear(modelUsers);
        int caso = 2;
        ///Aqui irán los setters hacía los Jtextfiel del primer uso
        Procesos.CRUDprimeruso(modelUsers, modelContactos, modelActivty, modelGenero, 1, modelAdmin);
        ///Aqui Acaban
        Procesos.PrimerUso(modelUsers, caso);
        // Procesos.Acercademi(modelUsers, 1);
        //Aqui van los setters
        // this.panelacercademi.setTxtDescrip_JF025_S3_RH(modelUsers.getDescripcion());
        this.panelprimeruso.setTxtCorreoElectronico_jp0048_RH(modelContactos.getCorreo());
        this.panelprimeruso.setTxtActiLabo_JP0048(modelActivty.getActiviadadLaboral());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaTexto = panelprimeruso.getTxtFechaNa_JP0048().getText();

        if (!fechaTexto.isEmpty()) { // Comprobamos si la cadena no está vacía
            try {
                Date fechaNacimiento = sdf.parse(fechaTexto);
                if (fechaNacimiento != null) {
                    modelAdmin.setFNacimiento(new java.sql.Date(fechaNacimiento.getTime()));
                } else {
                    // El texto no es una fecha válida, maneja el error aquí
                    // Puedes mostrar un mensaje de error al usuario o tomar otra acción apropiada
                }
            } catch (ParseException ex) {
                // Ocurrió un error al analizar la fecha, maneja la excepción aquí
            }
        } else {
            // El texto está vacío, maneja el error aquí si es necesario
            // Puedes mostrar un mensaje de error al usuario o tomar otra acción apropiada
        }

        this.panelprimeruso.setTxtDui_JP0048(modelAdmin.getDUI());
        this.panelprimeruso.setTxtNumTel_JP0048(modelContactos.getNumTelefonico());
        this.panelprimeruso.CmbxGenero.setSelectedIndex(modelGenero.getGenero());
        //
        int Acceso = modelUsers.getAcceso();
        int Nivel = modelUsers.getResultado();
        int Primeruso = modelUsers.getPrimerUso();
        System.out.println("Si es 1 es proque tiene acceso: " + Acceso);
        System.out.println("Nivel de usuario: " + Nivel);
        System.out.println("Primer uso en 1 es porque si: " + Primeruso);
        if (Acceso == 1) {
            Procesos.SaberIDUsuario(modelUsers);

            switch (Nivel) {
                case 1:
                    if (Primeruso == 1) {
                        Procesos.SaberID(modelUsers, modelAdmin);
                        vista.mostrarOcultarPanel("panelPrimerUso");
                    } else {
                        Procesos.SaberID(modelUsers, modelAdmin);
                        vista.mostrarOcultarPanel("panelMenuAdmin");
                    }
                    break;
                case 2:
                    if (Primeruso == 1) {
                        Procesos.SaberIDSecre(modelUsers, ModelSecret);
                        vista.mostrarOcultarPanel("panelPrimerUso");
                    } else {
                        Procesos.SaberIDSecre(modelUsers, ModelSecret);
                        vista.mostrarOcultarPanel("panelMenuSec");
                    }
                    break;
                case 3:
                    if (Primeruso == 1) {
                        Procesos.SaberIDTer(modelUsers, modelTerap);
                        vista.mostrarOcultarPanel("panelPrimerUso");
                    } else {
                        Procesos.SaberIDTer(modelUsers, modelTerap);
                        vista.mostrarOcultarPanel("panelMenuTp");
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Tu usuario es de tipo paciente, usa la aplicación de móvil para acceder a él por favor", "Usuario inválido", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
            Procesos.SaberIDClinica(modelClinica, modelUsers);
            panelRegistro.setTxtUsuario_JF001_S1_AF("");
            panelRegistro.setPass_JF001_S1_AF("");
            
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado, compruebe el usuario y la contraseña de nuevo", "ERROR JF001DA", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public void reiniciar() {
        modelUsers.setIDUsuario(0);
        modelTerap.setIDTerapeuta(0);
        modelTerap.setIDUsuario(0);
        ModelSecret.setIDSecretaria(0);
        ModelSecret.setIDUsuario(0);
        modelAdmin.setIDUsuario(0);
        modelAdmin.setIDAdministrador(0);
        modelClinica.setIDClinica(null);
        modelEmpleado.setIDUsuario(0);
        modelPac.setSeñal(false);
        modelTerap.setSeñal(false);
        
        
    }
}
