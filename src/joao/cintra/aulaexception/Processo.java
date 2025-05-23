package joao.cintra.aulaexception;

import java.util.Scanner;

public class Processo {
    private Scanner scanner;

    public Processo(Scanner scanner) {
        this.scanner = scanner;
    }
    public int lerNumero() throws RuntimeException {
        int numero = scanner.nextInt();

        if (numero > 9999) {
            throw new RuntimeException(" Numero tem que ser de 4 digitos");
        }

        return numero;
    }
}
