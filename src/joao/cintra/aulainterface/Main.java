package joao.cintra.aulainterface;

public class Main {

    public static void main(String[] args) {
        System.out.println("Aula Interfaces");

        var computador = new Computador();
        var teclado = new Teclado();
        var mouse = new Mouse();
        computador.plugar(teclado);
        computador.plugar(mouse);
        teclado.desconectar("Teclado desconectado");
        mouse.desconectar("Mouse desconecado");

        var casa = new Casa();
        var geladeira = new Geladeira();
        var televisao = new Televisao();
        casa.colocarTomada(geladeira);
        casa.colocarTomada(televisao);
    }

}