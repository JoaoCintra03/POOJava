package joao.cintra.aulainterface;

public class Teclado implements Usb{

    @Override
    public void conectar() {
        System.out.println("Teclado conectado");
    }
}
