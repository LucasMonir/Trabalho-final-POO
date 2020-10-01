package Componentes;

public class Mes {
    private double inadimplencia = 0;
    private String nome = null;
    private int numero = 0;

    public Mes(String nome, double inadimplencia, int numero) {
        setInadimplencia(inadimplencia);
        setNome(nome);
        setNumero(numero);
    }

    public double getInadimplencia() {
        return inadimplencia;
    }

    private void setInadimplencia(double inadimplencia) {
        this.inadimplencia = inadimplencia;
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    private void setNumero(int numero) {
        this.numero = numero;
    }

    public void addInadimplencia(double inadimplencia) {
        this.inadimplencia += inadimplencia;
    }

}