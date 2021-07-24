package geometria;

public class Comparacao {

    private static <T> boolean isEmpty(T[] v) {
        for (int i = 0; i < v.length; i++)
            if (v[i] != null) return false;
        return true;
    }

    public static <T extends Comparable<T>> T maiorElemento(T[] v) {
        if (v.length == 0) return null;
        if (isEmpty(v)) return null;

        int maiorElemento = 0;
        for (int i = 1; i < v.length; i++) {
            if (v[i] == null) continue;
            if (v[i].compareTo(v[maiorElemento]) > 0) maiorElemento = i;
        }

        return v[maiorElemento];
    }
    
    public static <T extends Comparable<T>> T menorElemento(T[] v) {
        if (v.length == 0) return null;
        if (isEmpty(v)) return null;

        int menorElemento = 0;
        for (int i = 1; i < v.length; i++) {
            if (v[i] == null) continue;
            if (v[i].compareTo(v[menorElemento]) < 0) menorElemento = i;
        }

        return v[menorElemento];
    }

}
