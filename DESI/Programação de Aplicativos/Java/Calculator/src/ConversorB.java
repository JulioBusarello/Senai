
import javax.swing.JOptionPane;

/**
 * @author julio_busarello
 */
public class ConversorB extends javax.swing.JFrame {

    // Construtor da Classe
    public ConversorB() {
        initComponents(); // Inicia os Componentes

        // Adiciona os radio buttons aos seus grupos
        bgOrigem.add(jrBtnBinario1);
        bgOrigem.add(jrBtnDecimal1);
        bgOrigem.add(jrBtnHexa1);
        bgOrigem.add(jrBtnOctal1);

        bgDestino.add(jrBtnBinario2);
        bgDestino.add(jrBtnDecimal2);
        bgDestino.add(jrBtnHexa2);
        bgDestino.add(jrBtnOctal2);

        // Definindo os padrão de iniciaização
        jtaOrigem.setText("0");
        jrBtnDecimal1.setSelected(true);
        jrBtnDecimal2.setSelected(true);

        // Adicionando ActionListener a cada botão
        jrBtnBinario1.addActionListener(e -> verificarAtulizacao());
        jrBtnDecimal1.addActionListener(e -> verificarAtulizacao());
        jrBtnHexa1.addActionListener(e -> verificarAtulizacao());
        jrBtnOctal1.addActionListener(e -> verificarAtulizacao());

        jrBtnBinario2.addActionListener(e -> verificarAtulizacao());
        jrBtnDecimal2.addActionListener(e -> verificarAtulizacao());
        jrBtnHexa2.addActionListener(e -> verificarAtulizacao());
        jrBtnOctal2.addActionListener(e -> verificarAtulizacao());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgOrigem = new javax.swing.ButtonGroup();
        bgDestino = new javax.swing.ButtonGroup();
        jbtnVoltar = new javax.swing.JButton();
        jrBtnDecimal1 = new javax.swing.JRadioButton();
        jrBtnBinario1 = new javax.swing.JRadioButton();
        jrBtnOctal1 = new javax.swing.JRadioButton();
        jrBtnHexa1 = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaOrigem = new javax.swing.JTextArea();
        jrBtnDecimal2 = new javax.swing.JRadioButton();
        jrBtnBinario2 = new javax.swing.JRadioButton();
        jrBtnOctal2 = new javax.swing.JRadioButton();
        jrBtnHexa2 = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtaDestino = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conversor");
        setResizable(false);

        jbtnVoltar.setText("Voltar");
        jbtnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVoltarActionPerformed(evt);
            }
        });

        jrBtnDecimal1.setText("Decimal");

        jrBtnBinario1.setText("Binario");

        jrBtnOctal1.setText("Octal");

        jrBtnHexa1.setText("Hexa");

        jtaOrigem.setColumns(20);
        jtaOrigem.setRows(5);
        jtaOrigem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtaOrigemKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jtaOrigem);

        jrBtnDecimal2.setText("Decimal");

        jrBtnBinario2.setText("Binario");

        jrBtnOctal2.setText("Octal");

        jrBtnHexa2.setText("Hexa");

        jtaDestino.setEditable(false);
        jtaDestino.setColumns(20);
        jtaDestino.setRows(5);
        jtaDestino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtaDestinoKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jtaDestino);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jbtnVoltar)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jrBtnDecimal1)
                                .addGap(18, 18, 18)
                                .addComponent(jrBtnBinario1)
                                .addGap(18, 18, 18)
                                .addComponent(jrBtnOctal1)
                                .addGap(18, 18, 18)
                                .addComponent(jrBtnHexa1))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jrBtnDecimal2)
                            .addGap(18, 18, 18)
                            .addComponent(jrBtnBinario2)
                            .addGap(18, 18, 18)
                            .addComponent(jrBtnOctal2)
                            .addGap(18, 18, 18)
                            .addComponent(jrBtnHexa2))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnVoltar)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrBtnDecimal1)
                    .addComponent(jrBtnBinario1)
                    .addComponent(jrBtnOctal1)
                    .addComponent(jrBtnHexa1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrBtnDecimal2)
                    .addComponent(jrBtnBinario2)
                    .addComponent(jrBtnOctal2)
                    .addComponent(jrBtnHexa2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVoltarActionPerformed
        // Configurando botão de voltar para calculadora
        dispose(); // Fecha a janela
        TelaPrincipal tela = new TelaPrincipal(); // Instancia a tela
        tela.setVisible(true); // Define a tela como visivel
    }//GEN-LAST:event_jbtnVoltarActionPerformed

    private void jtaOrigemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtaOrigemKeyReleased
        verificarAtulizacao(); // Chama o método
    }//GEN-LAST:event_jtaOrigemKeyReleased

    private void jtaDestinoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtaDestinoKeyReleased

    }//GEN-LAST:event_jtaDestinoKeyReleased

    public void verificarAtulizacao() {
        // Define as variáveis
        String valorConvertido = "";
        String valorEntrada = jtaOrigem.getText();
        int valorVerify;

        // Verifica qual botao está selecionado
        if (jrBtnBinario1.isSelected()) {
            try { // Verificando se o valor de entrada é Binário
                valorVerify = Integer.parseInt(valorEntrada, 2);
            } catch (NumberFormatException e) { // Caso não seja
                erroVerify(); // Método mensagem padrão
                return;
            }
        } else if (jrBtnHexa1.isSelected()) {
            try { // Verificando se o valor de entrada é Hexadecimal
                valorVerify = Integer.parseInt(valorEntrada, 16);
            } catch (NumberFormatException e) { // Caso não seja
                erroVerify(); // Método mensagem padrão
                return;
            }
        } else if (jrBtnOctal1.isSelected()) {
            try { // Verificando se o valor de entrada é Octal
                valorVerify = Integer.parseInt(valorEntrada, 8);
            } catch (NumberFormatException e) { // Caso não seja
                erroVerify(); // Método mensagem padrão
                return;
            }
        } else {
            try { // Verificando se o valor de entrada é Decimal
                valorVerify = Integer.parseInt(valorEntrada);
            } catch (NumberFormatException e) { // Caso não seja
                erroVerify(); // Método mensagem padrão
                return;
            }
        }

        // Verificando qual botao é selecionado
        if (jrBtnBinario2.isSelected()) {
            valorConvertido = Integer.toBinaryString(valorVerify); // Converte o valor para Binário
        } else if (jrBtnHexa2.isSelected()) {
            valorConvertido = Integer.toHexString(valorVerify); // Converte o valor para Hexadecimal
        } else if (jrBtnOctal2.isSelected()) {
            valorConvertido = Integer.toOctalString(valorVerify); // Converte o valor para Octal
        } else if (jrBtnDecimal2.isSelected()) {
            valorConvertido = Double.toString(valorVerify); // Converte o valor para Decimal
        }
        jtaDestino.setText(valorConvertido); // Define o valor convertido na caixa de texto de destino
    }

    // Função padrão de erro
    public void erroVerify() {
        JOptionPane.showMessageDialog(null, "Valor inserido inválido!"); // Avisa o usuário
        jtaOrigem.setText("0"); // Reseta a caixa de entrada
    }

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ConversorB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConversorB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConversorB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConversorB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConversorB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgDestino;
    private javax.swing.ButtonGroup bgOrigem;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbtnVoltar;
    private javax.swing.JRadioButton jrBtnBinario1;
    private javax.swing.JRadioButton jrBtnBinario2;
    private javax.swing.JRadioButton jrBtnDecimal1;
    private javax.swing.JRadioButton jrBtnDecimal2;
    private javax.swing.JRadioButton jrBtnHexa1;
    private javax.swing.JRadioButton jrBtnHexa2;
    private javax.swing.JRadioButton jrBtnOctal1;
    private javax.swing.JRadioButton jrBtnOctal2;
    private javax.swing.JTextArea jtaDestino;
    private javax.swing.JTextArea jtaOrigem;
    // End of variables declaration//GEN-END:variables
}
