package relatorio;

public class ImpressaoLimiteLargura implements PluginImpressao{
    
    private int largura;

    public ImpressaoLimiteLargura(int largura) {
        this.largura = largura;
    }
    
    private int comprimentoPalavra(String text, int indice) {
        int res = 0;

        if (text.charAt(indice) == ')') return 1;

        for (int i = indice; i < text.length(); i++) {
            if (text.charAt(i) == ' ' || text.charAt(i) == ')') break;
            res++;
        }
        return res;
    }

    private String getPalavra(String texto, int inicio, int fim) {
        String palavra = "";
        for (int i = inicio; i <= fim; i++) {
            palavra += texto.charAt(i);
        }
        return palavra;
    }

    @Override
    public void imprimir(Relatorio r) {
        String texto = r.getTexto();
        String linhaAtual = "";
        int qtdCaracteresLinha = 0;

        int indiceAtual = 0;

        boolean terminou = false;

        while (terminou == false) {

            //trata espaços
            if (texto.charAt(indiceAtual) == ' ') {
                //caso em que tenha um espaço após quebra de linha
                if (qtdCaracteresLinha == 0) indiceAtual++;
                //caso em que haja um espaço no meio da linha
                else {
                    qtdCaracteresLinha++;
                    linhaAtual += ' ';
                    indiceAtual++;
                }
            }

            int comprimentoPalavra = comprimentoPalavra(texto, indiceAtual);

            //caso a palavra caiba na linha
            if (qtdCaracteresLinha + comprimentoPalavra <= largura) {

                linhaAtual += getPalavra(texto, indiceAtual, indiceAtual + comprimentoPalavra - 1);
                indiceAtual += comprimentoPalavra;
                qtdCaracteresLinha += comprimentoPalavra;

            } else { // caso a palavra não caiba na linha
            
                if (linhaAtual.charAt(linhaAtual.length() - 1) == ' ') {
                    linhaAtual = this.getPalavra(linhaAtual, 0, linhaAtual.length() - 2);
                }

                Impressao.imprimirLinha(linhaAtual);

                qtdCaracteresLinha = 0;
                linhaAtual = "";

            }

            if (indiceAtual >= texto.length()) {
                terminou = true;
                Impressao.imprimirLinha(linhaAtual);
            }

        }
    }

}
