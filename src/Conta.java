import javax.swing.*;
public class Conta {
    private double saldo = 0;
    private int numeroConta;
    private String titular;

    public Conta(int numeroConta, String titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
    }

    public Conta() {
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.err.println("Não é permitido valores negativos ou iguais a zero para depósito");
        } else {
            setSaldo(getSaldo() + valor);
            System.out.printf("Deposito de R$ %.2f realizado com sucesso\nSaldo atual: %.2f\n", valor, getSaldo());
        }

    }

    public void sacar(double valor) {
        if (this.saldo > 0) {
            if (valor < saldo && valor > 0) {
                setSaldo(getSaldo() - valor);
                System.out.printf("Saque de R$ %.2f realizado com sucesso\nSaldo atual: %.2f\n", valor, getSaldo());
            }else if (valor <= 0) {
                System.err.println("Valor de saque inválido");
            }
            else {
                System.err.println("Saldo insuficiente");
            }
        } else if (valor <= 0) {
            System.err.println("Valor de saque inválido");
        } else {
            System.err.println("Não há saldo");
        }
    }

    public void transferir(double valor, Conta contaDestino) {
        if (valor > getSaldo()) {
            System.err.println("Não há saldo suficiente");
        } else if (valor < getSaldo() && valor != 0) {
            setSaldo(getSaldo() - valor);
            contaDestino.setSaldo(contaDestino.getSaldo() + valor);
            System.out.printf("Transferência de valor R$ %.2f para %s realizada com sucesso\nSaldo restante: %.2f\n", valor, contaDestino.getTitular(), getSaldo());
        } else if (valor <= 0) {
            System.err.println("Não é permitido transferir valores iguais a zero ou negativos");
        }
    }

    public void mostrarMenuOpcoesConta() {

        Conta conta1 = new Conta(1234, "Marco");
        Conta conta2 = new Conta(12345, "Pedro");
        boolean isExecutandoOperacoes = true;

        while (isExecutandoOperacoes) {
            int opcaoUsuario = receberOperacoesUsuario("Digite a operação desejada:\n1 - Saque\n2 - Deposito\n 3 - Transferencia\n 4 - Sair");
            isExecutandoOperacoes = executarOperacoesUsuario(conta1, conta2, opcaoUsuario);
        }
    }

    private static int receberOperacoesUsuario(String mensagemDialogo) {
        String entradaUsuario = JOptionPane.showInputDialog(null, mensagemDialogo);
        int opcaoUsuario = 0;
        if (entradaUsuario == null) {
            JOptionPane.showMessageDialog(null, "Entrada não pode ser vazia!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else if (entradaUsuario.matches("[1-4]*") && entradaUsuario.length() == 1) {
            opcaoUsuario = Integer.parseInt(entradaUsuario);
        } else {
            JOptionPane.showMessageDialog(null, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return opcaoUsuario;
    }

    private static boolean executarOperacoesUsuario(Conta conta1, Conta conta2, int operacao) {
        double valorOperacao;
        boolean isExecutandoOperacoes = true;
        switch (operacao) {
            case 1:
                valorOperacao = converterValorOperacao("Digite o valor do saque");
                conta1.sacar(valorOperacao);
                break;
            case 2:
                valorOperacao = converterValorOperacao("Digite o valor do depósito");
                conta1.depositar(valorOperacao);
                break;
            case 3:
                valorOperacao = converterValorOperacao("Digite o valor da transferência");
                conta1.transferir(valorOperacao, conta2);
                break;
            case 4:
                isExecutandoOperacoes = false;
                break;
            default:
                break;
        }
        return isExecutandoOperacoes;
    }

    private static double converterValorOperacao(String mensagem) {
        String valorOperacaoTxt = JOptionPane.showInputDialog(null, mensagem);
        double valorOperacaoConvertido = 0;
        if (valorOperacaoTxt != null) {
            if (valorOperacaoTxt.matches("[0-9]{1,9}(\\.[0-9]*)?")) {
                valorOperacaoConvertido = Double.parseDouble(valorOperacaoTxt);

            } else {
                JOptionPane.showMessageDialog(null, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operação cancelada!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return valorOperacaoConvertido;
    }

}
