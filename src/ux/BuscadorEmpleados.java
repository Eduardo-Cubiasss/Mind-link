/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ux;

import Database.ActividadesLaborales;
import Database.Empleado;
import Database.Procesos_almacenados;
import Ui.JP010_S2_AF;
import Ui.JP012_S2_AF;
import Ui.JP043_1_S3_RH;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class BuscadorEmpleados implements ActionListener {

    private JPanel JPContenido;
    private JP012_S2_AF vista12;
    private Empleado modelEmpleado;
    private ActividadesLaborales modelactivity;
    private Resultado resultado;
    private Procesos_almacenados procesos;
    private DefaultTableModel tableModel;
    private HabilitarPaneles PanelesManager;
    private JP010_S2_AF vista10;
    private Inicializador init;
    private JP043_1_S3_RH vista43;

    public BuscadorEmpleados(JPanel JPContenido, JP012_S2_AF vista12, Empleado modelEmpleado, ActividadesLaborales modelactivity, Procesos_almacenados procesos, HabilitarPaneles PanelesManager, Resultado resultado, JP010_S2_AF vista10,
            Inicializador init, JP043_1_S3_RH vista43) {
        this.JPContenido = JPContenido;
        this.modelEmpleado = modelEmpleado;
        this.modelactivity = modelactivity;
        this.procesos = procesos;
        this.vista12 = vista12;
        this.vista10 = vista10;
        this.vista43 = vista43;
        
        this.PanelesManager = PanelesManager;
        this.resultado = resultado;
         this.init = init;
        this.vista12.getBtn1_JF012().addActionListener(this);
        this.vista12.getBtn3_JF012().addActionListener(this);
        this.vista12.getBtnBuscar().addActionListener(this);

        String[] columnTitles = {"Id", "Nombres", "Actividad laboral"};

        tableModel = new DefaultTableModel(columnTitles, 0);
        vista12.getjTable1().setModel(tableModel);

        vista12.getjTable1().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = vista12.getjTable1().getSelectedRow();

                if (filaSeleccionada != -1) {
                    Object valorIDUsuario = vista12.getjTable1().getValueAt(filaSeleccionada, 0);

                    if (valorIDUsuario != null) {
                        int IDUsuario = Integer.parseInt(valorIDUsuario.toString());
                        modelEmpleado.setIdEmpleado(IDUsuario);
                        System.out.println(IDUsuario);
                    }
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista12.getBtn3_JF012()) {
            
            if(modelEmpleado.isSeñal() == true)
            {
                vista43.setTxtTerapeuta_JP043_S3_RH(String.valueOf(modelEmpleado.getIdEmpleado()));
                init.mostrarOcultarPanel("panelCrearCita");
            }
            else
            {
                init.mostrarOcultarPanel("panelPersonalClinica"); 
            }
            

            
            //Es para volver al panel anterior
        } else if (e.getSource() == vista12.getBtn1_JF012()) {
            vista10.setTxtNombre(modelEmpleado.getNombre());
            vista10.setTxtEdad(String.valueOf(modelEmpleado.getEdad()));
            vista10.setTxtOficio(modelEmpleado.getActividadLab());
            vista10.setTxtDias(modelEmpleado.getDUI());

            // Actualiza la imagen en vista10 si hay una imagen en modelEmpleado
            if (modelEmpleado.getFotoPerfil() != null && modelEmpleado.getFotoPerfil().length > 0) {
                try {
                    // Convertir el arreglo de bytes en una imagen redimensionada
                    ImageIcon imagenIcon = createResizedImageIcon(modelEmpleado.getFotoPerfil(), 200, 200); // Cambia las dimensiones según tus necesidades

                    // Establecer la imagen redimensionada en el JLabel de vista10
                    vista10.getLb_chino().setIcon(imagenIcon);

                    // Establecer las dimensiones del JLabel según la imagen redimensionada
                    vista10.getLb_chino().setPreferredSize(new Dimension(200, 200)); // Cambia las dimensiones según tus necesidades

                    // Asegúrate de que el JLabel se repinte
                    vista10.getLb_chino().revalidate();
                    vista10.getLb_chino().repaint();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                // Si no hay imagen, puedes establecer un icono de imagen predeterminado o realizar otra acción adecuada
                vista10.getLb_chino().setIcon(null); // Esto quitará cualquier imagen existente en el JLabel
                vista10.getLb_chino().setPreferredSize(new Dimension(0, 0)); // Restablece las dimensiones del JLabel
                System.out.println("Está vacío o contiene propiedades indebidas");
            }
            
                        init.mostrarOcultarPanel("panelDetallesDePerfil"); 

            
            // Es para abrir el perfil del usuario en base a su ID
        } else if (e.getSource() == vista12.getBtnBuscar()) {
            String textoBusqueda = vista12.getjTextField1().getText();
            if (textoBusqueda != null && !textoBusqueda.isEmpty()) {
                System.out.println(textoBusqueda);
                actualizarTablaConResultadosDeBusqueda(textoBusqueda);

            } else {
                JOptionPane.showMessageDialog(null, "El JTextField de búsqueda esta vacío.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                // Puedes realizar otras acciones apropiadas aquí si es necesario
            }
            //Es para el buscador y que muestre los resultados en la tabla
        }

    }

    private void actualizarTablaConResultadosDeBusqueda(String textoBusqueda) {
        // Borra todas las filas existentes en el modelo
        tableModel.setRowCount(0);

        // Aquí debes realizar la consulta a la base de datos
        // y obtener los resultados que coincidan con el texto de búsqueda
        List<Resultado> resultados = procesos.Empleados(modelEmpleado, 1, textoBusqueda);

        for (Resultado resultado : resultados) {
            tableModel.addRow(new Object[]{resultado.getIdPaciente(), resultado.getNombre(), resultado.getApellido()});
        }
    }
    private ImageIcon createResizedImageIcon(byte[] imageData, int width, int height) throws IOException {
        BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(imageData));
        Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}
