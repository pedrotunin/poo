// Escreva aqui a classe TabuleiroEstrategia

package jogo;

public class TabuleiroEstrategia extends Tabuleiro {

    private EstrategiaJogo jogador1, jogador2;

    public void setStrategyJogador1(EstrategiaJogo jogador1) {
        this.jogador1 = jogador1;
    }

    public void setStrategyJogador2(EstrategiaJogo jogador2) {
        this.jogador2 = jogador2;
    }

    public void jogarPartida() {

        EstrategiaJogo estrategiaAtual;
        int atual = 1;
        char simboloAtual;

        int[] coords;

        while (this.getJogadorVencedor() == '.') {

            if (atual == 1) {
                estrategiaAtual = this.jogador1;
                simboloAtual = 'X';
                atual = 2;
            } else {
                estrategiaAtual = this.jogador2;
                simboloAtual = 'O';
                atual = 1;
            }

            coords = estrategiaAtual.getProximaJogada(this.getTabuleiro(), simboloAtual);

            this.jogar(simboloAtual, coords[0], coords[1]);

        }

    }

}