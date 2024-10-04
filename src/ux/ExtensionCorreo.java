package ux;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

public class ExtensionCorreo implements KeyListener {

    private final JTextField textField;

    public ExtensionCorreo(JTextField textField) {
        this.textField = textField;
        textField.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No se necesita hacer nada en este evento
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // No se necesita hacer nada en este evento
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String texto = textField.getText().toLowerCase(); // Convertir a minúsculas para hacer la validación insensible a mayúsculas/minúsculas

        if (texto.contains("@")) {
            if (!(texto.endsWith("gmail.com") || texto.endsWith("hotmail.com") || texto.endsWith("yahoo.com"))) {
                // Si el texto contiene "@" pero no termina con alguna de las extensiones permitidas, se muestra un mensaje de error
                // y se limpia el contenido del JTextField
                textField.setText("");
                System.out.println("Formato de correo no válido");
                // Puedes mostrar una ventana emergente con JOptionPane si lo deseas:
                // JOptionPane.showMessageDialog(null, "Formato de correo no válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}


