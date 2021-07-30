package cartoes;

public class CartaoCredito extends CartaoDebito {

    private double valorDevidoCredito = 0;

    public boolean pagarComCredito(double valor) {
        this.valorDevidoCredito += valor;
        return true;
    }

    public void quitarCredito(double valor) {
        if (valor <= 0) return;
        if (valor > this.valorDevidoCredito) {
            this.valorDevidoCredito = 0;
            return;
        }
        this.valorDevidoCredito -= valor;
    }

    public double verificarExtrato() {
        return this.valorDevidoCredito;
    }

}