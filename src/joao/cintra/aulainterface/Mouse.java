package joao.cintra.aulainterface;

public class Mouse  implements Usb{
    @Override
    public void conectar() {
        System.out.println("Mouse conectado");
    }
}
