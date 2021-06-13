package caca_palavras.palavras;

import caca_palavras.palavras.PalavraEncontrada;

public class Tabuleiro {
    
    char[][] matriz;
    int[][] matrizPossibilidades;

    public Tabuleiro(char[][] matriz) {
        int qtdLinhas = matriz.length;
        int qtdColunas = matriz[0].length;

        this.matriz = new char[qtdLinhas][qtdColunas];
        this.matrizPossibilidades = new int[qtdLinhas][qtdColunas];

        for (int i = 0; i < qtdLinhas; i++) {
            for (int k = 0; k < qtdColunas; k++) {
                this.matriz[i][k] = matriz[i][k];
            }
        }
    }

    public Tabuleiro(int qtdLinhas, int qtdColunas, char[] dadosMatriz) {
        this.matriz = new char[qtdLinhas][qtdColunas];
        this.matrizPossibilidades = new int[qtdLinhas][qtdColunas];
        int pos = 0;
        for (int i = 0; i < qtdLinhas; i++) {
            for (int k = 0; k < qtdColunas; k++) {
                this.matriz[i][k] = dadosMatriz[pos++];
            }
        }
    }

    private void zeraMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int k = 0; k < matriz[0].length; k++) {
                matriz[i][k] = 0;
            }
        }
    }

    private int preencheMatrizPossibilidades(char primeiraLetra) {
        int qtd = 0;
        for (int i = 0; i < this.matriz.length; i++) {
            for (int k = 0; k < this.matriz[i].length; k++) {
                if (this.matriz[i][k] == primeiraLetra) {
                    qtd++;
                    this.matrizPossibilidades[i][k] = 1;
                }
            }
        }
        return qtd;
    }

    //retorna a direcao = {1, 2} ou null caso a palavra não seja encontrada
    private Integer verificaLinhas(int lin, int col, String palavra) {
        if (palavra.length() - 1 > col && this.matriz[0].length - col < palavra.length()) return null;

        //verifica esquerda
        int cont = 0;
        for (int k = col; k >= 0; k--) {
            if (this.matriz[lin][k] != palavra.charAt(cont)) break;
            cont++;
            if (cont == palavra.length()) return 2;
        }

        //verifica direita
        cont = 0;
        for (int k = col; k < this.matriz[0].length; k++) {
            if (this.matriz[lin][k] != palavra.charAt(cont)) break;
            cont++;
            if (cont == palavra.length()) return 1;
        }

        return null;
    }

    //retorna a direcao = {1, 2} ou null caso a palavra não seja encontrada
    private Integer verificaColunas(int lin, int col, String palavra) {
        int cont = 0;

        //verifica cima
        cont = 0;
        for (int k = lin; k >= 0; k--) {
            if (this.matriz[k][col] != palavra.charAt(cont)) break;
            cont++;
            if (cont == palavra.length()) return 2;
        }

        //verifica baixo
        cont = 0;
        for (int k = lin; k < this.matriz.length; k++) {
            if (this.matriz[k][col] != palavra.charAt(cont)) break;
            cont++;
            if (cont == palavra.length()) return 1;
        }

        return null;
    }

    //retorna a direcao = {1, 2, 3, 4} ou null caso a palavra não seja encontrada
    private Integer verificaDiagonais(int lin, int col, String palavra) {
        
        int cont = 0;
        int i = lin, k = col;

        //pode ser para cima
        if (palavra.length() - 1 <= lin) {

            //verifica NW - 4
            cont = 0;
            i = lin;
            k = col;
            while (i >= 0 && k >= 0) {
                if (this.matriz[i][k] != palavra.charAt(cont)) break;
                cont++;
                if (cont == palavra.length()) return 4;
                i--;
                k--;
            }

            //verifica NE - 1
            cont = 0;
            i = lin;
            k = col;
            while (i >= 0 && k < this.matriz[0].length) {
                if (this.matriz[i][k] != palavra.charAt(cont)) break;
                cont++;
                if (cont == palavra.length()) return 1;
                i--;
                k++;
            }

        }

        //pode ser para baixo
        if (palavra.length() - 1 < this.matriz.length - lin) {

            //verifica SW - 3
            cont = 0;
            i = lin;
            k = col;
            while (i < this.matriz.length && k >= 0) {
                if (this.matriz[i][k] != palavra.charAt(cont)) break;
                cont++;
                if (cont == palavra.length()) return 3;
                i++;
                k--;
            }

            //verifica SE - 2
            cont = 0;
            i = lin;
            k = col;
            while (i < this.matriz.length && k < this.matriz[0].length) {
                if (this.matriz[i][k] != palavra.charAt(cont)) break;
                cont++;
                if (cont == palavra.length()) return 2;
                i++;
                k++;
            }
        }

        return null;
    }

    //retorna um objeto PalavraEncontrada caso a palavra seja encontrada ou null caso contrário
    private PalavraEncontrada verificaPalavra(int lin, int col, String palavra) {

        int tipo;
        Integer direcao;

        direcao = verificaLinhas(lin, col, palavra);
        if (direcao != null) {
            tipo = 1;
            return new PalavraEncontrada(palavra, lin, col, tipo, direcao);
        }

        direcao = verificaColunas(lin, col, palavra);
        if (direcao != null) {
            tipo = 2;
            return new PalavraEncontrada(palavra, lin, col, tipo, direcao);
        }
        
        direcao = verificaDiagonais(lin, col, palavra);
        if (direcao != null) {
            tipo = 3;
            return new PalavraEncontrada(palavra, lin, col, tipo, direcao);
        }
        
        return null;

    }

    public PalavraEncontrada buscar(String palavra) {
        int qtdPossibilidades = preencheMatrizPossibilidades(palavra.charAt(0));
        if (qtdPossibilidades == 0) return null;

        for (int i = 0; i < this.matrizPossibilidades.length; i++) {
            for (int k = 0; k < this.matrizPossibilidades[0].length; k++) {
                if (this.matrizPossibilidades[i][k] == 1) {
                    PalavraEncontrada verifica = verificaPalavra(i, k, palavra);
                    if (verifica != null) {
                        zeraMatriz(this.matrizPossibilidades);
                        return verifica; 
                    }
                }
            }
        }
        
        zeraMatriz(this.matrizPossibilidades);
        return null;
    }

    public PalavraEncontrada[] buscar(String[] palavras) {
        int qtd = 0;
        PalavraEncontrada[] vetorInicial = new PalavraEncontrada[palavras.length];
        for (int i = 0; i < palavras.length; i++) {
            PalavraEncontrada p = this.buscar(palavras[i]);
            vetorInicial[i] = p;
            if (p != null) qtd++;
        }

        if (qtd == 0) return null;

        PalavraEncontrada[] vetorFinal = new PalavraEncontrada[qtd];

        int cont = 0;
        for (int i = 0; i < palavras.length; i++) {
            if (vetorInicial[i] == null) continue;
            vetorFinal[cont] = vetorInicial[i];
            cont++;
        }

        return vetorFinal;
    }

    public static void main(String[] args) {

        /*char[][] matriz = {
            {'', '', '', '', '', ''},
            {'', '', '', '', '', ''},
            {'', '', '', '', '', ''},
            {'', '', '', '', '', ''},
            {'', '', '', '', '', ''}
        };*/

        char[][] matriz = {
            {'Y', 'T', 'X', 'W', 'B', 'I'},
            {'R', 'E', 'V', 'A', 'D', 'F'},
            {'O', 'S', 'T', 'H', 'F', 'I'},
            {'C', 'T', 'K', 'M', 'F', 'A'},
            {'G', 'E', 'P', 'W', 'V', 'L'}
        };

        Tabuleiro t = new Tabuleiro(matriz);

        String[] v = {"PROGRAMA"};

        PalavraEncontrada[] p = t.buscar(v);

        System.out.println("Palavra: " + p[0].getPalavra());
        System.out.println("Tipo: " + p[0].getTipo());
        System.out.println("Direcao: " + p[0].getDirecao());
        System.out.println("Linha: " + p[0].getPosicao()[0] + " | Coluna: " + p[0].getPosicao()[1]);

    }

}
