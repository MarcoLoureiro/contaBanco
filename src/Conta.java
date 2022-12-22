public class Conta {
    private double saldo = 0;
    private int numeroConta;
    private String titular;

    public Conta(int numeroConta, String titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
    }


    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor < 0) {
            System.err.println("Não é permitido valores negativos de deposito");
        } else {
            this.saldo += valor;
            System.out.println("Deposito de "+valor +" realizado com sucesso\nSaldo atual:: " + this.saldo);
        }

    }

    public void sacar(double valor) {
        if (this.saldo > 0) {
            if (valor < saldo) {
                this.saldo -= valor;
                System.out.println("Saque de "+ valor+" realizado com sucesso!"+ "\nSaldo atual: " + this.saldo);
            } else {
                System.err.println("Saldo insuficiente");
            }
        } else {
            System.err.println("Não há saldo");
        }
    }

    public void transferir(double valor, Conta conta) {
        if (valor > this.saldo) {
            System.err.println("Não há saldo suficiente");
        } else {
            this.saldo -= valor;
            conta.saldo += valor;
            System.out.println("Transferência de valor R$ " + valor + " realizada com sucesso\nSaldo restante: " + this.saldo);
        }
    }
}
