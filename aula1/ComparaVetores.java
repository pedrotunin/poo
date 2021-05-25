import java.util.Scanner;

public class ComparaVetores {
    
    public static void leVetor (int[] v, Scanner leitor) {

        for (int i = 0; i < v.length; i++) {
            v[i] = leitor.nextInt();
        }

    }

    public static boolean compara (int n, int[] a, int[] b) {

        double divisor = 0; 

        for (int i = 1; i < n; i++) {
            if (b[i] < a[i]) return false;
            if (i == 0) {
                divisor = b[i] / a[i];
                continue;
            }

            if (divisor != b[i] / a[i]) return false;
        }

        return true;
    }

    public static void main (String[] args) {

        Scanner leitor = new Scanner(System.in);

        int n = leitor.nextInt();

        int[] a, b;
        a = new int [n];
        b = new int [n];

        leVetor(a, leitor);
        leVetor(b, leitor);

        if (compara(n, a, b) || compara(n, b, a))
            System.out.println("SIM");
        else 
            System.out.println("NAO");

        leitor.close();

    }

}
