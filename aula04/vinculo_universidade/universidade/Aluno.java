package universidade;

public class Aluno extends Pessoa {

    public Aluno() {

    }

    @Override
    public String getEmail() {
        return this.nome + "." + this.sobrenome + "@aluno.ufabc.edu.br"
    }

    @Override
    public String getVinculo() {
        return "Aluno da UFABC";
    }
    
};