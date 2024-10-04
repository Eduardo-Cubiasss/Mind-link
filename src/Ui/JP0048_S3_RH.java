/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import keeptoo.KGradientPanel;
import ux.Hints;
import ux.LimiteCaracteres;
import ux.Login;
import ux.PanelesInicializador;
import ux.Validaciones;
import ux.primer_uso;




public final class JP0048_S3_RH extends javax.swing.JPanel {
    
     private primer_uso controlador; 
    private PanelesInicializador str;
     private Hints hint;
    private LimiteCaracteres Limite;

 
    
    public void setTxtCorreoElectronico_jp0048_RH(String texto) {
        txtCorreoElectronico_jp0048_RH.setText(texto);
    }

    // Setter para el campo de texto txtActiLabo_JP0048
    public void setTxtActiLabo_JP0048(String texto) {
        txtActiLabo_JP0048.setText(texto);
    }

    // Setter para el campo de texto txtNumTel_JP0048
    public void setTxtNumTel_JP0048(String texto) {
        txtNumTel_JP0048.setText(texto);
    }

    // Setter para el campo de texto txtFechaNa_JP0048
    public void setTxtFechaNa_JP0048(String texto) {
        txtFechaNa_JP0048.setText(texto);
    }

    // Setter para el campo de texto txtDui_JP0048
    public void setTxtDui_JP0048(String texto) {
        txtDui_JP0048.setText(texto);
    }
     public JTextField getTxtCorreoElectronico_jp0048_RH() {
        return txtCorreoElectronico_jp0048_RH;
    }

    public JTextField getTxtNumTel_JP0048() {
        return txtNumTel_JP0048;
    }

    public JTextField getTxtDui_JP0048() {
        return txtDui_JP0048;
    }

    public JTextField getTxtActiLabo_JP0048() {
        return txtActiLabo_JP0048;
    }

    public JTextField getTxtFechaNa_JP0048() {
        return txtFechaNa_JP0048;
    }

    public JComboBox getJComboBox1() {
        return CmbxGenero;
    }

    public JButton getbtnOmitir() {
        return btnOmitir;
    }
    
    public JButton getbtnEmpecemos() {
        return btnEmpecemos;
    }

    public JButton getBtn02_JF048_S3_RH() {
        return btn02_JF048_S3_RH;
    }

    public void setBtn02_JF048_S3_RH(JButton btn02_JF048_S3_RH) {
        this.btn02_JF048_S3_RH = btn02_JF048_S3_RH;
    }
    
    
    public JComboBox<String> getCmbxGenero() {
        return CmbxGenero;
    }

    public void setCmbxGenero(JComboBox<String> CmbxGenero) {
        this.CmbxGenero = CmbxGenero;
    }

    public JButton getBtnEmpecemos() {
        return btnEmpecemos;
    }

    public void setBtnEmpecemos(JButton btnEmpecemos) {
        this.btnEmpecemos = btnEmpecemos;
    }

    public JButton getBtnOmitir() {
        return btnOmitir;
    }

    public void setBtnOmitir(JButton btnOmitir) {
        this.btnOmitir = btnOmitir;
    }


    public JLabel getjLabel18() {
        return jLabel18;
    }

    public void setjLabel18(JLabel jLabel18) {
        this.jLabel18 = jLabel18;
    }


    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }


    

    

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }

    public JLabel getjLabel12() {
        return jLabel12;
    }

    public void setjLabel12(JLabel jLabel12) {
        this.jLabel12 = jLabel12;
    }

    public JLabel getjLabel13() {
        return jLabel13;
    }

    public void setjLabel13(JLabel jLabel13) {
        this.jLabel13 = jLabel13;
    }

    public JLabel getjLabel14() {
        return jLabel14;
    }

    public void setjLabel14(JLabel jLabel14) {
        this.jLabel14 = jLabel14;
    }

    public JLabel getjLabel15() {
        return jLabel15;
    }

    public void setjLabel15(JLabel jLabel15) {
        this.jLabel15 = jLabel15;
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

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }
    
    
     
    public JP0048_S3_RH(primer_uso controlador) {
        this.controlador = controlador;
        str = new PanelesInicializador();
        initComponents();
        
              
        LimiteCaracteres limiteFecha = new LimiteCaracteres(txtFechaNa_JP0048, 0, 10);
         new Validaciones(getTxtFechaNa_JP0048(),"Fecha10Digitos");
        hint.addHint(txtFechaNa_JP0048,"dd/MM/yyyy");

        
        LimiteCaracteres limiteContaseña = new LimiteCaracteres(txtNumTel_JP0048, 0, 8);
         
      // new Validaciones(getTxtNumTel_JP0048(), "SoloNumeros");
        hint.addHint(txtNumTel_JP0048,"Ingrese su número de telefono");
        
        LimiteCaracteres limiteDui = new LimiteCaracteres(txtDui_JP0048, 0, 9);
       new Validaciones(getTxtDui_JP0048(), "ValidarDUI");
        hint.addHint(txtDui_JP0048,"XXXXXXXX-X");
        
        
        // Establecer el valor de str aquí después de haberlo creado
        str.setJP0048_S3_RH(this);
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
        CmbxGenero = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCorreoElectronico_jp0048_RH = new javax.swing.JTextField();
        txtActiLabo_JP0048 = new javax.swing.JTextField();
        txtNumTel_JP0048 = new javax.swing.JTextField();
        txtFechaNa_JP0048 = new javax.swing.JTextField();
        txtDui_JP0048 = new javax.swing.JTextField();
        btnEmpecemos = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        kGradientPanel9 = new keeptoo.KGradientPanel();
        jLabel18 = new javax.swing.JLabel();
        btnOmitir = new javax.swing.JButton();
        btn02_JF048_S3_RH = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1120, 640));
        setMinimumSize(new java.awt.Dimension(1120, 640));
        setPreferredSize(new java.awt.Dimension(1120, 640));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1120, 640));
        jPanel1.setMinimumSize(new java.awt.Dimension(1120, 640));
        jPanel1.setPreferredSize(new java.awt.Dimension(1120, 640));

        CmbxGenero.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        CmbxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Género", "Masculino", "Femenino", "Prefiero no decirlo", " ", " " }));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setText("Antes de empezar necesitamos cierta ");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setText("información para mejorar nuestros servicios");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Llena todos los campos del formulario, nos servirá más adelante");

        txtCorreoElectronico_jp0048_RH.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtCorreoElectronico_jp0048_RH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoElectronico_jp0048_RHActionPerformed(evt);
            }
        });

        txtActiLabo_JP0048.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtActiLabo_JP0048.setToolTipText("");

        txtNumTel_JP0048.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtNumTel_JP0048.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtNumTel_JP0048.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumTel_JP0048ActionPerformed(evt);
            }
        });

        txtFechaNa_JP0048.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtFechaNa_JP0048.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaNa_JP0048ActionPerformed(evt);
            }
        });

        txtDui_JP0048.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtDui_JP0048.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDui_JP0048ActionPerformed(evt);
            }
        });

        btnEmpecemos.setBackground(new java.awt.Color(255, 255, 255));
        btnEmpecemos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnEmpecemos.png"))); // NOI18N
        btnEmpecemos.setBorderPainted(false);

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel9.setText("Correo Electrónico");

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel12.setText("Fecha de nacimiento");

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel13.setText("Dui");

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel14.setText("Número Telefónico");

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel15.setText("Actividad Laboral");

        kGradientPanel9.setkEndColor(new java.awt.Color(0, 204, 204));
        kGradientPanel9.setkStartColor(new java.awt.Color(0, 102, 102));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LogitoGrande.png"))); // NOI18N

        javax.swing.GroupLayout kGradientPanel9Layout = new javax.swing.GroupLayout(kGradientPanel9);
        kGradientPanel9.setLayout(kGradientPanel9Layout);
        kGradientPanel9Layout.setHorizontalGroup(
            kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel9Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        kGradientPanel9Layout.setVerticalGroup(
            kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(187, 187, 187))
        );

        btnOmitir.setBackground(new java.awt.Color(255, 255, 255));
        btnOmitir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnRegresar.png"))); // NOI18N
        btnOmitir.setBorderPainted(false);
        btnOmitir.setContentAreaFilled(false);
        btnOmitir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOmitir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOmitirActionPerformed(evt);
            }
        });

        btn02_JF048_S3_RH.setBackground(new java.awt.Color(255, 255, 255));
        btn02_JF048_S3_RH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/left.png"))); // NOI18N
        btn02_JF048_S3_RH.setBorderPainted(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(54, 54, 54))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btn02_JF048_S3_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(jLabel2))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(jLabel3))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel4))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(CmbxGenero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addGap(268, 268, 268)
                                            .addComponent(txtNumTel_JP0048, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(335, 335, 335)
                                            .addComponent(jLabel14)
                                            .addGap(78, 78, 78)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtActiLabo_JP0048, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnOmitir, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDui_JP0048, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnEmpecemos, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(86, 86, 86))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtCorreoElectronico_jp0048_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFechaNa_JP0048, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(71, 71, 71)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addGap(169, 169, 169)))
                .addComponent(kGradientPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn02_JF048_S3_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreoElectronico_jp0048_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaNa_JP0048, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDui_JP0048, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtActiLabo_JP0048, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNumTel_JP0048, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CmbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOmitir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmpecemos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
            .addComponent(kGradientPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCorreoElectronico_jp0048_RHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoElectronico_jp0048_RHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoElectronico_jp0048_RHActionPerformed

    private void btnOmitirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOmitirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOmitirActionPerformed

    private void txtDui_JP0048ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDui_JP0048ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDui_JP0048ActionPerformed

    private void txtFechaNa_JP0048ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaNa_JP0048ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaNa_JP0048ActionPerformed

    private void txtNumTel_JP0048ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumTel_JP0048ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumTel_JP0048ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> CmbxGenero;
    public javax.swing.JButton btn02_JF048_S3_RH;
    public javax.swing.JButton btnEmpecemos;
    public javax.swing.JButton btnOmitir;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public keeptoo.KGradientPanel kGradientPanel9;
    public javax.swing.JTextField txtActiLabo_JP0048;
    public javax.swing.JTextField txtCorreoElectronico_jp0048_RH;
    public javax.swing.JTextField txtDui_JP0048;
    public javax.swing.JTextField txtFechaNa_JP0048;
    public javax.swing.JTextField txtNumTel_JP0048;
    // End of variables declaration//GEN-END:variables
}
