package joao.cintra.gui;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Janela extends JFrame {

    private JLabel jlNome;
    private JTextField tfNome;
    private JLabel jlSobrenome;
    private JTextField tfSobrenome;
    private JLabel jlEndereco;
    private JTextField tfEndereco;
    private JButton btConfirmar;
    private JButton btListar;

    public Janela() {
        setTitle("Cadastro de Aluno");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        var jPanel = new JPanel(new GridBagLayout());

        jlNome = new JLabel("Nome");
        jPanel.add(jlNome, montarConstraints(0, 0));
        tfNome = new JTextField(20);
        jPanel.add(tfNome, montarConstraints(1, 0));

        jlSobrenome= new JLabel("Sobrenome");
        jPanel.add(jlSobrenome, montarConstraints(0, 1));
        tfSobrenome = new JTextField(20);
        jPanel.add(tfSobrenome, montarConstraints(1, 1));

        jlEndereco= new JLabel("Endereço");
        jPanel.add(jlEndereco, montarConstraints(0, 2));
        tfEndereco = new JTextField(20);
        jPanel.add(tfEndereco, montarConstraints(1, 2));


        btConfirmar = new JButton("Confirmar");
        btConfirmar.addActionListener(e -> confirmar(e));
        jPanel.add(btConfirmar, montarConstraints(0, 3));

        btListar = new JButton("Listar Registros");
        btListar.addActionListener(this::listarRegistros);
        jPanel.add(btListar, montarConstraints(1, 3));

        add(jPanel);
    }

    private void listarRegistros(ActionEvent event) {
        var arquivo = new File(
                System.getProperty("user.dir"),
                "\\arquivo.txt");
        var registros = readerFile(arquivo.toString());

        var message = "";
        for (String registro: registros){
            message = message + "\n" + registro;
        }

        JOptionPane.showMessageDialog(this, message);
    }

    private Boolean isBlank(JTextField campo, String mensagem) {
        if (campo.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, mensagem);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private void confirmar(ActionEvent event) {
        if (isBlank(tfNome, "Informe o Nome!")) return;
        if (isBlank(tfSobrenome, "Informe o Sobrenome!")) return;
        if (isBlank(tfEndereco, "Informe o Endereço!")) return;

        System.out.println("Salvando no Arquivo.txt");

        var texto = " Nome: " + tfNome.getText() +
                " Sobrenome: " + tfSobrenome.getText() + " Endereço " + tfEndereco.getText();

        writerFile(texto, new File(
                System.getProperty("user.dir"),
                "\\arquivo.txt")
                .toString());

        JOptionPane.showMessageDialog(this, "Registro feito com sucesso");
    }

    private GridBagConstraints montarConstraints(int x, int y) {
        var constraint = new GridBagConstraints();
        constraint.insets = new Insets(5, 5, 5, 5);
        constraint.gridx = x;
        constraint.gridy = y;
        return constraint;
    }

    private void writerFile(String conteudo, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.newLine();
            writer.write(conteudo);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<String> readerFile(String nomeArquivo) {
        List<String> registros = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new FileReader(nomeArquivo))) {
            reader.lines().forEach(registros::add);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return registros;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var janela = new Janela();
            janela.setVisible(true);
        });
    }
}
