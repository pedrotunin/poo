package jogo;

public class Programa {
    public static void main(String[] args) {
        TabuleiroEstrategia tabuleiro = new TabuleiroEstrategia();

        tabuleiro.setStrategyJogador1(new EstrategiaB());
        tabuleiro.setStrategyJogador2(new EstrategiaA());

        tabuleiro.jogarPartida();
    }
}
