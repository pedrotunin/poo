package pedidos.empresa;

public class Pedido {
    
    private boolean entregue = false;
    private boolean cancelado = false;

    private Integer[] produtos = new Integer[5];

    private int getQtdProdutos() {
        int qtd = 0;
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] != null) qtd++;
        }
        return qtd;
    }

    private Integer encontrarPosicaoVazia() {
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] == null) return i;
        }
        return null;
    }

    private void copiarProdutos(int[] produtos) {
        int indice = 0;
        for (int i = 0; i < this.produtos.length; i++) {
            if (this.produtos[i] == null) continue;
            produtos[indice++] = this.produtos[i];
        }
    }

    private boolean encontraCodigo(int codigo) {
        for (int i = 0; i < this.produtos.length; i++) {
            if (this.produtos[i] == null) continue;
            if (this.produtos[i] == codigo) return true;
        }
        return false;
    }

    private int getQtdProdutosDif(Pedido p) {
        int qtd = this.getQtdProdutos();

        for (int i = 0; i < p.produtos.length; i++) {
            if (p.produtos[i] == null) continue;
            if (!this.encontraCodigo(p.produtos[i])) qtd++;
        }

        return qtd;
    }

    private void somaPedido(Integer[] produtos) {

        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] == null) continue;

            if (this.encontraCodigo(produtos[i])) continue;

            Integer indice = this.encontrarPosicaoVazia();
            if (indice == null) continue;
            this.produtos[indice] = produtos[i];
        }

    }

    public boolean adicionarProduto(int codProduto) {
        if (this.entregue || this.cancelado) return false;
        if (this.getQtdProdutos() == this.produtos.length) return false;

        if (this.encontraCodigo(codProduto)) return false;

        Integer indice = this.encontrarPosicaoVazia();
        if (indice == null) return false;

        this.produtos[indice] = codProduto;
        return true;
    }

    public int[] entregar() {
        if (this.cancelado) return null;
        int qtdProdutos = this.getQtdProdutos();
        if (qtdProdutos == 0) return null;

        int[] produtosEntrega = new int[qtdProdutos];
        this.copiarProdutos(produtosEntrega);
        this.entregue = true;
        return produtosEntrega;
    }

    public boolean cancelar() {
        if (this.entregue || this.cancelado) return false;
        this.cancelado = true;
        return true;
    }

    public boolean somarPedido(Pedido p) {
        if (this.getQtdProdutosDif(p) > this.produtos.length) return false;

        this.somaPedido(p.produtos);
        return true;
    }

}
