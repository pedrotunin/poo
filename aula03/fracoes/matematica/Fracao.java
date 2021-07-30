package aula3.fracoes.matematica;

public class Fracao {
    
    private int numerador;
    private int denominador;

    public Fracao() {
        this.numerador = 1;
        this.denominador = 1;
    }

    public Fracao(int numerador) {
        this.numerador = numerador;
        this.denominador = 1;
    }

    public Fracao(int numerador, int denominador) {

        int mdc = this.mdc(numerador, denominador);
        numerador /= mdc;
        denominador /= mdc;

        while (mdc != 1) {
            mdc = this.mdc(numerador, denominador);
            numerador /= mdc;
            denominador /= mdc;
        }

        this.numerador = numerador;
        this.denominador = denominador;
    }

    private int mdc(int a, int b) {
        if (b == 0) return a;
        else return mdc(b, a % b);
    }

    public String getRepresentacao() {
        return this.numerador + "/" + this.denominador;
    }

    private int getNumerador() {
        return this.numerador;
    }

    private int getDenominador() {
        return this.denominador;
    }

    public Fracao somar(Fracao f2) {
        int numerador = (this.getNumerador() * f2.getDenominador()) + (f2.getNumerador() * this.getDenominador()); 
        int denominador = this.getDenominador() * f2.getDenominador();
        return new Fracao(numerador, denominador);
    }

    public static Fracao somar(Fracao f1, Fracao f2) {
        int numerador = f1.getNumerador() * f2.getDenominador() + f2.getNumerador() * f1.getDenominador(); 
        int denominador = f1.getDenominador() * f2.getDenominador();
        return new Fracao(numerador, denominador);
    }

    public static Fracao somar(Fracao[] fracoes) {

        int qtd = fracoes.length;
        if (qtd == 1) return fracoes[0];

        Fracao resultado = somar(fracoes[0], fracoes[1]);     

        for (int i = 2; i < qtd; i++) {
            resultado = somar(resultado, fracoes[i]);
        }
    
        return resultado;
    }

    public static Fracao multiplicar(Fracao f1, Fracao f2) {
        return new Fracao(f1.getNumerador() * f2.getNumerador(), f1.getDenominador() * f2.getDenominador());
    }

}
