package multimidia;

public class Playlist implements Cloneable {
    
    private ArquivoMultimidia[] arquivos;
    private int ultimoIndice = -1;

    public Playlist() {
        this.arquivos = new ArquivoMultimidia[100];
    }

    public void adicionarItem(ArquivoMultimidia arquivo) {
        this.ultimoIndice++;
        this.arquivos[this.ultimoIndice] = arquivo; //colocar .clone() para testar
    }

    public void renomearItem(int indiceArquivo, String novoNomeArquivo) {
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

    public void moverParaInicio(int indiceArquivo) {
        shiftDireita();
        this.arquivos[0] = this.arquivos[indiceArquivo + 1];
        this.arquivos[indiceArquivo + 1] = null;
        shiftEsquerda(indiceArquivo + 1);
    }

    public String[] listarArquivos() {
        String[] arquivos = new String[this.ultimoIndice + 1];

        for (int i = 0; i <= this.ultimoIndice; i++) {
            arquivos[i] = this.arquivos[i].getNomeArquivo();
        }

        return arquivos;
    }

    @Override
    public Playlist clone() throws CloneNotSupportedException {
        Playlist novaPlaylist = (Playlist) super.clone();

        novaPlaylist.arquivos = this.arquivos.clone();

        for (int i = 0; i <= this.ultimoIndice; i++) {
            novaPlaylist.arquivos[i] = this.arquivos[i].clone();
        }

        return novaPlaylist;
    }

}
