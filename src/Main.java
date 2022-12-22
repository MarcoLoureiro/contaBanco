import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        Conta conta1 = new Conta(1234, "Marco");
        Conta conta2 = new Conta(12345, "Pedro");

        int valor;

        MostrarMenu : while (true){
            int opcao = Integer.parseInt(JOptionPane.showInputDialog(null,"1 - Saque\n2 - Deposito\n 3 - Transferencia\n 4 - Sair"));

            switch (opcao){
                case 1:
                    valor = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o valor do saque"));
                    conta1.sacar(valor);
                    break;
                case 2:
                    valor = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o valor do depósito"));
                    conta1.depositar(valor);
                    break;
                case 3:
                    valor = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o valor da transferência"));
                    conta1.transferir(valor,conta2);
                    break;
                case 4:
                    break MostrarMenu;
                default:
                    JOptionPane.showMessageDialog(null,"Opção inválida!");
                    break;
            }
        }


    }
}
