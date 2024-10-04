/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Reportes.ParaReporte;
import Ui.JP008_S2_AF;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class PersonalClinica implements ActionListener{
    private JPanel JPContenido;
    private JP008_S2_AF vista08;
    private HabilitarPaneles PanelesManager;
    private ParaReporte reporte;
    private Inicializador init;
    
    public PersonalClinica(JPanel JPContenido, JP008_S2_AF vista08, HabilitarPaneles PanelesManager, ParaReporte reporte, Inicializador init)
    {
        this.JPContenido = JPContenido;
        this.vista08 = vista08;
        this.PanelesManager = PanelesManager;
        this.vista08.Btn006_JF008_S3_AF.addActionListener(this);
        this.vista08.Btn004_JF008_S3_AF.addActionListener(this);
        this.vista08.Btn005_JF008_S3_AF.addActionListener(this);
        this.vista08.Btn001_JF008_S3_AF.addActionListener(this);
        this.vista08.Btn007_JF008_S3_AF.addActionListener(this);
        this.init = init;
        this.reporte = reporte;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista08.getBtn004_JF008_S3_AF())
        {
            reporte.mostrarReporteSecretaria();
        }
        else if(e.getSource() == vista08.getBtn006_JF008_S3_AF())
        {
            reporte.mostrarReporteTerapeuta();
        }
        
        else if(e.getSource() == vista08.getBtn005_JF008_S3_AF())
        {
                 //Para el buscador de empleados
            init.mostrarOcultarPanel("panelBuscadorDeEmpleados");
                
        }
        
        else if(e.getSource() == vista08.getBtn001_JF008_S3_AF())
        {
                 //Para regresar al anterior
            
            init.mostrarOcultarPanel("panelMenuAdmin");
                
        }
        
        else if(e.getSource() == vista08.getBtn007_JF008_S3_AF())
        {
                 //Para regresar al anterior
            
            init.mostrarOcultarPanel("panelAgregarPerfilesDeUsuario");
                
        }
        
        else if(e.getSource() == vista08.getBtn007_JF008_S3_AF())
        {
                 //Para regresar al anterior
            
            init.mostrarOcultarPanel("panelBuscadorDeEmpleados");
                
        }
        
    }
    
}
