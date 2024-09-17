import javax.swing.JOptionPane;

/**
 * @author julio_busarello
 */
public class TelaPrincipal extends javax.swing.JFrame {

    String memoria;
    double numero1, numero2;
    char operador;

    public TelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfVisor = new javax.swing.JTextField();
        jbtnBackspace = new javax.swing.JButton();
        jtbnClear = new javax.swing.JButton();
        jbtnAddMem = new javax.swing.JButton();
        jbtnMult = new javax.swing.JButton();
        jbtnPorc = new javax.swing.JButton();
        jtbDiv = new javax.swing.JButton();
        jbtnMais = new javax.swing.JButton();
        jbtnPonto = new javax.swing.JButton();
        jbtnSub = new javax.swing.JButton();
        jbtnIgual = new javax.swing.JButton();
        jbtnMemoria = new javax.swing.JButton();
        jbtnNove = new javax.swing.JButton();
        jbtnOito = new javax.swing.JButton();
        jbtnSete = new javax.swing.JButton();
        jbtnSeis = new javax.swing.JButton();
        jbtnCinco = new javax.swing.JButton();
        jbtnQuatro = new javax.swing.JButton();
        jbtnTres = new javax.swing.JButton();
        jbtnDois = new javax.swing.JButton();
        jbtnUm = new javax.swing.JButton();
        jbtnZero = new javax.swing.JButton();
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

        jbtnBackspace.setText("<");
        jbtnBackspace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBackspaceActionPerformed(evt);
            }
        });

        jtbnClear.setText("CE");
        jtbnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbnClearActionPerformed(evt);
            }
        });

        jbtnAddMem.setText("M+");
        jbtnAddMem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddMemActionPerformed(evt);
            }
        });

        jbtnMult.setText("X");
        jbtnMult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMultActionPerformed(evt);
            }
        });

        jbtnPorc.setText("%");
        jbtnPorc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPorcActionPerformed(evt);
            }
        });

        jtbDiv.setText("/");
        jtbDiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbDivActionPerformed(evt);
            }
        });

        jbtnMais.setText("+");
        jbtnMais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMaisActionPerformed(evt);
            }
        });

        jbtnPonto.setText(".");
        jbtnPonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPontoActionPerformed(evt);
            }
        });

        jbtnSub.setText("-");
        jbtnSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSubActionPerformed(evt);
            }
        });

        jbtnIgual.setText("=");
        jbtnIgual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIgualActionPerformed(evt);
            }
        });

        jbtnMemoria.setText("Memória");
        jbtnMemoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMemoriaActionPerformed(evt);
            }
        });

        jbtnNove.setBackground(new java.awt.Color(153, 153, 153));
        jbtnNove.setText("9");
        jbtnNove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNoveActionPerformed(evt);
            }
        });

        jbtnOito.setBackground(new java.awt.Color(153, 153, 153));
        jbtnOito.setText("8");
        jbtnOito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOitoActionPerformed(evt);
            }
        });

        jbtnSete.setBackground(new java.awt.Color(153, 153, 153));
        jbtnSete.setText("7");
        jbtnSete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSeteActionPerformed(evt);
            }
        });

        jbtnSeis.setBackground(new java.awt.Color(153, 153, 153));
        jbtnSeis.setText("6");
        jbtnSeis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSeisActionPerformed(evt);
            }
        });

        jbtnCinco.setBackground(new java.awt.Color(153, 153, 153));
        jbtnCinco.setText("5");
        jbtnCinco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCincoActionPerformed(evt);
            }
        });

        jbtnQuatro.setBackground(new java.awt.Color(153, 153, 153));
        jbtnQuatro.setText("4");
        jbtnQuatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnQuatroActionPerformed(evt);
            }
        });

        jbtnTres.setBackground(new java.awt.Color(153, 153, 153));
        jbtnTres.setText("3");
        jbtnTres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTresActionPerformed(evt);
            }
        });

        jbtnDois.setBackground(new java.awt.Color(153, 153, 153));
        jbtnDois.setText("2");
        jbtnDois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDoisActionPerformed(evt);
            }
        });

        jbtnUm.setBackground(new java.awt.Color(153, 153, 153));
        jbtnUm.setText("1");
        jbtnUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUmActionPerformed(evt);
            }
        });

        jbtnZero.setBackground(new java.awt.Color(153, 153, 153));
        jbtnZero.setText("0");
        jbtnZero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnZeroActionPerformed(evt);
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
                        .addComponent(jbtnMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnIgual, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbtnSeis, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnCinco, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnQuatro, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnZero, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbtnTres, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnDois, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnUm, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnSub, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnPonto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtnMais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnNove, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnOito, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnSete, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnMult, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jtbDiv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jtfVisor)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtbnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnBackspace, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnAddMem, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnPorc, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtfVisor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnBackspace)
                    .addComponent(jtbnClear)
                    .addComponent(jbtnAddMem)
                    .addComponent(jbtnPorc))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtbDiv)
                    .addComponent(jbtnMult)
                    .addComponent(jbtnNove)
                    .addComponent(jbtnOito)
                    .addComponent(jbtnSete))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnMais)
                    .addComponent(jbtnSeis)
                    .addComponent(jbtnCinco)
                    .addComponent(jbtnQuatro)
                    .addComponent(jbtnZero))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnPonto)
                    .addComponent(jbtnTres)
                    .addComponent(jbtnDois)
                    .addComponent(jbtnUm)
                    .addComponent(jbtnSub))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnMemoria)
                    .addComponent(jbtnIgual))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmiConversorBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConversorBaseActionPerformed
        dispose();
        ConversorB tela = new ConversorB();
        tela.setVisible(true);
    }//GEN-LAST:event_jmiConversorBaseActionPerformed

    private void jtfVisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfVisorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfVisorActionPerformed

    private void jtbnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbnClearActionPerformed
        jtfVisor.setText("");
    }//GEN-LAST:event_jtbnClearActionPerformed

    private void jbtnBackspaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBackspaceActionPerformed
        if (jtfVisor.getText().length() > 0) {
            jtfVisor.setText(jtfVisor.getText().substring(0, jtfVisor.getText().length() - 1));
        }
    }//GEN-LAST:event_jbtnBackspaceActionPerformed

    private void jbtnAddMemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddMemActionPerformed
        if(memoria != null){
            jtfVisor.setText(memoria);
        }else{
            JOptionPane.showMessageDialog(null, "Não há nenhum número na memória!");
        }
    }//GEN-LAST:event_jbtnAddMemActionPerformed

    private void jbtnPontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPontoActionPerformed
        if (jtfVisor.getText().contains(".") || jtfVisor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Você já inseriu um ponto ou o campo está vazio!");
        } else {
            jtfVisor.setText(jtfVisor.getText() + ".");
        }
    }//GEN-LAST:event_jbtnPontoActionPerformed

    private void jbtnIgualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIgualActionPerformed
        if (jtfVisor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo não pode estar vázio!");
        } else {
            switch (operador) {
                case '+':
                    numero2 = Double.parseDouble(jtfVisor.getText());
                    jtfVisor.setText(String.valueOf(numero1 + numero2));
                    break;
                case '-':
                    numero2 = Double.parseDouble(jtfVisor.getText());
                    jtfVisor.setText(String.valueOf(numero1 - numero2));
                    break;
                case '/':
                    numero2 = Double.parseDouble(jtfVisor.getText());
                    if (numero2 != 0) {
                        jtfVisor.setText(String.valueOf(numero1 / numero2));
                    }else{
                        JOptionPane.showMessageDialog(null, "Não é possível realizar divisão por 0!");
                    }
                    break;
                case '*':
                    numero2 = Double.parseDouble(jtfVisor.getText());
                    jtfVisor.setText(String.valueOf(numero1 * numero2));
                    break;
                case '%':
                    numero2 = Double.parseDouble(jtfVisor.getText());
                    jtfVisor.setText(String.valueOf((numero1 * numero2) / 100));
                    break;
            }
        }
    }//GEN-LAST:event_jbtnIgualActionPerformed

    private void jbtnSeteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSeteActionPerformed
        jtfVisor.setText(jtfVisor.getText() + "7");
    }//GEN-LAST:event_jbtnSeteActionPerformed

    private void jbtnOitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOitoActionPerformed
        jtfVisor.setText(jtfVisor.getText() + "8");
    }//GEN-LAST:event_jbtnOitoActionPerformed

    private void jbtnNoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNoveActionPerformed
        jtfVisor.setText(jtfVisor.getText() + "9");
    }//GEN-LAST:event_jbtnNoveActionPerformed

    private void jbtnSeisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSeisActionPerformed
        jtfVisor.setText(jtfVisor.getText() + "6");
    }//GEN-LAST:event_jbtnSeisActionPerformed

    private void jbtnCincoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCincoActionPerformed
        jtfVisor.setText(jtfVisor.getText() + "5");
    }//GEN-LAST:event_jbtnCincoActionPerformed

    private void jbtnQuatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnQuatroActionPerformed
        jtfVisor.setText(jtfVisor.getText() + "4");
    }//GEN-LAST:event_jbtnQuatroActionPerformed

    private void jbtnZeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnZeroActionPerformed
        jtfVisor.setText(jtfVisor.getText() + "0");
    }//GEN-LAST:event_jbtnZeroActionPerformed

    private void jbtnTresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTresActionPerformed
        jtfVisor.setText(jtfVisor.getText() + "3");
    }//GEN-LAST:event_jbtnTresActionPerformed

    private void jbtnDoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDoisActionPerformed
        jtfVisor.setText(jtfVisor.getText() + "2");
    }//GEN-LAST:event_jbtnDoisActionPerformed

    private void jbtnUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUmActionPerformed
        jtfVisor.setText(jtfVisor.getText() + "1");
    }//GEN-LAST:event_jbtnUmActionPerformed

    private void jbtnMemoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMemoriaActionPerformed
        if(jtfVisor.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Não há nenhum número para salvar!");
        }else{
            memoria = jtfVisor.getText();
        }
    }//GEN-LAST:event_jbtnMemoriaActionPerformed

    private void jbtnMaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMaisActionPerformed
        numero1 = Double.parseDouble(jtfVisor.getText());
        jtfVisor.setText("");
        operador = '+';
    }//GEN-LAST:event_jbtnMaisActionPerformed

    private void jbtnSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSubActionPerformed
        numero1 = Double.parseDouble(jtfVisor.getText());
        jtfVisor.setText("");
        operador = '-';
    }//GEN-LAST:event_jbtnSubActionPerformed

    private void jtbDivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbDivActionPerformed
        numero1 = Double.parseDouble(jtfVisor.getText());
        jtfVisor.setText("");
        operador = '/';
    }//GEN-LAST:event_jtbDivActionPerformed

    private void jbtnMultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMultActionPerformed
        numero1 = Double.parseDouble(jtfVisor.getText());
        jtfVisor.setText("");
        operador = '*';
    }//GEN-LAST:event_jbtnMultActionPerformed

    private void jbtnPorcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPorcActionPerformed
        numero1 = Double.parseDouble(jtfVisor.getText());
        jtfVisor.setText("");
        operador = '%';
    }//GEN-LAST:event_jbtnPorcActionPerformed

    private void jmiSairSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSairSairActionPerformed
        JOptionPane.showMessageDialog(null, "Você escolheu sair!");
        System.exit(0);
    }//GEN-LAST:event_jmiSairSairActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnAddMem;
    private javax.swing.JButton jbtnBackspace;
    private javax.swing.JButton jbtnCinco;
    private javax.swing.JButton jbtnDois;
    private javax.swing.JButton jbtnIgual;
    private javax.swing.JButton jbtnMais;
    private javax.swing.JButton jbtnMemoria;
    private javax.swing.JButton jbtnMult;
    private javax.swing.JButton jbtnNove;
    private javax.swing.JButton jbtnOito;
    private javax.swing.JButton jbtnPonto;
    private javax.swing.JButton jbtnPorc;
    private javax.swing.JButton jbtnQuatro;
    private javax.swing.JButton jbtnSeis;
    private javax.swing.JButton jbtnSete;
    private javax.swing.JButton jbtnSub;
    private javax.swing.JButton jbtnTres;
    private javax.swing.JButton jbtnUm;
    private javax.swing.JButton jbtnZero;
    private javax.swing.JMenuBar jmbPrincipal;
    private javax.swing.JMenuItem jmiConversorBase;
    private javax.swing.JMenu jmiConversorVelocidade;
    private javax.swing.JMenu jmiSair;
    private javax.swing.JMenuItem jmiSairSair;
    private javax.swing.JButton jtbDiv;
    private javax.swing.JButton jtbnClear;
    private javax.swing.JTextField jtfVisor;
    // End of variables declaration//GEN-END:variables
}
