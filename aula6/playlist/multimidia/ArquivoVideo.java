package multimidia;

public class ArquivoVideo extends ArquivoMultimidia{

    private int largura;
    private int altura;

    public ArquivoVideo(String nomeArquivo, int largura, int altura) {
        super(nomeArquivo);
        this.altura = altura;
        this.largura = largura;
    }

    @Override
    public String toString() {
        return String.format("Video: %s (%d x %d)", super.getNomeArquivo(), this.largura, this.altura);
    }
    
}
