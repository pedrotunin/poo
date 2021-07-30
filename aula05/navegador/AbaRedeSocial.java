package navegador;

public class AbaRedeSocial extends AbaNavegador {
    
    public AbaRedeSocial(String titulo) {
        this.titulo = titulo;
    }

    public void postar(String texto) {
        Navegador.registraHistorico("Post: " + texto);
    }

    @Override
    public String getTipo() {
        return "RedeSocial";
    }

}
