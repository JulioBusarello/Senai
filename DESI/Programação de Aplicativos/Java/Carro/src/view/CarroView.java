package view;

import dao.CarroDao;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Carro;

/**
 * @author julio_busarello
 */
public class CarroView extends javax.swing.JFrame {

    private static int ultimaLinha = -1;
    private static int vNumber = 0;

    public static boolean editar = false;
    public static boolean selecionado = false;
    public static boolean visualizar = false;

    CarroDao carroDao = new CarroDao();

    public CarroView() {
        initComponents();
        loadCar();
        visual(true, false, false);
    }

    public void loadCar() {
        DefaultTableModel defaultCar = new DefaultTableModel(new Object[]{
            "Código",
            "Descrição",
            "Potência",
            "Cor",}, 0);

        try {
            List<Carro> carros = carroDao.getAllCarros();
            for (Carro carro : carros) {
                Object linha[] = new Object[]{
                    carro.getCod_carro(),
                    carro.getDes_carro(),
                    carro.getPot_carro(),
                    carro.getCor_carro(),};
                defaultCar.addRow(linha);
            }
            jTbCarros.setModel(defaultCar);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nenhum dado para ser recuperado!");
        }

    }

    public void visual(boolean campos, boolean selecao, boolean manter) {
        if (manter == false) {
            jTfCodigo.setText("");
            jTaDescricao.setText("");
            jTfPotencia.setText("");
            jTfCor.setText("");
        }

        jTfCodigo.setEnabled(false);
        jTaDescricao.setEnabled(campos);
        jTfPotencia.setEnabled(campos);
        jTfCor.setEnabled(campos);

        jBtnAdd.setEnabled(false);
        jBtnEditar.setEnabled(selecao);
        jBtnExcluir.setEnabled(selecao);
        jBtnVisualizar.setEnabled(true);

        jBtnVisualizar.setText("Visualizar");
        jBtnAdd.setText("Adicionar");

        if (selecao == false) {
            jTbCarros.clearSelection();
            selecionado = false;
        } else {
            selecionado = true;
        }
        if (editar) {
            jTfCodigo.setEnabled(false);
            jBtnEditar.setEnabled(false);
            jBtnVisualizar.setEnabled(false);
        }

        vNumber = 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTfCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTfPotencia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTfCor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTaDescricao = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTbCarros = new javax.swing.JTable();
        jBtnAdd = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnVisualizar = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro Carro");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Código:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Descrição:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Potência:");

        jTfPotencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfPotenciaKeyReleased(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Cor:");

        jTfCor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfCorKeyReleased(evt);
            }
        });

        jTaDescricao.setColumns(20);
        jTaDescricao.setRows(5);
        jTaDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTaDescricaoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTaDescricao);

        jTbCarros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Potência", "Cor"
            }
        ));
        jTbCarros.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTbCarros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTbCarrosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTbCarros);

        jBtnAdd.setText("Adicionar");
        jBtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddActionPerformed(evt);
            }
        });

        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnEditar.setText("Editar");
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });

        jBtnVisualizar.setText("Visualizar");
        jBtnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVisualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnVisualizar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTfCor, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTfPotencia, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTfCodigo)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTfPotencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTfCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAdd)
                    .addComponent(jBtnExcluir)
                    .addComponent(jBtnEditar)
                    .addComponent(jBtnVisualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddActionPerformed
        int cod = 0;
        String desc = jTaDescricao.getText();
        int pot = Integer.parseInt(jTfPotencia.getText());
        String cor = jTfCor.getText();

        int a;

        a = JOptionPane.showConfirmDialog(null, "Deseja realmente salvar estas informações?\n\n"
                + "Descrição: " + desc
                + "\nPotência: " + pot
                + "\nCor: " + cor,
                "confirmar", JOptionPane.YES_NO_OPTION);

        if (a == JOptionPane.YES_NO_OPTION) {
            Carro carro = new Carro(desc, pot, cor);
            if (editar) {
                cod = Integer.parseInt(jTfCodigo.getText());
                carroDao.updateCarro(cod, cor);
                editar = false;
            } else {
                carroDao.addCarro(carro);
            }
            visual(false, false, false);
            loadCar();
        }
    }//GEN-LAST:event_jBtnAddActionPerformed

    private void jTaDescricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTaDescricaoKeyReleased
        if (!jTaDescricao.getText().isBlank() && !jTfPotencia.getText().isBlank() && !jTfCor.getText().isBlank()) {
            jBtnAdd.setEnabled(true);
        } else {
            jBtnAdd.setEnabled(false);
        }
    }//GEN-LAST:event_jTaDescricaoKeyReleased

    private void jTfPotenciaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfPotenciaKeyReleased
        if (!jTaDescricao.getText().isBlank() && !jTfPotencia.getText().isBlank() && !jTfCor.getText().isBlank()) {
            jBtnAdd.setEnabled(true);
        } else {
            jBtnAdd.setEnabled(false);
        }
    }//GEN-LAST:event_jTfPotenciaKeyReleased

    private void jTfCorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfCorKeyReleased
        if (!jTaDescricao.getText().isBlank() && !jTfPotencia.getText().isBlank() && !jTfCor.getText().isBlank()) {
            jBtnAdd.setEnabled(true);
        } else {
            jBtnAdd.setEnabled(false);
        }
    }//GEN-LAST:event_jTfCorKeyReleased

    private void jTbCarrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbCarrosMouseClicked
        int linhaSelect = jTbCarros.getSelectedRow();

        if (!(linhaSelect == ultimaLinha)) {
            editar = false;

            if (linhaSelect != -1) {
                jTfCodigo.setText(jTbCarros.getValueAt(linhaSelect, 0).toString());
                jTaDescricao.setText(jTbCarros.getValueAt(linhaSelect, 1).toString());
                jTfPotencia.setText(jTbCarros.getValueAt(linhaSelect, 2).toString());
                jTfCor.setText(jTbCarros.getValueAt(linhaSelect, 3).toString());

                visual(false, true, true);
            }
            ultimaLinha = linhaSelect;
        } else {
            visual(true, false, false);
            ultimaLinha = -1;
        }

    }//GEN-LAST:event_jTbCarrosMouseClicked

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        try {
            int opt = JOptionPane.showConfirmDialog(null, "Você realmente deseja deletar este Carro?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (opt == JOptionPane.YES_NO_OPTION) {
                carroDao.deleteCarro(Integer.parseInt(jTfCodigo.getText()));
                visual(false, false, false);
            } else {
                visual(true, false, false);
            }
            loadCar();
        } catch (SQLException ex) {
            Logger.getLogger(CarroView.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
        editar = true;
        selecionado = false;
        visual(false, false, true);
        jTfCor.setEnabled(true);

        jBtnVisualizar.setText("Cancelar");
        jBtnAdd.setText("Salvar");
        jBtnVisualizar.setEnabled(true);
    }//GEN-LAST:event_jBtnEditarActionPerformed

    private void jBtnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVisualizarActionPerformed
        if (jBtnVisualizar.getText().equals("Cancelar")) {
            editar = false;
            visual(true, false, false);
        } else {
            if (!visualizar) {
                visualizar = true;
                visual(false, false, false);
                jTfCodigo.setEnabled(true);
            } else {
                if (!jTfCodigo.getText().isBlank()) {
                    try {
                        Carro car = carroDao.getCarro(Integer.parseInt(jTfCodigo.getText()));

                        jTaDescricao.setText(car.getDes_carro());
                        jTfPotencia.setText(car.getPot_carro() + "");
                        jTfCor.setText(car.getCor_carro());
                        vNumber += 1;

                        if (vNumber == 2) {
                            jTfCodigo.setEnabled(false);
                            visual(true, false, false);
                            visualizar = false;
                            vNumber = 0;
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "O ID não foi encontrado!");
                    }
                } else {
                    jTfCodigo.setEnabled(false);
                    visual(true, false, false);
                    visualizar = false;
                }
            }
        }
    }//GEN-LAST:event_jBtnVisualizarActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CarroView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarroView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarroView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarroView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarroView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAdd;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnVisualizar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTaDescricao;
    private javax.swing.JTable jTbCarros;
    private javax.swing.JTextField jTfCodigo;
    private javax.swing.JTextField jTfCor;
    private javax.swing.JTextField jTfPotencia;
    // End of variables declaration//GEN-END:variables
}
