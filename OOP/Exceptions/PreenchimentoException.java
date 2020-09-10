package Exceptions;

public class PreenchimentoException extends Exception{
    
    private static final long serialVersionUID = -977295337367476951L;

    //Informa problema com preenchimento de dados
    //utiliza herança da classe Exception
    public PreenchimentoException(String message) {
        super(message);
    }
}