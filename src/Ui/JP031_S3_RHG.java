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
import javax.swing.JTextField;
import ux.ExpedienteDelPaciente;
import ux.Hints;
import ux.LimiteCaracteres;
import ux.MBEliminarArticulo;
import ux.PanelesInicializador;
import ux.Ver_Expediente;

/**
 *
 * @author 50369
 */
public class JP031_S3_RHG extends javax.swing.JPanel {

    private ExpedienteDelPaciente controlador;
    private PanelesInicializador str;
    private Hints hint;
    private LimiteCaracteres Limite;
    
    public JP031_S3_RHG(ExpedienteDelPaciente controlador) {
        initComponents();
        hint.addHintToJTextArea(txtEscribirMensaje_JP031_S3_RH, "Escribir mensaje");
        this.controlador = controlador;

        str = new PanelesInicializador();

        // Establecer el valor de str aquí después de haberlo creado
        str.setJP031_S3_RHG(this);
    }

    public JButton getBtn1_JF031_S3_RH() {
        return Btn1_JF031_S3_RH;
    }

    public JPanel getJP01_JF031_S3_RH() {
        return JP01_JF031_S3_RH;
    }

    public JButton getBtn2_JF031_S3_RH1() {
        return Btn2_JF031_S3_RH1;
    }

    public JButton getBtn3_JF031_S3_RH2() {
        return Btn3_JF031_S3_RH2;
    }

    public JButton getBtn4_JF031_S3_RH() {
        return Btn4_JF031_S3_RH;
    }

    public JLabel getJL_Edad_JF031_S3_RH() {
        return JL_Edad_JF031_S3_RH;
    }

    public JButton getBtn01_JP031_S3_RH() {
        return btn01_JP031_S3_RH;
    }

    public void setBtn01_JP031_S3_RH(JButton btn01_JP031_S3_RH) {
        this.btn01_JP031_S3_RH = btn01_JP031_S3_RH;
    }

    public JLabel getJL_Correo_JF031_S3_RH() {
        return JL_Correo_JF031_S3_RH;
    }

    public JLabel getJL_Nombre_JF031_S3_RH() {
        return JL_Nombre_JF031_S3_RH;
    }

    public JLabel getJL_image_JF031_S3_RH() {
        return JL_image_JF031_S3_RH;
    }

    public void setJL_Edad_JF031_S3_RH(String texto) {
        JL_Edad_JF031_S3_RH.setText(texto);
    }

    public void setJL_Correo_JF031_S3_RH(String texto) {
        JL_Correo_JF031_S3_RH.setText(texto);
    }

    public void setJL_Nombre_JF031_S3_RH(String texto) {
        JL_Nombre_JF031_S3_RH.setText(texto);
    }

    public void setJL_image_JF031_S3_RH(String texto) {
        JL_image_JF031_S3_RH.setText(texto);
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
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

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JTextArea getTxtEscribirMensaje_JP031_S3_RH() {
        return txtEscribirMensaje_JP031_S3_RH;
    }

    public void setTxtEscribirMensaje_JP031_S3_RH(String text) {
        txtEscribirMensaje_JP031_S3_RH.setText(text);
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
        Btn1_JF031_S3_RH = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JP01_JF031_S3_RH = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        JL_Nombre_JF031_S3_RH = new javax.swing.JLabel();
        JL_image_JF031_S3_RH = new javax.swing.JLabel();
        JL_Edad_JF031_S3_RH = new javax.swing.JLabel();
        JL_Correo_JF031_S3_RH = new javax.swing.JLabel();
        btn01_JP031_S3_RH = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEscribirMensaje_JP031_S3_RH = new javax.swing.JTextArea();
        Btn4_JF031_S3_RH = new javax.swing.JButton();
        Btn2_JF031_S3_RH1 = new javax.swing.JButton();
        Btn3_JF031_S3_RH2 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1120, 640));
        setMinimumSize(new java.awt.Dimension(1120, 640));
        setPreferredSize(new java.awt.Dimension(1120, 640));
        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1120, 640));
        jPanel1.setMinimumSize(new java.awt.Dimension(1120, 640));
        jPanel1.setPreferredSize(new java.awt.Dimension(1120, 640));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn1_JF031_S3_RH.setBackground(new java.awt.Color(255, 255, 255));
        Btn1_JF031_S3_RH.setForeground(new java.awt.Color(255, 255, 255));
        Btn1_JF031_S3_RH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Vector (1).png"))); // NOI18N
        Btn1_JF031_S3_RH.setBorderPainted(false);
        Btn1_JF031_S3_RH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(Btn1_JF031_S3_RH, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Expediente del paciente");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/log.PNG"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, -1, -1));

        JP01_JF031_S3_RH.setBackground(new java.awt.Color(255, 255, 255));
        JP01_JF031_S3_RH.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        JL_Nombre_JF031_S3_RH.setBackground(new java.awt.Color(255, 255, 255));
        JL_Nombre_JF031_S3_RH.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        JL_Nombre_JF031_S3_RH.setText("Nombre Persona");
        JL_Nombre_JF031_S3_RH.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JL_image_JF031_S3_RH.setBackground(new java.awt.Color(0, 0, 0));
        JL_image_JF031_S3_RH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/gg.PNG"))); // NOI18N

        JL_Edad_JF031_S3_RH.setBackground(new java.awt.Color(255, 255, 255));
        JL_Edad_JF031_S3_RH.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        JL_Edad_JF031_S3_RH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JL_Correo_JF031_S3_RH.setBackground(new java.awt.Color(255, 255, 255));
        JL_Correo_JF031_S3_RH.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        JL_Correo_JF031_S3_RH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn01_JP031_S3_RH.setBackground(new java.awt.Color(255, 255, 255));
        btn01_JP031_S3_RH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/corazao.png"))); // NOI18N
        btn01_JP031_S3_RH.setBorderPainted(false);
        btn01_JP031_S3_RH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setText("Edad");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("Correo Electrónico");

        txtEscribirMensaje_JP031_S3_RH.setBackground(new java.awt.Color(148, 177, 181));
        txtEscribirMensaje_JP031_S3_RH.setColumns(20);
        txtEscribirMensaje_JP031_S3_RH.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        txtEscribirMensaje_JP031_S3_RH.setRows(5);
        jScrollPane1.setViewportView(txtEscribirMensaje_JP031_S3_RH);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JL_image_JF031_S3_RH)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(JL_Nombre_JF031_S3_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(87, 87, 87)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn01_JP031_S3_RH)
                        .addGap(7, 7, 7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JL_Correo_JF031_S3_RH, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(JL_Edad_JF031_S3_RH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(197, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JL_Edad_JF031_S3_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_Nombre_JF031_S3_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JL_Correo_JF031_S3_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addComponent(btn01_JP031_S3_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1)
                                .addContainerGap())))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(JL_image_JF031_S3_RH)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        JP01_JF031_S3_RH.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(JP01_JF031_S3_RH, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 920, 310));

        Btn4_JF031_S3_RH.setBackground(new java.awt.Color(255, 255, 255));
        Btn4_JF031_S3_RH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnMedicina.png"))); // NOI18N
        Btn4_JF031_S3_RH.setBorderPainted(false);
        Btn4_JF031_S3_RH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(Btn4_JF031_S3_RH, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 480, 160, 100));

        Btn2_JF031_S3_RH1.setBackground(new java.awt.Color(255, 255, 255));
        Btn2_JF031_S3_RH1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgenda.png"))); // NOI18N
        Btn2_JF031_S3_RH1.setBorderPainted(false);
        Btn2_JF031_S3_RH1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn2_JF031_S3_RH1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn2_JF031_S3_RH1ActionPerformed(evt);
            }
        });
        jPanel1.add(Btn2_JF031_S3_RH1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 480, 150, 100));

        Btn3_JF031_S3_RH2.setBackground(new java.awt.Color(255, 255, 255));
        Btn3_JF031_S3_RH2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnVerNotas.png"))); // NOI18N
        Btn3_JF031_S3_RH2.setBorderPainted(false);
        Btn3_JF031_S3_RH2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(Btn3_JF031_S3_RH2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 480, 150, 100));

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void Btn2_JF031_S3_RH1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn2_JF031_S3_RH1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn2_JF031_S3_RH1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Btn1_JF031_S3_RH;
    public javax.swing.JButton Btn2_JF031_S3_RH1;
    public javax.swing.JButton Btn3_JF031_S3_RH2;
    public javax.swing.JButton Btn4_JF031_S3_RH;
    public javax.swing.JLabel JL_Correo_JF031_S3_RH;
    public javax.swing.JLabel JL_Edad_JF031_S3_RH;
    public javax.swing.JLabel JL_Nombre_JF031_S3_RH;
    public javax.swing.JLabel JL_image_JF031_S3_RH;
    public javax.swing.JPanel JP01_JF031_S3_RH;
    public javax.swing.JButton btn01_JP031_S3_RH;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea txtEscribirMensaje_JP031_S3_RH;
    // End of variables declaration//GEN-END:variables
}
