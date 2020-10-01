package Exceptions;

public class SituacaoException extends Exception {

    private static final long serialVersionUID = 7468520558094687607L;

    // Erro personalizado para caso a data informada não implique em débito
    public SituacaoException(String message) {
        super(message);
    }
}
