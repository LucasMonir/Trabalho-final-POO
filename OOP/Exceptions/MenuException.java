package Exceptions;

public class MenuException extends Exception {

    private static final long serialVersionUID = 6905488159387204403L;

    // Informa problema com o menu
    public MenuException(String message) {
        super(message);
    }
}