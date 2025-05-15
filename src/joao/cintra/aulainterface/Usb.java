package joao.cintra.aulainterface;

public interface Usb {
    void conectar();

    default void desconectar(String aviso){
        System.out.println();
    }
}