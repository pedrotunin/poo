package multimidia;

class QuantidadeLimiteArquivos extends Exception {
    public QuantidadeLimiteArquivos() {
        super("Quantidade limite de arquivos foi atingida.");
    }
}

class IndiceArquivoInvalido extends Exception {
    public IndiceArquivoInvalido(int indiceInvalido) {
        super(String.format("Indice de arquivo invalido = %d", indiceInvalido));
    }
}

public class Playlist {
    
    private ArquivoMultimidia[] arquivos;
    private int ultimoIndice = -1;

    public Playlist() {
        this.arquivos = new ArquivoMultimidia[10];
    }

    public void adicionarItem(ArquivoMultimidia arquivo) throws QuantidadeLimiteArquivos {
        if (this.ultimoIndice + 1 >= this.arquivos.length)
            throw new QuantidadeLimiteArquivos();

        this.ultimoIndice++;
        this.arquivos[this.ultimoIndice] = arquivo;
    }

    public void renomearItem(int indiceArquivo, String novoNomeArquivo) throws IndiceArquivoInvalido {
        if (indiceArquivo < 0 || indiceArquivo > this.arquivos.length - 1)
            throw new IndiceArquivoInvalido(indiceArquivo);
        if (this.arquivos[indiceArquivo] == null)
            throw new IndiceArquivoInvalido(indiceArquivo);

        this.arquivos[indiceArquivo].setNomeArquivo(novoNomeArquivo);
    }

    private void shiftDireita() {
        for (int i = this.ultimoIndice + 1; i > 0; i--) {
            this.arquivos[i] = this.arquivos[i - 1];
            this.arquivos[i - 1] = null;
        }
    }

    private void shiftEsquerda(int indice) {
        for (int i = indice; i < this.arquivos.length; i++) {
            if (this.arquivos[i + 1] == null) return;
            this.arquivos[i] = this.arquivos[i + 1];
            this.arquivos[i + 1] = null;
        }
    }

    public void moverParaInicio(int indiceArquivo) throws IndiceArquivoInvalido {
        if (indiceArquivo < 0 || indiceArquivo > this.arquivos.length - 1)
            throw new IndiceArquivoInvalido(indiceArquivo);
        if (this.arquivos[indiceArquivo] == null)
            throw new IndiceArquivoInvalido(indiceArquivo);

        shiftDireita();
        this.arquivos[0] = this.arquivos[indiceArquivo + 1];
        this.arquivos[indiceArquivo + 1] = null;
        shiftEsquerda(indiceArquivo + 1);
    }

    public String[] listarArquivos() {
        String[] arquivos = new String[this.ultimoIndice + 1];

        for (int i = 0; i <= this.ultimoIndice; i++) {
            arquivos[i] = this.arquivos[i].toString();
        }

        return arquivos;
    }

    private ArquivoMultimidia[] ordenaLexicografica(ArquivoMultimidia[] arquivos) {
        for (int i = 0; i <= this.ultimoIndice - 1; i++) {
            for (int k = i + 1; k <= this.ultimoIndice; k++) {
                
                String nomeI = arquivos[i].getNomeArquivo();
                String nomeK = arquivos[k].getNomeArquivo();

                if (nomeK.compareTo(nomeI) < 0) {

                    ArquivoMultimidia tmp = arquivos[i];
                    arquivos[i] = arquivos[k];
                    arquivos[k] = tmp;

                } else if (nomeK.compareTo(nomeI) == 0 && arquivos[k].getTamanhoArquivo() < arquivos[i].getTamanhoArquivo()) {

                    ArquivoMultimidia tmp = arquivos[i];
                    arquivos[i] = arquivos[k];
                    arquivos[k] = tmp;

                }

            }
        }
        return arquivos;
    }

    private ArquivoMultimidia[] ordenaTamanho(ArquivoMultimidia[] arquivos) {
        for (int i = 0; i <= this.ultimoIndice - 1; i++) {
            for (int k = i + 1; k <= this.ultimoIndice; k++) {
                if (arquivos[k].getTamanhoArquivo() < arquivos[i].getTamanhoArquivo()) {
                    ArquivoMultimidia tmp = arquivos[i];
                    arquivos[i] = arquivos[k];
                    arquivos[k] = tmp;
                } else if (arquivos[k].getTamanhoArquivo() == arquivos[i].getTamanhoArquivo()) {

                    String nomeI = arquivos[i].getNomeArquivo();
                    String nomeK = arquivos[k].getNomeArquivo();

                    if (nomeK.compareTo(nomeI) < 0) {

                        ArquivoMultimidia tmp = arquivos[i];
                        arquivos[i] = arquivos[k];
                        arquivos[k] = tmp;
    
                    }

                }
            }
        }
        return arquivos;
    }

    public void ordenarArquivos(int tipo) {
        if (tipo == 1) this.arquivos = this.ordenaLexicografica(arquivos);
        else if (tipo == 2) this.arquivos = this.ordenaTamanho(arquivos);
    }

}
