import java.util.Scanner;

public class CampoMinado {

    public static int qtdBombasVizinhas(int[][] m, int l, int c) {
        int qtd = 0;

        //verificando linha
        if (m[l][c-1] == 1) qtd++;
        if (m[l][c+1] == 1) qtd++;
        
        //verificando coluna
        if (m[l-1][c] == 1) qtd++;
        if (m[l+1][c] == 1) qtd++;
        
        //verificando diagonais
        if (m[l+1][c+1] == 1) qtd++;
        if (m[l+1][c-1] == 1) qtd++;
        if (m[l-1][c+1] == 1) qtd++;
        if (m[l-1][c-1] == 1) qtd++;

        return qtd;
    }

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        int linhas = leitor.nextInt();
        int colunas = leitor.nextInt();

        int[][] m = new int[linhas+2][colunas+2];

        for (int i = 1; i <= linhas; i++) {
            for (int k = 1; k <= colunas; k++) {
                m[i][k] = leitor.nextInt();
            }
        }

        int linha = 1 + leitor.nextInt();
        int coluna = 1 + leitor.nextInt();

        int qtd = qtdBombasVizinhas(m, linha, coluna);

        System.out.println(qtd);

        leitor.close();
    }

}