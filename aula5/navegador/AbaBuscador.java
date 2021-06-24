package navegador;

public class AbaBuscador extends AbaNavegador {

    public AbaBuscador(String titulo) {
        this.titulo = titulo;
    }

    public void buscar(String expressao) {
        Navegador.registraHistorico("Busca: " + expressao);
    }

    @Override
    public String getTipo() {
        return "Buscador";
    }
    
}
