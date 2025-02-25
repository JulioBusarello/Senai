import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class S7AppSwing extends JFrame {

    public byte[] indxColorBlk = new byte[28];
    public Integer indxExpedition;
    public PlcConnector plcStock;
    public PlcConnector plcExpedition;
    public JPanel pnlBlkEst;
    public JPanel pnlExp;
    private boolean leituraCiclica = false;

    public S7AppSwing() {
        setTitle("Leitura e Escrita de TAGs no CLP - Protocolo S7");
        setSize(850, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel labelIp = new JLabel("Ip Host:");
        labelIp.setBounds(50, 10, 100, 30);
        add(labelIp);

        JTextField textIp = new JTextField("10.74.241.10");
        textIp.setBounds(150, 10, 200, 30);
        add(textIp);

        JLabel labelDB = new JLabel("DB:");
        labelDB.setBounds(50, 50, 100, 30);
        add(labelDB);

        JTextField textDB = new JTextField("6");
        textDB.setBounds(150, 50, 200, 30);
        add(textDB);

        JLabel labelType = new JLabel("Tipo:");
        labelType.setBounds(50, 100, 100, 30);
        add(labelType);

        JComboBox<String> comboType = new JComboBox<>(
                new String[] { "String", "Block", "Integer", "Float", "Byte", "Boolean" });
        comboType.setBounds(150, 100, 200, 30);
        add(comboType);

        JLabel labelOffset = new JLabel("Offset:");
        labelOffset.setBounds(50, 150, 100, 30);
        add(labelOffset);

        JTextField textOffset = new JTextField("16");
        textOffset.setBounds(150, 150, 200, 30);
        add(textOffset);

        JLabel labelBitNumber = new JLabel("Bit Number:");
        labelBitNumber.setBounds(50, 200, 100, 30);
        add(labelBitNumber);

        JTextField textBitNumber = new JTextField("0");
        textBitNumber.setBounds(150, 200, 200, 30);
        add(textBitNumber);

        JLabel labelSize = new JLabel("Tamanho");
        labelSize.setBounds(50, 250, 100, 30);
        add(labelSize);

        JTextField textSize = new JTextField("14");
        textSize.setBounds(150, 250, 200, 30);
        add(textSize);

        comboType.addActionListener((ActionEvent e) -> {
            String selectedItem = (String) comboType.getSelectedItem();
            switch (selectedItem) {
                case "Boolean" -> textSize.setText("1");
                case "Byte" -> {
                    textSize.setText("1");
                    textBitNumber.setText("0");
                }
                case "Integer" -> {
                    textSize.setText("2");
                    textBitNumber.setText("0");
                }
                case "Float" -> {
                    textSize.setText("4");
                    textBitNumber.setText("0");
                }
                case "String" -> textBitNumber.setText("0");
            }
        });

        JButton buttonRead = new JButton("Ler TAG");
        buttonRead.setBounds(150, 300, 200, 30);
        add(buttonRead);

        JLabel labelValueRead = new JLabel("Valor lido:");
        labelValueRead.setBounds(50, 350, 200, 30);
        add(labelValueRead);

        JTextField textValue = new JTextField();
        textValue.setBounds(150, 350, 200, 30);
        textValue.setEditable(false);
        add(textValue);

        JButton buttonWrite = new JButton("Escrever TAG");
        buttonWrite.setBounds(150, 400, 200, 30);
        add(buttonWrite);

        JLabel labelValue = new JLabel("Valor Escrito: ");
        labelValue.setBounds(50, 450, 100, 30);
        add(labelValue);

        JTextField textValueWrite = new JTextField();
        textValueWrite.setBounds(150, 450, 200, 30);
        add(textValueWrite);

        JButton buttonLeituras = new JButton("Ativar Leitura Cíclica");
        buttonLeituras.setBounds(150, 500, 200, 30);
        add(buttonLeituras);

        buttonLeituras.addActionListener((ActionEvent e) -> {
            if (leituraCiclica) {
                leituraCiclica = false;
                buttonLeituras.setText("Ativar Leitura Cíclica");
            } else {
                leituraCiclica = true;
                buttonLeituras.setText("Desativar Leitura Cíclica");
            }
            updateTimer();
        });

        buttonRead.addActionListener((ActionEvent e) -> {
            try {
                int db = Integer.parseInt(textDB.getText());
                int offset = Integer.parseInt(textOffset.getText());
                int bitNumber = !textBitNumber.getText().equals("") ? Integer.parseInt(textBitNumber.getText()) : -1;
                int size = Integer.parseInt(textSize.getText());
                String type = (String) comboType.getSelectedItem();

                PlcConnector plc = new PlcConnector(textIp.getText().trim(), 102);
                plc.connect();

                switch (type.toLowerCase()) {
                    case "string" -> {
                        String str = plc.readString(db, offset, size);
                        textValue.setText(str);
                    }
                    case "block" -> {
                        String blk = bytesToHex(plc.readBlock(db, offset, size), size);
                        textValue.setText(blk);
                    }
                    case "float" -> {
                        float flt = plc.readFloat(db, offset);
                        textValue.setText(String.valueOf(flt));
                    }
                    case "integer" -> {
                        int val = plc.readInt(db, offset);
                        textValue.setText(String.valueOf(val));
                    }
                    case "byte" -> {
                        byte byt = plc.readByte(db, offset);
                        textValue.setText(String.valueOf(byt));
                    }
                    case "boolean" -> {
                        boolean bit = plc.readBit(db, offset, bitNumber);
                        textValue.setText(String.valueOf(bit));
                    }
                    default -> {

                    }
                }
                plc.disconnect();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        buttonWrite.addActionListener((ActionEvent e) -> {
            try {
                int db = Integer.parseInt(textDB.getText());
                int offset = Integer.parseInt(textOffset.getText());
                int bitNumber = !textBitNumber.getText().equals("") ? Integer.parseInt(textBitNumber.getText()) : -1;
                int size = Integer.parseInt(textSize.getText());
                String type = (String) comboType.getSelectedItem();

                PlcConnector plc = new PlcConnector(textIp.getText().trim(), 102);
                plc.connect();

                switch (type.toLowerCase()) {
                    case "string" -> {
                        if (plc.writeString(db, offset, size, textValueWrite.getText().trim())) {
                            System.out.println("Escrita no CLP realizada com sucesso!");
                        } else {
                            System.err.println("Erro de escrita no CLP!");
                        }
                    }
                    case "block" -> {
                        if (plc.writeBlock(db, offset, size,
                                PlcConnector.hexStringToByteArray(textValueWrite.getText().trim()))) {
                            System.out.println("Escrita no CLP realizada com sucesso!");
                        } else {
                            System.err.println("Erro de escrita no CLP!");
                        }
                    }
                    case "float" -> {
                        if (plc.writeFloat(db, offset, Float.parseFloat(textValueWrite.getText().trim()))) {
                            System.out.println("Escrita no CLP realizada com sucesso!");
                        } else {
                            System.err.println("Erro de escrita no CLP!");
                        }
                    }
                    case "integer" -> {
                        if (plc.writeInt(db, offset, Integer.parseInt(textValueWrite.getText().trim()))) {
                            System.out.println("Escrita no CLP realizada com sucesso!");
                        } else {
                            System.err.println("Erro de escrita no CLP!");
                        }
                    }
                    case "byte" -> {
                        if (plc.writeByte(db, offset, Byte.parseByte(textValueWrite.getText().trim()))) {
                            System.out.println("Escrita no CLP realizada com sucesso!");
                        } else {
                            System.err.println("Erro de escrita no CLP!");
                        }
                    }
                    case "boolean" -> {
                        if (plc.writeBit(db, offset, bitNumber,
                                Boolean.parseBoolean(textValueWrite.getText().trim()))) {
                            System.out.println("Escrita no CLP realizada com sucesso!");
                        } else {
                            System.err.println("Erro de escrita no CLP!");
                        }
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        pnlBlkEst = new JPanel();
        pnlBlkEst.setBounds(380, 10, 280, 235);
        pnlBlkEst.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        pnlBlkEst.setLayout(null);
        add(pnlBlkEst);

        JButton buttonUpdateStock = new JButton("Update");
        buttonUpdateStock.setBounds(380, 255, 280, 30);
        add(buttonUpdateStock);

        updateStock();

        buttonUpdateStock.addActionListener((ActionEvent e) -> {
            updateStock();
        });

        pnlExp = new JPanel();
        pnlExp.setBounds(380, 305, 370, 160);
        pnlExp.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        pnlExp.setLayout(null);
        add(pnlExp);

        updateExpedition();

        JButton buttonUpdateExp = new JButton("Update");
        buttonUpdateExp.setBounds(380, 475, 370, 30);
        add(buttonUpdateExp);

        buttonUpdateExp.addActionListener((ActionEvent e) -> {
            updateExpedition();
        });

    }

    private static String bytesToHex(byte[] bytes, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02X", bytes[i]));
        }
        return sb.toString().trim();
    }

    public static void updateTextField(int id, byte[] bytes) {

    }

    private static void extracted(int id, byte[] bytes) {

    }

    private void updateStock() {
        plcStock = new PlcConnector("10.74.241.10", 102);
        try {
            plcStock.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            indxColorBlk = plcStock.readBlock(9, 68, 28);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            // Criar matriz de JPanels 6x5 - 2
            pnlBlkEst.removeAll();
            int largura = 35;
            int altura = 35;
            int espaco = 10;

            for (int i = 0; i < 28; i++) {
                JLabel block = new JLabel("" + (i + 1), SwingConstants.CENTER);

                block.setSize(largura, altura);
                block.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                block.setOpaque(true);

                int x = (i % 6) * (largura + espaco);
                int y = (i / 6) * (altura + espaco);

                block.setLocation(x + 10, y + 10);

                switch (indxColorBlk[i]) {
                    case 0 -> {
                        block.setBackground(Color.WHITE);
                        block.setForeground(Color.BLACK);
                    }
                    case 1 -> {
                        block.setBackground(Color.BLACK);
                        block.setForeground(Color.WHITE);
                    }
                    case 2 -> {
                        block.setBackground(Color.RED);
                        block.setForeground(Color.WHITE);
                    }
                    case 3 -> {
                        block.setBackground(Color.BLUE);
                        block.setForeground(Color.WHITE);
                    }

                }

                pnlBlkEst.add(block);
                pnlBlkEst.revalidate();
                pnlBlkEst.repaint();
            }
        });
    }

    public void updateExpedition() {
        int returns[] = new int[12];
        plcExpedition = new PlcConnector("10.74.241.40", 102);
        try {
            plcExpedition.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            int j = 0;
            for (int i = 6; i <= 28; i += 2) {
                returns[j] = plcExpedition.readInt(9, i);
                j++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Falha no Read");
        }

        SwingUtilities.invokeLater(() -> {
            pnlExp.removeAll();
            int largura = 80;
            int altura = 40;
            int espaco = 10;

            for (int i = 0; i < 12; i++) {
                String formattedReturn;
                if (returns[i] == 0) {
                    formattedReturn = "____";
                } else {
                    formattedReturn = String.format("OP%04d", returns[i]);
                }
                JLabel label = new JLabel("P" + (i + 1) + "= [" + formattedReturn + "]", SwingConstants.CENTER);

                label.setSize(largura, altura);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                label.setOpaque(true);
                label.setForeground(Color.WHITE);
                label.setBackground(Color.DARK_GRAY);
                label.setFont(new Font("Arial", Font.PLAIN, 10));

                int x = (i % 4) * (largura + espaco);
                int y = (i / 4) * (altura + espaco);

                label.setLocation(x + 10, y + 10);

                pnlExp.add(label);
                pnlExp.revalidate();
                pnlExp.repaint();
            }
        });

    }

    public void updateTimer() {
        Thread thread = new Thread(() -> {
            while (leituraCiclica) {
                updateExpedition();
                updateStock();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(() -> {
            S7AppSwing app = new S7AppSwing();
            app.setVisible(true);
        });
    }
}
