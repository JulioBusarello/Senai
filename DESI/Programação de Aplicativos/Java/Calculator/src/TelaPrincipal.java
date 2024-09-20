
import javax.swing.JOptionPane;

/**
 * @author julio_busarello
 */
public class TelaPrincipal extends javax.swing.JFrame {

    // Define as variáveis
    String memoria;
    double numero1, numero2;
    char operador;

    // Construtor da classe
    public TelaPrincipal() {
        initComponents(); // Inicia os componentes
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfVisor = new javax.swing.JTextField();
        jBtnBackspace = new javax.swing.JButton();
        jBtnClear = new javax.swing.JButton();
        jBtnAddMem = new javax.swing.JButton();
        jBtnMult = new javax.swing.JButton();
        jBtnPorc = new javax.swing.JButton();
        jBtnDiv = new javax.swing.JButton();
        jBtnMais = new javax.swing.JButton();
        jBtnPonto = new javax.swing.JButton();
        jBtnSub = new javax.swing.JButton();
        jBtnIgual = new javax.swing.JButton();
        jBtnMemoria = new javax.swing.JButton();
        jBtnNove = new javax.swing.JButton();
        jBtnOito = new javax.swing.JButton();
        jBtnSete = new javax.swing.JButton();
        jBtnSeis = new javax.swing.JButton();
        jBtnCinco = new javax.swing.JButton();
        jBtnQuatro = new javax.swing.JButton();
        jBtnTres = new javax.swing.JButton();
        jBtnDois = new javax.swing.JButton();
        jBtnUm = new javax.swing.JButton();
        jBtnZero = new javax.swing.JButton();
        jmbPrincipal = new javax.swing.JMenuBar();
        jmiConversorVelocidade = new javax.swing.JMenu();
        jmiConversorBase = new javax.swing.JMenuItem();
        jmiSair = new javax.swing.JMenu();
        jmiSairSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculadora");
        setResizable(false);

        jtfVisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfVisorActionPerformed(evt);
            }
        });

        jBtnBackspace.setText("<");
        jBtnBackspace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBackspaceActionPerformed(evt);
            }
        });

        jBtnClear.setText("CE");
        jBtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClearActionPerformed(evt);
            }
        });

        jBtnAddMem.setText("M+");
        jBtnAddMem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddMemActionPerformed(evt);
            }
        });

        jBtnMult.setText("X");
        jBtnMult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMultActionPerformed(evt);
            }
        });

        jBtnPorc.setText("%");
        jBtnPorc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPorcActionPerformed(evt);
            }
        });

        jBtnDiv.setText("/");
        jBtnDiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDivActionPerformed(evt);
            }
        });

        jBtnMais.setText("+");
        jBtnMais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMaisActionPerformed(evt);
            }
        });

        jBtnPonto.setText(".");
        jBtnPonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPontoActionPerformed(evt);
            }
        });

        jBtnSub.setText("-");
        jBtnSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSubActionPerformed(evt);
            }
        });

        jBtnIgual.setText("=");
        jBtnIgual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIgualActionPerformed(evt);
            }
        });

        jBtnMemoria.setText("Memória");
        jBtnMemoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMemoriaActionPerformed(evt);
            }
        });

        jBtnNove.setBackground(new java.awt.Color(153, 153, 153));
        jBtnNove.setText("9");
        jBtnNove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNoveActionPerformed(evt);
            }
        });

        jBtnOito.setBackground(new java.awt.Color(153, 153, 153));
        jBtnOito.setText("8");
        jBtnOito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOitoActionPerformed(evt);
            }
        });

        jBtnSete.setBackground(new java.awt.Color(153, 153, 153));
        jBtnSete.setText("7");
        jBtnSete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSeteActionPerformed(evt);
            }
        });

        jBtnSeis.setBackground(new java.awt.Color(153, 153, 153));
        jBtnSeis.setText("6");
        jBtnSeis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSeisActionPerformed(evt);
            }
        });

        jBtnCinco.setBackground(new java.awt.Color(153, 153, 153));
        jBtnCinco.setText("5");
        jBtnCinco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCincoActionPerformed(evt);
            }
        });

        jBtnQuatro.setBackground(new java.awt.Color(153, 153, 153));
        jBtnQuatro.setText("4");
        jBtnQuatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnQuatroActionPerformed(evt);
            }
        });

        jBtnTres.setBackground(new java.awt.Color(153, 153, 153));
        jBtnTres.setText("3");
        jBtnTres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTresActionPerformed(evt);
            }
        });

        jBtnDois.setBackground(new java.awt.Color(153, 153, 153));
        jBtnDois.setText("2");
        jBtnDois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDoisActionPerformed(evt);
            }
        });

        jBtnUm.setBackground(new java.awt.Color(153, 153, 153));
        jBtnUm.setText("1");
        jBtnUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnUmActionPerformed(evt);
            }
        });

        jBtnZero.setBackground(new java.awt.Color(153, 153, 153));
        jBtnZero.setText("0");
        jBtnZero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnZeroActionPerformed(evt);
            }
        });

        jmiConversorVelocidade.setText("Conversor");

        jmiConversorBase.setText("Base Numérica");
        jmiConversorBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConversorBaseActionPerformed(evt);
            }
        });
        jmiConversorVelocidade.add(jmiConversorBase);

        jmbPrincipal.add(jmiConversorVelocidade);

        jmiSair.setText("Sair");

        jmiSairSair.setText("Sair");
        jmiSairSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSairSairActionPerformed(evt);
            }
        });
        jmiSair.add(jmiSairSair);

        jmbPrincipal.add(jmiSair);

        setJMenuBar(jmbPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnIgual, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtnSeis, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnCinco, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnQuatro, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnZero, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtnTres, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnDois, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnUm, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnSub, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnPonto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnMais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnNove, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnOito, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnSete, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnMult, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jBtnDiv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jtfVisor)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnBackspace, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnAddMem, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnPorc, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtfVisor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnBackspace)
                    .addComponent(jBtnClear)
                    .addComponent(jBtnAddMem)
                    .addComponent(jBtnPorc))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnDiv)
                    .addComponent(jBtnMult)
                    .addComponent(jBtnNove)
                    .addComponent(jBtnOito)
                    .addComponent(jBtnSete))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnMais)
                    .addComponent(jBtnSeis)
                    .addComponent(jBtnCinco)
                    .addComponent(jBtnQuatro)
                    .addComponent(jBtnZero))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnPonto)
                    .addComponent(jBtnTres)
                    .addComponent(jBtnDois)
                    .addComponent(jBtnUm)
                    .addComponent(jBtnSub))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnMemoria)
                    .addComponent(jBtnIgual))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmiConversorBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConversorBaseActionPerformed
        dispose(); // Fecha a janela
        ConversorB tela = new ConversorB(); // Instancia a tela
        tela.setVisible(true); // Mostra a tela
    }//GEN-LAST:event_jmiConversorBaseActionPerformed

    private void jtfVisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfVisorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfVisorActionPerformed

    // Função Clear
    private void jBtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClearActionPerformed
        jtfVisor.setText(""); // Reseta o Visor
    }//GEN-LAST:event_jBtnClearActionPerformed

    // Função Backspace
    private void jBtnBackspaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBackspaceActionPerformed
        if (jtfVisor.getText().length() > 0) { // Se o visor não estiver vazio
            jtfVisor.setText(jtfVisor.getText().substring(0, jtfVisor.getText().length() - 1)); // Separa os itens do visor e apaga a ultima posição
        }
    }//GEN-LAST:event_jBtnBackspaceActionPerformed

    // Função carregar memória
    private void jBtnAddMemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddMemActionPerformed
        if (memoria != null) { // Se memória não estiver vazia
            jtfVisor.setText(memoria); // Mostra o que está armazenado na memória no visor
        } else {
            JOptionPane.showMessageDialog(null, "Não há nenhum número na memória!"); // Mensagem de erro
        }
    }//GEN-LAST:event_jBtnAddMemActionPerformed

    // Função ponto
    private void jBtnPontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPontoActionPerformed
        if (jtfVisor.getText().contains(".") || jtfVisor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Você já inseriu um ponto ou o campo está vazio!"); // Mensagem de erro
        } else {
            jtfVisor.setText(jtfVisor.getText() + "."); // Adiciona um Ponto no visor
        }
    }//GEN-LAST:event_jBtnPontoActionPerformed

    // Função Igual
    private void jBtnIgualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIgualActionPerformed
        if (jtfVisor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo não pode estar vázio!"); // Mensagem de erro se estiver vazio
        } else {
            switch (operador) { // Verifica o operador
                case '+':   // Realiza adição
                    numero2 = Double.parseDouble(jtfVisor.getText());
                    jtfVisor.setText(String.valueOf(numero1 + numero2));
                    break;
                case '-': // Realiza subtração
                    numero2 = Double.parseDouble(jtfVisor.getText());
                    jtfVisor.setText(String.valueOf(numero1 - numero2));
                    break;
                case '/': // Realiza divisão
                    numero2 = Double.parseDouble(jtfVisor.getText());
                    if (numero2 != 0) { // Se não for divisão por 0
                        jtfVisor.setText(String.valueOf(numero1 / numero2));
                    } else {
                        JOptionPane.showMessageDialog(null, "Não é possível realizar divisão por 0!"); // Mensagem de erro divisão por 0
                    }
                    break;
                case '*': // Realiza multiplicação
                    numero2 = Double.parseDouble(jtfVisor.getText());
                    jtfVisor.setText(String.valueOf(numero1 * numero2));
                    break;
                case '%': // Realiza porcentagem
                    numero2 = Double.parseDouble(jtfVisor.getText());
                    jtfVisor.setText(String.valueOf((numero1 * numero2) / 100));
                    break;
            }
        }
    }//GEN-LAST:event_jBtnIgualActionPerformed

    private void jBtnSeteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSeteActionPerformed
        jtfVisor.setText(jtfVisor.getText() + "7"); // Adiciona o 7 ao visor
    }//GEN-LAST:event_jBtnSeteActionPerformed

    private void jBtnOitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnOitoActionPerformed
        jtfVisor.setText(jtfVisor.getText() + "8"); // Adiciona o 8 ao visor
    }//GEN-LAST:event_jBtnOitoActionPerformed

    private void jBtnNoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNoveActionPerformed
        jtfVisor.setText(jtfVisor.getText() + "9"); // Adiciona o 9 ao visor
    }//GEN-LAST:event_jBtnNoveActionPerformed

    private void jBtnSeisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSeisActionPerformed
        jtfVisor.setText(jtfVisor.getText() + "6"); // Adiciona o 6 ao visor
    }//GEN-LAST:event_jBtnSeisActionPerformed

    private void jBtnCincoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCincoActionPerformed
        jtfVisor.setText(jtfVisor.getText() + "5"); // Adiciona o 5 ao visor
    }//GEN-LAST:event_jBtnCincoActionPerformed

    private void jBtnQuatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnQuatroActionPerformed
        jtfVisor.setText(jtfVisor.getText() + "4"); // Adiciona o 4 ao visor
    }//GEN-LAST:event_jBtnQuatroActionPerformed

    private void jBtnZeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnZeroActionPerformed
        jtfVisor.setText(jtfVisor.getText() + "0"); // Adiciona o 0 ao visor
    }//GEN-LAST:event_jBtnZeroActionPerformed

    private void jBtnTresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTresActionPerformed
        jtfVisor.setText(jtfVisor.getText() + "3"); // Adiciona o 3 ao visor
    }//GEN-LAST:event_jBtnTresActionPerformed

    private void jBtnDoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDoisActionPerformed
        jtfVisor.setText(jtfVisor.getText() + "2"); // Adiciona o 2 ao visor
    }//GEN-LAST:event_jBtnDoisActionPerformed

    private void jBtnUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnUmActionPerformed
        jtfVisor.setText(jtfVisor.getText() + "1"); // Adiciona o 1 ao visor
    }//GEN-LAST:event_jBtnUmActionPerformed

    // Função salvar na memória
    private void jBtnMemoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMemoriaActionPerformed
        if (jtfVisor.getText().isEmpty()) { // Se o visor estiver vazio
            JOptionPane.showMessageDialog(null, "Não há nenhum número para salvar!"); // Mensagem de erro visor vazio
        } else {
            memoria = jtfVisor.getText(); // Salva o texto na memória
        }
    }//GEN-LAST:event_jBtnMemoriaActionPerformed

    // Função Adição
    private void jBtnMaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMaisActionPerformed
        numero1 = Double.parseDouble(jtfVisor.getText()); // Salva o valor no visor
        jtfVisor.setText(""); // Limpa o visor
        operador = '+'; // Define operador como +
    }//GEN-LAST:event_jBtnMaisActionPerformed

    // Função Subtração
    private void jBtnSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSubActionPerformed
        numero1 = Double.parseDouble(jtfVisor.getText()); // Salva o valor no visor
        jtfVisor.setText(""); // Limpa o visor
        operador = '-'; // Define operador como -
    }//GEN-LAST:event_jBtnSubActionPerformed

    // Função Divisão
    private void jBtnDivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDivActionPerformed
        numero1 = Double.parseDouble(jtfVisor.getText()); // Salva o valor no visor
        jtfVisor.setText(""); // Limpa o visor
        operador = '/'; // Define operador como /
    }//GEN-LAST:event_jBtnDivActionPerformed

    // Função Multiplicação
    private void jBtnMultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMultActionPerformed
        numero1 = Double.parseDouble(jtfVisor.getText()); // Salva o valor no visor
        jtfVisor.setText(""); // Limpa o visor
        operador = '*'; // Define operador como *
    }//GEN-LAST:event_jBtnMultActionPerformed

    // Função Porcentagem
    private void jBtnPorcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPorcActionPerformed
        numero1 = Double.parseDouble(jtfVisor.getText()); // Salva o valor no visor
        jtfVisor.setText(""); // Limpa o visor
        operador = '%'; // Define operador como %
    }//GEN-LAST:event_jBtnPorcActionPerformed

    // Função sair
    private void jmiSairSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSairSairActionPerformed
        JOptionPane.showMessageDialog(null, "Você escolheu sair!"); // Avisa o usuário
        System.exit(0); // Para a aplicação
    }//GEN-LAST:event_jmiSairSairActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAddMem;
    private javax.swing.JButton jBtnBackspace;
    private javax.swing.JButton jBtnCinco;
    private javax.swing.JButton jBtnClear;
    private javax.swing.JButton jBtnDiv;
    private javax.swing.JButton jBtnDois;
    private javax.swing.JButton jBtnIgual;
    private javax.swing.JButton jBtnMais;
    private javax.swing.JButton jBtnMemoria;
    private javax.swing.JButton jBtnMult;
    private javax.swing.JButton jBtnNove;
    private javax.swing.JButton jBtnOito;
    private javax.swing.JButton jBtnPonto;
    private javax.swing.JButton jBtnPorc;
    private javax.swing.JButton jBtnQuatro;
    private javax.swing.JButton jBtnSeis;
    private javax.swing.JButton jBtnSete;
    private javax.swing.JButton jBtnSub;
    private javax.swing.JButton jBtnTres;
    private javax.swing.JButton jBtnUm;
    private javax.swing.JButton jBtnZero;
    private javax.swing.JMenuBar jmbPrincipal;
    private javax.swing.JMenuItem jmiConversorBase;
    private javax.swing.JMenu jmiConversorVelocidade;
    private javax.swing.JMenu jmiSair;
    private javax.swing.JMenuItem jmiSairSair;
    private javax.swing.JTextField jtfVisor;
    // End of variables declaration//GEN-END:variables
}
