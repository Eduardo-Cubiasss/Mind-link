/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import ux.NuevaSolicitudDeEmpleado;
import ux.PanelesInicializador;

/**
 *
 * @author LENOVO
 */
public class JP015_1_S2_RH extends javax.swing.JPanel {

    
    
    private NuevaSolicitudDeEmpleado controlador;
    private PanelesInicializador str;

    public JButton getBtn1_JF015_S2_RH() {
        return Btn1_JF015_S2_RH;
    }

    public void setBtn1_JF015_S2_RH(JButton Btn1_JF015_S2_RH) {
        this.Btn1_JF015_S2_RH = Btn1_JF015_S2_RH;
    }

    public JButton getBtn2_JF015_S2_RH() {
        return Btn2_JF015_S2_RH;
    }

    public void setBtn2_JF015_S2_RH(JButton Btn2_JF015_S2_RH) {
        this.Btn2_JF015_S2_RH = Btn2_JF015_S2_RH;
    }

    public JPanel getJPSolicitud_JP015_S2_RH() {
        return JPSolicitud_JP015_S2_RH;
    }

    public void setJPSolicitud_JP015_S2_RH(JPanel JPSolicitud_JP015_S2_RH) {
        this.JPSolicitud_JP015_S2_RH = JPSolicitud_JP015_S2_RH;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JButton getBtn3_JF015_S2_RH() {
        return Btn3_JF015_S2_RH;
    }

    public void setBtn3_JF015_S2_RH(JButton Btn3_JF015_S2_RH) {
        this.Btn3_JF015_S2_RH = Btn3_JF015_S2_RH;
    }
    
        public JLabel getLbNotas() {
        return LbNotas;
    }

    public void setLbNotasText(String texto) {
        this.LbNotas.setText(texto);
    }

    public JLabel getLblAsunto() {
        return LblAsunto;
    }

    public void setLblAsunto(String LblAsunto) {
        this.LblAsunto.setText(LblAsunto);
    }
    
    
    
    

    public JP015_1_S2_RH(NuevaSolicitudDeEmpleado controlador) {
        initComponents();
        this.controlador = controlador;
        
        str = new PanelesInicializador();
        
         // Establecer el valor de str aquí después de haberlo creado
        str.setJP015_1_S2_RH(this);
    }
    
    
    
    public JP015_1_S2_RH() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Btn1_JF015_S2_RH = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JPSolicitud_JP015_S2_RH = new javax.swing.JPanel();
        Btn3_JF015_S2_RH = new javax.swing.JButton();
        Btn2_JF015_S2_RH = new javax.swing.JButton();
        LblAsunto = new javax.swing.JLabel();
        JPSolicitud_JP017_S2_RH2 = new javax.swing.JPanel();
        LbNotas = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1120, 640));
        setMinimumSize(new java.awt.Dimension(1120, 640));
        setPreferredSize(new java.awt.Dimension(1120, 640));
        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1120, 640));
        jPanel1.setMinimumSize(new java.awt.Dimension(1120, 640));
        jPanel1.setPreferredSize(new java.awt.Dimension(1120, 640));

        Btn1_JF015_S2_RH.setBackground(new java.awt.Color(255, 255, 255));
        Btn1_JF015_S2_RH.setForeground(new java.awt.Color(255, 255, 255));
        Btn1_JF015_S2_RH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Vector (1).png"))); // NOI18N
        Btn1_JF015_S2_RH.setBorderPainted(false);
        Btn1_JF015_S2_RH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setText("Nueva solicitud de un empleado");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/log.PNG"))); // NOI18N

        JPSolicitud_JP015_S2_RH.setBackground(new java.awt.Color(246, 246, 246));

        Btn3_JF015_S2_RH.setBackground(new java.awt.Color(246, 246, 246));
        Btn3_JF015_S2_RH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rechazarS.png"))); // NOI18N
        Btn3_JF015_S2_RH.setBorderPainted(false);
        Btn3_JF015_S2_RH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Btn2_JF015_S2_RH.setBackground(new java.awt.Color(246, 246, 246));
        Btn2_JF015_S2_RH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AprobarS.png"))); // NOI18N
        Btn2_JF015_S2_RH.setBorderPainted(false);
        Btn2_JF015_S2_RH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        LblAsunto.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        LblAsunto.setText("Asunto");

        JPSolicitud_JP017_S2_RH2.setBackground(new java.awt.Color(204, 204, 204));
        JPSolicitud_JP017_S2_RH2.setMaximumSize(new java.awt.Dimension(1120, 540));

        LbNotas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LbNotas.setText("jLabel1");
        LbNotas.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout JPSolicitud_JP017_S2_RH2Layout = new javax.swing.GroupLayout(JPSolicitud_JP017_S2_RH2);
        JPSolicitud_JP017_S2_RH2.setLayout(JPSolicitud_JP017_S2_RH2Layout);
        JPSolicitud_JP017_S2_RH2Layout.setHorizontalGroup(
            JPSolicitud_JP017_S2_RH2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPSolicitud_JP017_S2_RH2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(LbNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        JPSolicitud_JP017_S2_RH2Layout.setVerticalGroup(
            JPSolicitud_JP017_S2_RH2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPSolicitud_JP017_S2_RH2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(LbNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JPSolicitud_JP015_S2_RHLayout = new javax.swing.GroupLayout(JPSolicitud_JP015_S2_RH);
        JPSolicitud_JP015_S2_RH.setLayout(JPSolicitud_JP015_S2_RHLayout);
        JPSolicitud_JP015_S2_RHLayout.setHorizontalGroup(
            JPSolicitud_JP015_S2_RHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPSolicitud_JP015_S2_RHLayout.createSequentialGroup()
                .addContainerGap(398, Short.MAX_VALUE)
                .addComponent(Btn3_JF015_S2_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(178, 178, 178))
            .addGroup(JPSolicitud_JP015_S2_RHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(711, Short.MAX_VALUE))
            .addGroup(JPSolicitud_JP015_S2_RHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JPSolicitud_JP015_S2_RHLayout.createSequentialGroup()
                    .addGap(138, 138, 138)
                    .addComponent(Btn2_JF015_S2_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(438, Short.MAX_VALUE)))
            .addGroup(JPSolicitud_JP015_S2_RHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JPSolicitud_JP015_S2_RHLayout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(JPSolicitud_JP017_S2_RH2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(33, Short.MAX_VALUE)))
        );
        JPSolicitud_JP015_S2_RHLayout.setVerticalGroup(
            JPSolicitud_JP015_S2_RHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPSolicitud_JP015_S2_RHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblAsunto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 380, Short.MAX_VALUE)
                .addComponent(Btn3_JF015_S2_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(JPSolicitud_JP015_S2_RHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPSolicitud_JP015_S2_RHLayout.createSequentialGroup()
                    .addContainerGap(427, Short.MAX_VALUE)
                    .addComponent(Btn2_JF015_S2_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22)))
            .addGroup(JPSolicitud_JP015_S2_RHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JPSolicitud_JP015_S2_RHLayout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addComponent(JPSolicitud_JP017_S2_RH2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(92, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Btn1_JF015_S2_RH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(229, 229, 229)))
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(JPSolicitud_JP015_S2_RH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Btn1_JF015_S2_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addGap(28, 28, 28)
                .addComponent(JPSolicitud_JP015_S2_RH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Btn1_JF015_S2_RH;
    public javax.swing.JButton Btn2_JF015_S2_RH;
    public javax.swing.JButton Btn3_JF015_S2_RH;
    public javax.swing.JPanel JPSolicitud_JP015_S2_RH;
    public javax.swing.JPanel JPSolicitud_JP017_S2_RH2;
    public javax.swing.JLabel LbNotas;
    public javax.swing.JLabel LblAsunto;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
