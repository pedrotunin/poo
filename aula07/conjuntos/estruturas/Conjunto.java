package estruturas;

class ListaLigada {

    private int qtdItens = 0;
    private NoLista inicio = null;

    static class NoLista {
        int numero;
        NoLista prox = null;

        NoLista(int numero) {
            this.numero = numero;
        }
    }

    public int getQtd() {
        return this.qtdItens;
    }

    protected void setQtd(int qtd) {
        this.qtdItens = qtd;
    }

    public boolean adicionar(int numero) {

        NoLista novo = new NoLista(numero);
        if (this.inicio == null) {
            this.inicio = novo;
        } else {
            NoLista anterior = null;
            NoLista atual = this.inicio;
            while (atual != null) {
                anterior = atual;
                atual = atual.prox;
            }
            anterior.prox = novo;
        }
        this.setQtd(this.getQtd() + 1);

        return true;

    }

    public boolean remover(int numero) {

        if (this.inicio == null) return false;

        NoLista anterior = null;
        NoLista atual = this.inicio;
        while (atual != null && numero != atual.numero) {
            anterior = atual;
            atual = atual.prox;
        }
        if (atual == null) return false;

        if (anterior == null) this.inicio = atual.prox;
        else anterior.prox = atual.prox;

        atual.prox = null;
        atual = null;

        this.setQtd(this.getQtd() - 1);
        return true;

    }

    public int buscar(int numero) {

        int pos = 0;
        NoLista atual = this.inicio;
        while (atual != null) {
            if (atual.numero == numero) return pos;
            pos++;
            atual = atual.prox;
        }
        return -1;

    }

    @Override
    public String toString() {
        String listaStr = "";
        for (NoLista atual = this.inicio; atual != null; atual = atual.prox) {
            if (atual.prox == null) listaStr += atual.numero;
            else listaStr += atual.numero + " ";
        }
        
        return listaStr;
    }

    public static ListaLigada uniao(ListaLigada a, ListaLigada b) {
        ListaLigada nova = new ListaLigada();
        for (NoLista atual = a.inicio; atual != null; atual = atual.prox) {
            nova.adicionar(atual.numero);
        }
        for (NoLista atual = b.inicio; atual != null; atual = atual.prox) {
            if (nova.buscar(atual.numero) == -1) nova.adicionar(atual.numero);
        }
        return nova;
    }

    public static ListaLigada intersecao(ListaLigada a, ListaLigada b) {
        ListaLigada nova = new ListaLigada();
        for (NoLista atual = a.inicio; atual != null; atual = atual.prox) {
            if (b.buscar(atual.numero) != -1) nova.adicionar(atual.numero);
        }
        for (NoLista atual = b.inicio; atual != null; atual = atual.prox) {
            if (a.buscar(atual.numero) != -1 && nova.buscar(atual.numero) == -1) nova.adicionar(atual.numero);
        }
        return nova;
    }

}

public class Conjunto implements Lista {

    ListaLigada ll = new ListaLigada();

    @Override
    public int getQtd() {
        return ll.getQtd();
    }
    
    @Override
    public void adicionar(int numero) {
        if (ll.buscar(numero) != -1) return;
        ll.adicionar(numero);
    }

    @Override
    public void remover(int numero) {
        ll.remover(numero);
    }

    @Override
    public int buscar(int numero) {
        return ll.buscar(numero);
    }

    @Override
    public String toString() {
        return ll.toString();
    }

    public static Conjunto uniao(Conjunto a, Conjunto b) {
        Conjunto c = new Conjunto();
        c.ll = ListaLigada.uniao(a.ll, b.ll);
        return c;
    } 

    public static Conjunto intersecao(Conjunto a, Conjunto b) {
        Conjunto c = new Conjunto();
        c.ll = ListaLigada.intersecao(a.ll, b.ll);
        return c;
    }
    
}
