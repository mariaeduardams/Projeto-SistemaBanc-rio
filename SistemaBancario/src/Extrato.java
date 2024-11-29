import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Extrato {
    private List<String> transacoes;

    public Extrato() {
        this.transacoes = new ArrayList<>();
    }

    // Registrar uma transação no extrato
    public void registrarTransacao(String operacao, double valor, double imposto, String nomeCliente,
                                   String tipoConta, String nomeAtendente, String nomeAgencia) {
        String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        String registro = String.format(
                "Data e Hora: %s | Operação: %s | Valor: R$ %.2f | Imposto: R$ %.2f | model.Cliente: %s | Tipo de model.Conta: %s | model.Atendente: %s | Agência: %s",
                dataHora, operacao, valor, imposto, nomeCliente, tipoConta, nomeAtendente, nomeAgencia
        );
        transacoes.add(registro);
        System.out.println("Transação registrada com sucesso!");
    }

    // Imprimir o extrato de transações
    public void imprimirExtrato() {
        if (transacoes.isEmpty()) {
            System.out.println("\nNenhuma transação registrada até o momento.");
        } else {
            System.out.println("\nmodel.Extrato de Transações:");
            System.out.println("-------------------------------");
            for (String transacao : transacoes) {
                System.out.println(transacao);
            }
            System.out.println("-------------------------------");
        }
    }