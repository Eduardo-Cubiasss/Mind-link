/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Database.Administrador;
import Database.Citas;
import Database.Contactos;
import Database.Empleado;
import Database.Pacientes;
import Database.Procesos_almacenados;
import Database.Secretarias;
import Database.Terapeutas;
import Ui.JP012_S2_AF;
import Ui.JP024_S3_AF;
import Ui.JP043_1_S3_RH;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class CrearCita implements ActionListener {

    private JPanel JPContenido;
    private JP043_1_S3_RH vista43;
    private HabilitarPaneles PanelesManager;
    private Inicializador init;
    private Procesos_almacenados procesos;
    private Citas modelCitas;
    private Secretarias modelSecretaria;
    private JP024_S3_AF crudPaciente;
    private JP012_S2_AF crudEmpleado;
    private Terapeutas modelTerap;
    private Pacientes modelPac;
    private Administrador modelAdmin;
    private Empleado modelEmpleado;
    private Contactos modelContacto;

    public CrearCita(JPanel JPContenido, JP043_1_S3_RH vista43, HabilitarPaneles PanelesManager, Inicializador init,
            Procesos_almacenados procesos, Citas modelCitas, JP024_S3_AF crudPaciente, JP012_S2_AF crudEmpleado,
            Terapeutas modelTerap, Pacientes modelPac, Administrador modelAdmin, Empleado modelEmpleado, Contactos modelContacto) {
        this.JPContenido = JPContenido;
        this.init = init;
        this.modelEmpleado = modelEmpleado;
        this.vista43 = vista43;
        this.PanelesManager = PanelesManager;
        this.procesos = procesos;
        this.modelCitas = modelCitas;
        this.crudPaciente = crudPaciente;
        this.crudEmpleado = crudEmpleado;
        this.modelTerap = modelTerap;
        this.modelAdmin = modelAdmin;
        this.modelPac = modelPac;
        this.modelContacto = modelContacto;
        this.vista43.getBtn1_JF043_S3_RH().addActionListener(this);
        this.vista43.getBtn01_JP043_S3_RH().addActionListener(this);
        this.vista43.getBtn_verEmpleados().addActionListener(this);
        this.vista43.getBtnverpacientes().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista43.getBtn1_JF043_S3_RH()) {
            crudEmpleado.getBtn1_JF012().setVisible(true);
            crudPaciente.getBtnVer().setVisible(true);
            System.out.println("El IDAdministrador es: " + modelAdmin.getIDUsuario());
            modelPac.setSeñal(false);
            if(modelAdmin.getIDUsuario() == 0)
            {
                init.mostrarOcultarPanel("panelMenuSec");
            }
            else
            {
            init.mostrarOcultarPanel("panelMenuAdmin");
            }
            
            //Botón de volver a un panel anterior
        } else if (e.getSource() == vista43.getBtn01_JP043_S3_RH()) {
            modelCitas.setIDTerapeuta(Integer.parseInt(vista43.getTxtTerapeuta_JP043_S3_RH().getText()));
            modelCitas.setIDPaciente(Integer.parseInt(vista43.getTxtID_JP043_S3_RH().getText()));
            modelCitas.setHora(vista43.getTxtHoraInicio_JP043_S3_RH().getText());

            // Para la fecha, primero debes obtener el valor del componente de fecha y luego convertirlo a un objeto Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/dd/MM"); // Ajusta el formato a tu entrada de fecha
            try {
                Date fecha = dateFormat.parse(vista43.getTxtDia_JP043_S3_RH().getText());
                modelCitas.setFecha(fecha);
            } catch (ParseException ex) {
                // Manejar la excepción de análisis de fecha
                ex.printStackTrace();
            }
            try {
                    

                    // Preparar las cosas
                    String correoEmisor = "mindlinkoficial@gmail.com";
                    String contraseñaEmisor = "inblyssyqjiszhds";
                    String CorreoReceptor = modelContacto.getCorreo();
                    String asunto = "Cita agendada para el día "+ vista43.getTxtDia_JP043_S3_RH().getText();
                    String mensaje = "Su cita ha sido programada para el día: "+ vista43.getTxtDia_JP043_S3_RH().getText()+ " \nA la hora: " + vista43.getTxtHoraInicio_JP043_S3_RH().getText();

                    // Configurar SMTP
                    Properties props = new Properties();
                    props.setProperty("mail.smtp.host", "smtp.gmail.com");
                    props.setProperty("mail.smtp.starls.enable", "true");
                    props.setProperty("mail.smtp.port", "465");
                    props.setProperty("mail.smtp.auth", "true");
                    props.setProperty("mail.smtp.socketFactory.port", "465");
                    props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

                    // Configurar el envío
                    Session session = Session.getDefaultInstance(props);
                    if (session != null) {
                        MimeMessage message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(correoEmisor));
                        message.addRecipient(Message.RecipientType.TO, new InternetAddress(CorreoReceptor));
                        message.setSubject(asunto);
                        message.setText(mensaje);

                        // Envío del mensaje
                        Transport t = session.getTransport("smtp");
                        t.connect(correoEmisor, contraseñaEmisor);
                        t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
                        t.close();

                        JOptionPane.showMessageDialog(null, "Correo enviado");
                    } else {
                        JOptionPane.showMessageDialog(null, "La sesión de correo es nula", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "El correo ingresado es inexistente, si el error persiste cerrar y abrir la aplicación o prueba otro método de recuperación", "Error JP002", JOptionPane.ERROR_MESSAGE);
                }
            //procesos.Crearcita(modelCitas);
        } else if (e.getSource() == vista43.getBtn_verEmpleados()) {
            crudEmpleado.getBtn1_JF012().setVisible(false);
            modelEmpleado.setSeñal(true);
            init.mostrarOcultarPanel("panelBuscadorDeEmpleados");
        } else if (e.getSource() == vista43.getBtnverpacientes()) {
            crudPaciente.getBtnVer().setVisible(false);
            modelPac.setSeñal(true);
            init.mostrarOcultarPanel("panelBuscadorPacientes");
        }

    }

}
