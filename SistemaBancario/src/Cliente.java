oi
public class Cliente {
    private String nome;
    private int idade;
    private String cpf;
    private String email;
    private TipoConta tipoConta;
    private Conta conta;

    // Construtor com parâmetros que o cliente vai digitar e selecionar
    public Cliente(String nome, int idade, String cpf, String email, TipoConta tipoConta, double saldoInicial) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.email = email;
        this.tipoConta = tipoConta;
        this.conta = new Conta(tipoConta, saldoInicial);
    }

    // Construtor sem parâmetros para o cliente definir o saldo inicial
    public Cliente() {

        this.conta = new Conta(TipoConta.CORRENTE, 0.0);
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Conta getConta() {
        return conta;
    }

    @Override
    public String toString() {
        return "model.Cliente{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", tipoConta=" + tipoConta +
                ", saldo=" + conta.getSaldo() +
                '}';
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
