package aula3.projetoProva.autocorrecao;

public class Prova {

    private Pergunta[] perguntas;
    private int indiceUltimaPergunta;

    public Prova(int qtdPerguntas) {
        this.perguntas = new Pergunta[qtdPerguntas];
        this.indiceUltimaPergunta = -1;
    }

    public void adicionarPergunta(Pergunta novaPergunta) {
        if (indiceUltimaPergunta + 1 >= this.perguntas.length) {
            System.out.println("Vetor de perguntas esta cheio.");
            return;
        }
        this.perguntas[++this.indiceUltimaPergunta] = novaPergunta;
    }

    public void imprimir() {
        System.out.println("------- PROVA -------");
        for (Pergunta elemento : this.perguntas) {
            elemento.imprimir();
        }
    }
}