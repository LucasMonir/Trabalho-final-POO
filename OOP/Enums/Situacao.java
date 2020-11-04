package Enums;

public enum Situacao {

    AVISO("1", "Primeiro aviso: 15 dias de atraso"), 
    AVISO2("2", "Segundo aviso: 30 dias de atraso"),
    PROT("3", "45 dias de atraso-Protesto em cartório");

    private String codigo;
    private String aviso;

    private Situacao(String codigo, String aviso) {
        this.aviso = aviso;
        this.codigo = codigo;
    }

    public String getAviso() {
        return aviso;
    }

    public String getCodigo() {
        return codigo;
    }
}