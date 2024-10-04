/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Reportes.ParaReporte;
import Ui.JP022_S3_AF;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class Estadisticas implements ActionListener{
    private JPanel JPContenido;
    private JP022_S3_AF vista22;
     private HabilitarPaneles PanelesManager;  
      private ParaReporte reporte;
      private Inicializador init;
    public Estadisticas(JPanel JPContenido, JP022_S3_AF vista22, HabilitarPaneles PanelesManager, ParaReporte reporte, Inicializador init)
    {
        this.JPContenido = JPContenido;
        this.vista22 = vista22;
        this.init = init;
        this.PanelesManager = PanelesManager;    
        this.vista22.getBtn001_JF22_S3_AF().addActionListener(this);
        this.vista22.getBtn1().addActionListener(this);
        this.vista22.getBtn2().addActionListener(this);
        this.reporte = reporte;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vista22.getBtn001_JF22_S3_AF())
        {
            
                         init.mostrarOcultarPanel("panelMenuAdmin"); 

           
            //Botón para volver un panel anterior (Al)
        }
        else if(e.getSource() == vista22.getBtn1())
        {
        reporte.mostrarReporteCantArticulo();
        }
        else if(e.getSource() == vista22.getBtn2())
        {
        reporte.mostrarReporteSecretaria();
        }
    }
    
}
