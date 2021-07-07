package usuarios;

public class PerfilRedeSocial extends PerfilUsuario {

    private String mensagemPaginaInicial = "Sem mensagem";

    public PerfilRedeSocial(String nome, String login) {
        super(nome, login);
    }

    public PerfilRedeSocial(String nome, String login, String mensagemPaginaInicial) {
        this(nome, login);
        this.mensagemPaginaInicial = mensagemPaginaInicial;
    }

    public String getPerfil() {
        return String.format("%s %s", super.getNome(), this.mensagemPaginaInicial);
    }
    
}
