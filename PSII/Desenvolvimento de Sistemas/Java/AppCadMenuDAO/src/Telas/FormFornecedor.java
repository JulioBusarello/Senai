package Telas;

import dao.FornecedorDaoImpl;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Fornecedor;

/**
 * @author julio_busarello
 */
public class FormFornecedor extends javax.swing.JInternalFrame {

    public static boolean editar = false;
    
    FornecedorDaoImpl fornecedorDao = new FornecedorDaoImpl();

    public FormFornecedor() {
        initComponents();
        loadFor();
        ativadoFor(false, false, false);
    }
    
    public void loadFor() {
        DefaultTableModel defaultFor = new DefaultTableModel(new Object[]{
            "Código",
            "Contato",
            "Telefone",
            "Email",
            "Empresa"
        }, 0);

        List<Fornecedor> fornecedores = fornecedorDao.getAllFornecedores();
        for (Fornecedor fornecedor : fornecedores) {
            Object linha[] = new Object[]{
                fornecedor.getCodigo(),
                fornecedor.getContato(),
                fornecedor.getTelefone(),
                fornecedor.getEmail(),
                fornecedor.getEmpresa(),};
            defaultFor.addRow(linha);
        }
        jTbFor.setModel(defaultFor);
    }

    public void ativadoFor(boolean campos, boolean selecao, boolean manter) {
        if (manter == false) {
            jTfCodigoFor.setText("");
            jTfContatoFor.setText("");
            jTfTelefoneFor.setText("");
            jTfEmailFor.setText("");
            jTaEmpresaFor.setText("");
        }

        jTfCodigoFor.setEnabled(campos);
        jTfContatoFor.setEnabled(campos);
        jTfTelefoneFor.setEnabled(campos);
        jTfEmailFor.setEnabled(campos);
        jTaEmpresaFor.setEnabled(campos);

        jBtnEditarFor.setEnabled(selecao);
        jBtnExcluirFor.setEnabled(selecao);
        jBtnSalvarFor.setEnabled(false);
        jBtnCancelarFor.setEnabled(selecao);
        jBtnNovoFor.setEnabled(true);
        
        if(!selecao){
            jTbFor.clearSelection();
        }
        if(editar){
            jTfCodigoFor.setEnabled(false);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTfCodigoFor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTfContatoFor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTfTelefoneFor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTfEmailFor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTaEmpresaFor = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTbFor = new javax.swing.JTable();
        jBtnNovoFor = new javax.swing.JButton();
        jBtnEditarFor = new javax.swing.JButton();
        jBtnExcluirFor = new javax.swing.JButton();
        jBtnCancelarFor = new javax.swing.JButton();
        jBtnSalvarFor = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jTfCodigoFor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfCodigoForKeyReleased(evt);
            }
        });

        jLabel1.setText("Código:");

        jTfContatoFor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfContatoForKeyReleased(evt);
            }
        });

        jLabel6.setText("Contato:");

        jTfTelefoneFor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfTelefoneForKeyReleased(evt);
            }
        });

        jLabel7.setText("Telefone:");

        jTfEmailFor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfEmailForKeyReleased(evt);
            }
        });

        jLabel8.setText("Email:");

        jLabel9.setText("Empresa:");

        jTaEmpresaFor.setColumns(20);
        jTaEmpresaFor.setRows(5);
        jTaEmpresaFor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTaEmpresaForKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTaEmpresaFor);

        jTbFor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Contato", "Telefone", "Email", "Empresa"
            }
        ));
        jTbFor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTbForMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTbFor);

        jBtnNovoFor.setText("Novo");
        jBtnNovoFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoForActionPerformed(evt);
            }
        });

        jBtnEditarFor.setText("Editar");
        jBtnEditarFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarForActionPerformed(evt);
            }
        });

        jBtnExcluirFor.setText("Excluir");
        jBtnExcluirFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirForActionPerformed(evt);
            }
        });

        jBtnCancelarFor.setText("Cancelar");
        jBtnCancelarFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarForActionPerformed(evt);
            }
        });

        jBtnSalvarFor.setText("Salvar");
        jBtnSalvarFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarForActionPerformed(evt);
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
                        .addComponent(jBtnNovoFor)
                        .addGap(73, 73, 73)
                        .addComponent(jBtnEditarFor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addComponent(jBtnExcluirFor)
                        .addGap(91, 91, 91)
                        .addComponent(jBtnCancelarFor)
                        .addGap(95, 95, 95)
                        .addComponent(jBtnSalvarFor))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jTfEmailFor)
                            .addComponent(jTfTelefoneFor)
                            .addComponent(jTfContatoFor)
                            .addComponent(jTfCodigoFor)
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
                        .addComponent(jTfCodigoFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTfContatoFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTfTelefoneFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTfEmailFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnNovoFor)
                    .addComponent(jBtnEditarFor)
                    .addComponent(jBtnExcluirFor)
                    .addComponent(jBtnCancelarFor)
                    .addComponent(jBtnSalvarFor))
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

    private void jBtnSalvarForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarForActionPerformed
        int cod = Integer.parseInt(jTfCodigoFor.getText());
        String contato = jTfContatoFor.getText();
        String telefone = jTfTelefoneFor.getText();
        String email = jTfEmailFor.getText();
        String empresa = jTaEmpresaFor.getText();

        int a = JOptionPane.showConfirmDialog(null, "Deseja realmente salvar estas informações?\n\n"
                + "Código: " + cod
                + "\nContato: " + contato
                + "\nTelefone: " + telefone
                + "\nEmail: " + email
                + "\nEmpresa: " + empresa,
                "confirmar", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_NO_OPTION) {
            Fornecedor fornecedor = new Fornecedor(cod, contato, telefone, email, empresa);
            if(editar){
                fornecedorDao.updateFornecedor(fornecedor);
                editar = false;
            }else{
                fornecedorDao.addFornecedor(fornecedor);
            }
            ativadoFor(false, false, false);
            loadFor();
        }
    }//GEN-LAST:event_jBtnSalvarForActionPerformed

    private void jBtnNovoForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoForActionPerformed
        ativadoFor(true, false, false);

        jBtnCancelarFor.setEnabled(true);
        jBtnNovoFor.setEnabled(false);
    }//GEN-LAST:event_jBtnNovoForActionPerformed

    private void jBtnEditarForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarForActionPerformed
        editar = true;
        ativadoFor(true, false, true); 
    }//GEN-LAST:event_jBtnEditarForActionPerformed

    private void jBtnExcluirForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirForActionPerformed
        int cod = Integer.parseInt(jTfCodigoFor.getText());
        String contato = jTfContatoFor.getText();
        String telefone = jTfTelefoneFor.getText();
        String email = jTfEmailFor.getText();
        String empresa = jTaEmpresaFor.getText();

        int opt = JOptionPane.showConfirmDialog(null,
                "Você tem certeza que quer apagar este registro?\n\n"
                + "Código: " + cod
                + "\nContato: " + contato
                + "\nTelefone: " + telefone
                + "\nEmail: " + email
                + "\nEmpresa: " + empresa,
                "confirmar", JOptionPane.YES_NO_OPTION);
        if (opt == JOptionPane.YES_NO_OPTION) {
            fornecedorDao.deleteFornecedor(Integer.parseInt(jTfCodigoFor.getText()));
            loadFor();
        }
        ativadoFor(false, false, false);
    }//GEN-LAST:event_jBtnExcluirForActionPerformed

    private void jBtnCancelarForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarForActionPerformed
        ativadoFor(false, false, false);
    }//GEN-LAST:event_jBtnCancelarForActionPerformed

    private void jTfCodigoForKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfCodigoForKeyReleased
        if (!jTfCodigoFor.getText().isEmpty() && !jTfContatoFor.getText().isEmpty() && !jTfTelefoneFor.getText().isEmpty() && !jTfEmailFor.getText().isEmpty() && !jTaEmpresaFor.getText().isEmpty()) {
            jBtnSalvarFor.setEnabled(true);
        } else {
            jBtnSalvarFor.setEnabled(false);
        }
    }//GEN-LAST:event_jTfCodigoForKeyReleased

    private void jTfContatoForKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfContatoForKeyReleased
        if (!jTfCodigoFor.getText().isEmpty() && !jTfContatoFor.getText().isEmpty() && !jTfTelefoneFor.getText().isEmpty() && !jTfEmailFor.getText().isEmpty() && !jTaEmpresaFor.getText().isEmpty()) {
            jBtnSalvarFor.setEnabled(true);
        } else {
            jBtnSalvarFor.setEnabled(false);
        }
    }//GEN-LAST:event_jTfContatoForKeyReleased

    private void jTfTelefoneForKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfTelefoneForKeyReleased
        if (!jTfCodigoFor.getText().isEmpty() && !jTfContatoFor.getText().isEmpty() && !jTfTelefoneFor.getText().isEmpty() && !jTfEmailFor.getText().isEmpty() && !jTaEmpresaFor.getText().isEmpty()) {
            jBtnSalvarFor.setEnabled(true);
        } else {
            jBtnSalvarFor.setEnabled(false);
        }
    }//GEN-LAST:event_jTfTelefoneForKeyReleased

    private void jTfEmailForKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfEmailForKeyReleased
        if (!jTfCodigoFor.getText().isEmpty() && !jTfContatoFor.getText().isEmpty() && !jTfTelefoneFor.getText().isEmpty() && !jTfEmailFor.getText().isEmpty() && !jTaEmpresaFor.getText().isEmpty()) {
            jBtnSalvarFor.setEnabled(true);
        } else {
            jBtnSalvarFor.setEnabled(false);
        }
    }//GEN-LAST:event_jTfEmailForKeyReleased

    private void jTaEmpresaForKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTaEmpresaForKeyReleased
        if (!jTfCodigoFor.getText().isEmpty() && !jTfContatoFor.getText().isEmpty() && !jTfTelefoneFor.getText().isEmpty() && !jTfEmailFor.getText().isEmpty() && !jTaEmpresaFor.getText().isEmpty()) {
            jBtnSalvarFor.setEnabled(true);
        } else {
            jBtnSalvarFor.setEnabled(false);
        }
    }//GEN-LAST:event_jTaEmpresaForKeyReleased

    private void jTbForMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbForMouseClicked
        int linhaSelect = jTbFor.getSelectedRow();

        if (linhaSelect != -1) {
            jTfCodigoFor.setText(jTbFor.getValueAt(linhaSelect, 0).toString());
            jTfContatoFor.setText(jTbFor.getValueAt(linhaSelect, 1).toString());
            jTfTelefoneFor.setText(jTbFor.getValueAt(linhaSelect, 2).toString());
            jTfEmailFor.setText(jTbFor.getValueAt(linhaSelect, 3).toString());
            jTaEmpresaFor.setText(jTbFor.getValueAt(linhaSelect, 4).toString());

            ativadoFor(false, true, true);
        }
    }//GEN-LAST:event_jTbForMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCancelarFor;
    private javax.swing.JButton jBtnEditarFor;
    private javax.swing.JButton jBtnExcluirFor;
    private javax.swing.JButton jBtnNovoFor;
    private javax.swing.JButton jBtnSalvarFor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTaEmpresaFor;
    private javax.swing.JTable jTbFor;
    private javax.swing.JTextField jTfCodigoFor;
    private javax.swing.JTextField jTfContatoFor;
    private javax.swing.JTextField jTfEmailFor;
    private javax.swing.JTextField jTfTelefoneFor;
    // End of variables declaration//GEN-END:variables
}
