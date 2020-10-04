package Components;

import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import Exceptions.*;
import Enums.*;

public class Titulo implements IConsulta {
    private double debito = 0;
    private LocalDate dataVencimento;
    private double multa;
    private double juros;
    private Situacao situacao;

    // Formato de data personalizado.
    DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    // Limitador de casas decimais (2 unidades).
    DecimalFormat formatoDouble = new DecimalFormat("#.00");

    // Construtor de um titulo.
    public Titulo(double debito, String dataVencimento) throws ParseException, SituacaoException {
        this.debito = debito;
        this.dataVencimento = dateFormatter(dataVencimento);
        this.multa = calculaMulta(debito);
        this.juros = calculaJuros(debito);
        this.situacao = defineSituação();
        this.debito += multa + juros;
    }

    // formata a data e converte em localDate
    private LocalDate dateFormatter(String date) throws ParseException {
        LocalDate dataConvertida = LocalDate.parse(date, formatoData);
        return dataConvertida;
    }

    // calcula a multa fixa
    private double calculaMulta(double debito) {
        return debito * 0.10;
    }

    // calcula os juros utilizando a diferença de meses entre datas
    private double calculaJuros(double debito) {
        LocalDate dataAtual = LocalDate.now();
        double meses = ChronoUnit.MONTHS.between(this.dataVencimento, dataAtual);
        double total = debito;
        for (int i = 0; i < meses; i++) {
            total += (total * 0.02);
        }

        return total - debito;
    }

    // Define a situação do cliente
    private Situacao defineSituação() throws SituacaoException {

        LocalDate dataAtual = LocalDate.now();
        double dias = ChronoUnit.DAYS.between(this.dataVencimento, dataAtual);
        if (dias >= 45) {
            return Situacao.PROT;
        } else if (dias >= 30) {
            return Situacao.AVISO2;
        } else if (dias >= 15) {
            return Situacao.AVISO;
        }
        throw new SituacaoException("Data fornecida não implica necessidade de aviso");
    }

    // consulta titulo, usa interface Consulta
    @Override
    public String consultaTitulo() {
        return "Valor total do débito: " + formatoDouble.format(getDebito())
        + "\n" + "Data de vencimento: " 
        + getDataVencimento().format(formatoData) + "\n" + "Multa: " + formatoDouble.format(getMulta()) + "\n"
        + "Juros: " + formatoDouble.format(getJuros()) + "\n" + "Valor inicial: "
        + formatoDouble.format((getDebito() - getJuros()) - getMulta()) + "\n" + "Situação da cobrança: "
        + getSituacao();
    }

    // Utiliza interface Consulta
    @Override
    public String relacaoDebito() {
        return "Valor do débito: " + formatoDouble.format(getDebito()) + "| Data de vencimento: " + getDataVencimento().format(formatoData) + "|";
    }

    // movimentação-baixa de titulo
    public double movimentacaoTitulo(double quantia) {
        this.debito = this.debito - quantia;
        return debito;
    }

    // alterar titulo, validação na tela principal
    public String alteraTitulo(double novoDebito, String novaData) throws ParseException {
        this.multa = calculaMulta(novoDebito);
        this.juros = calculaJuros(novoDebito);
        this.debito = novoDebito + multa + juros;
        this.dataVencimento = dateFormatter(novaData);
        return consultaTitulo();
    }

    // sobrecarga de altera titulo
    public String alteraTitulo(double novoDebito) {
        this.multa = calculaMulta(novoDebito);
        this.juros = calculaJuros(novoDebito);
        this.debito = novoDebito + multa + juros;
        return consultaTitulo();
    }

    // sobrecarga de altera titulo
    public String alteraTitulo(String novaData) throws ParseException {
        this.dataVencimento = dateFormatter(novaData);
        return consultaTitulo();
    }

    // getters
    public double getDebito() {
        return debito;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    private double getMulta() {
        return multa;
    }

    private double getJuros() {
        return juros;
    }

    public String getSituacao() {
        return situacao.getAviso();
    }

    // utiliza interface consulta.
    @Override
    public String getSituacaoCodigo() {
        return situacao.getCodigo();
    }
}