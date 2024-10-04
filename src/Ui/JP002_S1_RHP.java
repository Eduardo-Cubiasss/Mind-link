/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import keeptoo.KGradientPanel;
import ux.Hints;
import ux.LimiteCaracteres;
import ux.PanelesInicializador;
import ux.RegAdmin_JF002;
import ux.Validaciones;


/**
 *
 * @author 50369
 */
public class JP002_S1_RHP extends javax.swing.JPanel {

    private RegAdmin_JF002 controlador;
    private JP002_S1_RHP panel;
    private PanelesInicializador str;
    private Hints hint;
    private LimiteCaracteres Limite;

    public RegAdmin_JF002 getControlador() {
        return controlador;
    }

    public void setControlador(RegAdmin_JF002 controlador) {
        this.controlador = controlador;
    }

    public JP002_S1_RHP getPanel() {
        return panel;
    }

    public void setPanel(JP002_S1_RHP panel) {
        this.panel = panel;
    }

    public PanelesInicializador getStr() {
        return str;
    }

    public void setStr(PanelesInicializador str) {
        this.str = str;
    }

    public Hints getHint() {
        return hint;
    }

    public void setHint(Hints hint) {
        this.hint = hint;
    }

    public LimiteCaracteres getLimite() {
        return Limite;
    }

    public void setLimite(LimiteCaracteres Limite) {
        this.Limite = Limite;
    }

    public JButton getBtn1_JF002_S1_RH() {
        return Btn1_JF002_S1_RH;
    }

    public void setBtn1_JF002_S1_RH(JButton Btn1_JF002_S1_RH) {
        this.Btn1_JF002_S1_RH = Btn1_JF002_S1_RH;
    }

    public JButton getBtn2_JF002_S1_RH() {
        return Btn2_JF002_S1_RH;
    }

    public void setBtn2_JF002_S1_RH(JButton Btn2_JF002_S1_RH) {
        this.Btn2_JF002_S1_RH = Btn2_JF002_S1_RH;
    }

    public JPanel getJP001_S1_RH() {
        return JP001_S1_RH;
    }

    public void setJP001_S1_RH(JPanel JP001_S1_RH) {
        this.JP001_S1_RH = JP001_S1_RH;
    }

    public JPasswordField getPassField_ConfirmarContra_JF002_S1_RH() {
        return PassField_ConfirmarContra_JF002_S1_RH;
    }

    public void setPassField_ConfirmarContra_JF002_S1_RH(JPasswordField PassField_ConfirmarContra_JF002_S1_RH) {
        this.PassField_ConfirmarContra_JF002_S1_RH = PassField_ConfirmarContra_JF002_S1_RH;
    }

    public JPasswordField getPassField_Contraseña_JF002_S1_RH() {
        return PassField_Contraseña_JF002_S1_RH;
    }

    public void setPassField_Contraseña_JF002_S1_RH(JPasswordField PassField_Contraseña_JF002_S1_RH) {
        this.PassField_Contraseña_JF002_S1_RH = PassField_Contraseña_JF002_S1_RH;
    }

    public JTextField getTxtID_JF002_S1_RH3() {
        return TxtID_JF002_S1_RH3;
    }

    public void setTxtID_JF002_S1_RH3(JTextField TxtID_JF002_S1_RH3) {
        this.TxtID_JF002_S1_RH3 = TxtID_JF002_S1_RH3;
    }

    public JTextField getTxtNombre_JF002_S1_RH() {
        return TxtNombre_JF002_S1_RH;
    }

    public void setTxtNombre_JF002_S1_RH(JTextField TxtNombre_JF002_S1_RH) {
        this.TxtNombre_JF002_S1_RH = TxtNombre_JF002_S1_RH;
    }

    public JTextField getTxtUsuario_JF002_S1_RH2() {
        return TxtUsuario_JF002_S1_RH2;
    }

    public void setTxtUsuario_JF002_S1_RH2(JTextField TxtUsuario_JF002_S1_RH2) {
        this.TxtUsuario_JF002_S1_RH2 = TxtUsuario_JF002_S1_RH2;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }

    public JLabel getjLabel11() {
        return jLabel11;
    }

    public void setjLabel11(JLabel jLabel11) {
        this.jLabel11 = jLabel11;
    }

    public JLabel getjLabel12() {
        return jLabel12;
    }

    public void setjLabel12(JLabel jLabel12) {
        this.jLabel12 = jLabel12;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }

    public KGradientPanel getkGradientPanel1() {
        return kGradientPanel1;
    }

    public void setkGradientPanel1(KGradientPanel kGradientPanel1) {
        this.kGradientPanel1 = kGradientPanel1;
    }
    
    

    

    /**
     * Creates new form JP002_S1_RHP
     */
    public JP002_S1_RHP (RegAdmin_JF002 controlador) {
        
        this.controlador = controlador;
        initComponents();
        LimiteCaracteres limiteNombre = new LimiteCaracteres(TxtNombre_JF002_S1_RH, 0, 25);
        new Validaciones(TxtNombre_JF002_S1_RH, "SoloLetras");
        hint.addHint(TxtNombre_JF002_S1_RH, "Ingrese su nombre");

       LimiteCaracteres limiteUsuario = new LimiteCaracteres(TxtUsuario_JF002_S1_RH2, 0, 25);
        new Validaciones(getTxtUsuario_JF002_S1_RH2(), "SoloLetras");
        hint.addHint(getTxtUsuario_JF002_S1_RH2(), "Ingrese su nombre de usuario");



        LimiteCaracteres limiteContraseña1 = new LimiteCaracteres(PassField_Contraseña_JF002_S1_RH, 0, 16);
       

        LimiteCaracteres limiteContraseña2 = new LimiteCaracteres(PassField_ConfirmarContra_JF002_S1_RH, 0, 16);
        

        LimiteCaracteres limiteID = new LimiteCaracteres(TxtID_JF002_S1_RH3, 0, 5);
        hint.addHint(getTxtID_JF002_S1_RH3(), "XXXXX");
         str = new PanelesInicializador();
         
        
        
        // Establecer el valor de str aquí después de haberlo creado
        str.setJP002_S1_RHP(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JP001_S1_RH = new javax.swing.JPanel();
        TxtNombre_JF002_S1_RH = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtUsuario_JF002_S1_RH2 = new javax.swing.JTextField();
        TxtID_JF002_S1_RH3 = new javax.swing.JTextField();
        PassField_ConfirmarContra_JF002_S1_RH = new javax.swing.JPasswordField();
        PassField_Contraseña_JF002_S1_RH = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Btn1_JF002_S1_RH = new javax.swing.JButton();
        Btn2_JF002_S1_RH = new javax.swing.JButton();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1120, 640));
        setMinimumSize(new java.awt.Dimension(1120, 640));
        setPreferredSize(new java.awt.Dimension(1120, 640));
        setLayout(new java.awt.CardLayout());

        JP001_S1_RH.setBackground(new java.awt.Color(255, 255, 255));
        JP001_S1_RH.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        JP001_S1_RH.setMaximumSize(new java.awt.Dimension(1120, 640));
        JP001_S1_RH.setMinimumSize(new java.awt.Dimension(1120, 640));
        JP001_S1_RH.setPreferredSize(new java.awt.Dimension(1120, 640));

        TxtNombre_JF002_S1_RH.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        TxtNombre_JF002_S1_RH.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        TxtNombre_JF002_S1_RH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TxtNombre_JF002_S1_RH.setSelectionColor(new java.awt.Color(0, 0, 0));
        TxtNombre_JF002_S1_RH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNombre_JF002_S1_RHActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("<html> REGISTRARSE COMO ADMINISTRADOR <br>    ");

        TxtUsuario_JF002_S1_RH2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        TxtUsuario_JF002_S1_RH2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        TxtUsuario_JF002_S1_RH2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        TxtUsuario_JF002_S1_RH2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtUsuario_JF002_S1_RH2ActionPerformed(evt);
            }
        });

        TxtID_JF002_S1_RH3.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        TxtID_JF002_S1_RH3.setForeground(new java.awt.Color(153, 153, 153));
        TxtID_JF002_S1_RH3.setText("Elige un ID único");
        TxtID_JF002_S1_RH3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        TxtID_JF002_S1_RH3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        TxtID_JF002_S1_RH3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtID_JF002_S1_RH3ActionPerformed(evt);
            }
        });

        PassField_ConfirmarContra_JF002_S1_RH.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        PassField_ConfirmarContra_JF002_S1_RH.setToolTipText("");
        PassField_ConfirmarContra_JF002_S1_RH.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        PassField_Contraseña_JF002_S1_RH.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        PassField_Contraseña_JF002_S1_RH.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        PassField_Contraseña_JF002_S1_RH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PassField_Contraseña_JF002_S1_RHActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Nombre");

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("Usuario");

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("Contraseña");

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("Crea el ID de tu clínica");

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("Confirmar contraseña");

        Btn1_JF002_S1_RH.setBackground(new java.awt.Color(255, 255, 255));
        Btn1_JF002_S1_RH.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        Btn1_JF002_S1_RH.setForeground(new java.awt.Color(255, 255, 255));
        Btn1_JF002_S1_RH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/RegistrarseClarito.png"))); // NOI18N
        Btn1_JF002_S1_RH.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Btn1_JF002_S1_RH.setBorderPainted(false);
        Btn1_JF002_S1_RH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn1_JF002_S1_RH.setInheritsPopupMenu(true);
        Btn1_JF002_S1_RH.setMaximumSize(new java.awt.Dimension(1120, 540));
        Btn1_JF002_S1_RH.setMinimumSize(new java.awt.Dimension(1120, 540));
        Btn1_JF002_S1_RH.setPreferredSize(new java.awt.Dimension(1120, 540));
        Btn1_JF002_S1_RH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn1_JF002_S1_RHMouseClicked(evt);
            }
        });
        Btn1_JF002_S1_RH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn1_JF002_S1_RHActionPerformed(evt);
            }
        });

        Btn2_JF002_S1_RH.setBackground(new java.awt.Color(255, 255, 255));
        Btn2_JF002_S1_RH.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        Btn2_JF002_S1_RH.setForeground(new java.awt.Color(255, 255, 255));
        Btn2_JF002_S1_RH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/IniciarSesionTrns.png"))); // NOI18N
        Btn2_JF002_S1_RH.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 50, true));
        Btn2_JF002_S1_RH.setBorderPainted(false);
        Btn2_JF002_S1_RH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn2_JF002_S1_RH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn2_JF002_S1_RHActionPerformed(evt);
            }
        });

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 204, 204));
        kGradientPanel1.setkGradientFocus(100);
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 102, 102));
        kGradientPanel1.setkTransparentControls(false);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LogitoGrande.png"))); // NOI18N

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(237, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JP001_S1_RHLayout = new javax.swing.GroupLayout(JP001_S1_RH);
        JP001_S1_RH.setLayout(JP001_S1_RHLayout);
        JP001_S1_RHLayout.setHorizontalGroup(
            JP001_S1_RHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP001_S1_RHLayout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(JP001_S1_RHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP001_S1_RHLayout.createSequentialGroup()
                        .addGroup(JP001_S1_RHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JP001_S1_RHLayout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addGroup(JP001_S1_RHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(JP001_S1_RHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel1)
                                        .addComponent(TxtNombre_JF002_S1_RH, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                                        .addComponent(TxtUsuario_JF002_S1_RH2)
                                        .addComponent(PassField_Contraseña_JF002_S1_RH))))
                            .addGroup(JP001_S1_RHLayout.createSequentialGroup()
                                .addGap(196, 196, 196)
                                .addComponent(TxtID_JF002_S1_RH3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(JP001_S1_RHLayout.createSequentialGroup()
                        .addGroup(JP001_S1_RHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JP001_S1_RHLayout.createSequentialGroup()
                                .addGap(214, 214, 214)
                                .addComponent(jLabel11))
                            .addGroup(JP001_S1_RHLayout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(Btn2_JF002_S1_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(JP001_S1_RHLayout.createSequentialGroup()
                .addGap(659, 659, 659)
                .addGroup(JP001_S1_RHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP001_S1_RHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel12)
                        .addComponent(PassField_ConfirmarContra_JF002_S1_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP001_S1_RHLayout.createSequentialGroup()
                        .addComponent(Btn1_JF002_S1_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)))
                .addGap(0, 132, Short.MAX_VALUE))
        );
        JP001_S1_RHLayout.setVerticalGroup(
            JP001_S1_RHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP001_S1_RHLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtNombre_JF002_S1_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtUsuario_JF002_S1_RH2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PassField_Contraseña_JF002_S1_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PassField_ConfirmarContra_JF002_S1_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtID_JF002_S1_RH3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(Btn1_JF002_S1_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn2_JF002_S1_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(JP001_S1_RHLayout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(JP001_S1_RH, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void Btn2_JF002_S1_RHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn2_JF002_S1_RHActionPerformed
        
    }//GEN-LAST:event_Btn2_JF002_S1_RHActionPerformed

    private void Btn1_JF002_S1_RHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn1_JF002_S1_RHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn1_JF002_S1_RHActionPerformed

    private void Btn1_JF002_S1_RHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn1_JF002_S1_RHMouseClicked

    }//GEN-LAST:event_Btn1_JF002_S1_RHMouseClicked

    private void PassField_Contraseña_JF002_S1_RHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PassField_Contraseña_JF002_S1_RHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PassField_Contraseña_JF002_S1_RHActionPerformed

    private void TxtID_JF002_S1_RH3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtID_JF002_S1_RH3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtID_JF002_S1_RH3ActionPerformed

    private void TxtUsuario_JF002_S1_RH2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtUsuario_JF002_S1_RH2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtUsuario_JF002_S1_RH2ActionPerformed

    private void TxtNombre_JF002_S1_RHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNombre_JF002_S1_RHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNombre_JF002_S1_RHActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Btn1_JF002_S1_RH;
    public javax.swing.JButton Btn2_JF002_S1_RH;
    private javax.swing.JPanel JP001_S1_RH;
    public javax.swing.JPasswordField PassField_ConfirmarContra_JF002_S1_RH;
    public javax.swing.JPasswordField PassField_Contraseña_JF002_S1_RH;
    public javax.swing.JTextField TxtID_JF002_S1_RH3;
    public javax.swing.JTextField TxtNombre_JF002_S1_RH;
    public javax.swing.JTextField TxtUsuario_JF002_S1_RH2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private keeptoo.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
}
