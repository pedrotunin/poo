package aula3.projetoProva.autocorrecao;

public class Alternativa {
    private String descricao;

    public Alternativa(String descricao) {
        this.setDescricao(descricao);
    }

    private void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
