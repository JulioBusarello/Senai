import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author julio_busarello
 */
public class FormPrincipal extends javax.swing.JFrame {

    public static ArrayList<Cliente> listaCliente;
    public static ArrayList<Fornecedor> listaFornecedor;
    public static ArrayList<Produto> listaProduto;
    

    // <editor-fold defaultstate="collapsed" desc="Criados">
    // <editor-fold defaultstate="collapsed" desc="Construtor">
    public FormPrincipal() {
        listaCliente = new ArrayList<>();
        listaProduto = new ArrayList<>();
        listaFornecedor = new ArrayList<>();
        loadCli();
        loadFor();
        loadPro();
        initComponents();
        tblCliente();
        tblFornecedor();
        tblProduto();

        ativadoPro(false, false);
        ativadoCli(false, false);
        ativadoFor(false, false);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Base Cliente">
    // Carregar Tabelas Clientes
    public final void tblCliente() {
        DefaultTableModel modeloCli = new DefaultTableModel(new Object[]{
            "Código", "Nome", "Telefone", "Email", "Endereço"}, 0);
        for (int i = 0; i < listaCliente.size(); i++) {
            Object linhaCli[] = new Object[]{
                listaCliente.get(i).getCodigo(),
                listaCliente.get(i).getNome(),
                listaCliente.get(i).getTelefone(),
                listaCliente.get(i).getEmail(),
                listaCliente.get(i).getEndereco()};
            modeloCli.addRow(linhaCli);
        }
        jTbCli.setModel(modeloCli);
        jTbCli.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTbCli.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTbCli.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTbCli.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTbCli.getColumnModel().getColumn(4).setPreferredWidth(80);
    }

    // Salvar Dados Clientes
    public void saveCli() {
        String fileCli = "cliente.db";
        String linhaCli = "";

        for (int i = 0; i < listaCliente.size(); i++) {
            linhaCli += listaCliente.get(i).getCodigo() + ";"
                    + listaCliente.get(i).getNome() + ";"
                    + listaCliente.get(i).getTelefone() + ";"
                    + listaCliente.get(i).getEmail() + ";"
                    + listaCliente.get(i).getEndereco() + "\n";
        }
        if (Arquivo.write(fileCli, linhaCli)) {
            JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Erro na gravação do arquivo");
        }
    }

    // Carregar Dados Clientes
    public final void loadCli() {
        String fileCli = "cliente.db";
        String conteudo = Arquivo.read(fileCli);

        if (conteudo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Erro de leitura do arquivo cliente.db");
        } else {
            String[] linhaCli = conteudo.split("\n");
            String[] dadosCli;

            for (int i = 0; i < linhaCli.length; i++) {
                dadosCli = linhaCli[i].split(";");
                Cliente cli = new Cliente();
                cli.setCodigo(Integer.parseInt(dadosCli[0]));
                cli.setNome(dadosCli[1]);
                cli.setTelefone(dadosCli[2]);
                cli.setEmail(dadosCli[3]);
                cli.setEndereco(dadosCli[4]);
                listaCliente.add(cli);
            }
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Base Produto">
    // Carregar Tabela Produto
    public final void tblProduto() {
        DefaultTableModel modeloPro = new DefaultTableModel(new Object[]{
            "Código", "Descrição", "Unidade", "Quantidade", "Preço"}, 0);
        for (int i = 0; i < listaProduto.size(); i++) {
            Object linhaPro[] = new Object[]{
                listaProduto.get(i).getCodigo(),
                listaProduto.get(i).getDescricao(),
                listaProduto.get(i).getUnidade(),
                listaProduto.get(i).getQtd(),
                listaProduto.get(i).getPreco()};
            modeloPro.addRow(linhaPro);
        }
        jTbPro.setModel(modeloPro);
        jTbPro.getColumnModel().getColumn(0).setPreferredWidth(250);
        jTbPro.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTbPro.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTbPro.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTbPro.getColumnModel().getColumn(4).setPreferredWidth(250);
    }

    // Salvar Dados Produto
    public void savePro() {
        String filePro = "produto.db";
        String linhaPro = "";

        for (int i = 0; i < listaProduto.size(); i++) {
            linhaPro += listaProduto.get(i).getCodigo() + ";"
                    + listaProduto.get(i).getDescricao() + ";"
                    + listaProduto.get(i).getUnidade() + ";"
                    + listaProduto.get(i).getQtd() + ";"
                    + listaProduto.get(i).getPreco() + "\n";
        }
        if (Arquivo.write(filePro, linhaPro)) {
            JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Erro na gravação do arquivo");
        }
    }

    // Carregar Dados Fornecedor
    public static void loadPro() {
        String filePro = "produto.db";
        String conteudo = Arquivo.read(filePro);

        if (conteudo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Erro de leitura do arquivo produto.db");
        } else {
            String[] linhaPro = conteudo.split("\n");
            String[] dadosPro;

            for (int i = 0; i < linhaPro.length; i++) {
                dadosPro = linhaPro[i].split(";");
                Produto pro = new Produto();
                pro.setCodigo(Integer.parseInt(dadosPro[0]));
                pro.setDescricao(dadosPro[1]);
                pro.setUnidade(dadosPro[2]);
                pro.setQtd(Integer.parseInt(dadosPro[3]));
                pro.setPreco(Double.parseDouble(dadosPro[4]));
                listaProduto.add(pro);
            }
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Base Fornecedor">
    // Carregar Tabela Fornecedor
    public final void tblFornecedor() {
        DefaultTableModel modeloFor = new DefaultTableModel(new Object[]{
            "Código", "Contato", "Telefone", "Email", "Empresa"}, 0);
        for (int i = 0; i < listaFornecedor.size(); i++) {
            Object linhaFor[] = new Object[]{
                listaFornecedor.get(i).getCodigo(),
                listaFornecedor.get(i).getContato(),
                listaFornecedor.get(i).getTelefone(),
                listaFornecedor.get(i).getEmail(),
                listaFornecedor.get(i).getEmpresa()};
            modeloFor.addRow(linhaFor);
        }
        jTbFor.setModel(modeloFor);
        jTbFor.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTbFor.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTbFor.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTbFor.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTbFor.getColumnModel().getColumn(4).setPreferredWidth(80);
    }

    // Salvar Dados Fornecedor
    public void saveFor() {
        String fileFor = "fornecedor.db";
        String linhaFor = "";

        for (int i = 0; i < listaFornecedor.size(); i++) {
            linhaFor += listaFornecedor.get(i).getCodigo() + ";"
                    + listaFornecedor.get(i).getContato() + ";"
                    + listaFornecedor.get(i).getTelefone() + ";"
                    + listaFornecedor.get(i).getEmail() + ";"
                    + listaFornecedor.get(i).getEmpresa() + "\n";
        }
        if (Arquivo.write(fileFor, linhaFor)) {
            JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Erro na gravação do arquivo");
        }
    }

    // Carregar Dados Fornecedor
    public static void loadFor() {
        String fileFor = "fornecedor.db";
        String conteudo = Arquivo.read(fileFor);

        if (conteudo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Erro de leitura do arquivo fornecedor.db");
        } else {
            String[] linhaFor = conteudo.split("\n");
            String[] dadosFor;

            for (int i = 0; i < linhaFor.length; i++) {
                dadosFor = linhaFor[i].split(";");
                Fornecedor forn = new Fornecedor();
                forn.setCodigo(Integer.parseInt(dadosFor[0]));
                forn.setContato(dadosFor[1]);
                forn.setTelefone(dadosFor[2]);
                forn.setEmail(dadosFor[3]);
                forn.setEmpresa(dadosFor[4]);
                listaFornecedor.add(forn);
            }
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Ativado Interfaces">
    // Ativar e Desativar Botões Cliente
    public void ativadoCli(boolean campos, boolean selecao) {
        if (campos == false) {
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
    }

    //  Ativar e Desativar Botões Produto
    public void ativadoPro(boolean campos, boolean selecao) {
        if (campos == false) {
            jTfCodigoPro.setText("");
            jTfUnidadePro.setText("");
            jTfQuantidadePro.setText("");
            jTfPrecoPro.setText("");
            jTfDescricaoPro.setText("");
        }

        jTfCodigoPro.setEnabled(campos);
        jTfUnidadePro.setEnabled(campos);
        jTfQuantidadePro.setEnabled(campos);
        jTfPrecoPro.setEnabled(campos);
        jTfDescricaoPro.setEnabled(campos);

        jBtnEditarPro.setEnabled(selecao);
        jBtnExcluirPro.setEnabled(selecao);
        jBtnSalvarPro.setEnabled(false);
        jBtnCancelarPro.setEnabled(false);
        jBtnNovoPro.setEnabled(true);
    }

    //  Ativar e Desativar Botões Produto
    public void ativadoFor(boolean campos, boolean selecao) {
        if (campos == false) {
            jTfCodigoFor.setText("");
            jTfContatoFor.setText("");
            jTfTelefoneFor.setText("");
            jTfEmailFor.setText("");
            jTfEmpresaFor.setText("");
        }

        jTfCodigoFor.setEnabled(campos);
        jTfContatoFor.setEnabled(campos);
        jTfTelefoneFor.setEnabled(campos);
        jTfEmailFor.setEnabled(campos);
        jTfEmpresaFor.setEnabled(campos);

        jBtnEditarFor.setEnabled(selecao);
        jBtnExluirFor.setEnabled(selecao);
        jBtnSalvarFor.setEnabled(false);
        jBtnCancelarFor.setEnabled(false);
        jBtnNovoFor.setEnabled(true);
    }
    // </editor-fold>
    // </editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTbCli = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTfCodigoCli = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTfTelefoneCli = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTfNomeCli = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTfEmailCli = new javax.swing.JTextField();
        jBtnNovoCli = new javax.swing.JButton();
        jBtnSalvarCli = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTaEnderecoCli = new javax.swing.JTextArea();
        jBtnEditarCli = new javax.swing.JButton();
        jBtnExcluirCli = new javax.swing.JButton();
        jBtnCancelarCli = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTfCodigoPro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTfQuantidadePro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTfUnidadePro = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTfPrecoPro = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTfDescricaoPro = new javax.swing.JTextField();
        jBtnNovoPro = new javax.swing.JButton();
        jBtnEditarPro = new javax.swing.JButton();
        jBtnExcluirPro = new javax.swing.JButton();
        jBtnCancelarPro = new javax.swing.JButton();
        jBtnSalvarPro = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTbPro = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbFor = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jTfCodigoFor = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTfTelefoneFor = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTfContatoFor = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTfEmailFor = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTfEmpresaFor = new javax.swing.JTextField();
        jBtnNovoFor = new javax.swing.JButton();
        jBtnEditarFor = new javax.swing.JButton();
        jBtnExluirFor = new javax.swing.JButton();
        jBtnCancelarFor = new javax.swing.JButton();
        jBtnSalvarFor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplicativo Exemplo de Desenho de Formulário");
        setResizable(false);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTbCli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "Telefone", "Email", "Endereco"
            }
        ));
        jTbCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTbCliMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTbCli);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Código:");

        jTfCodigoCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfCodigoCliKeyReleased(evt);
            }
        });

        jLabel2.setText("Telefone:");

        jTfTelefoneCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfTelefoneCliKeyReleased(evt);
            }
        });

        jLabel5.setText("Nome:");

        jTfNomeCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfNomeCliKeyReleased(evt);
            }
        });

        jLabel4.setText("Email:");

        jTfEmailCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfEmailCliKeyReleased(evt);
            }
        });

        jBtnNovoCli.setText("Novo");
        jBtnNovoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoCliActionPerformed(evt);
            }
        });

        jBtnSalvarCli.setText("Salvar");
        jBtnSalvarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarCliActionPerformed(evt);
            }
        });

        jLabel3.setText("Endereço:");

        jTaEnderecoCli.setColumns(20);
        jTaEnderecoCli.setLineWrap(true);
        jTaEnderecoCli.setRows(5);
        jTaEnderecoCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTaEnderecoCliKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTaEnderecoCli);

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTfCodigoCli)
                            .addComponent(jTfTelefoneCli, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(16, 16, 16)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTfNomeCli, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                            .addComponent(jTfEmailCli)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)))
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jBtnSalvarCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnNovoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnEditarCli, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnExcluirCli, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnCancelarCli, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jBtnNovoCli)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnEditarCli)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnExcluirCli)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnCancelarCli)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnSalvarCli))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jTfNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jTfCodigoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTfEmailCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTfTelefoneCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane3))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cliente", jPanel1);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setText("Código:");

        jTfCodigoPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfCodigoProKeyReleased(evt);
            }
        });

        jLabel10.setText("Quantidade:");

        jTfQuantidadePro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfQuantidadeProKeyReleased(evt);
            }
        });

        jLabel11.setText("Unidade:");

        jTfUnidadePro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfUnidadeProKeyReleased(evt);
            }
        });

        jLabel12.setText("Preço:");

        jTfPrecoPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfPrecoProKeyReleased(evt);
            }
        });

        jLabel13.setText("Descrição:");

        jTfDescricaoPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfDescricaoProKeyReleased(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTfCodigoPro)
                            .addComponent(jTfQuantidadePro, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTfUnidadePro, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                            .addComponent(jTfPrecoPro)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(jTfDescricaoPro)))
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jBtnSalvarPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnNovoPro, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnEditarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnExcluirPro, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnCancelarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTfCodigoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTfQuantidadePro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jTfUnidadePro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTfDescricaoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jBtnNovoPro)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnEditarPro)
                            .addComponent(jTfPrecoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jBtnExcluirPro)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnCancelarPro)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnSalvarPro)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTbPro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descrição", "Unidade", "Quantidade", "Preço"
            }
        ));
        jTbPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTbProMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTbPro);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Produto", jPanel2);

        jTbFor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
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
        jScrollPane1.setViewportView(jTbFor);

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel19.setText("Código:");

        jTfCodigoFor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfCodigoForKeyReleased(evt);
            }
        });

        jLabel20.setText("Telefone:");

        jTfTelefoneFor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfTelefoneForKeyReleased(evt);
            }
        });

        jLabel21.setText("Contato:");

        jTfContatoFor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfContatoForKeyReleased(evt);
            }
        });

        jLabel22.setText("Email:");

        jTfEmailFor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfEmailForKeyReleased(evt);
            }
        });

        jLabel23.setText("Empresa:");

        jTfEmpresaFor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTfEmpresaForKeyReleased(evt);
            }
        });

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

        jBtnExluirFor.setText("Excluir");
        jBtnExluirFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExluirForActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTfTelefoneFor, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(jTfCodigoFor))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTfContatoFor)
                            .addComponent(jTfEmailFor, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTfEmpresaFor)))
                .addGap(31, 31, 31)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jBtnSalvarFor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnNovoFor, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnEditarFor, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnExluirFor, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnCancelarFor, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTfEmailFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22))
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTfContatoFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel21))
                                    .addGap(41, 41, 41)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTfCodigoFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTfTelefoneFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20))))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jTfEmpresaFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jBtnNovoFor)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnEditarFor)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnExluirFor)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnCancelarFor)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnSalvarFor)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Fornecedor", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // --- Funções do Design
    // <editor-fold defaultstate="collapsed" desc="Gerados">
    // <editor-fold defaultstate="collapsed" desc="Botões Salvar">
    // Botão Salvar Cliente
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

            listaCliente.add(cliente);
            tblCliente();
            saveCli();
        }
    }//GEN-LAST:event_jBtnSalvarCliActionPerformed

    // Botão Salvar Produto
    private void jBtnSalvarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarProActionPerformed
        int codigo = Integer.parseInt(jTfCodigoPro.getText());
        String descricao = jTfDescricaoPro.getText();
        String unidade = jTfUnidadePro.getText();
        int quantidade = Integer.parseInt(jTfQuantidadePro.getText());
        double preco = Double.parseDouble(jTfPrecoPro.getText());

        int a = JOptionPane.showConfirmDialog(null, "Deseja realmente salvar estas informações?\n\n"
                + "Código: " + codigo
                + "\nDescrição: " + descricao
                + "\nUnidade: " + unidade
                + "\nQuantidade: " + quantidade
                + "\nPreço: " + preco,
                "confirmar", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_NO_OPTION) {
            Produto produto = new Produto(codigo, descricao, unidade, quantidade, preco);

            listaProduto.add(produto);
            tblProduto();
            savePro();
        }
    }//GEN-LAST:event_jBtnSalvarProActionPerformed

    // Botão Salvar Fornecedor
    private void jBtnSalvarForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarForActionPerformed
        int codigo = Integer.parseInt(jTfCodigoFor.getText());
        String contato = jTfContatoFor.getText();
        String telefone = jTfTelefoneFor.getText();
        String email = jTfEmailFor.getText();
        String empresa = jTfEmpresaFor.getText();

        int a = JOptionPane.showConfirmDialog(null, "Deseja realmente salvar estas informações?\n\n"
                + "Código: " + codigo
                + "\nContato: " + contato
                + "\nTelefone: " + telefone
                + "\nEmail: " + email
                + "\nEmpresa: " + empresa,
                "confirmar", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_NO_OPTION) {
            Fornecedor fornecedor = new Fornecedor(codigo, contato, telefone, email, empresa);

            listaFornecedor.add(fornecedor);
            tblFornecedor();
            saveFor();
        }
    }//GEN-LAST:event_jBtnSalvarForActionPerformed
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Clicar nas Tabelas">
    // Tabela Selecionada Cliente
    private void jTbCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbCliMouseClicked
        int linhaSelect = jTbCli.getSelectedRow();

        if (linhaSelect != -1) {
            jTfCodigoCli.setText(jTbCli.getValueAt(linhaSelect, 0).toString());
            jTfNomeCli.setText(jTbCli.getValueAt(linhaSelect, 1).toString());
            jTfTelefoneCli.setText(jTbCli.getValueAt(linhaSelect, 2).toString());
            jTfEmailCli.setText(jTbCli.getValueAt(linhaSelect, 3).toString());
            jTaEnderecoCli.setText(jTbCli.getValueAt(linhaSelect, 4).toString());

            ativadoCli(true, true);
        }
    }//GEN-LAST:event_jTbCliMouseClicked

    // Tabela Selecionada Produto
    private void jTbProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbProMouseClicked
        int linhaSelect = jTbPro.getSelectedRow();

        if (linhaSelect != -1) {
            jTfCodigoPro.setText(jTbPro.getValueAt(linhaSelect, 0).toString());
            jTfDescricaoPro.setText(jTbPro.getValueAt(linhaSelect, 1).toString());
            jTfUnidadePro.setText(jTbPro.getValueAt(linhaSelect, 2).toString());
            jTfQuantidadePro.setText(jTbPro.getValueAt(linhaSelect, 3).toString());
            jTfPrecoPro.setText(jTbPro.getValueAt(linhaSelect, 4).toString());

            ativadoPro(true, true);
        }
    }//GEN-LAST:event_jTbProMouseClicked

    // Tabela Selecionada Fornecedor
    private void jTbForMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbForMouseClicked
        int linhaSelect = jTbFor.getSelectedRow();

        if (linhaSelect != -1) {
            jTfCodigoFor.setText(jTbFor.getValueAt(linhaSelect, 0).toString());
            jTfContatoFor.setText(jTbFor.getValueAt(linhaSelect, 1).toString());
            jTfTelefoneFor.setText(jTbFor.getValueAt(linhaSelect, 2).toString());
            jTfEmailFor.setText(jTbFor.getValueAt(linhaSelect, 3).toString());
            jTfEmpresaFor.setText(jTbFor.getValueAt(linhaSelect, 4).toString());

            ativadoFor(true, true);
        }
    }//GEN-LAST:event_jTbForMouseClicked
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Botões Cliente">
    // Botão Novo Cliente
    private void jBtnNovoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoCliActionPerformed
        jTfCodigoCli.setText("");
        jTfEmailCli.setText("");
        jTfNomeCli.setText("");
        jTfTelefoneCli.setText("");
        jTaEnderecoCli.setText("");

        jTbCli.clearSelection();

        ativadoCli(true, false);

        jBtnCancelarCli.setEnabled(true);
        jBtnNovoCli.setEnabled(false);
    }//GEN-LAST:event_jBtnNovoCliActionPerformed

    // Botão Excluir Cliente
    private void jBtnExcluirCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirCliActionPerformed
        int selectedCli = jTbCli.getSelectedRow();
        listaCliente.remove(selectedCli);
        saveCli();
        tblCliente();
        ativadoCli(false, false);
    }//GEN-LAST:event_jBtnExcluirCliActionPerformed

    // Botão Cancelar Cliente
    private void jBtnCancelarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarCliActionPerformed
        ativadoCli(false, false);
    }//GEN-LAST:event_jBtnCancelarCliActionPerformed

    // Verificar o texto dos campos
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

    // Botão Editar Cliente
    private void jBtnEditarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarCliActionPerformed
        int selectedCli = jTbCli.getSelectedRow();
        int codigo = Integer.parseInt(jTfCodigoCli.getText());
        String nome = jTfNomeCli.getText();
        String telefone = jTfTelefoneCli.getText();
        String email = jTfEmailCli.getText();
        String endereco = jTaEnderecoCli.getText();

        int opt = JOptionPane.showConfirmDialog(null,
                "Deseja realmente editar essas informações?\n\n"
                + "Código: " + codigo
                + "\nNome: " + nome
                + "\nTelefone: " + telefone
                + "\nEmail: " + email
                + "\nEndereço: " + endereco,
                "Confirmar",
                JOptionPane.YES_NO_OPTION
        );

        if (opt == JOptionPane.YES_OPTION) {
            Cliente cliente = new Cliente(codigo, nome, telefone, email, endereco);

            listaCliente.add(selectedCli, cliente);
            listaCliente.remove(selectedCli + 1);
            tblCliente();
            saveCli();
            ativadoCli(false, false);
        }
    }//GEN-LAST:event_jBtnEditarCliActionPerformed
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Botões Produto">
    // Botão Novo Produto
    private void jBtnNovoProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoProActionPerformed
        jTfCodigoPro.setText("");
        jTfUnidadePro.setText("");
        jTfQuantidadePro.setText("");
        jTfPrecoPro.setText("");
        jTfDescricaoPro.setText("");

        jTbPro.clearSelection();

        ativadoPro(true, false);

        jBtnCancelarPro.setEnabled(true);
        jBtnNovoPro.setEnabled(false);
    }//GEN-LAST:event_jBtnNovoProActionPerformed

    // Botão Cancelar Produto
    private void jBtnCancelarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarProActionPerformed
        ativadoPro(false, false);
    }//GEN-LAST:event_jBtnCancelarProActionPerformed

    // Botão Excluir Produto
    private void jBtnExcluirProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirProActionPerformed
        int selectedPro = jTbPro.getSelectedRow();
        listaProduto.remove(selectedPro);
        savePro();
        tblProduto();
        ativadoPro(false, false);
    }//GEN-LAST:event_jBtnExcluirProActionPerformed

    // Botão Editar Produto
    private void jBtnEditarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarProActionPerformed
        int selectedPro = jTbPro.getSelectedRow();
        int codigo = Integer.parseInt(jTfCodigoPro.getText());
        String descricao = jTfDescricaoPro.getText();
        String unidade = jTfUnidadePro.getText();
        int quantidade = Integer.parseInt(jTfQuantidadePro.getText());
        double preco = Double.parseDouble(jTfPrecoPro.getText());

        int opt = JOptionPane.showConfirmDialog(null, "Deseja realmente salvar estas informações?\n\n"
                + "Código: " + codigo
                + "\nDescrição: " + descricao
                + "\nUnidade: " + unidade
                + "\nQuantidade: " + quantidade
                + "\nPreço: " + preco,
                "confirmar", JOptionPane.YES_NO_OPTION);

        if (opt == JOptionPane.YES_OPTION) {
            Produto produto = new Produto(codigo, descricao, unidade, quantidade, preco);

            listaProduto.add(selectedPro, produto);
            listaProduto.remove(selectedPro + 1);
            tblProduto();
            savePro();
            ativadoPro(false, false);
        }
    }//GEN-LAST:event_jBtnEditarProActionPerformed

    // Verificar o texto dos campos 
    private void jTfCodigoProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfCodigoProKeyReleased
        if (!jTfCodigoPro.getText().isEmpty() && !jTfUnidadePro.getText().isEmpty() && !jTfQuantidadePro.getText().isEmpty() && !jTfPrecoPro.getText().isEmpty() && !jTfDescricaoPro.getText().isEmpty()) {
            jBtnSalvarPro.setEnabled(true);
        } else {
            jBtnSalvarPro.setEnabled(false);
        }
    }//GEN-LAST:event_jTfCodigoProKeyReleased

    private void jTfUnidadeProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfUnidadeProKeyReleased
        if (!jTfCodigoPro.getText().isEmpty() && !jTfUnidadePro.getText().isEmpty() && !jTfQuantidadePro.getText().isEmpty() && !jTfPrecoPro.getText().isEmpty() && !jTfDescricaoPro.getText().isEmpty()) {
            jBtnSalvarPro.setEnabled(true);
        } else {
            jBtnSalvarPro.setEnabled(false);
        }
    }//GEN-LAST:event_jTfUnidadeProKeyReleased

    private void jTfQuantidadeProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfQuantidadeProKeyReleased
        if (!jTfCodigoPro.getText().isEmpty() && !jTfUnidadePro.getText().isEmpty() && !jTfQuantidadePro.getText().isEmpty() && !jTfPrecoPro.getText().isEmpty() && !jTfDescricaoPro.getText().isEmpty()) {
            jBtnSalvarPro.setEnabled(true);
        } else {
            jBtnSalvarPro.setEnabled(false);
        }
    }//GEN-LAST:event_jTfQuantidadeProKeyReleased

    private void jTfPrecoProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfPrecoProKeyReleased
        if (!jTfCodigoPro.getText().isEmpty() && !jTfUnidadePro.getText().isEmpty() && !jTfQuantidadePro.getText().isEmpty() && !jTfPrecoPro.getText().isEmpty() && !jTfDescricaoPro.getText().isEmpty()) {
            jBtnSalvarPro.setEnabled(true);
        } else {
            jBtnSalvarPro.setEnabled(false);
        }
    }//GEN-LAST:event_jTfPrecoProKeyReleased

    private void jTfDescricaoProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfDescricaoProKeyReleased
        if (!jTfCodigoPro.getText().isEmpty() && !jTfUnidadePro.getText().isEmpty() && !jTfQuantidadePro.getText().isEmpty() && !jTfPrecoPro.getText().isEmpty() && !jTfDescricaoPro.getText().isEmpty()) {
            jBtnSalvarPro.setEnabled(true);
        } else {
            jBtnSalvarPro.setEnabled(false);
        }
    }//GEN-LAST:event_jTfDescricaoProKeyReleased
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Botões Fornecedor">
    // Botão Novo Fornecedor
    private void jBtnNovoForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoForActionPerformed
        jTfCodigoFor.setText("");
        jTfContatoFor.setText("");
        jTfTelefoneFor.setText("");
        jTfEmailFor.setText("");
        jTfEmpresaFor.setText("");

        jTbFor.clearSelection();

        ativadoFor(true, false);

        jBtnCancelarFor.setEnabled(true);
        jBtnNovoFor.setEnabled(false);
    }//GEN-LAST:event_jBtnNovoForActionPerformed

    // Botão Editar Fornecedor
    private void jBtnEditarForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarForActionPerformed
        int selectedFor = jTbPro.getSelectedRow();
        int codigo = Integer.parseInt(jTfCodigoFor.getText());
        String contato = jTfContatoFor.getText();
        String telefone = jTfTelefoneFor.getText();
        String email = jTfEmailFor.getText();
        String empresa = jTfEmpresaFor.getText();

        int a = JOptionPane.showConfirmDialog(null, "Deseja realmente salvar estas informações?\n\n"
                + "Código: " + codigo
                + "\nContato: " + contato
                + "\nTelefone: " + telefone
                + "\nEmail: " + email
                + "\nEmpresa: " + empresa,
                "confirmar", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_NO_OPTION) {
            Fornecedor fornecedor = new Fornecedor(codigo, contato, telefone, email, empresa);

            listaFornecedor.add(selectedFor, fornecedor);
            listaFornecedor.remove(selectedFor + 1);
            tblFornecedor();
            saveFor();
            ativadoFor(false, false);
        }

    }//GEN-LAST:event_jBtnEditarForActionPerformed

    // Botão Excluir Fornecedor
    private void jBtnExluirForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExluirForActionPerformed
        int selectedFor = jTbFor.getSelectedRow();
        listaFornecedor.remove(selectedFor);
        saveFor();
        tblFornecedor();
        ativadoFor(false, false);
    }//GEN-LAST:event_jBtnExluirForActionPerformed

    // Botão Cancelar Fornecedor
    private void jBtnCancelarForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarForActionPerformed
        ativadoFor(false, false);
    }//GEN-LAST:event_jBtnCancelarForActionPerformed

    // Verificar o texto dos campos
    private void jTfCodigoForKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfCodigoForKeyReleased
        if (!jTfCodigoFor.getText().isEmpty() && !jTfContatoFor.getText().isEmpty() && !jTfTelefoneFor.getText().isEmpty() && !jTfEmailFor.getText().isEmpty() && !jTfEmpresaFor.getText().isEmpty()) {
            jBtnSalvarFor.setEnabled(true);
        } else {
            jBtnSalvarFor.setEnabled(false);
        }
    }//GEN-LAST:event_jTfCodigoForKeyReleased

    private void jTfContatoForKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfContatoForKeyReleased
        if (!jTfCodigoFor.getText().isEmpty() && !jTfContatoFor.getText().isEmpty() && !jTfTelefoneFor.getText().isEmpty() && !jTfEmailFor.getText().isEmpty() && !jTfEmpresaFor.getText().isEmpty()) {
            jBtnSalvarFor.setEnabled(true);
        } else {
            jBtnSalvarFor.setEnabled(false);
        }
    }//GEN-LAST:event_jTfContatoForKeyReleased

    private void jTfTelefoneForKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfTelefoneForKeyReleased
        if (!jTfCodigoFor.getText().isEmpty() && !jTfContatoFor.getText().isEmpty() && !jTfTelefoneFor.getText().isEmpty() && !jTfEmailFor.getText().isEmpty() && !jTfEmpresaFor.getText().isEmpty()) {
            jBtnSalvarFor.setEnabled(true);
        } else {
            jBtnSalvarFor.setEnabled(false);
        }
    }//GEN-LAST:event_jTfTelefoneForKeyReleased

    private void jTfEmailForKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfEmailForKeyReleased
        if (!jTfCodigoFor.getText().isEmpty() && !jTfContatoFor.getText().isEmpty() && !jTfTelefoneFor.getText().isEmpty() && !jTfEmailFor.getText().isEmpty() && !jTfEmpresaFor.getText().isEmpty()) {
            jBtnSalvarFor.setEnabled(true);
        } else {
            jBtnSalvarFor.setEnabled(false);
        }
    }//GEN-LAST:event_jTfEmailForKeyReleased

    private void jTfEmpresaForKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTfEmpresaForKeyReleased
        if (!jTfCodigoFor.getText().isEmpty() && !jTfContatoFor.getText().isEmpty() && !jTfTelefoneFor.getText().isEmpty() && !jTfEmailFor.getText().isEmpty() && !jTfEmpresaFor.getText().isEmpty()) {
            jBtnSalvarFor.setEnabled(true);
        } else {
            jBtnSalvarFor.setEnabled(false);
        }
    }//GEN-LAST:event_jTfEmpresaForKeyReleased
    // </editor-fold>
    // </editor-fold>

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(FormPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPrincipal().setVisible(true);
            }
        });
    }
    // <editor-fold defaultstate="collapsed" desc="Variáveis">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCancelarCli;
    private javax.swing.JButton jBtnCancelarFor;
    private javax.swing.JButton jBtnCancelarPro;
    private javax.swing.JButton jBtnEditarCli;
    private javax.swing.JButton jBtnEditarFor;
    private javax.swing.JButton jBtnEditarPro;
    private javax.swing.JButton jBtnExcluirCli;
    private javax.swing.JButton jBtnExcluirPro;
    private javax.swing.JButton jBtnExluirFor;
    private javax.swing.JButton jBtnNovoCli;
    private javax.swing.JButton jBtnNovoFor;
    private javax.swing.JButton jBtnNovoPro;
    private javax.swing.JButton jBtnSalvarCli;
    private javax.swing.JButton jBtnSalvarFor;
    private javax.swing.JButton jBtnSalvarPro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTaEnderecoCli;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTbCli;
    private javax.swing.JTable jTbFor;
    private javax.swing.JTable jTbPro;
    private javax.swing.JTextField jTfCodigoCli;
    private javax.swing.JTextField jTfCodigoFor;
    private javax.swing.JTextField jTfCodigoPro;
    private javax.swing.JTextField jTfContatoFor;
    private javax.swing.JTextField jTfDescricaoPro;
    private javax.swing.JTextField jTfEmailCli;
    private javax.swing.JTextField jTfEmailFor;
    private javax.swing.JTextField jTfEmpresaFor;
    private javax.swing.JTextField jTfNomeCli;
    private javax.swing.JTextField jTfPrecoPro;
    private javax.swing.JTextField jTfQuantidadePro;
    private javax.swing.JTextField jTfTelefoneCli;
    private javax.swing.JTextField jTfTelefoneFor;
    private javax.swing.JTextField jTfUnidadePro;
    // End of variables declaration//GEN-END:variables
// </editor-fold>
}
