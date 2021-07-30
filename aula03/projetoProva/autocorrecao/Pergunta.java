package aula3.projetoProva.autocorrecao;

public class Pergunta {
    private String textoPergunta;
    private Alternativa[] alternativas;
    private int indiceAlternativaCorreta;
    private int indiceUltimaAlternativa;

    public Pergunta(int qtdAlternativas, String textoPergunta) {
        this.alternativas = new Alternativa[qtdAlternativas];
        this.setTextoPergunta(textoPergunta);
        this.indiceAlternativaCorreta = -1;
        this.indiceUltimaAlternativa = -1;
    }

    private void setTextoPergunta(String textoPergunta) {
        this.textoPergunta = textoPergunta;
    }

    public String getTextoPergunta() {
        return this.textoPergunta;
    }

    public void adicionarAlternativa(boolean correta, Alternativa alternativa) {
        if (this.indiceUltimaAlternativa + 1 >= this.alternativas.length) {
            System.out.println("Lista de alternativas esta cheia.");
            return;
        }
        if (correta){

            if (this.indiceAlternativaCorreta == -1) {
                this.indiceAlternativaCorreta = this.indiceUltimaAlternativa + 1;
            } else {
                System.out.println("Existe outra alternativa correta.");
                return;
            }

        } 
        this.alternativas[++this.indiceUltimaAlternativa] = alternativa;
    }

    public void imprimir() {
        System.out.println("-------------------------------------");
        System.out.println("Enunciado: " + this.getTextoPergunta());
        for (Alternativa elemento : this.alternativas) {
            System.out.println("- " + elemento.getDescricao());
        }

    }
}
