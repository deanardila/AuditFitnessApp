/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AuditFitness.vista.cliente;

import AuditFitness.controlador.auth.SesionSingleton;
import AuditFitness.modelo.entidades.Cliente;
import AuditFitness.modelo.entidades.Progreso;
import AuditFitness.modelo.repository.ClienteRepositoryImpl;
import AuditFitness.modelo.repository.ProgresoRepositoryImpl;
import AuditFitness.modelo.repository.RutinaRepositoryImpl;
import AuditFitness.vista.auth.LoginClienteView;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

/**
 *
 * @author deana
 */
public class VerMiProgresoView extends javax.swing.JFrame {

    ClienteRepositoryImpl clienteRepositoryImpl = new ClienteRepositoryImpl();
    ProgresoRepositoryImpl progresoRepositoryImpl = new ProgresoRepositoryImpl();
    private Cliente clienteEncontrado;
    SesionSingleton sesionSingleton = SesionSingleton.getInstance();

    /**
     * Creates new form Inicio
     */
    public VerMiProgresoView() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timeSeriesURLGenerator1 = new org.jfree.chart.urls.TimeSeriesURLGenerator();
        ClienteMenuView = new swing.Panel_Round_JWC();
        panel_Round_JWC2 = new swing.Panel_Round_JWC();
        BtnVerMiProgreso = new btn_efecto01_jwc.btn_efecto_V1_JWC();
        BtnRegistrarAsistencia = new btn_efecto01_jwc.btn_efecto_V1_JWC();
        BtnVerMisRutinas = new btn_efecto01_jwc.btn_efecto_V1_JWC();
        jPanel1 = new javax.swing.JPanel();
        imagen_redondo_degradado_JWC1 = new img_redondo_degradado_jwc.imagen_redondo_degradado_JWC();
        BtnAtras = new swing.Btn_Round_JWC();
        jLabel1 = new javax.swing.JLabel();
        BtnSalirRedondo = new swing.Btn_Round_JWC();
        jLabel2 = new javax.swing.JLabel();
        panelChart = new javax.swing.JPanel();
        BtnActualizarRutina = new swing.Btn_Round_JWC();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ClienteMenuView");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ClienteMenuView.setBackground(new java.awt.Color(242, 240, 240));
        ClienteMenuView.setEsqInferiorDerecha(50);
        ClienteMenuView.setEsqInferiorIzquierda(50);
        ClienteMenuView.setEsqSuperiorDerecha(50);
        ClienteMenuView.setEsqSuperiorIzquierda(50);
        ClienteMenuView.setPreferredSize(new java.awt.Dimension(720, 620));

        panel_Round_JWC2.setBackground(new java.awt.Color(51, 51, 51));
        panel_Round_JWC2.setEsqInferiorIzquierda(50);
        panel_Round_JWC2.setEsqSuperiorIzquierda(50);
        panel_Round_JWC2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnVerMiProgreso.setForeground(new java.awt.Color(153, 153, 153));
        BtnVerMiProgreso.setText("Ver Mi Progreso");
        BtnVerMiProgreso.setBackground_Hover_1(new java.awt.Color(255, 102, 0));
        BtnVerMiProgreso.setBackground_Hover_2(new java.awt.Color(242, 240, 240));
        BtnVerMiProgreso.setBackground_No_Hover_1(new java.awt.Color(51, 51, 51));
        BtnVerMiProgreso.setBackground_No_Hover_2(new java.awt.Color(51, 51, 51));
        BtnVerMiProgreso.setBtn_abajo(BtnRegistrarAsistencia);
        BtnVerMiProgreso.setBtn_arriba(BtnVerMisRutinas);
        BtnVerMiProgreso.setBtn_arriba_abajo_esquina_ovalado(60);
        BtnVerMiProgreso.setColor_Hover_text(new java.awt.Color(0, 0, 0));
        BtnVerMiProgreso.setColor_NoHover_text(new java.awt.Color(153, 153, 153));
        BtnVerMiProgreso.setEsquina_inferior_izquierdo(40);
        BtnVerMiProgreso.setEsquina_superior_izquierdo(40);
        BtnVerMiProgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVerMiProgresoActionPerformed(evt);
            }
        });
        panel_Round_JWC2.add(BtnVerMiProgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, 50));

        BtnRegistrarAsistencia.setForeground(new java.awt.Color(153, 153, 153));
        BtnRegistrarAsistencia.setText("Registrar Asistencia");
        BtnRegistrarAsistencia.setBackground_Hover_1(new java.awt.Color(255, 102, 0));
        BtnRegistrarAsistencia.setBackground_Hover_2(new java.awt.Color(242, 240, 240));
        BtnRegistrarAsistencia.setBackground_No_Hover_1(new java.awt.Color(51, 51, 51));
        BtnRegistrarAsistencia.setBackground_No_Hover_2(new java.awt.Color(51, 51, 51));
        BtnRegistrarAsistencia.setBtn_arriba(BtnVerMiProgreso);
        BtnRegistrarAsistencia.setBtn_arriba_abajo_esquina_ovalado(60);
        BtnRegistrarAsistencia.setColor_Hover_text(new java.awt.Color(0, 0, 0));
        BtnRegistrarAsistencia.setColor_NoHover_text(new java.awt.Color(153, 153, 153));
        BtnRegistrarAsistencia.setEsquina_inferior_izquierdo(40);
        BtnRegistrarAsistencia.setEsquina_superior_izquierdo(40);
        BtnRegistrarAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarAsistenciaActionPerformed(evt);
            }
        });
        panel_Round_JWC2.add(BtnRegistrarAsistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, 50));

        BtnVerMisRutinas.setForeground(new java.awt.Color(153, 153, 153));
        BtnVerMisRutinas.setText("Ver Mis Rutinas");
        BtnVerMisRutinas.setBackground_Hover_1(new java.awt.Color(255, 102, 0));
        BtnVerMisRutinas.setBackground_Hover_2(new java.awt.Color(242, 240, 240));
        BtnVerMisRutinas.setBackground_No_Hover_1(new java.awt.Color(51, 51, 51));
        BtnVerMisRutinas.setBackground_No_Hover_2(new java.awt.Color(51, 51, 51));
        BtnVerMisRutinas.setBtn_abajo(BtnVerMiProgreso);
        BtnVerMisRutinas.setBtn_arriba_abajo_esquina_ovalado(60);
        BtnVerMisRutinas.setColor_Hover_text(new java.awt.Color(0, 0, 0));
        BtnVerMisRutinas.setColor_NoHover_text(new java.awt.Color(153, 153, 153));
        BtnVerMisRutinas.setEsquina_inferior_izquierdo(40);
        BtnVerMisRutinas.setEsquina_superior_izquierdo(40);
        BtnVerMisRutinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVerMisRutinasActionPerformed(evt);
            }
        });
        panel_Round_JWC2.add(BtnVerMisRutinas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, 50));

        jPanel1.setBackground(new java.awt.Color(242, 240, 240));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panel_Round_JWC2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 50, 150));

        imagen_redondo_degradado_JWC1.setBorderSize(2);
        imagen_redondo_degradado_JWC1.setColo1(new java.awt.Color(255, 102, 0));
        imagen_redondo_degradado_JWC1.setColo2(new java.awt.Color(255, 204, 102));
        imagen_redondo_degradado_JWC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images.png"))); // NOI18N
        panel_Round_JWC2.add(imagen_redondo_degradado_JWC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 110, 100));

        BtnAtras.setBackground(new java.awt.Color(204, 102, 0));
        BtnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salida.png"))); // NOI18N
        BtnAtras.setText("");
        BtnAtras.setArco_esquina(20);
        BtnAtras.setColor_H_text(new java.awt.Color(204, 102, 0));
        BtnAtras.setColor_Hover(new java.awt.Color(255, 255, 255));
        BtnAtras.setColor_Normal(new java.awt.Color(204, 102, 0));
        BtnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAtrasActionPerformed(evt);
            }
        });
        panel_Round_JWC2.add(BtnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 190, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Menú - Cliente");
        jLabel1.setToolTipText("");
        panel_Round_JWC2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 100, -1));

        BtnSalirRedondo.setBackground(new java.awt.Color(204, 102, 0));
        BtnSalirRedondo.setText("");
        BtnSalirRedondo.setArco_esquina(15);
        BtnSalirRedondo.setColor_H_text(new java.awt.Color(204, 102, 0));
        BtnSalirRedondo.setColor_Hover(new java.awt.Color(204, 102, 0));
        BtnSalirRedondo.setColor_Normal(new java.awt.Color(204, 102, 0));
        BtnSalirRedondo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirRedondoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Progreso: ");

        panelChart.setBackground(new java.awt.Color(242, 240, 240));

        javax.swing.GroupLayout panelChartLayout = new javax.swing.GroupLayout(panelChart);
        panelChart.setLayout(panelChartLayout);
        panelChartLayout.setHorizontalGroup(
            panelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );
        panelChartLayout.setVerticalGroup(
            panelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
        );

        BtnActualizarRutina.setBackground(new java.awt.Color(204, 102, 0));
        BtnActualizarRutina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/actualizar-flecha.png"))); // NOI18N
        BtnActualizarRutina.setText("");
        BtnActualizarRutina.setArco_esquina(20);
        BtnActualizarRutina.setColor_H_text(new java.awt.Color(204, 102, 0));
        BtnActualizarRutina.setColor_Hover(new java.awt.Color(255, 153, 51));
        BtnActualizarRutina.setColor_Normal(new java.awt.Color(204, 102, 0));
        BtnActualizarRutina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarRutinaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ClienteMenuViewLayout = new javax.swing.GroupLayout(ClienteMenuView);
        ClienteMenuView.setLayout(ClienteMenuViewLayout);
        ClienteMenuViewLayout.setHorizontalGroup(
            ClienteMenuViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClienteMenuViewLayout.createSequentialGroup()
                .addComponent(panel_Round_JWC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(ClienteMenuViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ClienteMenuViewLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 526, Short.MAX_VALUE)
                        .addComponent(BtnSalirRedondo, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(ClienteMenuViewLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(ClienteMenuViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ClienteMenuViewLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(309, 309, 309)
                                .addComponent(BtnActualizarRutina, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelChart, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        ClienteMenuViewLayout.setVerticalGroup(
            ClienteMenuViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Round_JWC2, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
            .addGroup(ClienteMenuViewLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(BtnSalirRedondo, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(ClienteMenuViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnActualizarRutina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(ClienteMenuView, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 620));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSalirRedondoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirRedondoActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BtnSalirRedondoActionPerformed

    private void BtnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAtrasActionPerformed
        LoginClienteView loginCliente = new LoginClienteView();
        loginCliente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnAtrasActionPerformed

    private void BtnVerMisRutinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVerMisRutinasActionPerformed
        abrirVerMisRutinasView();
    }//GEN-LAST:event_BtnVerMisRutinasActionPerformed

    private void BtnVerMiProgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVerMiProgresoActionPerformed
        abrirVerMiProgresoView();
    }//GEN-LAST:event_BtnVerMiProgresoActionPerformed

    private void BtnRegistrarAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarAsistenciaActionPerformed
        abrirRegistrarAsistenciaView();
    }//GEN-LAST:event_BtnRegistrarAsistenciaActionPerformed

    private void BtnActualizarRutinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizarRutinaActionPerformed
        String identificacionSession = sesionSingleton.getIdenficacionSes();

        try {
            this.clienteEncontrado = clienteRepositoryImpl.readClientes().stream().filter(c -> c.getUsername().equals(identificacionSession)).findFirst().orElse(null);
            List<Progreso> progresos = progresoRepositoryImpl.listar();

            List<Progreso> progresosFiltradoPorCliente = progresos.stream()
                    .filter(p -> p != null
                    && p.getClienteId() != null
                    && p.getClienteId().equals(clienteEncontrado.getIdentificacion())
                    && p.getFecha() != null
                    && p.getPeso() != 0)
                    .sorted(Comparator.comparing(Progreso::getFecha))
                    .toList();

            if (progresosFiltradoPorCliente.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay datos de progreso para mostrar", "Información", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            TimeSeries series = new TimeSeries("Peso Del Cliente");
            progresosFiltradoPorCliente.forEach(p -> {
                LocalDate fecha = p.getFecha();
                Day day = new Day(fecha.getDayOfMonth(), fecha.getMonthValue(), fecha.getYear());
                series.add(day, p.getPeso());
            });

            TimeSeriesCollection dataset = new TimeSeriesCollection();
            dataset.addSeries(series);

            JFreeChart chart = ChartFactory.createTimeSeriesChart(
                    "Evolución de Peso Corporal",
                    "Fecha",
                    "Peso (kg)",
                    dataset,
                    true,
                    true,
                    false);

            // Customize chart appearance
            XYPlot plot = chart.getXYPlot();
            plot.setBackgroundPaint(Color.WHITE);
            plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
            plot.setRangeGridlinePaint(Color.LIGHT_GRAY);

            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(400, 300));

            panelChart.removeAll();
            panelChart.setLayout(new BorderLayout());
            panelChart.add(chartPanel, BorderLayout.CENTER);
            panelChart.revalidate();
            panelChart.repaint();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al generar el gráfico: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnActualizarRutinaActionPerformed

    private void abrirRegistrarAsistenciaView() {
        RegistrarAsistenciaView registrarAsistencia = new RegistrarAsistenciaView();
        registrarAsistencia.setVisible(true);
        this.dispose();
    }

    private void abrirVerMiProgresoView() {
        VerMiProgresoView verMiProgreso = new VerMiProgresoView();
        verMiProgreso.setVisible(true);
        this.dispose();
    }

    private void abrirVerMisRutinasView() {
        VerMisRutinasView verMisRutinas = new VerMisRutinasView();
        verMisRutinas.setVisible(true);
        this.dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteMenuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Btn_Round_JWC BtnActualizarRutina;
    private swing.Btn_Round_JWC BtnAtras;
    private btn_efecto01_jwc.btn_efecto_V1_JWC BtnRegistrarAsistencia;
    private swing.Btn_Round_JWC BtnSalirRedondo;
    private btn_efecto01_jwc.btn_efecto_V1_JWC BtnVerMiProgreso;
    private btn_efecto01_jwc.btn_efecto_V1_JWC BtnVerMisRutinas;
    private swing.Panel_Round_JWC ClienteMenuView;
    private img_redondo_degradado_jwc.imagen_redondo_degradado_JWC imagen_redondo_degradado_JWC1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelChart;
    private swing.Panel_Round_JWC panel_Round_JWC2;
    private org.jfree.chart.urls.TimeSeriesURLGenerator timeSeriesURLGenerator1;
    // End of variables declaration//GEN-END:variables
}
