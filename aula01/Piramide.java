import java.util.Scanner;

public class Piramide {
    
    public static void imprimeSimbolo (int qtd, char c) {
        if (qtd == 0) return;

        for (int i = 0; i < qtd; i++) {
            System.out.print(c);
        }

    }

    public static void constroiPiramide(int n) {

        int qtdHifens = n - 1;
        int qtdUm = 1;

        for (int i = 0; i < n; i++) {

            imprimeSimbolo(qtdHifens, '-');
            imprimeSimbolo(qtdUm , '1');
            imprimeSimbolo(qtdHifens, '-');
            System.out.println();

            qtdHifens--;
            qtdUm += 2;
        }

    }
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        int n = leitor.nextInt();

        constroiPiramide(n);

        leitor.close();

    }

}
