
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author julio_busarello
 */
public class Main {

    public static void main(String[] args) {
        // Deixar bonito
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

        } catch (UnsupportedLookAndFeelException exc) {
            exc.printStackTrace();
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        } catch (InstantiationException exc) {
            exc.printStackTrace();
        } catch (IllegalAccessException exc) {
            exc.printStackTrace();
        }

        // ----- Janela
        JFrame form = new JFrame();

        form.setSize(300, 470);
        form.setTitle("Calculadora");
        form.setLayout(null);
        form.setLocationRelativeTo(null);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ----- Caixas de Texto
        JTextField texto = new JTextField();

        texto.setBounds(20, 25, 250, 80);

        form.add(texto);

        // ----- Botoes
        // C
        JButton clear = new JButton("C");

        clear.setBounds(20, 120, 50, 50);
        
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText("");
            }
        });

        // <
        JButton erase = new JButton("<");

        erase.setBounds(85, 120, 50, 50);
        
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText("");
            }
        });

        // (
        JButton colchete1 = new JButton("(");

        colchete1.setBounds(150, 120, 50, 50);
        
        colchete1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText()+"(");
            }
        });

        // )
        JButton colchete2 = new JButton(")");

        colchete2.setBounds(215, 120, 50, 50);
        
        colchete2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText()+")");
            }
        });
        
        // 1
        JButton um = new JButton("1");

        um.setBounds(20, 300, 50, 50);
        
        um.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText() + 1);
            }
        });

        // 2
        JButton dois = new JButton("2");

        dois.setBounds(85, 300, 50, 50);
        
        dois.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText() + 2);
            }
        });

        // 3
        JButton tres = new JButton("3");

        tres.setBounds(150, 300, 50, 50);
        
        tres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText() + 3);
            }
        });
        
        // 4
        JButton quatro = new JButton("4");

        quatro.setBounds(20, 240, 50, 50);
        
        quatro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText() + 4);
            }
        });

        // 5
        JButton cinco = new JButton("5");

        cinco.setBounds(85, 240, 50, 50);
        
        cinco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText() + 5);
            }
        });

        // 6
        JButton seis = new JButton("6");

        seis.setBounds(150, 240, 50, 50);
        
        seis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText() + 6);
            }
        });

        // 7
        JButton sete = new JButton("7");

        sete.setBounds(20, 180, 50, 50);
        
        sete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText() + 7);
            }
        });

        // 8
        JButton oito = new JButton("8");

        oito.setBounds(85, 180, 50, 50);
        
        oito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText() + 8);
            }
        });

        // 9
        JButton nove = new JButton("9");

        nove.setBounds(150, 180, 50, 50);
        
        nove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText() + 9);
            }
        });
        
        // 0
        JButton zero = new JButton("0");

        zero.setBounds(20, 360, 50, 50);
        
        zero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText() + 0);
            }
        });

        // /
        JButton dividido = new JButton("/");

        dividido.setBounds(215, 180, 50, 50);
        
        dividido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText()+"/");
            }
        });

        // X
        JButton multiplicacao = new JButton("X");

        multiplicacao.setBounds(215, 240, 50, 50);
        
        multiplicacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText()+"x");
            }
        });

        // -
        JButton menos = new JButton("-");

        menos.setBounds(215, 300, 50, 50);
        
        menos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText()+"-");
            }
        });

        // .
        JButton ponto = new JButton(".");

        ponto.setBounds(85, 360, 50, 50);
        
        ponto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText()+".");
            }
        });

        // =
        JButton igual = new JButton("=");

        igual.setBounds(150, 360, 50, 50);

        igual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String exp = texto.getText();

                System.out.println(">>>" + exp);
                Calculadora calculo = new Calculadora();
                String resultado = calculo.evalExp(exp);
            }
        });

        // +
        JButton mais = new JButton("+");

        mais.setBounds(215, 360, 50, 50);
        
        mais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText()+"+");
            }
        });

        // Adicionar os botoes ao form
        form.add(clear);
        form.add(erase);
        form.add(colchete1);
        form.add(colchete2);
        form.add(sete);
        form.add(oito);
        form.add(nove);
        form.add(dividido);
        form.add(quatro);
        form.add(cinco);
        form.add(seis);
        form.add(multiplicacao);
        form.add(um);
        form.add(dois);
        form.add(tres);
        form.add(menos);
        form.add(zero);
        form.add(ponto);
        form.add(igual);
        form.add(mais);
        // Acao Botao Igual

        // Deixar visivel
        form.setVisible(true);
    }

}
