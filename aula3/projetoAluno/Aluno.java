package aula3.projetoAluno;

public class Aluno {
    private String nome;
    private int ra;
    private static int qtdAlunos = 0;

    public Aluno(int ra, String nome) {
        qtdAlunos++;
        this.nome = nome;
        this.ra = ra;
    }

    public String getNome() {
        return this.nome;
    }

    public int getRA() {
        return this.ra;
    }

    public static int getQtdAlunos() {
        return qtdAlunos;
    }
}
