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

    public static int ultimaLinha = -1;
    public static int vNumber = 0;

    public static boolean editar = false;
    public static boolean selecionado = false;
    public static boolean visualizar = false;

    CarroDao carroDao = new CarroDao();

    // Construtor
    public CarroView() {
        initComponents();
        loadCar(); // Carrega tabela
        visual(true, false, false); // Muda o modo visual
    }

    // Função para trazer todos os dados para a tabela
    public void loadCar() {
        // Design padrão da tabela
        DefaultTableModel defaultCar = new DefaultTableModel(new Object[]{
            "Código",
            "Descrição",
            "Potência",
            "Cor",}, 0);

        // Verifica se existem dados para serem recuperados
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

    // Função para alterar a forma visual dos campos e botões
    public void visual(boolean campos, boolean selecao, boolean manter) {
        // Limpa os campos
        if (manter == false) {
            jTfCodigo.setText("");
            jTaDescricao.setText("");
            jTfPotencia.setText("");
            jTfCor.setText("");
        }

        jTfCodigo.setEnabled(false);
        jBtnAdd.setEnabled(false);
        jBtnVisualizar.setEnabled(true);

        // Se os campos devem ser utilizaveis
        jTaDescricao.setEnabled(campos);
        jTfPotencia.setEnabled(campos);
        jTfCor.setEnabled(campos);

        // Se algo está selecionado
        jBtnEditar.setEnabled(selecao);
        jBtnExcluir.setEnabled(selecao);

        jBtnVisualizar.setText("Visualizar");
        jBtnAdd.setText("Adicionar");

        if (selecao == false) {
            jTbCarros.clearSelection();
            selecionado = false;
        } else {
            selecionado = true;
        }
        // Em caso esteja editando algo
        if (editar) {
            jTfCodigo.setEnabled(false);
            jBtnEditar.setEnabled(false);
            jBtnVisualizar.setEnabled(false);
        }

        // Reseta o número de verificação do visualizar
        vNumber = 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLaTitulo = new javax.swing.JLabel();
        jLaCodigo = new javax.swing.JLabel();
        jTfCodigo = new javax.swing.JTextField();
        jLaDescricao = new javax.swing.JLabel();
        jSPDescricao = new javax.swing.JScrollPane();
        jTaDescricao = new javax.swing.JTextArea();
        jLaPotencia = new javax.swing.JLabel();
        jTfPotencia = new javax.swing.JTextField();
        jLaCor = new javax.swing.JLabel();
        jTfCor = new javax.swing.JTextField();
        jSPTabela = new javax.swing.JScrollPane();
        jTbCarros = new javax.swing.JTable();
        jBtnAdd = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnVisualizar = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Carros");

        jLaTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLaTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLaTitulo.setText("Cadastro Carro");

        jLaCodigo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLaCodigo.setText("Código:");

        jLaDescricao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLaDescricao.setText("Descrição:");

        jTaDescricao.setColumns(20);
        jTaDescricao.setRows(5);
        jTaDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTaDescricaoKeyReleased(evt);
            }
        });
        jSPDescricao.setViewportView(jTaDescricao);

        jLaPotencia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLaPotencia.setText("Potência:");

        jTfPotencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfPotenciaKeyReleased(evt);
            }
        });

        jLaCor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLaCor.setText("Cor:");

        jTfCor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfCorKeyReleased(evt);
            }
        });

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
        jSPTabela.setViewportView(jTbCarros);

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
            .addComponent(jLaTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSPTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
                            .addComponent(jLaCor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTfCor, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLaPotencia, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTfPotencia, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLaDescricao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLaCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTfCodigo)
                                .addComponent(jSPDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLaTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLaCodigo)
                    .addComponent(jTfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLaDescricao)
                    .addComponent(jSPDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLaPotencia)
                    .addComponent(jTfPotencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLaCor)
                    .addComponent(jTfCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAdd)
                    .addComponent(jBtnExcluir)
                    .addComponent(jBtnEditar)
                    .addComponent(jBtnVisualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jSPTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Função Botão Adicionar
    private void jBtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddActionPerformed
        int cod = 0;
        String desc = jTaDescricao.getText();
        int pot = Integer.parseInt(jTfPotencia.getText());
        String cor = jTfCor.getText();

        int a;

        // Mensagem confirmando o salvamento e os dados
        a = JOptionPane.showConfirmDialog(null, "Deseja realmente salvar estas informações?\n\n"
                + "Descrição: " + desc
                + "\nPotência: " + pot
                + "\nCor: " + cor,
                "confirmar", JOptionPane.YES_NO_OPTION);

        // Se concordar verifica se é edição ou não
        if (a == JOptionPane.YES_NO_OPTION) {
            Carro carro = new Carro(desc, pot, cor);
            if (editar) {
                cod = Integer.parseInt(jTfCodigo.getText());
                carroDao.updateCarro(cod, cor);
                editar = false;
            } else {
                carroDao.addCarro(carro);
            }
            // Muda o modo de visualização e carrega a tabela
            visual(false, false, false);
            loadCar();
        }
    }//GEN-LAST:event_jBtnAddActionPerformed

    // Verificação se após digitar em um campo todos foram preenchidos
    private void jTaDescricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTaDescricaoKeyReleased
        if (!jTaDescricao.getText().isBlank() && !jTfPotencia.getText().isBlank() && !jTfCor.getText().isBlank()) {
            jBtnAdd.setEnabled(true);
        } else {
            jBtnAdd.setEnabled(false);
        }
    }//GEN-LAST:event_jTaDescricaoKeyReleased

    // Verificação se após digitar em um campo todos foram preenchidos
    private void jTfPotenciaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfPotenciaKeyReleased
        if (!jTaDescricao.getText().isBlank() && !jTfPotencia.getText().isBlank() && !jTfCor.getText().isBlank()) {
            jBtnAdd.setEnabled(true);
        } else {
            jBtnAdd.setEnabled(false);
        }
    }//GEN-LAST:event_jTfPotenciaKeyReleased

    // Verificação se após digitar em um campo todos foram preenchidos
    private void jTfCorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfCorKeyReleased
        if (!jTaDescricao.getText().isBlank() && !jTfPotencia.getText().isBlank() && !jTfCor.getText().isBlank()) {
            jBtnAdd.setEnabled(true);
        } else {
            jBtnAdd.setEnabled(false);
        }
    }//GEN-LAST:event_jTfCorKeyReleased

    // Função clique na tabela
    private void jTbCarrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbCarrosMouseClicked
        int linhaSelect = jTbCarros.getSelectedRow();

        // Verificando se a mesma linha foi selecionada
        if (!(linhaSelect == ultimaLinha)) {
            editar = false;

            // Verificando se a linha existe
            if (linhaSelect != -1) {
                jTfCodigo.setText(jTbCarros.getValueAt(linhaSelect, 0).toString());
                jTaDescricao.setText(jTbCarros.getValueAt(linhaSelect, 1).toString());
                jTfPotencia.setText(jTbCarros.getValueAt(linhaSelect, 2).toString());
                jTfCor.setText(jTbCarros.getValueAt(linhaSelect, 3).toString());

                // Altera o modo visual
                visual(false, true, true);
            }

            // Armazena qual foi a ultima linha selecionada
            ultimaLinha = linhaSelect;
        } else {
            // Altera o modo visual e reseta a ultima linha
            visual(true, false, false);
            ultimaLinha = -1;
        }

    }//GEN-LAST:event_jTbCarrosMouseClicked

    // Função Botão Excluir
    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        try {
            int opt = JOptionPane.showConfirmDialog(null, "Você realmente deseja deletar este Carro?", "Confirmar", JOptionPane.YES_NO_OPTION);

            // Confirmando a escolha
            if (opt == JOptionPane.YES_NO_OPTION) {
                // Deleta o carro e muda o modo visual
                carroDao.deleteCarro(Integer.parseInt(jTfCodigo.getText()));
                visual(false, false, false);
            } else {
                // Muda o modo visual
                visual(true, false, false);
            }
            // Carrega a tabela
            loadCar();
        } catch (SQLException ex) {
            Logger.getLogger(CarroView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jBtnExcluirActionPerformed

    // Função Botão Editar
    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
        // Ativa o modo de edição, ativa o campo para edição e muda o modo visual
        editar = true;
        visual(false, false, true);
        jTfCor.setEnabled(true);

        // Altera os textos para verificação
        jBtnVisualizar.setText("Cancelar");
        jBtnAdd.setText("Salvar");
        jBtnVisualizar.setEnabled(true);
    }//GEN-LAST:event_jBtnEditarActionPerformed

    // Função Botão Cancelar/Visualizar
    private void jBtnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVisualizarActionPerformed
        // Verificando qual ação será realizada
        if (jBtnVisualizar.getText().equals("Cancelar")) {
            // Desativa a edição e altera o modo visual
            editar = false;
            visual(true, false, false);
        } else {
            // Verifica se a visualização ja foi ativada, caso não, ativa ela
            if (!visualizar) {
                visualizar = true;
                visual(false, false, false);
                jTfCodigo.setEnabled(true);
            } else {
                // Verificando se o campo está vazio
                if (!jTfCodigo.getText().isBlank()) {
                    try {
                        // Seleciona o carro através do ID, removendo espaços
                        Carro car = carroDao.getCarro(Integer.parseInt(jTfCodigo.getText().replace(" ", "")));

                        // Retorna as informações do carro
                        jTaDescricao.setText(car.getDes_carro());
                        jTfPotencia.setText(car.getPot_carro() + "");
                        jTfCor.setText(car.getCor_carro());

                        vNumber += 1; // Adiciona +1 para a verificação de cliques

                        // Verificando se o botão visualizar ja foi clicado duas vezes, se já, desativa o campo
                        if (vNumber == 2) {
                            jTfCodigo.setEnabled(false);
                            visual(true, false, false);
                            visualizar = false;
                            vNumber = 0;
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "O ID não foi encontrado!");
                    }
                    // Caso esteja vazio desativa a visualização
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
    private javax.swing.JLabel jLaCodigo;
    private javax.swing.JLabel jLaCor;
    private javax.swing.JLabel jLaDescricao;
    private javax.swing.JLabel jLaPotencia;
    private javax.swing.JLabel jLaTitulo;
    private javax.swing.JScrollPane jSPDescricao;
    private javax.swing.JScrollPane jSPTabela;
    private javax.swing.JTextArea jTaDescricao;
    private javax.swing.JTable jTbCarros;
    private javax.swing.JTextField jTfCodigo;
    private javax.swing.JTextField jTfCor;
    private javax.swing.JTextField jTfPotencia;
    // End of variables declaration//GEN-END:variables
}
