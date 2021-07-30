package aula8.classificacao;

class Exemplo {

    private double[] atributosEntrada;
    private int rotuloClasse;

    public Exemplo(double[] atributosEntrada, int rotuloClasse) {
        this.atributosEntrada = atributosEntrada;
        this.rotuloClasse = rotuloClasse;
    }

    public double[] getAtributosEntrada() {
        return this.atributosEntrada;
    }

    public int getRotuloClasse() {
        return this.rotuloClasse;
    }

}

public class ListaExemplos {

    Exemplo[] exemplos;
    private int maxQtd;
    private int ultimoIndice;

    public ListaExemplos(int maxQtd) {
        this.maxQtd = maxQtd;
        this.exemplos = new Exemplo[this.maxQtd];
        this.ultimoIndice = -1;
    }

    public void adicionarExemplo(Exemplo exemplo) {
        this.exemplos[++this.ultimoIndice] = exemplo;
    }
    
    private double getDistancia(double[] atributosExemplo, double[] atributosEntrada) {

        double res = 0;

        for (int i = 0; i < atributosEntrada.length; i++) {
            res += Math.pow(atributosExemplo[i] - atributosEntrada[i], 2);
        }

        return Math.sqrt(res);

    }

    public void ordenarPelaDistancia(double[] atributosEntrada) {

        for (int i = 0; i < this.ultimoIndice; i++) {
            for (int k = i + 1; k < this.ultimoIndice + 1; k++) {
                if (getDistancia(this.exemplos[k].getAtributosEntrada(), atributosEntrada) < getDistancia(this.exemplos[i].getAtributosEntrada(), atributosEntrada)) {
                    Exemplo tmp = this.exemplos[i];
                    this.exemplos[i] = this.exemplos[k];
                    this.exemplos[k] = tmp;
                }
            }
        }
        
    }
    
    public int getQtdExemplos() {
        return this.ultimoIndice + 1; 
    }

    public Exemplo[] getExemplos() {
        int qtd = this.ultimoIndice + 1;
        Exemplo[] exemplos = new Exemplo[qtd];

        for (int i = 0; i < qtd; i++) {
            exemplos[i] = this.exemplos[i];
        }

        return exemplos;
    }

    public Exemplo[] getPrimeirosExemplos(int n) {
        int qtd = n;
        Exemplo[] exemplos = new Exemplo[qtd];

        for (int i = 0; i < qtd; i++) {
            exemplos[i] = this.exemplos[i];
        }

        return exemplos;
    }

    public Exemplo[] getUltimosExemplos(int n)  {

        Exemplo[] exemplos = new Exemplo[n];
        int cont = 0;

        for (int i = this.ultimoIndice - n + 1; i <= this.ultimoIndice; i++) {
            exemplos[cont] = this.exemplos[i];
            cont++;
        }

        return exemplos;

    }

}
