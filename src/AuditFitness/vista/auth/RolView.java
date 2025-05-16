/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AuditFitness.vista.auth;

import java.awt.Color;


/**
 *
 * @author deana
 */
public class RolView extends javax.swing.JFrame {
    public RolView() {
        initComponents(); setBackground(new Color(0,0,0,0));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Round_JWC1 = new swing.Panel_Round_JWC();
        RolView = new swing.Panel_Round_JWC();
        btn_Round_JWC2 = new swing.Btn_Round_JWC();
        jLabel1 = new javax.swing.JLabel();
        btn_Rol_Entrenador = new swing.Btn_Round_JWC();
        btn_Rol_Cliente = new swing.Btn_Round_JWC();
        btn_Rol_Admin = new swing.Btn_Round_JWC();
        img_Autosize_JWC1 = new swing.Img_Autosize_JWC();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_Round_JWC1.setBackground(new java.awt.Color(0, 0, 0));
        panel_Round_JWC1.setEsqInferiorDerecha(50);
        panel_Round_JWC1.setEsqInferiorIzquierda(50);
        panel_Round_JWC1.setEsqSuperiorDerecha(50);
        panel_Round_JWC1.setEsqSuperiorIzquierda(50);

        RolView.setBackground(new java.awt.Color(255, 255, 255));
        RolView.setEsqInferiorDerecha(50);
        RolView.setEsqSuperiorDerecha(50);
        RolView.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Round_JWC2.setBackground(new java.awt.Color(204, 102, 0));
        btn_Round_JWC2.setText("");
        btn_Round_JWC2.setArco_esquina(15);
        btn_Round_JWC2.setColor_H_text(new java.awt.Color(204, 102, 0));
        btn_Round_JWC2.setColor_Hover(new java.awt.Color(204, 102, 0));
        btn_Round_JWC2.setColor_Normal(new java.awt.Color(204, 102, 0));
        btn_Round_JWC2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Round_JWC2ActionPerformed(evt);
            }
        });
        RolView.add(btn_Round_JWC2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 15, 15));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("¿Quien eres?");
        RolView.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 150, 40));

        btn_Rol_Entrenador.setBackground(new java.awt.Color(204, 102, 0));
        btn_Rol_Entrenador.setText("Entrenador");
        btn_Rol_Entrenador.setArco_esquina(20);
        btn_Rol_Entrenador.setColor_H_text(new java.awt.Color(204, 102, 0));
        btn_Rol_Entrenador.setColor_Normal(new java.awt.Color(204, 102, 0));
        btn_Rol_Entrenador.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btn_Rol_Entrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Rol_EntrenadorActionPerformed(evt);
            }
        });
        RolView.add(btn_Rol_Entrenador, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, 40));

        btn_Rol_Cliente.setBackground(new java.awt.Color(204, 102, 0));
        btn_Rol_Cliente.setText("Cliente");
        btn_Rol_Cliente.setArco_esquina(20);
        btn_Rol_Cliente.setColor_H_text(new java.awt.Color(204, 102, 0));
        btn_Rol_Cliente.setColor_Normal(new java.awt.Color(204, 102, 0));
        btn_Rol_Cliente.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btn_Rol_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Rol_ClienteActionPerformed(evt);
            }
        });
        RolView.add(btn_Rol_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, 40));

        btn_Rol_Admin.setBackground(new java.awt.Color(204, 102, 0));
        btn_Rol_Admin.setText("Administrador");
        btn_Rol_Admin.setArco_esquina(20);
        btn_Rol_Admin.setColor_H_text(new java.awt.Color(204, 102, 0));
        btn_Rol_Admin.setColor_Normal(new java.awt.Color(204, 102, 0));
        btn_Rol_Admin.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btn_Rol_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Rol_AdminActionPerformed(evt);
            }
        });
        RolView.add(btn_Rol_Admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, 40));

        img_Autosize_JWC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LOGO.png"))); // NOI18N

        javax.swing.GroupLayout panel_Round_JWC1Layout = new javax.swing.GroupLayout(panel_Round_JWC1);
        panel_Round_JWC1.setLayout(panel_Round_JWC1Layout);
        panel_Round_JWC1Layout.setHorizontalGroup(
            panel_Round_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_Round_JWC1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(img_Autosize_JWC1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RolView, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_Round_JWC1Layout.setVerticalGroup(
            panel_Round_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RolView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_Round_JWC1Layout.createSequentialGroup()
                .addContainerGap(145, Short.MAX_VALUE)
                .addComponent(img_Autosize_JWC1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
        );

        getContentPane().add(panel_Round_JWC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_Round_JWC2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Round_JWC2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_Round_JWC2ActionPerformed

    private void btn_Rol_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Rol_AdminActionPerformed
        abrirLoginAdmin();
    }//GEN-LAST:event_btn_Rol_AdminActionPerformed

    private void btn_Rol_EntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Rol_EntrenadorActionPerformed
        abrirLoginEntrenador();
    }//GEN-LAST:event_btn_Rol_EntrenadorActionPerformed

    private void btn_Rol_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Rol_ClienteActionPerformed
        abrirLoginCliente();
    }//GEN-LAST:event_btn_Rol_ClienteActionPerformed

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RolView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Panel_Round_JWC RolView;
    private swing.Btn_Round_JWC btn_Rol_Admin;
    private swing.Btn_Round_JWC btn_Rol_Cliente;
    private swing.Btn_Round_JWC btn_Rol_Entrenador;
    private swing.Btn_Round_JWC btn_Round_JWC2;
    private swing.Img_Autosize_JWC img_Autosize_JWC1;
    private javax.swing.JLabel jLabel1;
    private swing.Panel_Round_JWC panel_Round_JWC1;
    // End of variables declaration//GEN-END:variables

    
    private void abrirLoginAdmin() {
        LoginAdminView loginAdmin  = new LoginAdminView();
        loginAdmin.setVisible(true);
        this.dispose();
    }

    private void abrirLoginEntrenador() {
        LoginEntrenadorView loginEntrenador = new LoginEntrenadorView();
        loginEntrenador.setVisible(true);
        this.dispose();
    }
    
    private void abrirLoginCliente() {
        LoginClienteView loginCliente = new LoginClienteView();
        loginCliente.setVisible(true);
        this.dispose();
    }
}
