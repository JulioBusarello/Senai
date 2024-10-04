package Telas;

import dao.ClienteDaoImpl;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;

/**
 * @author julio_busarello
 */
public class FormCliente extends javax.swing.JInternalFrame {

    public static boolean editar = false;
    
    ClienteDaoImpl clienteDao = new ClienteDaoImpl();

    public FormCliente() {
        initComponents();
        loadCli();
        ativadoCli(false, false, false);
    }

    public void loadCli() {
        DefaultTableModel defaultCli = new DefaultTableModel(new Object[]{
            "Código",
            "Nome",
            "Telefone",
            "Email",
            "Endereço"
        }, 0);

        List<Cliente> clientes = clienteDao.getAllClientes();
        for (Cliente cliente : clientes) {
            Object linha[] = new Object[]{
                cliente.getCodigo(),
                cliente.getNome(),
                cliente.getTelefone(),
                cliente.getEmail(),
                cliente.getEndereco(),};
            defaultCli.addRow(linha);
        }
        jTbCli.setModel(defaultCli);
    }

    public void ativadoCli(boolean campos, boolean selecao, boolean manter) {
        if (manter == false) {
            jTfCodigoCli.setText("");
            jTfNomeCli.setText("");
            jTfTelefoneCli.setText("");
            jTfEmailCli.setText("");
            jTaEnderecoCli.setText("");
        }

        jTfCodigoCli.setEnabled(campos);
        jTfNomeCli.setEnabled(campos);
        jTfTelefoneCli.setEnabled(campos);
        jTfEmailCli.setEnabled(campos);
        jTaEnderecoCli.setEnabled(campos);

        jBtnEditarCli.setEnabled(selecao);
        jBtnExcluirCli.setEnabled(selecao);
        jBtnSalvarCli.setEnabled(false);
        jBtnCancelarCli.setEnabled(false);
        jBtnNovoCli.setEnabled(true);
        
        if(!selecao){
            jTbCli.clearSelection();
        }
        if(editar){
            jTfCodigoCli.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTfCodigoCli = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTfNomeCli = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTfTelefoneCli = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTfEmailCli = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTaEnderecoCli = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTbCli = new javax.swing.JTable();
        jBtnNovoCli = new javax.swing.JButton();
        jBtnEditarCli = new javax.swing.JButton();
        jBtnExcluirCli = new javax.swing.JButton();
        jBtnCancelarCli = new javax.swing.JButton();
        jBtnSalvarCli = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jTfCodigoCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfCodigoCliKeyReleased(evt);
            }
        });

        jLabel1.setText("Código:");

        jTfNomeCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfNomeCliKeyReleased(evt);
            }
        });

        jLabel6.setText("Nome:");

        jTfTelefoneCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfTelefoneCliKeyReleased(evt);
            }
        });

        jLabel7.setText("Telefone:");

        jTfEmailCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfEmailCliKeyReleased(evt);
            }
        });

        jLabel8.setText("Email:");

        jLabel9.setText("Endereço:");

        jTaEnderecoCli.setColumns(20);
        jTaEnderecoCli.setRows(5);
        jTaEnderecoCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTaEnderecoCliKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTaEnderecoCli);

        jTbCli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Telefone", "Email", "Endereço"
            }
        ));
        jTbCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTbCliMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTbCli);

        jBtnNovoCli.setText("Novo");
        jBtnNovoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoCliActionPerformed(evt);
            }
        });

        jBtnEditarCli.setText("Editar");
        jBtnEditarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarCliActionPerformed(evt);
            }
        });

        jBtnExcluirCli.setText("Excluir");
        jBtnExcluirCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirCliActionPerformed(evt);
            }
        });

        jBtnCancelarCli.setText("Cancelar");
        jBtnCancelarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarCliActionPerformed(evt);
            }
        });

        jBtnSalvarCli.setText("Salvar");
        jBtnSalvarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarCliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtnNovoCli)
                        .addGap(73, 73, 73)
                        .addComponent(jBtnEditarCli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addComponent(jBtnExcluirCli)
                        .addGap(91, 91, 91)
                        .addComponent(jBtnCancelarCli)
                        .addGap(95, 95, 95)
                        .addComponent(jBtnSalvarCli))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jTfEmailCli)
                            .addComponent(jTfTelefoneCli)
                            .addComponent(jTfNomeCli)
                            .addComponent(jTfCodigoCli)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTfCodigoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTfNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTfTelefoneCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTfEmailCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnNovoCli)
                    .addComponent(jBtnEditarCli)
                    .addComponent(jBtnExcluirCli)
                    .addComponent(jBtnCancelarCli)
                    .addComponent(jBtnSalvarCli))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSalvarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarCliActionPerformed
        int cod = Integer.parseInt(jTfCodigoCli.getText());
        String nome = jTfNomeCli.getText();
        String telefone = jTfTelefoneCli.getText();
        String email = jTfEmailCli.getText();
        String endereco = jTaEnderecoCli.getText();

        int a = JOptionPane.showConfirmDialog(null, "Deseja realmente salvar estas informações?\n\n"
                + "Código: " + cod
                + "\nNome: " + nome
                + "\nTelefone: " + telefone
                + "\nEmail: " + email
                + "\nEndereço: " + endereco,
                "confirmar", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_NO_OPTION) {
            Cliente cliente = new Cliente(cod, nome, telefone, email, endereco);
            if(editar){
                clienteDao.updateCliente(cliente);
                editar = false;
            }else{
                clienteDao.addCliente(cliente);
            }
            ativadoCli(false, false, false);
            loadCli();
        }
    }//GEN-LAST:event_jBtnSalvarCliActionPerformed

    private void jBtnNovoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoCliActionPerformed
        ativadoCli(true, false, false);

        jBtnCancelarCli.setEnabled(true);
        jBtnNovoCli.setEnabled(false);
    }//GEN-LAST:event_jBtnNovoCliActionPerformed

    private void jBtnEditarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarCliActionPerformed
        editar = true;
        ativadoCli(true, false, true); 
    }//GEN-LAST:event_jBtnEditarCliActionPerformed

    private void jBtnExcluirCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirCliActionPerformed
        int codigo = Integer.parseInt(jTfCodigoCli.getText());
        String nome = jTfNomeCli.getText();
        String telefone = jTfTelefoneCli.getText();
        String email = jTfEmailCli.getText();
        String endereco = jTaEnderecoCli.getText();

        int opt = JOptionPane.showConfirmDialog(null,
                "Você tem certeza que quer apagar este registro?\n\n"
                + "Código: " + codigo
                + "\nNome: " + nome
                + "\nTelefone: " + telefone
                + "\nEmail: " + email
                + "\nEndereço: " + endereco,
                "Confirmar",
                JOptionPane.YES_NO_OPTION);
        if (opt == JOptionPane.YES_NO_OPTION) {
            clienteDao.deleteCliente(Integer.parseInt(jTfCodigoCli.getText()));
            loadCli();
        }
        ativadoCli(false, false, false);
    }//GEN-LAST:event_jBtnExcluirCliActionPerformed

    private void jBtnCancelarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarCliActionPerformed
        ativadoCli(false, false, false);
    }//GEN-LAST:event_jBtnCancelarCliActionPerformed

    private void jTfCodigoCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfCodigoCliKeyReleased
        if (!jTfCodigoCli.getText().isEmpty() && !jTfNomeCli.getText().isEmpty() && !jTfTelefoneCli.getText().isEmpty() && !jTfEmailCli.getText().isEmpty() && !jTaEnderecoCli.getText().isEmpty()) {
            jBtnSalvarCli.setEnabled(true);
        } else {
            jBtnSalvarCli.setEnabled(false);
        }
    }//GEN-LAST:event_jTfCodigoCliKeyReleased

    private void jTfNomeCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfNomeCliKeyReleased
        if (!jTfCodigoCli.getText().isEmpty() && !jTfNomeCli.getText().isEmpty() && !jTfTelefoneCli.getText().isEmpty() && !jTfEmailCli.getText().isEmpty() && !jTaEnderecoCli.getText().isEmpty()) {
            jBtnSalvarCli.setEnabled(true);
        } else {
            jBtnSalvarCli.setEnabled(false);
        }
    }//GEN-LAST:event_jTfNomeCliKeyReleased

    private void jTfTelefoneCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfTelefoneCliKeyReleased
        if (!jTfCodigoCli.getText().isEmpty() && !jTfNomeCli.getText().isEmpty() && !jTfTelefoneCli.getText().isEmpty() && !jTfEmailCli.getText().isEmpty() && !jTaEnderecoCli.getText().isEmpty()) {
            jBtnSalvarCli.setEnabled(true);
        } else {
            jBtnSalvarCli.setEnabled(false);
        }
    }//GEN-LAST:event_jTfTelefoneCliKeyReleased

    private void jTfEmailCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfEmailCliKeyReleased
        if (!jTfCodigoCli.getText().isEmpty() && !jTfNomeCli.getText().isEmpty() && !jTfTelefoneCli.getText().isEmpty() && !jTfEmailCli.getText().isEmpty() && !jTaEnderecoCli.getText().isEmpty()) {
            jBtnSalvarCli.setEnabled(true);
        } else {
            jBtnSalvarCli.setEnabled(false);
        }
    }//GEN-LAST:event_jTfEmailCliKeyReleased

    private void jTaEnderecoCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTaEnderecoCliKeyReleased
        if (!jTfCodigoCli.getText().isEmpty() && !jTfNomeCli.getText().isEmpty() && !jTfTelefoneCli.getText().isEmpty() && !jTfEmailCli.getText().isEmpty() && !jTaEnderecoCli.getText().isEmpty()) {
            jBtnSalvarCli.setEnabled(true);
        } else {
            jBtnSalvarCli.setEnabled(false);
        }
    }//GEN-LAST:event_jTaEnderecoCliKeyReleased

    private void jTbCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbCliMouseClicked
        int linhaSelect = jTbCli.getSelectedRow();

        if (linhaSelect != -1) {
            jTfCodigoCli.setText(jTbCli.getValueAt(linhaSelect, 0).toString());
            jTfNomeCli.setText(jTbCli.getValueAt(linhaSelect, 1).toString());
            jTfTelefoneCli.setText(jTbCli.getValueAt(linhaSelect, 2).toString());
            jTfEmailCli.setText(jTbCli.getValueAt(linhaSelect, 3).toString());
            jTaEnderecoCli.setText(jTbCli.getValueAt(linhaSelect, 4).toString());

            ativadoCli(false, true, true);
        }
    }//GEN-LAST:event_jTbCliMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCancelarCli;
    private javax.swing.JButton jBtnEditarCli;
    private javax.swing.JButton jBtnExcluirCli;
    private javax.swing.JButton jBtnNovoCli;
    private javax.swing.JButton jBtnSalvarCli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTaEnderecoCli;
    private javax.swing.JTable jTbCli;
    private javax.swing.JTextField jTfCodigoCli;
    private javax.swing.JTextField jTfEmailCli;
    private javax.swing.JTextField jTfNomeCli;
    private javax.swing.JTextField jTfTelefoneCli;
    // End of variables declaration//GEN-END:variables
}
