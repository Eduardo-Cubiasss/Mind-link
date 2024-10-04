package ux;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

public class LimiteCaracteres implements KeyListener {
    
    private final JTextField textField;
    private final int limiteMinimo;
    private final int limiteMaximo;

    public LimiteCaracteres(JTextField textField, int limiteMinimo, int limiteMaximo) {
        this.textField = textField;
        this.limiteMinimo = limiteMinimo;
        this.limiteMaximo = limiteMaximo;
        textField.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        String textoActual = textField.getText();
        int longitudTextoActual = textoActual.length();
        
        if (longitudTextoActual >= limiteMaximo) {
            e.consume(); // Ignorar el evento si se ha alcanzado el límite máximo de caracteres
        } else if (longitudTextoActual < limiteMinimo) {
            // Si la longitud actual es menor que el límite mínimo, no consumir el evento
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // No es necesario hacer nada aquí, pero debes mantener el método debido a la interfaz KeyListener
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // No es necesario hacer nada aquí, pero debes mantener el método debido a la interfaz KeyListener
    }
}

