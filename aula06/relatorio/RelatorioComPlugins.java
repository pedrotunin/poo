package relatorio;

public class RelatorioComPlugins extends Relatorio {

    private PluginImpressao p;

    public RelatorioComPlugins(String autor) {
        super(autor);
    }

    public void aplicarPluginTexto(PluginTexto plugin) {
        String novoTexto = plugin.aplicar(super.getTexto());
        super.setTexto(novoTexto);
    }

    public void setPluginImpressao(PluginImpressao p) {
        this.p = p;
    }

    public void imprimirRelatorio() {
        this.p.imprimir(this);
    }
    
}
