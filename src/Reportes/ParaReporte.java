/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reportes;

import Database.ConnectionSQL;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ChrisChiquito
 */
public class ParaReporte {
    
     public void mostrarReporteReceta(JTextField texto) {
        try {
            
            //Crear un objeto Map para almacenar los parámetros
            Map<String, Object> parametro = new HashMap<>();
            parametro.put("PadecimientoE", texto.getText()); //Agregar parametro con el valor deseado
              
            
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteReceta.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(report, parametro, ConnectionSQL.getConexion());

            JasperViewer view = new JasperViewer(jprint, false);
            view.setTitle("Recetas");
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);

        } catch (JRException ex) {
            ex.getMessage();
            System.out.println("estee"+ ex);
        }
    }
    
      public void mostrarReporteTerapeuta() {
        try {
            
       JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteTerapeuta.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(report, null, ConnectionSQL.getConexion());

            JasperViewer view = new JasperViewer(jprint, false);
            view.setTitle("Terapeutas");
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);

        } catch (JRException ex) {
            ex.getMessage();
            System.out.println("estee reporte te"+ ex);
        }
    }
      
      public void mostrarReporteSecretaria() {
        try {
            
       JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteSecretaria.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(report, null, ConnectionSQL.getConexion());

            JasperViewer view = new JasperViewer(jprint, false);
            view.setTitle("Secretarias");
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);

        } catch (JRException ex) {
            ex.getMessage();
            System.out.println("este seceeeee"+ ex);
        }
    }
      
       public void mostrarReportePruebas() {
        try {
            
       JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReportePruebas.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(report, null, ConnectionSQL.getConexion());

            JasperViewer view = new JasperViewer(jprint, false);
            view.setTitle("Pruebas");
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);

        } catch (JRException ex) {
            ex.getMessage();
        }
    }
       
       public void mostrarReporteCantArticulo() {
        try {
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteCantArticulo.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(report, null, ConnectionSQL.getConexion());

            JasperViewer view = new JasperViewer(jprint, false);
            view.setTitle("Contador de pruebas");
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);

        } catch (JRException ex) {
            ex.getMessage();
        }
    }
       
     public void VerReportes() {
        try {
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/RP.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(report, null, ConnectionSQL.getConexion());

            JasperViewer view = new JasperViewer(jprint, false);
            view.setTitle("Nombre Reporte");
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);

        } catch (JRException ex) {
            ex.getMessage();
        }
    }
    
}
