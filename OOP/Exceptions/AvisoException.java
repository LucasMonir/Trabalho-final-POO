package Exceptions;

public class AvisoException extends Exception {

    private static final long serialVersionUID = 115002192467137713L;

    // Erro personalizado para caso de problema com avisos
    public AvisoException(String message) {
        super(message);
    }
}