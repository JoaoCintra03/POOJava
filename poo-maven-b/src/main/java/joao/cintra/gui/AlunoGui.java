package joao.cintra.gui;

import joao.cintra.model.Aluno;
import joao.cintra.service.AlunoService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AlunoGui  extends JFrame {

    private JTextField tfId;

    private JTextField tfNome;

    private JTextField tfCpf;

    private JTextField tfEndereco;

    private JButton btConfirmar;
    private Long rs;

    public AlunoGui() {
        this.btConfirmar = btConfirmar;
        setTitle("Cadastro de Aluno");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().add(montarPainelEntrada(), BorderLayout.NORTH);
        getContentPane().add(montarPainelSaida(), BorderLayout.CENTER);
    }


    private JPanel montarPainelEntrada() {
        var jPanel = new JPanel(new GridBagLayout());
        var guiUtils = new GuiUtils();

        JLabel jlId = new JLabel("RA");
        tfId = new JTextField(20);
        tfId.setEditable(false);
        JLabel jlNome = new JLabel("Nome");
        tfNome = new JTextField(20);
        JLabel jlCpf = new JLabel("Cpf");
        tfCpf = new JTextField(20);
        JLabel jlEndereco = new JLabel("Endereço");
        tfEndereco = new JTextField(20);

        btConfirmar = new JButton("Confirmar");
        btConfirmar.addActionListener(this::setBtConfirmar);

        jPanel.add(jlId, guiUtils.montarConstraints(0, 0));
        jPanel.add(tfId, guiUtils.montarConstraints(1, 0));
        jPanel.add(jlNome, guiUtils.montarConstraints(0, 1));
        jPanel.add(tfNome, guiUtils.montarConstraints(1, 1));
        jPanel.add(jlCpf, guiUtils.montarConstraints(0, 2));
        jPanel.add(tfCpf, guiUtils.montarConstraints(1, 2));
        jPanel.add(jlEndereco, guiUtils.montarConstraints(0, 3));
        jPanel.add(tfEndereco, guiUtils.montarConstraints(1, 3));
        jPanel.add(btConfirmar, guiUtils.montarConstraints(0, 4));

        return jPanel;
    }

    private void setBtConfirmar(ActionEvent event) {
        var aluno = new Aluno(rs.getLong("id"), rs.getLong("Nome"), rs.getLong("Cpf"), rs.getLong("Endereço"));
        aluno.setId(tfId.getText().isEmpty() ? null : Long.valueOf(tfId.getText()));
        aluno.setNome(tfNome.getText());
        aluno.setCpf(tfCpf.getText());
        aluno.setEndereco(tfEndereco.getText());

        var servico = new AlunoService();
        servico.salvar((aluno));

        limparCampos();
    }

    private void limparCampos() {
        tfId.setText(null);
        tfNome.setText(null);
        tfCpf.setText(null);
        tfEndereco.setText(null);
    }

    private JScrollPane montarPainelSaida(){
        var tableModel = new DefaultTableModel();
        tableModel.addColumn("RA");
        tableModel.addColumn("Nome");
        tableModel.addColumn("Cpf");
        tableModel.addColumn("Endereço");

        var jPanel = new JPanel();
        JTable tbAlunos = new JTable();
        tbAlunos.setDefaultEditor(Object.class, null);
        tbAlunos.getSelectionModel().addListSelectionListener(this::selecionar);

        var service = new AlunoService();
        service.listarTodos().forEach(aluno ->
        tableModel.addRow(new Object[]{aluno.getId(), aluno.getNome(), aluno.getCpf(), aluno.getEndereco()}));

        tbAlunos.setModel(tableModel);

        jPanel.add(new JScrollPane(tbAlunos));

        return new JScrollPane(tbAlunos);

    }

    private void selecionar(ListSelectionEvent listSelectionEvent) {

    }

}