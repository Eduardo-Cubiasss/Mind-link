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
import ux.DetallesDeMiPerfil;
import ux.PanelesInicializador;
import ux.SolicitudesAprobadas2;
import ux.LimiteCaracteres;
import ux.Hints;
import ux.Validaciones;

/**
 *
 * @author LENOVO
 */
public class JP025_S3_RH extends javax.swing.JPanel {

    
    private DetallesDeMiPerfil controlador;
    private PanelesInicializador str;
    private Hints hint;
    private LimiteCaracteres Limite;

    public JTextField getTxtContraNueva_JF025_S3_RH() {
        return TxtContraNueva_JF025_S3_RH;
    }

    public void setTxtContraNueva_JF025_S3_RH(String texto) {
        TxtContraNueva_JF025_S3_RH.setText(texto);
    }

    public JTextField getTxtContraseñaActual_JF025_S3_RH() {
        return TxtContraseñaActual_JF025_S3_RH;
    }

    public void setTxtContraseñaActual_JF025_S3_RH(JTextField TxtContraseñaActual_JF025_S3_RH) {
        this.TxtContraseñaActual_JF025_S3_RH = TxtContraseñaActual_JF025_S3_RH;
    }

    public JTextArea getTxtDescrip_JF025_S3_RH() {
        return TxtDescrip_JF025_S3_RH;
    }

    public void setTxtDescrip_JF025_S3_RH(String text) {
        TxtDescrip_JF025_S3_RH.setText(text);
    }



    public JButton getBtnotrasconfig() {
        return Btnotrasconfig;
    }

    public void setBtnotrasconfig(JButton Btnotrasconfig) {
        this.Btnotrasconfig = Btnotrasconfig;
    }


    public JButton getBtn03_JF025_S3_RH() {
        return Btnotrasconfig;
    }

    public void setBtn03_JF025_S3_RH(JButton btn03_JF025_S3_RH) {
        this.Btnotrasconfig = btn03_JF025_S3_RH;
    }

    public JButton getBtn04_JF025_S3_RH() {
        return btn04_JF025_S3_RH;
    }

    public void setBtn04_JF025_S3_RH(JButton btn04_JF025_S3_RH) {
        this.btn04_JF025_S3_RH = btn04_JF025_S3_RH;
    }

    public JButton getBtn05_JF025_S3_RH() {
        return btn05_JF025_S3_RH;
    }

    public void setBtn05_JF025_S3_RH(JButton btn05_JF025_S3_RH) {
        this.btn05_JF025_S3_RH = btn05_JF025_S3_RH;
    }

    public JButton getBtn1_JF025_S3_RH() {
        return Btn1_JF025_S3_RH;
    }

    public void setBtn1_JF025_S3_RH(JButton Btn1_JF025_S3_RH) {
        this.Btn1_JF025_S3_RH = Btn1_JF025_S3_RH;
    }


    public JPanel getJP02_Firma_JF025_S3_RH() {
        return JP02_Firma_JF025_S3_RH;
    }

    public void setJP02_Firma_JF025_S3_RH(JPanel JP02_Firma_JF025_S3_RH) {
        this.JP02_Firma_JF025_S3_RH = JP02_Firma_JF025_S3_RH;
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

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }
    
    
    
    
    public JP025_S3_RH(DetallesDeMiPerfil controlador) {
        this.hint = hint;
        
        initComponents();
        this.controlador = controlador;
        
        str = new PanelesInicializador();
        
         // Establecer el valor de str aquí después de haberlo creado
        str.setJP025_S3_RH(this);
        hint.addHintToJTextArea(getTxtDescrip_JF025_S3_RH(), "Describase brevemente");
        
        LimiteCaracteres limiteContraseña1 = new LimiteCaracteres(TxtContraseñaActual_JF025_S3_RH, 0, 16);
        hint.addHint(getTxtContraseñaActual_JF025_S3_RH(), "Ingrese su contraseña actual");

        LimiteCaracteres limiteContraseña2 = new LimiteCaracteres(TxtContraNueva_JF025_S3_RH, 0, 16);
        hint.addHint(getTxtContraNueva_JF025_S3_RH(), "Ingrese su contraseña nueva");
    }
    
    
    
    public JP025_S3_RH() {
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
        jLabel3 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Btn1_JF025_S3_RH = new javax.swing.JButton();
        TxtContraNueva_JF025_S3_RH = new javax.swing.JTextField();
        TxtContraseñaActual_JF025_S3_RH = new javax.swing.JTextField();
        btn05_JF025_S3_RH = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        JP02_Firma_JF025_S3_RH = new javax.swing.JPanel();
        btn04_JF025_S3_RH = new javax.swing.JButton();
        Btnotrasconfig = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtDescrip_JF025_S3_RH = new javax.swing.JTextArea();

        setMaximumSize(new java.awt.Dimension(1120, 640));
        setMinimumSize(new java.awt.Dimension(1120, 640));
        setPreferredSize(new java.awt.Dimension(1120, 640));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1120, 640));
        jPanel1.setMinimumSize(new java.awt.Dimension(1120, 640));
        jPanel1.setPreferredSize(new java.awt.Dimension(1120, 640));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel3.setText("Detalles de mi perfil");

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 204, 204));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1122, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setText("Cambiar contraseña");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("Acerca de mi");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/log.PNG"))); // NOI18N

        Btn1_JF025_S3_RH.setBackground(new java.awt.Color(255, 255, 255));
        Btn1_JF025_S3_RH.setForeground(new java.awt.Color(255, 255, 255));
        Btn1_JF025_S3_RH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Vector (1).png"))); // NOI18N
        Btn1_JF025_S3_RH.setBorderPainted(false);
        Btn1_JF025_S3_RH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        TxtContraNueva_JF025_S3_RH.setForeground(new java.awt.Color(153, 153, 153));
        TxtContraNueva_JF025_S3_RH.setText("Nueva contraseña");
        TxtContraNueva_JF025_S3_RH.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));

        TxtContraseñaActual_JF025_S3_RH.setForeground(new java.awt.Color(153, 153, 153));
        TxtContraseñaActual_JF025_S3_RH.setText("Contraseña actual");
        TxtContraseñaActual_JF025_S3_RH.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        TxtContraseñaActual_JF025_S3_RH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtContraseñaActual_JF025_S3_RHActionPerformed(evt);
            }
        });

        btn05_JF025_S3_RH.setBackground(new java.awt.Color(255, 255, 255));
        btn05_JF025_S3_RH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizarNegro.png"))); // NOI18N
        btn05_JF025_S3_RH.setBorderPainted(false);

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setText("Descripción");

        JP02_Firma_JF025_S3_RH.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout JP02_Firma_JF025_S3_RHLayout = new javax.swing.GroupLayout(JP02_Firma_JF025_S3_RH);
        JP02_Firma_JF025_S3_RH.setLayout(JP02_Firma_JF025_S3_RHLayout);
        JP02_Firma_JF025_S3_RHLayout.setHorizontalGroup(
            JP02_Firma_JF025_S3_RHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );
        JP02_Firma_JF025_S3_RHLayout.setVerticalGroup(
            JP02_Firma_JF025_S3_RHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        btn04_JF025_S3_RH.setBackground(new java.awt.Color(255, 255, 255));
        btn04_JF025_S3_RH.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        btn04_JF025_S3_RH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/+Negro.png"))); // NOI18N
        btn04_JF025_S3_RH.setBorderPainted(false);

        Btnotrasconfig.setBackground(new java.awt.Color(255, 255, 255));
        Btnotrasconfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Primerusoiiir.png"))); // NOI18N
        Btnotrasconfig.setBorderPainted(false);

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel6.setText("Otras configuraciones");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/gg.PNG"))); // NOI18N

        TxtDescrip_JF025_S3_RH.setColumns(20);
        TxtDescrip_JF025_S3_RH.setRows(5);
        jScrollPane1.setViewportView(TxtDescrip_JF025_S3_RH);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(jLabel2)
                                .addGap(329, 329, 329)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Btn1_JF025_S3_RH)
                                .addGap(366, 366, 366)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(JP02_Firma_JF025_S3_RH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(TxtContraseñaActual_JF025_S3_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(TxtContraNueva_JF025_S3_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(94, 94, 94)
                                                .addComponent(btn04_JF025_S3_RH)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btn05_JF025_S3_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(48, 48, 48)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(190, 190, 190)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(479, 479, 479)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(Btnotrasconfig))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel6))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Btn1_JF025_S3_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel3)))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtContraseñaActual_JF025_S3_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtContraNueva_JF025_S3_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JP02_Firma_JF025_S3_RH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn04_JF025_S3_RH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btn05_JF025_S3_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btnotrasconfig)
                        .addGap(38, 38, 38)))
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TxtContraseñaActual_JF025_S3_RHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtContraseñaActual_JF025_S3_RHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtContraseñaActual_JF025_S3_RHActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Btn1_JF025_S3_RH;
    public javax.swing.JButton Btnotrasconfig;
    public javax.swing.JPanel JP02_Firma_JF025_S3_RH;
    public javax.swing.JTextField TxtContraNueva_JF025_S3_RH;
    public javax.swing.JTextField TxtContraseñaActual_JF025_S3_RH;
    public javax.swing.JTextArea TxtDescrip_JF025_S3_RH;
    public javax.swing.JButton btn04_JF025_S3_RH;
    public javax.swing.JButton btn05_JF025_S3_RH;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public keeptoo.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
}
