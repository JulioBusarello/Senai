package Telas;

import dao.ProdutoDaoImpl;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Produto;

/**
 * @author julio_busarello
 */
public class FormProduto extends javax.swing.JInternalFrame {
    
    public static boolean editar = false;
    
    ProdutoDaoImpl produtoDao = new ProdutoDaoImpl();
    
    public void loadPro() {
        DefaultTableModel defaultPro = new DefaultTableModel(new Object[]{
            "Código",
            "Preço",
            "Unidade",
            "Quantidade",
            "Descrição"
        }, 0);

        List<Produto> produtos = produtoDao.getAllProdutos();
        for (Produto produto : produtos) {
            Object linha[] = new Object[]{
                produto.getCodigo(),
                produto.getPreco(),
                produto.getUnidade(),
                produto.getQtd(),
                produto.getDescricao(),};
            defaultPro.addRow(linha);
        }
        jTbPro.setModel(defaultPro);
    }

    public void ativadoPro(boolean campos, boolean selecao, boolean manter) {
        if (manter == false) {
            jTfCodigoPro.setText("");
            jTfPrecoPro.setText("");
            jTfUnidadePro.setText("");
            jTfQuantidadePro.setText("");
            jTaDescricaoPro.setText("");
        }

        jTfCodigoPro.setEnabled(campos);
        jTfPrecoPro.setEnabled(campos);
        jTfUnidadePro.setEnabled(campos);
        jTfQuantidadePro.setEnabled(campos);
        jTaDescricaoPro.setEnabled(campos);

        jBtnEditarPro.setEnabled(selecao);
        jBtnExcluirPro.setEnabled(selecao);
        jBtnSalvarPro.setEnabled(false);
        jBtnCancelarPro.setEnabled(selecao);
        jBtnNovoPro.setEnabled(true);
        
        if(!selecao){
            jTbPro.clearSelection();
        }
        if(editar){
            jTfCodigoPro.setEnabled(false);
            jBtnCancelarPro.setEnabled(true);
        }
    }
    
    public FormProduto() {
        initComponents();
        loadPro();
        ativadoPro(false, false, false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTfCodigoPro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTfPrecoPro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTfUnidadePro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTfQuantidadePro = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTaDescricaoPro = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTbPro = new javax.swing.JTable();
        jBtnNovoPro = new javax.swing.JButton();
        jBtnEditarPro = new javax.swing.JButton();
        jBtnExcluirPro = new javax.swing.JButton();
        jBtnCancelarPro = new javax.swing.JButton();
        jBtnSalvarPro = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jTfCodigoPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfCodigoProKeyReleased(evt);
            }
        });

        jLabel1.setText("Código:");

        jTfPrecoPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfPrecoProKeyReleased(evt);
            }
        });

        jLabel6.setText("Preço:");

        jTfUnidadePro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfUnidadeProKeyReleased(evt);
            }
        });

        jLabel7.setText("Unidade:");

        jTfQuantidadePro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfQuantidadeProKeyReleased(evt);
            }
        });

        jLabel8.setText("Quantidade:");

        jLabel9.setText("Descrição:");

        jTaDescricaoPro.setColumns(20);
        jTaDescricaoPro.setRows(5);
        jTaDescricaoPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTaDescricaoProKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTaDescricaoPro);

        jTbPro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Preço", "Unidade", "Quantidade", "Descrição"
            }
        ));
        jTbPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTbProMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTbPro);

        jBtnNovoPro.setText("Novo");
        jBtnNovoPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoProActionPerformed(evt);
            }
        });

        jBtnEditarPro.setText("Editar");
        jBtnEditarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarProActionPerformed(evt);
            }
        });

        jBtnExcluirPro.setText("Excluir");
        jBtnExcluirPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirProActionPerformed(evt);
            }
        });

        jBtnCancelarPro.setText("Cancelar");
        jBtnCancelarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarProActionPerformed(evt);
            }
        });

        jBtnSalvarPro.setText("Salvar");
        jBtnSalvarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarProActionPerformed(evt);
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
                        .addComponent(jBtnNovoPro)
                        .addGap(73, 73, 73)
                        .addComponent(jBtnEditarPro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addComponent(jBtnExcluirPro)
                        .addGap(91, 91, 91)
                        .addComponent(jBtnCancelarPro)
                        .addGap(95, 95, 95)
                        .addComponent(jBtnSalvarPro))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jTfQuantidadePro)
                            .addComponent(jTfUnidadePro)
                            .addComponent(jTfPrecoPro)
                            .addComponent(jTfCodigoPro)
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
                        .addComponent(jTfCodigoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTfPrecoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTfUnidadePro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTfQuantidadePro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnNovoPro)
                    .addComponent(jBtnEditarPro)
                    .addComponent(jBtnExcluirPro)
                    .addComponent(jBtnCancelarPro)
                    .addComponent(jBtnSalvarPro))
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

    private void jBtnNovoProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoProActionPerformed
        ativadoPro(true, false, false);

        jBtnCancelarPro.setEnabled(true);
        jBtnNovoPro.setEnabled(false);
    }//GEN-LAST:event_jBtnNovoProActionPerformed

    private void jBtnSalvarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarProActionPerformed
        int cod = Integer.parseInt(jTfCodigoPro.getText());
        double preco = Double.parseDouble(jTfPrecoPro.getText());
        String unidade = jTfUnidadePro.getText();
        int quantidade = Integer.parseInt(jTfQuantidadePro.getText());
        String descricao = jTaDescricaoPro.getText();

        int a = JOptionPane.showConfirmDialog(null, "Deseja realmente salvar estas informações?\n\n"
                + "Código: " + cod
                + "\nPreço: R$" + preco
                + "\nUnidade: " + unidade
                + "\nQuantidade: " + quantidade
                + "\nDescrição: " + descricao,
                "confirmar", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_NO_OPTION) {
            Produto produto = new Produto(cod, preco, unidade, quantidade, descricao);
            if(editar){
                produtoDao.updateProduto(produto);
                editar = false;
            }else{
                produtoDao.addProduto(produto);
            }
            ativadoPro(false, false, false);
            loadPro();
        }
    }//GEN-LAST:event_jBtnSalvarProActionPerformed

    private void jBtnEditarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarProActionPerformed
        editar = true;
        ativadoPro(true, false, true); 
    }//GEN-LAST:event_jBtnEditarProActionPerformed

    private void jBtnExcluirProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirProActionPerformed
        int cod = Integer.parseInt(jTfCodigoPro.getText());
        double preco = Double.parseDouble(jTfPrecoPro.getText());
        String unidade = jTfUnidadePro.getText();
        int quantidade = Integer.parseInt(jTfQuantidadePro.getText());
        String descricao = jTaDescricaoPro.getText();

        int opt = JOptionPane.showConfirmDialog(null,
                "Você tem certeza que quer apagar este registro?\n\n"
                + "Código: " + cod
                + "\nPreço: R$" + preco
                + "\nUnidade: " + unidade
                + "\nQuantidade: " + quantidade
                + "\nDescrição: " + descricao,
                "confirmar", JOptionPane.YES_NO_OPTION);
        if (opt == JOptionPane.YES_NO_OPTION) {
            produtoDao.deleteProduto(Integer.parseInt(jTfCodigoPro.getText()));
            loadPro();
        }
        ativadoPro(false, false, false);
    }//GEN-LAST:event_jBtnExcluirProActionPerformed

    private void jBtnCancelarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarProActionPerformed
        editar = false;
        ativadoPro(false, false, false);
    }//GEN-LAST:event_jBtnCancelarProActionPerformed

    private void jTfCodigoProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfCodigoProKeyReleased
        if (!jTfCodigoPro.getText().isEmpty() && !jTfUnidadePro.getText().isEmpty() && !jTfQuantidadePro.getText().isEmpty() && !jTfPrecoPro.getText().isEmpty() && !jTaDescricaoPro.getText().isEmpty()) {
            jBtnSalvarPro.setEnabled(true);
        } else {
            jBtnSalvarPro.setEnabled(false);
        }
    }//GEN-LAST:event_jTfCodigoProKeyReleased

    private void jTfPrecoProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfPrecoProKeyReleased
        if (!jTfCodigoPro.getText().isEmpty() && !jTfUnidadePro.getText().isEmpty() && !jTfQuantidadePro.getText().isEmpty() && !jTfPrecoPro.getText().isEmpty() && !jTaDescricaoPro.getText().isEmpty()) {
            jBtnSalvarPro.setEnabled(true);
        } else {
            jBtnSalvarPro.setEnabled(false);
        }
    }//GEN-LAST:event_jTfPrecoProKeyReleased

    private void jTfUnidadeProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfUnidadeProKeyReleased
        if (!jTfCodigoPro.getText().isEmpty() && !jTfUnidadePro.getText().isEmpty() && !jTfQuantidadePro.getText().isEmpty() && !jTfPrecoPro.getText().isEmpty() && !jTaDescricaoPro.getText().isEmpty()) {
            jBtnSalvarPro.setEnabled(true);
        } else {
            jBtnSalvarPro.setEnabled(false);
        }
    }//GEN-LAST:event_jTfUnidadeProKeyReleased

    private void jTfQuantidadeProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfQuantidadeProKeyReleased
        if (!jTfCodigoPro.getText().isEmpty() && !jTfUnidadePro.getText().isEmpty() && !jTfQuantidadePro.getText().isEmpty() && !jTfPrecoPro.getText().isEmpty() && !jTaDescricaoPro.getText().isEmpty()) {
            jBtnSalvarPro.setEnabled(true);
        } else {
            jBtnSalvarPro.setEnabled(false);
        }
    }//GEN-LAST:event_jTfQuantidadeProKeyReleased

    private void jTaDescricaoProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTaDescricaoProKeyReleased
        if (!jTfCodigoPro.getText().isEmpty() && !jTfUnidadePro.getText().isEmpty() && !jTfQuantidadePro.getText().isEmpty() && !jTfPrecoPro.getText().isEmpty() && !jTaDescricaoPro.getText().isEmpty()) {
            jBtnSalvarPro.setEnabled(true);
        } else {
            jBtnSalvarPro.setEnabled(false);
        }
    }//GEN-LAST:event_jTaDescricaoProKeyReleased

    private void jTbProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbProMouseClicked
        int linhaSelect = jTbPro.getSelectedRow();

        if (linhaSelect != -1) {
            jTfCodigoPro.setText(jTbPro.getValueAt(linhaSelect, 0).toString());
            jTfPrecoPro.setText(jTbPro.getValueAt(linhaSelect, 1).toString());
            jTfUnidadePro.setText(jTbPro.getValueAt(linhaSelect, 2).toString());
            jTfQuantidadePro.setText(jTbPro.getValueAt(linhaSelect, 3).toString());
            jTaDescricaoPro.setText(jTbPro.getValueAt(linhaSelect, 4).toString());

            ativadoPro(false, true, true);
        }
    }//GEN-LAST:event_jTbProMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCancelarPro;
    private javax.swing.JButton jBtnEditarPro;
    private javax.swing.JButton jBtnExcluirPro;
    private javax.swing.JButton jBtnNovoPro;
    private javax.swing.JButton jBtnSalvarPro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTaDescricaoPro;
    private javax.swing.JTable jTbPro;
    private javax.swing.JTextField jTfCodigoPro;
    private javax.swing.JTextField jTfPrecoPro;
    private javax.swing.JTextField jTfQuantidadePro;
    private javax.swing.JTextField jTfUnidadePro;
    // End of variables declaration//GEN-END:variables
}
