package multimidia;

public class ArquivoAudio extends ArquivoMultimidia{

    private boolean audioHD;

    public ArquivoAudio(String nomeArquivo, boolean audioHD) {
        super(nomeArquivo);
        this.audioHD = audioHD;
    }

    @Override
    public String toString() {
        return String.format("Audio: %s (HD = %s)", super.getNomeArquivo(), String.valueOf(audioHD));
    }
    
}