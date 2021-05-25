import java.util.Scanner;

public class Potencias2 {

    public static boolean potencia2(int n) {
        if (n < 1) return false;

        while (n > 1) {
            if (n % 2 != 0) return false;
            n /= 2;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        int n = leitor.nextInt();

        int qtd = 0;
        for (int i = 0; i < n; i++) {

            int novo = leitor.nextInt();
            if (potencia2(novo)) qtd++;

        }

        System.out.println(qtd);
        leitor.close();

    }
    
}
