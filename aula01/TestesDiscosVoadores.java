import java.util.Scanner;

public class TestesDiscosVoadores {
    
    public static void leMatriz (int[][] m, Scanner leitor) {

        for (int i = 0; i < m.length; i++) {
            for (int k = 0; k < m[i].length; k++) {
                m[i][k] = leitor.nextInt();
            }
        }

    }

    public static void imprimeMatriz (int[][] m) {

        for (int i = 0; i < m.length; i++) {
            for (int k = 0; k < m[i].length; k++) {

                if (k == m[i].length - 1)
                    System.out.print(m[i][k]);
                else
                    System.out.print(m[i][k] + " ");

            }
            System.out.println();
        }

    }

    //a > b ? true : false
    public static boolean comparaLinhas(int[] a, int[] b) {

        for (int i = 0; i < a.length; i++) {
            if (a[i] > b[i]) return true;
            else if (a[i] < b[i]) return false; 
        }
        return false;

    }

    public static void ordenaLinhas(int[][] m) {

        for (int i = 0; i < m.length - 1; i++) {
            for (int k = i + 1; k < m.length; k++) {
                if (comparaLinhas(m[i], m[k])) {
                    int[] tmp = m[k];
                    m[k] = m[i];
                    m[i] = tmp;
                }
            }
        }

    }

    //col1 > col2 ? true : false
    public static boolean comparaColunas(int[][] m, int col1, int col2) {

        for (int i = 0; i < m.length; i++) {
            if (m[i][col1] > m[i][col2]) return true;
            if (m[i][col1] < m[i][col2]) return false;
        }
        return false;

    }

    public static void trocaColunas(int[][] m, int col1, int col2) {

        for (int i = 0; i < m.length; i++) {
            int tmp = m[i][col1];
            m[i][col1] = m[i][col2];
            m[i][col2] = tmp;
        }

    }

    public static void ordenaColunas(int[][] m) {

        for (int i = 0; i < m[0].length - 1; i++) {
            for (int k = i + 1; k < m[0].length; k++) {
                if (comparaColunas(m, i, k)) {
                    trocaColunas(m, i, k);
                }

            }
        }

    }

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        int n_linhas = leitor.nextInt();
        int n_colunas = leitor.nextInt();

        int[][] m = new int[n_linhas][n_colunas];

        leMatriz(m, leitor);

        ordenaLinhas(m);
        imprimeMatriz(m);
        System.out.println();
        //ordenaColunas(m);
        //imprimeMatriz(m);

        leitor.close();

    }

}
