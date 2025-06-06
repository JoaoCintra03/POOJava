package joao.cintra;

import joao.cintra.gui.AlunoGui;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::iniciar);

    }

    private static void iniciar() {
        var alunoGui = new AlunoGui();
        alunoGui.setVisible(true);
    }
}
