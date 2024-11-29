import enums.TipoConta;

public class Conta implements TransacoesBancarias {
    private TipoConta tipoConta;
    private double saldo;
    private Extrato extrato;

    public Conta(TipoConta tipoConta, double saldoInicial) {
        this.tipoConta = tipoConta;
        this.saldo = saldoInicial;
        this.extrato = new Extrato();
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso. Saldo atual: R$ " + saldo);
        } else {
            System.out.println("Erro: Saldo insuficiente ou valor inválido para saque.");
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso. Saldo atual: R$ " + saldo);
        } else {
            System.out.println("Erro: Valor inválido para depósito.");
        }
    }

    public void registrarTransacao(String operacao, double valor, double imposto, String nomeCliente,
                                   String tipoConta, String nomeAtendente, String nomeAgencia) {
        extrato.registrarTransacao(operacao, valor, imposto, nomeCliente, tipoConta, nomeAtendente, nomeAgencia);
    }

    public double getSaldo() {
        return saldo;
    }

    public Extrato getExtrato() {
        return extrato;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }
}
