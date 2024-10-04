package ux;

import Ui.JF_000_S7_GU;
import Ui.SplashScreen;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import ux.Inicializador;

public class mainfake {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Crea una instancia del JFrame JF_000_S7_GU
                JF_000_S7_GU vista = new JF_000_S7_GU();
                Inicializador init = new Inicializador(vista);
                
                
                // Crea una instancia del SplashScreen y muestra antes que otros paneles
                vista.mostrarOcultarPanel("panelSplash");
               // SplashScreen splashScreen = new SplashScreen(vista.JPContenido, init);

                // Mostrar el panel que desees, por ejemplo:

                // Hace la ventana JF_000_S7_GU visible
                vista.setVisible(true);
            }
        });
    }

}
