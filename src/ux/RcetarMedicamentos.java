/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Database.Contactos;
import Database.Procesos_almacenados;
import Database.RecetasMedicas;
import Reportes.ParaReporte;
import Ui.JP036_S3_AF;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class RcetarMedicamentos implements ActionListener{
    private JPanel JPContenido;
    private JP036_S3_AF vista36;
    private ParaReporte reporte;
    private RecetasMedicas modelRecetas;
    private Procesos_almacenados proceso;
    private Inicializador init;
    private Contactos modelContactos;
    
    public RcetarMedicamentos(JPanel JPContenido, JP036_S3_AF vista36, ParaReporte reporte, RecetasMedicas modelRecetas, Procesos_almacenados proceso, 
            Inicializador init, Contactos modelContactos)
    {
        this.JPContenido = JPContenido;
        this.modelRecetas = modelRecetas;
        this.reporte = reporte;
        this.vista36 = vista36;
        this.proceso = proceso;
        this.modelContactos = modelContactos;
        this.init = init;
        this.vista36.btn1_JF036.addActionListener(this);
        this.vista36.btnagregar.addActionListener(this);
        this.vista36.getBtn3_JF012_A().addActionListener(this);
                
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista36.getBtnagregar())
        {
           this.modelRecetas.setNombrePadecimiento(vista36.getTxtNombreMedicamento_JP036_S3_AF().getText());
           this.modelRecetas.setMwedicamentos(vista36.getTxtIndicaciones_JP036_S3_AF().getText());
           this.modelRecetas.setDescripcion(vista36.getTxtHorario_JP036_S3_AF().getText());
            proceso.agregarecetas(modelRecetas);
            try {
                    

                    // Preparar las cosas
                    String correoEmisor = "mindlinkoficial@gmail.com";
                    String contraseñaEmisor = "inblyssyqjiszhds";
                    String CorreoReceptor = modelContactos.getCorreo();
                    String asunto = "Tu terapeuta te ha recetado medicamentos ";
                    String mensaje = "Tu terapeuta te receto lo siguiente\n : "+vista36.getTxtHorario_JP036_S3_AF().getText() + "\n Indicaciones: " + vista36.getTxtIndicaciones_JP036_S3_AF().getText();

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
            
        }
        else if (e.getSource() == vista36.getBtn1_JF036())
        {
            this.reporte.mostrarReporteReceta(vista36.getTxtBuscar_JP036());
        }
        else if (e.getSource() == vista36.getBtn3_JF012_A())
        {
            init.mostrarOcultarPanel("panelExpedienteDelPaciente");
        }
    }
    
}
