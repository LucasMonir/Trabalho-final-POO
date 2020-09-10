package Exceptions;

public class ListaException extends Exception{

    private static final long serialVersionUID = 3400461951244474864L;
    
    //erro para indicar problemas com a lista
    //utiliza herança da classe Exception
    public ListaException(String message) {
        super(message);
    }
}