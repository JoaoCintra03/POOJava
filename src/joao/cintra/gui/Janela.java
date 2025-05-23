package joao.cintra.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Janela extends JFrame {

    private final JLabel jlNome;
    private final JTextField tfNome;
    private final JLabel jlSobrenome;
    private final JTextField tfSobrenome;
    private JButton btConfirmar;

    public Janela(){
        setTitle("Cadastro de aluno");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        var jPanel = new JPanel(new GridBagLayout());

        jlNome = new JLabel("Nome");
        jPanel.add(jlNome, montarConstrainsts(0,0 ));
        tfNome = new JTextField(20);
        jPanel.add(tfNome,montarConstrainsts(1, 0));

        jlSobrenome = new JLabel("Sobrenome");
        jPanel.add(jlSobrenome, montarConstrainsts(0,1));
        tfSobrenome = new JTextField(20);
        jPanel.add(tfSobrenome,montarConstrainsts(1, 1));

        btConfirmar = new JButton("Confirmar");
        btConfirmar.addActionListener(e -> confirmar(e));
        jPanel.add(btConfirmar,montarConstrainsts(0,2));

        add(jPanel);
    }

    private Boolean isBlank(JTextField campo, String mensagem) {
        if (tfNome.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Informe o nome");
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private void confirmar(ActionEvent event) {

        if (isBlank(tfNome, "Informe seu nome")) return;
        if (isBlank(tfSobrenome, "Informe seu Sobrenome")) return;


        System.out.println("Salvando no banco de dados");
        System.out.println("Nome: " + tfNome.getText());
        System.out.println("Sobrenome: " + tfSobrenome.getText());
    }

    private GridBagConstraints montarConstrainsts(int x, int y){
        var constraint = new GridBagConstraints();
        constraint.insets = new Insets(5, 5, 5, 5);
        constraint.gridx = x;
        constraint.gridy = y;
        return constraint;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var janela = new Janela();
            janela.setVisible(true);
        });

    }

}
