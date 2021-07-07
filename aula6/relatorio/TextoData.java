package relatorio;

public class TextoData implements PluginTexto {

    private int dia, mes, ano;

    public TextoData(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    @Override
    public String aplicar(String texto) {
        return String.format("%s (DATA: %d/%d/%d)", texto, this.dia, this.mes, this.ano);
    }
    
}
