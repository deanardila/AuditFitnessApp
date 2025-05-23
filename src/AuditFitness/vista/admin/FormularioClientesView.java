/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package AuditFitness.vista.admin;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author deana
 */
public class FormularioClientesView extends javax.swing.JDialog {
    /**
     * Creates new form FormularioClientes
     */
    public FormularioClientesView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents(); 
    }

    void agregarListenerRegistrar(ActionListener actionListener) {
       BtnRegistrarCl.addActionListener(actionListener);
    }
    
    public String getUsername() {
        return jTextField9.getText().trim();
    }
    
     public String getNombre() {
        return jTextField7.getText().trim();
    }

    public String getIdentificacion() {
        return jTextField8.getText().trim(); // jTextField8 es el campo de identificación
    }
    public String getContraseña() {
        return jTextField5.getText().trim(); // jTextField5 es el campo de contraseña
    }
    public String getConfirmarContraseña() {
        return jTextField4.getText().trim(); // jTextField4 es el campo de confirmar contraseña
    }
    // Método para limpiar los campos del formulario
    // Método para mostrar mensajes
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RegistrarClienteView = new swing.Panel_Round_JWC();
        panel_Round_JWC3 = new swing.Panel_Round_JWC();
        BtnSalirRedondo1 = new swing.Btn_Round_JWC();
        jLabel2 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        BtnCancelarCl = new swing.Btn_Round_JWC();
        BtnRegistrarCl = new swing.Btn_Round_JWC();
        jLabel10 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        RegistrarClienteView.setBackground(new java.awt.Color(242, 240, 240));
        RegistrarClienteView.setEsqInferiorDerecha(50);
        RegistrarClienteView.setEsqInferiorIzquierda(50);
        RegistrarClienteView.setEsqSuperiorDerecha(50);
        RegistrarClienteView.setEsqSuperiorIzquierda(50);

        panel_Round_JWC3.setBackground(new java.awt.Color(0, 0, 0));
        panel_Round_JWC3.setEsqInferiorDerecha(50);
        panel_Round_JWC3.setEsqInferiorIzquierda(50);
        panel_Round_JWC3.setEsqSuperiorDerecha(50);
        panel_Round_JWC3.setEsqSuperiorIzquierda(50);
        panel_Round_JWC3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnSalirRedondo1.setBackground(new java.awt.Color(204, 102, 0));
        BtnSalirRedondo1.setText("");
        BtnSalirRedondo1.setArco_esquina(15);
        BtnSalirRedondo1.setColor_H_text(new java.awt.Color(204, 102, 0));
        BtnSalirRedondo1.setColor_Hover(new java.awt.Color(204, 102, 0));
        BtnSalirRedondo1.setColor_Normal(new java.awt.Color(204, 102, 0));
        BtnSalirRedondo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirRedondo1ActionPerformed(evt);
            }
        });
        panel_Round_JWC3.add(BtnSalirRedondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 15, 15));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 102, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Registrar Cliente");
        panel_Round_JWC3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 70));

        jTextField4.setBackground(new java.awt.Color(255, 255, 255));
        jTextField4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Confirmar contraseña");

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Contraseña:");

        jTextField5.setBackground(new java.awt.Color(255, 255, 255));
        jTextField5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(0, 0, 0));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Nombre y Apellidos:");

        jTextField7.setBackground(new java.awt.Color(255, 255, 255));
        jTextField7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(0, 0, 0));

        BtnCancelarCl.setBackground(new java.awt.Color(204, 102, 0));
        BtnCancelarCl.setText("Cancelar");
        BtnCancelarCl.setArco_esquina(20);
        BtnCancelarCl.setColor_H_text(new java.awt.Color(204, 102, 0));
        BtnCancelarCl.setColor_Normal(new java.awt.Color(204, 102, 0));
        BtnCancelarCl.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        BtnCancelarCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarClActionPerformed(evt);
            }
        });

        BtnRegistrarCl.setBackground(new java.awt.Color(204, 102, 0));
        BtnRegistrarCl.setText("Registrar");
        BtnRegistrarCl.setArco_esquina(20);
        BtnRegistrarCl.setColor_H_text(new java.awt.Color(204, 102, 0));
        BtnRegistrarCl.setColor_Normal(new java.awt.Color(204, 102, 0));
        BtnRegistrarCl.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        BtnRegistrarCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarClActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Identificación:");

        jTextField8.setBackground(new java.awt.Color(255, 255, 255));
        jTextField8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(0, 0, 0));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Usuario: ");

        jTextField9.setBackground(new java.awt.Color(255, 255, 255));
        jTextField9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout RegistrarClienteViewLayout = new javax.swing.GroupLayout(RegistrarClienteView);
        RegistrarClienteView.setLayout(RegistrarClienteViewLayout);
        RegistrarClienteViewLayout.setHorizontalGroup(
            RegistrarClienteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Round_JWC3, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
            .addGroup(RegistrarClienteViewLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(RegistrarClienteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegistrarClienteViewLayout.createSequentialGroup()
                        .addComponent(BtnRegistrarCl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(BtnCancelarCl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegistrarClienteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(RegistrarClienteViewLayout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField4))
                        .addGroup(RegistrarClienteViewLayout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(99, 99, 99)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(RegistrarClienteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(RegistrarClienteViewLayout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, RegistrarClienteViewLayout.createSequentialGroup()
                            .addGroup(RegistrarClienteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10))
                            .addGap(27, 27, 27)
                            .addGroup(RegistrarClienteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        RegistrarClienteViewLayout.setVerticalGroup(
            RegistrarClienteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrarClienteViewLayout.createSequentialGroup()
                .addComponent(panel_Round_JWC3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RegistrarClienteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9))
                .addGap(4, 4, 4)
                .addGroup(RegistrarClienteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegistrarClienteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegistrarClienteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegistrarClienteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4))
                .addGap(31, 31, 31)
                .addGroup(RegistrarClienteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnRegistrarCl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCancelarCl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(RegistrarClienteView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(RegistrarClienteView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSalirRedondo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirRedondo1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BtnSalirRedondo1ActionPerformed

    private void BtnCancelarClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarClActionPerformed
        this.dispose();
    }//GEN-LAST:event_BtnCancelarClActionPerformed

    private void BtnRegistrarClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarClActionPerformed
       // Obtener los datos del formulario
        String username = this.getUsername();
        String nombre = this.getNombre();
        String identificacion = this.getIdentificacion();
        String contraseña = this.getContraseña();
        String confirmarContraseña = this.getConfirmarContraseña();
        // Validar los datos
        if (username.isEmpty() || contraseña.isEmpty() || nombre.isEmpty() || identificacion.isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!contraseña.equals(confirmarContraseña)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Guardar los datos en el archivo CSV
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/clientes.csv", true))) { 
        writer.newLine(); // Agregar nueva línea
        writer.write(username +","  + contraseña + "," + nombre + "," +identificacion);
       
        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(this, "Cliente registrado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        // Limpiar campos después de registrar
        limpiarCampos();
    } catch (IOException e) {
        // Manejo de excepciones
        JOptionPane.showMessageDialog(this, "Error al guardar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_BtnRegistrarClActionPerformed
    
    // Método para limpiar los campos del formulario
    public void limpiarCampos() {
    jTextField9.setText("");
    jTextField7.setText("");
    jTextField8.setText("");
    jTextField5.setText("");
    jTextField4.setText("");
}

    
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
            java.util.logging.Logger.getLogger(FormularioClientesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioClientesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioClientesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioClientesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormularioClientesView dialog = new FormularioClientesView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Btn_Round_JWC BtnCancelarCl;
    private swing.Btn_Round_JWC BtnRegistrarCl;
    private swing.Btn_Round_JWC BtnSalirRedondo1;
    private swing.Panel_Round_JWC RegistrarClienteView;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private swing.Panel_Round_JWC panel_Round_JWC3;
    // End of variables declaration//GEN-END:variables

    
}
