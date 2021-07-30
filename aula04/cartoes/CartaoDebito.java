package cartoes;

public class CartaoDebito {

    private String titular = "";
    private double saldoDebito = 0;

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void adicionarSaldoDebito(double valor) {
        this.saldoDebito += valor;
    }

    public double verificarSaldoDebito() {
        return this.saldoDebito;
    }

    public boolean pagarComDebito(double valor) {
        if (this.saldoDebito - valor < 0) return false;
        this.saldoDebito -= valor;
        return true; 
    }
}