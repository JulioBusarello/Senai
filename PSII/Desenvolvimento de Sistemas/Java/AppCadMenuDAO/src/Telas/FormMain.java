package Telas;

/**
 * @author julio_busarello
 */
public class FormMain extends javax.swing.JFrame {

    public FormMain() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdskPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiCadastroCliente = new javax.swing.JMenuItem();
        jmiCadastroFornecedor = new javax.swing.JMenuItem();
        jmiCadastroProduto = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SCCPF - Sistema de Cadastro Cliente Produto Fornecedor");
        setResizable(false);

        jdskPane.setToolTipText("");

        javax.swing.GroupLayout jdskPaneLayout = new javax.swing.GroupLayout(jdskPane);
        jdskPane.setLayout(jdskPaneLayout);
        jdskPaneLayout.setHorizontalGroup(
            jdskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1024, Short.MAX_VALUE)
        );
        jdskPaneLayout.setVerticalGroup(
            jdskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );

        jMenu1.setText("Cadastro");

        jmiCadastroCliente.setText("Cliente");
        jmiCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadastroClienteActionPerformed(evt);
            }
        });
        jMenu1.add(jmiCadastroCliente);

        jmiCadastroFornecedor.setText("Fornecedor");
        jmiCadastroFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadastroFornecedorActionPerformed(evt);
            }
        });
        jMenu1.add(jmiCadastroFornecedor);

        jmiCadastroProduto.setText("Produto");
        jmiCadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadastroProdutoActionPerformed(evt);
            }
        });
        jMenu1.add(jmiCadastroProduto);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Relatório");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Impressão");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdskPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdskPane)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmiCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadastroClienteActionPerformed
        FormCliente telaCliente = new FormCliente();
        jdskPane.add(telaCliente);
        telaCliente.setVisible(true);
    }//GEN-LAST:event_jmiCadastroClienteActionPerformed

    private void jmiCadastroFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadastroFornecedorActionPerformed
        FormFornecedor telaFornecedor = new FormFornecedor();
        jdskPane.add(telaFornecedor);
        telaFornecedor.setVisible(true);
    }//GEN-LAST:event_jmiCadastroFornecedorActionPerformed

    private void jmiCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadastroProdutoActionPerformed
        FormProduto telaProduto = new FormProduto();
        jdskPane.add(telaProduto);
        telaProduto.setVisible(true);
    }//GEN-LAST:event_jmiCadastroProdutoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JDesktopPane jdskPane;
    private javax.swing.JMenuItem jmiCadastroCliente;
    private javax.swing.JMenuItem jmiCadastroFornecedor;
    private javax.swing.JMenuItem jmiCadastroProduto;
    // End of variables declaration//GEN-END:variables
}
