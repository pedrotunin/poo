package arquivos;

import java.util.ArrayList;

public class FilaArquivos<T> implements Fila<T>{

    private int n;
    private ArrayList<T> fila = new ArrayList<T>();

    public FilaArquivos(int n) {
        this.n = n;
    }
    
    @Override
    public boolean enfileirar(T arquivo) {
        if (this.fila.size() == this.n) return false;
        this.fila.add(arquivo);
        return true;
    }

    @Override
    public T desenfileirar() {
        if (this.fila.size() == 0) return null;
        T item = this.fila.get(0);
        this.fila.remove(0);
        return item;
    }
    
}
