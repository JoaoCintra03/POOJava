package joao.cintra.aulaexception;

import java.util.Scanner;

public class Main {
    private static final int NUM_INICIO = 0;
    private static final int NUM_FIM = 10;


    private Scanner scanner;
    private int[] numeros;

public Main(Scanner scanner, int[] numeros) {
    this.scanner = scanner;
    this.numeros = numeros;
    }

    public static void main(String[] args){
      var main = new Main(new Scanner(System.in), new int[10]);

      for (int i = 0; i < 10; i++) {
          System.out.println("Informe um número");
          main.adicionarNumero(i);
       }

         main.imprimirNumeros();
    }

    private void adicionarNumero(int index){
        try {
           var processo = new Processo(scanner);
           numeros[index] = processo.lerNumero();
        } catch (Exception e){
           System.out.println("Valor inválido!" + e.getLocalizedMessage());
           scanner.nextLine();
         }
    }

   private void imprimirNumeros(){
    var  mensagem = "Os números foram:";
       for (int i = NUM_INICIO; i < NUM_FIM; i++) {
           mensagem = mensagem + " " + numeros[i];
       }
       System.out.println(mensagem);
   }
}
