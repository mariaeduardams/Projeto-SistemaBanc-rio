import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inicialização de sistema
        Atendente atendente = new Atendente("João Emanuel Silva");
        Agencia agencia = new Agencia("Cabo Branco");

        System.out.println("Bem-vindo ao sistema de atendimento bancário!");
        System.out.println("model.Atendente: " + atendente.getNome());
        System.out.println("Agência: " + agencia.getNome());

        // Cadastro do cliente
        Cliente cliente = registrarCliente(scanner);

        // Operações bancárias
        while (true) {
            System.out.println("\nSelecione uma operação:");
            System.out.println("1 - Sacar");
            System.out.println("2 - Depositar");
            System.out.println("3 - Ver Saldo");
            System.out.println("4 - Ver model.Extrato");
            System.out.println("5 - Sair");

            int opcao = scanner.nextInt();
            if (!executarOperacao(opcao, cliente, atendente, agencia, scanner)) {
                break; // Sai do loop quando a opção for "Sair"
            }
        }
    }

    private static Cliente registrarCliente(Scanner scanner) {
        Cliente cliente = new Cliente();

        System.out.println("\nCadastro de model.Cliente:");
        System.out.print("Digite o seu nome: ");
        cliente.setNome(scanner.next());

        System.out.print("Digite sua idade: ");
        cliente.setIdade(scanner.nextInt());

        System.out.print("Digite seu CPF: ");
        cliente.setCpf(scanner.next());

        System.out.print("Digite seu e-mail: ");
        cliente.setEmail(scanner.next());

        System.out.println("Selecione o tipo de conta:");
        System.out.println("1 - Corrente");
        System.out.println("2 - Poupança");

        TipoConta tipoConta = null;
        while (tipoConta == null) {
            System.out.print("Digite o tipo de conta: ");
            int opcao = scanner.nextInt();
            tipoConta = switch (opcao) {
                case 1 -> TipoConta.CORRENTE;
                case 2 -> TipoConta.POUPANCA;
                default -> {
                    System.out.println("Opção inválida! Tente novamente.");
                    yield null;
                }
            };
        }

        System.out.print("Digite o saldo inicial: R$ ");
        double saldoInicial = scanner.nextDouble();
        cliente.setTipoConta(tipoConta);
        cliente.setConta(new Conta(tipoConta, saldoInicial));

        System.out.println("\nmodel.Cliente cadastrado com sucesso:");
        System.out.println(cliente);
        return cliente;
    }

    private static boolean executarOperacao(int opcao, Cliente cliente, Atendente atendente, Agencia agencia, Scanner scanner) {
        Conta conta = cliente.getConta();

        switch (opcao) {
                 // Saque
            case 1:  {
                System.out.print("Digite o valor para saque: R$ ");
                double valor = scanner.nextDouble();
                conta.sacar(valor);
                conta.registrarTransacao("Saque", valor, valor * 0.01, cliente.getNome(),
                        cliente.getTipoConta().toString(), atendente.getNome(), agencia.getNome());
            }
                // Depósito
            case 2:  {
                System.out.print("Digite o valor para depósito: R$ ");
                double valor = scanner.nextDouble();
                conta.depositar(valor);
                conta.registrarTransacao("Depósito", valor, valor * 0.01, cliente.getNome(),
                        cliente.getTipoConta().toString(), atendente.getNome(), agencia.getNome());
            }
            case 3:  System.out.println("Saldo atual: R$ " + conta.getSaldo());
            case 4:  conta.getExtrato().imprimirExtrato();
            case 5:  {
                System.out.println("Saindo do sistema...");
                return false; // Sai do programa
            }
            default: System.out.println("Opção inválida! Tente novamente.");
        }
        return true;
    }
}
