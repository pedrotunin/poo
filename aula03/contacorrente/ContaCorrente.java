package aula3.contacorrente;

public class ContaCorrente {

    private String nome;
    private double saldo;
    private static int qtdContas = 0;

    public ContaCorrente(String nome) {
        qtdContas++;
        this.nome = nome;
        this.saldo = 0;
    }

    public ContaCorrente(String nome, double saldo) {
        qtdContas++;
        this.nome = nome;
        this.saldo = saldo;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public String getTitular() {
        return this.nome;
    }

    public boolean depositar(double valor) {
        if (valor <= 0) return false;

        this.saldo += valor;
        return true;
    }

    public boolean sacar(double valor) {
        if (valor <= 0) return false;
        if (valor > this.saldo) return false;

        this.saldo -= valor;
        return true;
    }

    public static boolean transferir(ContaCorrente de, ContaCorrente para, double valor) {
        if (valor <= 0) return false;
        if (de.getSaldo() < valor) return false;

        de.sacar(valor);
        para.depositar(valor);

        return true;
    }

    public static int getQuantidadeContas() {
        return qtdContas;
    }

}
