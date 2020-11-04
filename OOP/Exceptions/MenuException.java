package Exceptions;

public class MenuException extends Exception {

    private static final long serialVersionUID = 6905488159387204403L;

    // Informa problema com o menu
    // utiliza herança da classe Exception
    public MenuException(String message) {
        super(message);
    }
}