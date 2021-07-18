package aula8.classificacao;

class ExcecaoDadosInvalidos extends Exception {

    private int qtdAtributosTreinamento;
    private int qtdAtributosPredizer;

    public ExcecaoDadosInvalidos(int qtdAtributosTreinamento, int qtdAtributosPredizer) {
        this.qtdAtributosTreinamento = qtdAtributosTreinamento;
        this.qtdAtributosPredizer = qtdAtributosPredizer;
    }
 
    public int getQtdAtributosTreinamento() {
        return this.qtdAtributosTreinamento;
    }

    public int getQtdAtributosPredizer() {
        return this.qtdAtributosPredizer;
    }

}

public class KNN {

    private int k;
    private ListaExemplos lista;

    public KNN(int k) {
        this.k = k;
    }

    public void setDadosTreinamento(ListaExemplos lista) {
        this.lista = lista;
    }

    private int getRotuloClasse(Exemplo[] exemplos) {

        int[] freq = new int[exemplos.length];
        int indiceMaior = 0;

        for (int i = 0; i < exemplos.length - 1; i++) {
            for (int k = i + 1; k < exemplos.length; k++) {
                if (exemplos[k].getRotuloClasse() == exemplos[i].getRotuloClasse())
                    freq[i]++;
            }
            if (freq[i] > freq[indiceMaior]) indiceMaior = i;
        }

        return exemplos[indiceMaior].getRotuloClasse();

    }

    public int predizer(double[] atributosEntrada) throws Exception, ExcecaoDadosInvalidos {
        if (this.lista == null || this.lista.getQtdExemplos() == 0)
            throw new Exception("Dados de treinamento - nao inicializado");

        if (atributosEntrada.length != this.lista.getExemplos()[0].getAtributosEntrada().length)
            throw new ExcecaoDadosInvalidos(this.lista.getExemplos()[0].getAtributosEntrada().length, atributosEntrada.length);

        this.lista.ordenarPelaDistancia(atributosEntrada);

        Exemplo[] exemplos = this.lista.getPrimeirosExemplos(this.k);

        int rotuloClasse = this.getRotuloClasse(exemplos);

        return rotuloClasse;
    }

}
