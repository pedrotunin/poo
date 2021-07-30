package caca_palavras.palavras;

public class PalavraEncontrada {

    private String palavra;
    private int[] posicao = new int[2];
    private int tipo;
    private int direcao;


    public PalavraEncontrada(String palavra, int lin, int col, int tipo, int direcao) {
        this.palavra = palavra;
        this.posicao[0] = lin;
        this.posicao[1] = col;
        this.tipo = tipo;
        this.direcao = direcao;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public void setPosicao(int lin, int col) {
        this.posicao[0] = lin;
        this.posicao[1] = col;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setDirecao(int direcao) {
        this.direcao = direcao;
    }

    public String getPalavra() {
        return this.palavra;
    }

    public int[] getPosicao() {
        return this.posicao;
    }

    public int getTipo() {
        return this.tipo;
    }

    public int getDirecao() {
        return this.direcao;
    }
}
