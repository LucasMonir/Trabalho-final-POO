import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import Exceptions.*;

public class Relatorios {
    // Formatador para manter debito com 2 casas decimais
    static DecimalFormat formatoDouble = new DecimalFormat("#0.00");

    // Clientes em debito
    public static String relatorioClientesEmDebito(Set<Cliente> listaClientes) {
        String clientesDebito = "________________________________ \n" + "|XYZ COMÉRCIO DE PRODUTOS LTDA.| \n|"
                + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + " |Clientes em débito: \n________________________________________________________________________________ \n";

        for (Cliente cliente : listaClientes) {
            clientesDebito += cliente.relacaoDebito()
                    + "\n================================================================================\n";
        }
        return clientesDebito;
    }

    // relatório de inadimplência
    public static String relatorioInadimplencia(Set<Cliente> listaClientes) {
        List<Mes> listaMeses = new ArrayList<Mes>();
        addMeses(listaMeses);
        for (Cliente cliente : listaClientes) {
            for (Mes mes : listaMeses) {
                if (cliente.getTitulo().getDataVencimento().getMonthValue() == mes.getNumero()) {
                    mes.addInadimplencia(cliente.getDebito());
                }
            }
        }
        return balancoToString(listaMeses) + "\n" + maioresDevedores(listaClientes); // add os 10 maiores devedores
    }

    // metodo para devolver inadimplencia em String
    private static String balancoToString(List<Mes> listaMeses) {
        String balanco = "________________________________ \n" + "|XYZ COMÉRCIO DE PRODUTOS LTDA.| \n|"
                + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy"))
                + " |Balanco de inadimplência: \n________________________________________________________________________________ \n";
        double mediaMeses = 0;
        for (Mes mes : listaMeses) {
            balanco += mes.getNome() + ": " + formatoDouble.format(mes.getInadimplencia())
                + " R$ \n================================================================================\n";
            mediaMeses += mes.getInadimplencia();
        }
        return balanco + "________________________________________________________________________________ \n"
            + "MEDIA MENSAL: " + formatoDouble.format(mediaMeses / 12)
            + "\n________________________________________________________________________________ ";
    }

    // calcula os 10 maiores devedores
    public static String maioresDevedores(Set<Cliente> listaClientes) {
        List<Cliente> devedores = new ArrayList<Cliente>();

        for (Cliente cliente : listaClientes) {
            devedores.add(cliente);
        }

        Collections.sort(devedores, comparador);
        String devedoresString = "________________________________ \n" + "|XYZ COMÉRCIO DE PRODUTOS LTDA.|\n|"
                + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "|10 MAIORES DEVEDORES:"
                + "\n================================================================================\n";
        
                int counter = devedores.size();
        if (counter < 10) {
            for (int i = 1; i <= counter; i++) {
                Cliente devedor = devedores.get(i - 1);
                devedoresString += (i) + " - " + devedor.getNome() + ": " + formatoDouble.format(devedor.getDebito())
                    + " R$"
                    + " \n________________________________________________________________________________ \n";
            }
        } else {
            for (int i = 1; i <= 10; i++) {
                Cliente devedor = devedores.get(i - 1);
                devedoresString += (i) + "-" + devedor.getNome() + ": " + formatoDouble.format(devedor.getDebito())
                    + " R$"
                    + "\n________________________________________________________________________________ \n";
            }
        }
        return devedoresString;
    }

    // Metodo para retornar avisos baseados no cliente solicitado
    public static String emiteAviso(Cliente cliente) throws AvisoException {
        String situacao = cliente.getSituacaoCodigo();
        switch (situacao) {
            case "1":
                String aviso = "1º AVISO AO SACADO";
                return situacaoToString(cliente, aviso);
            case "2":
                aviso = "2º AVISO AO SACADO";
                return situacaoToString(cliente, aviso);
            case "3":
                aviso = "PROTESTO EM CARTÓRIO";
                return situacaoToString(cliente, aviso);
        }
        throw new AvisoException("Erro ao gerar aviso, confirme informações do cliente.");
    }

    // Salva em arquivo TXT no diretorio especificado
    public static String salvar(Set<Cliente> listaClientes) {
        try {
            String date = new SimpleDateFormat("yyy-MM-dd-HH-mm-ssSS").format(new Date());
            FileWriter escritor = new FileWriter("C:\\Windows\\Temp\\Log-" + date + ".txt"); // diretório especificado
            String dadosSalvos = "DADOS SALVOS:" + date;
            for (Cliente cliente : listaClientes) {
                dadosSalvos += " \n----------------------------------------- \n" + cliente.consultaTitulo() + "\n";
            }
            escritor.write(dadosSalvos);
            escritor.close();
            return "Salvo com sucesso!";
        } catch (IOException e) {
            return "Problema ao criar arquivo ou diretório, (stackTrace:" + e.getStackTrace() + ")";
        }
    }

    // Criação de um criterio de comparação, utiliza o valor dos debitos passados
    // para strings
    private static Comparator<Cliente> comparador = new Comparator<Cliente>() {

        public int compare(Cliente c1, Cliente c2) {

            String db1 = String.valueOf(c1.getDebito());
            String db2 = String.valueOf(c2.getDebito());

            return db2.compareTo(db1);
        }
    };

    // metodo para fornecer meses a lista de meses e limpar a lista para garantir
    // não duplicidade
    private static void addMeses(List<Mes> listaMeses) {
        listaMeses.clear();
        listaMeses.add(new Mes("Janeiro", 0, 1));
        listaMeses.add(new Mes("Fevereiro", 0, 2));
        listaMeses.add(new Mes("Março", 0, 3));
        listaMeses.add(new Mes("Abril", 0, 4));
        listaMeses.add(new Mes("Maio", 0, 5));
        listaMeses.add(new Mes("Junho", 0, 6));
        listaMeses.add(new Mes("Julho", 0, 7));
        listaMeses.add(new Mes("Agosto", 0, 8));
        listaMeses.add(new Mes("Setembro", 0, 9));
        listaMeses.add(new Mes("Outubro", 0, 10));
        listaMeses.add(new Mes("Novembro", 0, 11));
        listaMeses.add(new Mes("Dezembro", 0, 12));
    }

    // emite aviso com base na situação do cliente
    public static String situacaoToString(Cliente cliente, String aviso) {
        return "________________________________ \n" + "|XYZ COMÉRCIO DE PRODUTOS LTDA.|\n|" + aviso + "|\n \n"
            + "Caro Sr(a) " + cliente.getNome() + ": \n \n" + "O Sr. Nos deve a quantia de R$ "
            + formatoDouble.format(cliente.getDebito())
            + ", favor comparecer ao nosso setor de cobrança o mais breve possivel, sob pena de protesto do titulo em cartório \n \n"
            + "Atenciosamente, \n" + "_________________________\n" + "João da Silva Santos Oliveira Junior \n"
            + "Chefe do Setor de Cobrança.";
    }
}