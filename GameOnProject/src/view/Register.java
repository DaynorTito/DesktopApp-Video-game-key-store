/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import databaseConnection.CLogin;
import databaseConnection.UsuariosLogin;
import databaseConnection.UsuariosRegister;
import databaseConnection.usuarios_login;
import databaseConnection.usuarios_register;

/**
 *
 * @author usr
 */
public class Register extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    public Register() {
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

        fondo_registro = new javax.swing.JPanel();
        Logo_regitro = new javax.swing.JLabel();
        Registro_texto = new javax.swing.JLabel();
        Nota_login_texto = new javax.swing.JLabel();
        Boton_login = new javax.swing.JButton();
        Nickname_usuario_texto = new javax.swing.JLabel();
        Primer_nombre_usuario_texto = new javax.swing.JLabel();
        Segundo_nombre_usuario_texto = new javax.swing.JLabel();
        Primer_apellido_usuario_texto = new javax.swing.JLabel();
        Segundo_apellido_usuario_texto = new javax.swing.JLabel();
        Fecha_nacimiento_usuario_texto = new javax.swing.JLabel();
        Registro_nickname = new javax.swing.JTextField();
        Registro_fecha_nacimiento = new javax.swing.JTextField();
        Registro_primer_nombre = new javax.swing.JTextField();
        Registro_segundo_nombre = new javax.swing.JTextField();
        Registro_segundo_apellido = new javax.swing.JTextField();
        Registro_primer_apellido = new javax.swing.JTextField();
        Boton_registrarse = new javax.swing.JButton();
        Contraseña_texto = new javax.swing.JLabel();
        Confirmar_contraseña_texto = new javax.swing.JLabel();
        Registro_contraseña = new javax.swing.JPasswordField();
        Registro_confirmar_contraseña = new javax.swing.JPasswordField();
        Correo_electronico_texto = new javax.swing.JLabel();
        Registro_correo_electronico = new javax.swing.JTextField();
        NIT_texto = new javax.swing.JLabel();
        Registro_NIT = new javax.swing.JTextField();
        Imagen_registro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondo_registro.setBackground(new java.awt.Color(204, 204, 204));

        Logo_regitro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logo_web-removebg-preview.png"))); // NOI18N

        Registro_texto.setFont(new java.awt.Font("OCR A Extended", 0, 50)); // NOI18N
        Registro_texto.setText("Registro de Usuario");

        Nota_login_texto.setFont(new java.awt.Font("OCR A Extended", 0, 15)); // NOI18N
        Nota_login_texto.setText("Ya tienes una cuenta?, inicia sesión");

        Boton_login.setFont(new java.awt.Font("OCR A Extended", 0, 15)); // NOI18N
        Boton_login.setText("Iniciar Sesión");
        Boton_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_loginActionPerformed(evt);
            }
        });

        Nickname_usuario_texto.setFont(new java.awt.Font("OCR A Extended", 0, 25)); // NOI18N
        Nickname_usuario_texto.setText("Nickname");

        Primer_nombre_usuario_texto.setFont(new java.awt.Font("OCR A Extended", 0, 25)); // NOI18N
        Primer_nombre_usuario_texto.setText("Primer Nombre");

        Segundo_nombre_usuario_texto.setFont(new java.awt.Font("OCR A Extended", 0, 25)); // NOI18N
        Segundo_nombre_usuario_texto.setText("Segundo Nombre");

        Primer_apellido_usuario_texto.setFont(new java.awt.Font("OCR A Extended", 0, 25)); // NOI18N
        Primer_apellido_usuario_texto.setText("Primer Apellido");

        Segundo_apellido_usuario_texto.setFont(new java.awt.Font("OCR A Extended", 0, 25)); // NOI18N
        Segundo_apellido_usuario_texto.setText("Segundo Apellido");

        Fecha_nacimiento_usuario_texto.setFont(new java.awt.Font("OCR A Extended", 0, 25)); // NOI18N
        Fecha_nacimiento_usuario_texto.setText("Fecha de nacimiento");

        Registro_nickname.setFont(new java.awt.Font("OCR A Extended", 0, 15)); // NOI18N
        Registro_nickname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Registro_nicknameActionPerformed(evt);
            }
        });

        Registro_fecha_nacimiento.setFont(new java.awt.Font("OCR A Extended", 0, 15)); // NOI18N
        Registro_fecha_nacimiento.setText("YYYY-MM-DD");
        Registro_fecha_nacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Registro_fecha_nacimientoActionPerformed(evt);
            }
        });

        Registro_primer_nombre.setFont(new java.awt.Font("OCR A Extended", 0, 15)); // NOI18N
        Registro_primer_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Registro_primer_nombreActionPerformed(evt);
            }
        });

        Registro_segundo_nombre.setFont(new java.awt.Font("OCR A Extended", 0, 15)); // NOI18N
        Registro_segundo_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Registro_segundo_nombreActionPerformed(evt);
            }
        });

        Registro_segundo_apellido.setFont(new java.awt.Font("OCR A Extended", 0, 15)); // NOI18N
        Registro_segundo_apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Registro_segundo_apellidoActionPerformed(evt);
            }
        });

        Registro_primer_apellido.setFont(new java.awt.Font("OCR A Extended", 0, 15)); // NOI18N
        Registro_primer_apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Registro_primer_apellidoActionPerformed(evt);
            }
        });

        Boton_registrarse.setFont(new java.awt.Font("OCR A Extended", 0, 20)); // NOI18N
        Boton_registrarse.setText("Registrarse");
        Boton_registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_registrarseActionPerformed(evt);
            }
        });

        Contraseña_texto.setFont(new java.awt.Font("OCR A Extended", 0, 25)); // NOI18N
        Contraseña_texto.setText("Contraseña");

        Confirmar_contraseña_texto.setFont(new java.awt.Font("OCR A Extended", 0, 25)); // NOI18N
        Confirmar_contraseña_texto.setText("Confirmar Contraseña");

        Registro_contraseña.setFont(new java.awt.Font("OCR A Extended", 0, 15)); // NOI18N
        Registro_contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Registro_contraseñaActionPerformed(evt);
            }
        });

        Registro_confirmar_contraseña.setFont(new java.awt.Font("OCR A Extended", 0, 15)); // NOI18N
        Registro_confirmar_contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Registro_confirmar_contraseñaActionPerformed(evt);
            }
        });

        Correo_electronico_texto.setFont(new java.awt.Font("OCR A Extended", 0, 25)); // NOI18N
        Correo_electronico_texto.setText("Correo Electronico");

        Registro_correo_electronico.setFont(new java.awt.Font("OCR A Extended", 0, 15)); // NOI18N
        Registro_correo_electronico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Registro_correo_electronicoActionPerformed(evt);
            }
        });

        NIT_texto.setFont(new java.awt.Font("OCR A Extended", 0, 25)); // NOI18N
        NIT_texto.setText("NIT");

        Registro_NIT.setFont(new java.awt.Font("OCR A Extended", 0, 15)); // NOI18N
        Registro_NIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Registro_NITActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fondo_registroLayout = new javax.swing.GroupLayout(fondo_registro);
        fondo_registro.setLayout(fondo_registroLayout);
        fondo_registroLayout.setHorizontalGroup(
            fondo_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondo_registroLayout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addGroup(fondo_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondo_registroLayout.createSequentialGroup()
                        .addGroup(fondo_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fondo_registroLayout.createSequentialGroup()
                                .addComponent(Contraseña_texto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE))
                            .addGroup(fondo_registroLayout.createSequentialGroup()
                                .addComponent(Registro_contraseña)
                                .addGap(62, 62, 62)))
                        .addGroup(fondo_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Confirmar_contraseña_texto)
                            .addComponent(Registro_confirmar_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(166, 166, 166))
                    .addGroup(fondo_registroLayout.createSequentialGroup()
                        .addGroup(fondo_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fondo_registroLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(fondo_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(fondo_registroLayout.createSequentialGroup()
                                        .addComponent(Nota_login_texto)
                                        .addGap(31, 31, 31)
                                        .addComponent(Boton_login))
                                    .addComponent(Registro_texto)))
                            .addGroup(fondo_registroLayout.createSequentialGroup()
                                .addComponent(Correo_electronico_texto)
                                .addGap(124, 124, 124)
                                .addGroup(fondo_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Registro_NIT)
                                    .addComponent(NIT_texto))))
                        .addGap(181, 181, 181))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondo_registroLayout.createSequentialGroup()
                        .addGroup(fondo_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Registro_correo_electronico, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Registro_nickname, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Registro_primer_nombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Registro_primer_apellido)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, fondo_registroLayout.createSequentialGroup()
                                .addGroup(fondo_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Nickname_usuario_texto, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Primer_nombre_usuario_texto, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Primer_apellido_usuario_texto, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(57, 57, 57)
                        .addGroup(fondo_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Registro_fecha_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Fecha_nacimiento_usuario_texto)
                            .addComponent(Segundo_apellido_usuario_texto)
                            .addComponent(Registro_segundo_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Segundo_nombre_usuario_texto)
                            .addComponent(Registro_segundo_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(181, 181, 181))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondo_registroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(fondo_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondo_registroLayout.createSequentialGroup()
                        .addComponent(Logo_regitro)
                        .addGap(391, 391, 391))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondo_registroLayout.createSequentialGroup()
                        .addComponent(Boton_registrarse)
                        .addGap(416, 416, 416))))
        );
        fondo_registroLayout.setVerticalGroup(
            fondo_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondo_registroLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(Logo_regitro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Registro_texto)
                .addGap(26, 26, 26)
                .addGroup(fondo_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nota_login_texto)
                    .addComponent(Boton_login))
                .addGap(31, 31, 31)
                .addGroup(fondo_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nickname_usuario_texto)
                    .addComponent(Fecha_nacimiento_usuario_texto))
                .addGap(18, 18, 18)
                .addGroup(fondo_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Registro_nickname, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Registro_fecha_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(fondo_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Primer_nombre_usuario_texto)
                    .addComponent(Segundo_nombre_usuario_texto))
                .addGap(18, 18, 18)
                .addGroup(fondo_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Registro_primer_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Registro_segundo_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(fondo_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Primer_apellido_usuario_texto)
                    .addComponent(Segundo_apellido_usuario_texto))
                .addGap(18, 18, 18)
                .addGroup(fondo_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Registro_segundo_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Registro_primer_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(fondo_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Correo_electronico_texto)
                    .addComponent(NIT_texto))
                .addGap(18, 18, 18)
                .addGroup(fondo_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Registro_correo_electronico, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Registro_NIT, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(fondo_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Confirmar_contraseña_texto)
                    .addComponent(Contraseña_texto))
                .addGap(18, 18, 18)
                .addGroup(fondo_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Registro_confirmar_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Registro_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Boton_registrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        getContentPane().add(fondo_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 1000, 1080));

        Imagen_registro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/fondo_registro.jpg"))); // NOI18N
        getContentPane().add(Imagen_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Boton_registrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_registrarseActionPerformed
        UsuariosRegister modSql = new UsuariosRegister();
        usuarios_register mod = new usuarios_register();
        UsuariosLogin modSql1 = new UsuariosLogin();
        usuarios_login mod1 = new usuarios_login();

        String pass = new String(Registro_contraseña.getPassword());
        String passCon = new String(Registro_confirmar_contraseña.getPassword());

        if (Registro_nickname.getText().equals("") || Registro_primer_nombre.getText().equals("") || Registro_segundo_nombre.getText().equals("") || Registro_primer_apellido.getText().equals("") || Registro_segundo_apellido.getText().equals("") || Registro_fecha_nacimiento.getText().equals("") || Registro_correo_electronico.getText().equals("") || pass.equals("") || Registro_NIT.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Hay campos vacios, debe llenar todos los campos");
        } else {

            if (pass.equals(passCon)) {

                if (modSql.existeUsuario(Registro_nickname.getText()) == 0) {

                    if (modSql1.esEmail(Registro_correo_electronico.getText())) {

                        String nuevoPass = pass;
                        mod1.setEmail(Registro_correo_electronico.getText());
                        mod1.setPassword(nuevoPass);
                        
                        mod.setUserName(Registro_nickname.getText());
                        mod.setFirstName(Registro_primer_nombre.getText());
                        mod.setSecondName(Registro_segundo_nombre.getText());
                        mod.setFirstSurname(Registro_primer_apellido.getText());
                        mod.setSecondLastName(Registro_segundo_apellido.getText());
                        mod.setDateOfBirth(Registro_fecha_nacimiento.getText());
                        mod.setNIT(Registro_NIT.getText());

                        

                        if (modSql.sonSoloNumeros(Registro_NIT.getText())) {

                            if (modSql1.registrar_login(mod1)) {
                                if(modSql.registrar(mod)){
                                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                                    Login ventanaLogin = new Login();
                                    ventanaLogin.setVisible(true);
                                    dispose();
                                }else{
                                   JOptionPane.showMessageDialog(null, "Error al guardar"); 
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Error al guardar");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El NIT solo debe tener numeros");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "El correo electronico no es valido");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario ya existe");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            }

        }
    }//GEN-LAST:event_Boton_registrarseActionPerformed

    private void Registro_nicknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Registro_nicknameActionPerformed

    }//GEN-LAST:event_Registro_nicknameActionPerformed

    private void Registro_fecha_nacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Registro_fecha_nacimientoActionPerformed

    }//GEN-LAST:event_Registro_fecha_nacimientoActionPerformed

    private void Registro_primer_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Registro_primer_nombreActionPerformed

    }//GEN-LAST:event_Registro_primer_nombreActionPerformed

    private void Registro_segundo_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Registro_segundo_nombreActionPerformed

    }//GEN-LAST:event_Registro_segundo_nombreActionPerformed

    private void Registro_primer_apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Registro_primer_apellidoActionPerformed

    }//GEN-LAST:event_Registro_primer_apellidoActionPerformed

    private void Registro_segundo_apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Registro_segundo_apellidoActionPerformed

    }//GEN-LAST:event_Registro_segundo_apellidoActionPerformed

    private void Boton_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_loginActionPerformed
        Login ventanaLogin = new Login();
        ventanaLogin.setVisible(true);
        dispose();
    }//GEN-LAST:event_Boton_loginActionPerformed

    private void Registro_contraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Registro_contraseñaActionPerformed

    }//GEN-LAST:event_Registro_contraseñaActionPerformed

    private void Registro_confirmar_contraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Registro_confirmar_contraseñaActionPerformed

    }//GEN-LAST:event_Registro_confirmar_contraseñaActionPerformed

    private void Registro_correo_electronicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Registro_correo_electronicoActionPerformed

    }//GEN-LAST:event_Registro_correo_electronicoActionPerformed

    private void Registro_NITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Registro_NITActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Registro_NITActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_login;
    private javax.swing.JButton Boton_registrarse;
    private javax.swing.JLabel Confirmar_contraseña_texto;
    private javax.swing.JLabel Contraseña_texto;
    private javax.swing.JLabel Correo_electronico_texto;
    private javax.swing.JLabel Fecha_nacimiento_usuario_texto;
    private javax.swing.JLabel Imagen_registro;
    private javax.swing.JLabel Logo_regitro;
    private javax.swing.JLabel NIT_texto;
    private javax.swing.JLabel Nickname_usuario_texto;
    private javax.swing.JLabel Nota_login_texto;
    private javax.swing.JLabel Primer_apellido_usuario_texto;
    private javax.swing.JLabel Primer_nombre_usuario_texto;
    private javax.swing.JTextField Registro_NIT;
    private javax.swing.JPasswordField Registro_confirmar_contraseña;
    private javax.swing.JPasswordField Registro_contraseña;
    private javax.swing.JTextField Registro_correo_electronico;
    private javax.swing.JTextField Registro_fecha_nacimiento;
    private javax.swing.JTextField Registro_nickname;
    private javax.swing.JTextField Registro_primer_apellido;
    private javax.swing.JTextField Registro_primer_nombre;
    private javax.swing.JTextField Registro_segundo_apellido;
    private javax.swing.JTextField Registro_segundo_nombre;
    private javax.swing.JLabel Registro_texto;
    private javax.swing.JLabel Segundo_apellido_usuario_texto;
    private javax.swing.JLabel Segundo_nombre_usuario_texto;
    private javax.swing.JPanel fondo_registro;
    // End of variables declaration//GEN-END:variables
}
