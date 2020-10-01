import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import Componentes.*;
import javax.swing.JOptionPane;

import Exceptions.*;

public class Apk {
    static DecimalFormat formatoDouble = new DecimalFormat("#0.00");
    private static Set<Cliente> listaClientes = new HashSet<Cliente>();

    public static void main(String[] args) {
        int op = 5;
        int subOp = 5;
        do {
            try {
                switch (op) {
                    case 5:
                        op = Integer.parseInt(JOptionPane.showInputDialog("XYZ COMERCIO DE PRODUTOS LTDA. \n" + "SISTEMA DE COBRANÇA \n \n"
                            + "MENU PRINCIPAL \n" + "1 -CADASTRO DE TÍTULOS \n" + "2 - BAIXA DE TÍTULOS \n"
                            + "3 - RELATÓRIOS \n" + "4 - SALVAR \n" + "0 - FINALIZAR \n" + "Opção:"));
                        break;

                    case 1:
                        do {
                            switch (subOp) {
                                case 5:
                                    subOp = Integer.parseInt(JOptionPane.showInputDialog("XYZ COMERCIO DE PRODUTOS LTDA. \n"
                                        + "SISTEMA DE COBRANÇA \n \n" + "CADASTRO DE TÍTULOS \n"
                                        + "1 - INCLUSÃO \n" + "2 - ALTERAÇÃO \n" + "3 - CONSULTA \n"
                                        + "4 - EXCLUSÃO \n" + "0 - RETORNAR \n" + "Opção:"));
                                    break;

                                case 1:
                                    incluir();
                                    subOp = 5;
                                    break;

                                case 2:
                                    alterar();
                                    subOp = 5;
                                    break;

                                case 3:
                                    consulta();
                                    subOp = 5;
                                    break;

                                case 4:
                                    exclusao();
                                    subOp = 5;
                                    break;

                                case 0:
                                    subOp = 6;
                                    break;

                                default:
                                    JOptionPane.showMessageDialog(null, "Opção inválida, voltando ao menu!", "Erro no menu", JOptionPane.ERROR_MESSAGE);
                                    subOp = 5;
                            }
                        } while (subOp != 6);
                        op = 5;
                        subOp = 5;
                        break;

                    case 2:
                        movimentacaoBaixa();
                        op = 5;
                        break;

                    case 3:
                        do {
                            switch (subOp) {
                                case 5:
                                    if (!listaClientes.isEmpty()) {
                                        subOp = Integer.parseInt(JOptionPane.showInputDialog("XYZ COMERCIO DE PRODUTOS LTDA. \n" + "SISTEMA DE COBRANÇA \n \n"
                                            + "RELATÓRIOS \n" + "1 - CLIENTES EM DÉBITO \n"
                                            + "2 - BALANÇO DE INADIMPLÊNCIA \n" + "3 - AVISOS AO CLIENTE \n"
                                            + "0 - RETORNAR \n" + "Opção:"));
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Lista se encontra vazia, retornando ao menu!", "Erro na lista", JOptionPane.ERROR_MESSAGE);
                                        subOp = 6;
                                    }
                                    break;

                                case 1:
                                    clientesEmDebito();
                                    subOp = 5;
                                    break;

                                case 2:
                                    relatorioInadimplencia();
                                    subOp = 5;
                                    break;

                                case 3:
                                    avisoCliente();
                                    subOp = 5;
                                    break;

                                case 0:
                                    subOp = 6;
                                    break;

                                default:
                                    JOptionPane.showMessageDialog(null, "Opção inválida, voltando ao menu!", "Erro no menu", JOptionPane.ERROR_MESSAGE);
                                    subOp = 4;

                            }

                        } while (subOp != 6);
                        op = 5;
                        break;

                    case 4:
                        salvar();
                        op = 5;
                        break;

                    case 0:
                        sair();
                        op = 6;
                        break;

                    default:
                        throw new MenuException("Opção inválida");
                }

            } catch (MenuException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro no menu", JOptionPane.ERROR_MESSAGE);
                op = 5;
                subOp = 5;
            } catch (ListaException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro relacionado a lista", JOptionPane.ERROR_MESSAGE);
                if (op == 2) {
                    op = 5;
                }
                subOp = 5;
            } catch (PreenchimentoException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro no preenchimento", JOptionPane.ERROR_MESSAGE);
                subOp = 5;
            } catch (SituacaoException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de enumeração", JOptionPane.ERROR_MESSAGE);
                subOp = 5;
            } catch (AvisoException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro na geração de aviso", JOptionPane.ERROR_MESSAGE);
                subOp = 5;
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de tipagem", JOptionPane.ERROR_MESSAGE);
                if (op == 2) {
                    op = 5;
                }
                subOp = 5;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida", "Erro", JOptionPane.ERROR_MESSAGE);
                if (op == 2) {
                    op = 5;
                }
                subOp = 5;
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Data inválida, voltando a tela inicial", "Erro de preenchimento de data", JOptionPane.ERROR_MESSAGE);
                subOp = 5;
            }
        } while (op != 6);
    }

    // metodos da tela 1.1 (Cadastro de título)

    // 1.1.1 Inclusão
    private static void incluir() throws ParseException, SituacaoException, PreenchimentoException, NumberFormatException {
        String nome = JOptionPane.showInputDialog("Nome do cliente:");
        int cpf = Integer.parseInt(JOptionPane.showInputDialog("Insira CPF do cliente:"));
        double debito = Double.parseDouble(JOptionPane.showInputDialog("Débito do cliente:"));
        String dataVencimento = JOptionPane.showInputDialog("Data de vencimento do titulo (dd/MM/yyyy):");

        String[] options = { "Sim", "Não" };
        int x = JOptionPane.showOptionDialog(null, "Confirmar inclusão? \n" + "Nome: " + nome + "\n" + "CPF: " + cpf + "\n" + "Débito: " + debito + "\n" + "Data de vencimento: " + dataVencimento, "ATENÇÃO", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (nulo(nome, cpf, debito, dataVencimento)) {
            throw new PreenchimentoException("Erro ao preencher titulo, voltando ao menu");
        } else {
            if (x == 0) {
                listaClientes.add(new Cliente(nome, cpf, new Titulo(debito, dataVencimento)));
            } else {
                JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário, voltando ao menu!", "Operação cancelada", JOptionPane.ERROR_MESSAGE);
            }
        }
        x = JOptionPane.showOptionDialog(null, "Nova inclusão?", "ATENÇÃO", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (x == 0) {
            incluir();
        }
    }

    // 1.1.2 Alteração
    private static void alterar() throws ParseException, ListaException {
        String[] options = { "Sim", "Não" };
        int x;
        boolean flag = false;
        if (listaClientes.isEmpty()) {
            int modo = 0;
            do {
                switch (modo) {
                    case 0:
                        modo = Integer.parseInt(JOptionPane.showInputDialog("1 - Alterar data de vencimento \n" + "2 - Alterar débito \n" + "3 - Alterar Ambos"));
                        break;

                    case 1:
                        int cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe CPF do cliente:"));
                        for (Cliente cliente : listaClientes) {
                            if (cliente.getCpf() == cpf) {
                                String novaData = JOptionPane.showInputDialog("Insira nova data de vencimento:");

                                x = JOptionPane.showOptionDialog(null, "Confirmar alteração de data? \n" + "Nova data: " + novaData, "ATENÇÃO", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                                flag = true;

                                if (x == 0) {
                                    cliente.getTitulo().alteraTitulo(novaData);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Alteração cancelada, voltando ao menu!", "Operação cancelada", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                        if (!flag) {
                            throw new ListaException("Cliente não encontrado, voltando ao menu principal!");
                        }
                        modo = 4;
                        break;

                    case 2:
                        flag = false;
                        cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe CPF do cliente:"));
                        for (Cliente cliente : listaClientes) {
                            if (cliente.getCpf() == cpf) {
                                double novoDebito = Double.parseDouble(JOptionPane.showInputDialog("Insira novo débito:"));

                                x = JOptionPane.showOptionDialog(null, "Confirmar alteração de débito?\n" + "Novo débito: " + novoDebito, "ATENÇÃO", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                                flag = true;

                                if (x == 0) {
                                    cliente.getTitulo().alteraTitulo(novoDebito);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Alteração cancelada, voltando ao menu!", "Operação cancelada", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                        if (!flag) {
                            throw new ListaException("Cliente não encontrado, voltando ao menu principal!");
                        }
                        modo = 4;
                        break;

                    case 3:
                        flag = false;
                        cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe CPF do cliente:"));
                        for (Cliente cliente : listaClientes) {
                            if (cliente.getCpf() == cpf) {
                                String novaData = JOptionPane.showInputDialog("Insira nova data de vencimento:");
                                double novoDebito = Double.parseDouble(JOptionPane.showInputDialog("Insira novo débito:"));

                                x = JOptionPane.showOptionDialog(null, "Confirmar alteração de data e débito?\n" + "Nova data: " + novaData + "\n" + "Novo débito: " + novoDebito, "ATENÇÃO", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                                flag = true;

                                if (x == 0) {
                                    cliente.getTitulo().alteraTitulo(novoDebito, novaData);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Alteração cancelada, voltando ao menu!", "Operação cancelada", JOptionPane.ERROR_MESSAGE);
                                }

                            }
                        }
                        if (!flag) {
                            throw new ListaException("Cliente não encontrado, voltando ao menu principal!");
                        }
                        modo = 4;
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida, retornando!", "Operação cancelada", JOptionPane.ERROR_MESSAGE);
                        modo = 0;
                }
            } while (modo != 4);
        } else {
            throw new ListaException("Não há clientes para alteração, voltando ao menu!");
        }
        x = JOptionPane.showOptionDialog(null, "Nova alteração?", "ATENÇÃO", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (x == 0) {
            alterar();
        }
    }

    // 1.1.3 consulta titulo
    private static void consulta() throws ListaException {
        boolean flag = false;
        if (!listaClientes.isEmpty()) {
            int cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe CPF do cliente:"));
            for (Cliente cliente : listaClientes) {
                if (cliente.getCpf() == cpf) {
                    JOptionPane.showMessageDialog(null, cliente.consultaTitulo());
                    flag = true;
                }
            }
        } else {
            throw new ListaException("Não há clientes para consulta, voltando ao menu!");
        }
        if (!flag) {
            throw new ListaException("Não há clientes para consulta, voltando ao menu!");
        }
        String[] options = { "Sim", "Não" };
        int x;
        x = JOptionPane.showOptionDialog(null, "Nova consulta?", "ATENÇÃO", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (x == 0) {
            consulta();
        }
    }

    // 1.1.4 Exclusão de titulo
    private static void exclusao() throws ListaException, IllegalStateException {
        boolean flag = false;
        String[] options = { "Sim", "Não" };
        int x;
        if (!listaClientes.isEmpty()) {
            int cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe CPF do cliente:"));
            Iterator<Cliente> iter = listaClientes.iterator();
            while (iter.hasNext()) {
                Cliente cli = iter.next();
                if (cli.getCpf() == cpf) {
                    flag = true;
                    JOptionPane.showMessageDialog(null, cli.consultaTitulo());
                    x = JOptionPane.showOptionDialog(null, "Confirmar Exclusão?", "ATENÇÃO", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                    if (x == 0) {
                        iter.remove();
                    } else {
                        JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário, voltando ao menu!");
                    }

                }
            }
        } else {
            throw new ListaException("Lista está vazia, voltando ao menu!");
        }
        if (!flag) {
            throw new ListaException("Lista está vazia, voltando ao menu!");
        }
        x = JOptionPane.showOptionDialog(null, "Nova exclusão?", "ATENÇÃO", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (x == 0) {
            exclusao();
        }
    }

    // metodo da tela 1.2 (Movimentação/baixa)
    private static void movimentacaoBaixa() throws ListaException, ParseException, NumberFormatException {
        String[] options = { "Sim", "Não" };
        int x;
        boolean flag = false;
        if (!listaClientes.isEmpty()) {
            int cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe CPF do cliente:"));
            for (Cliente cliente : listaClientes) {
                if (cliente.getCpf() == cpf) {
                    JOptionPane.showMessageDialog(null, " Cliente: " + cliente.getNome() + "\n Débito atual: " + formatoDouble.format(cliente.getDebito()));
                    double quantia = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor pago:"));
                    x = JOptionPane.showOptionDialog(null, "Confirmar baixa de tiítulo no valor de R$: " + quantia + " ?", "ATENÇÃO", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                    flag = true;

                    if (x == 0) {
                        cliente.getTitulo().movimentacaoTitulo(quantia);
                        JOptionPane.showMessageDialog(null, "Valor final: " + formatoDouble.format(cliente.getDebito()));
                    } else {
                        JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário, voltando ao menu!");
                    }
                    if (cliente.getDebito() == 0) {
                        JOptionPane.showMessageDialog(null, "Divida quitada, Titulo pode ser excluido!\n"
                        + "(Menu -> Cadastro de título -> Exclusão de título)");
                    }
                }
            }
            if (!flag) {
                throw new ListaException("Cliente não encontrado, voltando ao menu principal!");
            }
        } else {
            throw new ListaException("Lista está vazia, impossivel fazer movimentação!");
        }
        x = JOptionPane.showOptionDialog(null, "Nova baixa?", "ATENÇÃO", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (x == 0) {
            movimentacaoBaixa();
        }
    }

    // Metodos da tela 1.3

    // 1.3.1 relatótio de clientes em debito
    private static void clientesEmDebito() throws ListaException {
        JOptionPane.showMessageDialog(null, Relatorios.relatorioClientesEmDebito(listaClientes));
    }

    // 1.3.2 relatorio de inadimplência
    private static void relatorioInadimplencia() throws ListaException {
        JOptionPane.showMessageDialog(null, Relatorios.relatorioInadimplencia(listaClientes));
    }

    // 1.3.3 emite aviso ao cliente com base em sua situação
    private static void avisoCliente() throws AvisoException, ListaException {
        boolean flag = false;
        int cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe CPF do cliente:"));
        for (Cliente cliente : listaClientes) {
            if (cliente.getCpf() == cpf) {
                JOptionPane.showMessageDialog(null, Relatorios.emiteAviso(cliente));
                flag = true;
            }
        }
        if (!flag) {
            throw new ListaException("Cliente não encontrado!");
        }
    }

    // metodo de Finalizar programa (salva os dados por garantia)
    private static void sair() {
        JOptionPane.showMessageDialog(null, "Saindo do programa!");
        if (!listaClientes.isEmpty()) {
            Relatorios.salvar(listaClientes);
        }
    }

    // metodo de salvamento
    private static void salvar() throws ListaException {
        if (!listaClientes.isEmpty()) {
            Relatorios.salvar(listaClientes);
            JOptionPane.showMessageDialog(null, "Dados dalvos com sucesso!");
        } else {
            throw new ListaException("Lista está vazia, não há dados para salvar!");
        }
    }

    // verifica se alguma variavel é nula
    private static boolean nulo(String nome, int cpf, double debito, String dataVencimento) {
        if (nome == null || cpf == 0 || debito == 0 || dataVencimento == null) {
            return true;
        }
        return false;
    }
}
