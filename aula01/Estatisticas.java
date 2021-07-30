import java.util.Scanner;

public class Estatisticas {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        int qtd = 0;
        int soma = 0;
        double media = 0.0;
        int min = 0;
        int max = -1;

        while (true) {

            int n = leitor.nextInt();
            if (n < 0) break;

            qtd++;
            soma += n;

            if (n > max) max = n;
            if (qtd == 1) min = n;
            if (qtd > 1 && n < min) min = n;

        }

        media = soma / (qtd + 0.0);

        System.out.println(soma);
        System.out.println(String.format("%.2f", media));
        System.out.println(min);
        System.out.println(max);

        leitor.close();

    }
    
}
