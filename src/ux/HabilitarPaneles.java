package ux;

import Ui.JF_000_S7_GU;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HabilitarPaneles {
    private HashMap<String, JPanel> paneles;
    private JF_000_S7_GU vista;
    private PanelesInicializador sts;
    private String nombreUltimoPanelEliminado; // Variable para almacenar el nombre del último panel eliminado

    public HabilitarPaneles() {
        this.paneles = new HashMap<>();
        this.nombreUltimoPanelEliminado = null; // Inicialmente no hay ningún panel eliminado
    }

    public void agregarPanel(String nombre, JPanel panel) {
        paneles.put(nombre, panel);
    }

    public JPanel obtenerPanel(String nombrePanel) {
        return paneles.get(nombrePanel);
    }

    public JPanel copiaPanel(String nombrePanel) {
        JPanel panelOriginal = paneles.get(nombrePanel);
        if (panelOriginal != null) {
            // Crea una copia del panel original
            JPanel copiaPanel = new JPanel();
            copiaPanel.setLayout(new CardLayout()); // Configura el layout según tus necesidades

            // Clona los componentes del panel original al panel de copia
            Component[] componentes = panelOriginal.getComponents();
            for (Component componente : componentes) {
                copiaPanel.add(componente);
            }
           nombreUltimoPanelEliminado = nombrePanel;
            return copiaPanel;
        }
        return null; // Si no se encuentra el panel original, devuelve null
    }

    public JPanel obtenerPanelCopia(String nombrePanel) {
        return copiaPanel(nombrePanel); // Obtiene una copia del panel
    }

    public void mostrarPanel(String nombrePanel) {
        JPanel panel = obtenerPanel(nombrePanel);
        if (panel != null) {
            panel.setVisible(true);
        }
    }

    public void ocultarPanel(String nombrePanel) {
        JPanel panel = obtenerPanel(nombrePanel);
        if (panel != null) {
            panel.setVisible(false);
        }
    }
    public void configurarPanel(String nombrePanel) {
    if (nombrePanel != null) {
        switch (nombrePanel) {
            case "JP001_S1_AFP":
                sts.setJP001_S1_AFP(obtenerPanel(nombrePanel));
                break;
            case "JP002_S1_RHP":
                sts.setJP002_S1_RHP(obtenerPanel(nombrePanel));
                break;
            case "JP003_2_S1_RH":
                sts.setJP003_2_S1_RH(obtenerPanel(nombrePanel));
                break;
            case "JP003_S1_RH":
                sts.setJP003_S1_RH(obtenerPanel(nombrePanel));
                break;
            case "JP004_S2_AF":
                sts.setJP004_S2_AF(obtenerPanel(nombrePanel));
                break;
            case "JP005_2_S2_RH":
                sts.setJP005_2_S2_RH(obtenerPanel(nombrePanel));
                break;
            case "JP023_S3_RH":
                sts.setJP023_S3_RH(obtenerPanel(nombrePanel));
                break;
            case "JP039_S3_RH":
                sts.setJP039_S3_RH(obtenerPanel(nombrePanel));
                break;
           
            case "JP035_1_S3_RH":
                sts.setJP035_1_S3_RH(obtenerPanel(nombrePanel));
                break;
            case "JP027_S3_RH":
                sts.setJP027_S3_RH(obtenerPanel(nombrePanel));
                break;
            case "JP006_S2_AF":
                sts.setJP006_S2_AF(obtenerPanel(nombrePanel));
                break;
                
            case "JP007_S2_RH":
                sts.setJP007_S2_RH(obtenerPanel(nombrePanel));
                break;
                
            case "JP008_S2_AF":
                sts.setJP008_S2_AF(obtenerPanel(nombrePanel));
                break;
                
            case "JP009_S2_RH":
                sts.setJP009_S2_RH(obtenerPanel(nombrePanel));
                break;
                
            case "JP010_S2_AF":
                sts.setJP010_S2_AF(obtenerPanel(nombrePanel));
                break;
            
            case "JP011_S2_RH":
                sts.setJP011_S2_RH(obtenerPanel(nombrePanel));
                break;
                
             case "JP012_A_AF":
                sts.setJP012_A_AF(obtenerPanel(nombrePanel));
                break;
                
                
             case "JP012_E_AF":
                sts.setJP012_E_AF(obtenerPanel(nombrePanel));
                break;
                
            case "JP012_S2_AF":
                sts.setJP012_S2_AF(obtenerPanel(nombrePanel));
                break;
                
            case "JP014_S2_AF":
                sts.setJP014_S2_AF(obtenerPanel(nombrePanel));
                break;
                
            case "JP015_1_S2_RH":
                sts.setJP015_1_S2_RH(obtenerPanel(nombrePanel));
                break;
                
            case "JP016_S2_AF":
                sts.setJP016_S2_AF(obtenerPanel(nombrePanel));
                break;
                
            case "JP017_1_S2_RH":
                sts.setJP017_1_S2_RH(obtenerPanel(nombrePanel));
                break;
                
            case "JP018_S2_AF":
                sts.setJP018_S2_AF(obtenerPanel(nombrePanel));
                break;
                
            case "JP019_1_S2_RH":
                sts.setJP019_1_S2_RH(obtenerPanel(nombrePanel));
                break;
                
            case "JP021_S3_RH":
                sts.setJP021_S3_RH(obtenerPanel(nombrePanel));
                break;
                
            case "JP022_S3_AF":
                sts.setJP022_S3_AF(obtenerPanel(nombrePanel));
                break;
                
            case "JP024_S3_AF":
                sts.setJP024_S3_AF(obtenerPanel(nombrePanel));
                break;
                
            case "JP025_S3_RH":
                sts.setJP025_S3_RH(obtenerPanel(nombrePanel));
                break;
                
             case "JP028_S3_AF":
                sts.setJP028_S3_AF(obtenerPanel(nombrePanel));
                break;
 
            case "JP029_A_S3_RH":
                sts.setJP029_A_S3_RH(obtenerPanel(nombrePanel));
                break;
                
             case "JP029_S3_RH":
                sts.setJP029_S3_RH(obtenerPanel(nombrePanel));
                break;   
                
                
            case "JP030_S3_AF":
                sts.setJP030_S3_AF(obtenerPanel(nombrePanel));
                break;
                
            case "JP031_S3_RHG":
                sts.setJP031_S3_RHG(obtenerPanel(nombrePanel));
                break;
                
            case "JP032_S3_AF":
                sts.setJP032_S3_AF(obtenerPanel(nombrePanel));
                break;
                
            case "JP033_S3_RH":
                sts.setJP033_S3_RH(obtenerPanel(nombrePanel));
                break;
                
            case "JP034_S3_AF":
                sts.setJP034_S3_AF(obtenerPanel(nombrePanel));
                break;
                
            case "JP036_S3_AF":
                sts.setJP036_S3_AF(obtenerPanel(nombrePanel));
                break;
                
                case "JP037_S3_RH":
                sts.setJP037_S3_RH(obtenerPanel(nombrePanel));
                break;
                
                case "JP038_S3_AF":
                sts.setJP038_S3_AF(obtenerPanel(nombrePanel));
                break;
                
                case "JP040_S3_AF":
                sts.setJP040_S3_AF(obtenerPanel(nombrePanel));
                break;
                
                case "JP041_1_S3_RH":
                sts.setJP041_1_S3_RH(obtenerPanel(nombrePanel));
                break;
                
                case "JP042_1_S3_AF":
                sts.setJP042_1_S3_AF(obtenerPanel(nombrePanel));
                break;
                
                case "JP043_1_S3_RH":
                sts.setJP043_1_S3_RH(obtenerPanel(nombrePanel));
                break;
                
                case "JP044_S3_AF":
                sts.setJP044_S3_AF(obtenerPanel(nombrePanel));
                break;
                
                case "JP045_S3_RH":
                sts.setJP045_S3_RH(obtenerPanel(nombrePanel));
                break;
                
                case "JP047_S3_AF":
                sts.setJP047_S3_AF(obtenerPanel(nombrePanel));
                break;
                
                case "JP0048_S3_RH":
                sts.setJP0048_S3_RH(obtenerPanel(nombrePanel));
                break;
            default:
                // Manejo para otros paneles si es necesario
                break;
        }
    }
}


    public void restaurarPanelEliminado() {
        if (nombreUltimoPanelEliminado != null) {
            // Restaura el panel original usando el nombre almacenado
            JPanel copia = obtenerPanelCopia(nombreUltimoPanelEliminado);
            JPanel panelOriginal = obtenerPanel(nombreUltimoPanelEliminado);
            if (panelOriginal != null && copia != null) {
                panelOriginal.removeAll();
                Component[] componentesCopia = copia.getComponents();
                for (Component componente : componentesCopia) {
                    panelOriginal.add(componente);
                }
                System.out.println(componentesCopia + " oli");
                agregarPanel(nombreUltimoPanelEliminado, panelOriginal);
                configurarPanel(nombreUltimoPanelEliminado);
                vista.JPContenido.add(panelOriginal); // Agrega el panel anterior
                vista.JPContenido.revalidate();
                vista.JPContenido.repaint();
            }
            else{
                System.out.println("no contiene nada la copia o el panel");
            }
        }
        else
        {
            System.out.println("No ta eliminado, simple");
        }
    }
}
