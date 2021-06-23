public class CrachaFuncionario extends Cracha {
    
    private String cargo;
    private int a;
    private int m;

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setDataAdmissao(int m, int a) {
        this.m = m;
        this.a = a;
    }

    private String getCargo() {
        return this.cargo;
    }

    private String getAdmissao() {
        return this.m + "/" + this.a;
    }

    @Override
    public void imprimir() {
        Impressao.imprimirLinha("FUNCIONARIO");
        Impressao.imprimirLinha("Nome: " + super.getNome());
        Impressao.imprimirLinha("Cargo: " + this.getCargo());
        Impressao.imprimirLinha("Admissao: " + this.getAdmissao());
    }

}