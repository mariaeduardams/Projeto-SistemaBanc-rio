public class TransformacaoPolimorfica {
    public void realizarsaque (TransacoesBancarias cliente, double valor) {
        cliente.sacar(valor);
    }
    public void realizardeposito (TransacoesBancarias cliente, double valor) {
        cliente.depositar(valor);
    }
}