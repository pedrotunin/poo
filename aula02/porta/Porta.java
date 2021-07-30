package porta;

public class Porta {
    private boolean aberta = true;
    private String nome = "Porta sem nome";

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public boolean estaAberta() {
        return aberta;
    }

    public int abrir() {
        if (aberta) return 1;
        this.aberta = true;
        return 0;
    }

    public int fechar() {
        if(!aberta) return 1;
        this.aberta = false;
        return 0;
    }
}
