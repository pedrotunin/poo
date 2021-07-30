package navegador;

public class Navegador {
    
    private int limiteAbas;
    private static String[] historico = new String[100];
    private AbaNavegador[] abasAbertas;

    public Navegador(int limiteAbas) {
        this.limiteAbas = limiteAbas;
        this.abasAbertas = new AbaNavegador[this.limiteAbas];
    }

    private int qtdAbasAbertas() {
        int qtd = 0;
        for (AbaNavegador aba : this.abasAbertas) {
            if (aba == null) continue;
            qtd++;
        }
        return qtd;
    }

    private Integer encontraPosicaoVazia() {
        for (int i = 0; i < this.abasAbertas.length; i++) {
            if (this.abasAbertas[i] == null) return i;
        }
        return null;
    }

    private static Integer encontraPosicaoHistorico() {
        for (int i = 0; i < historico.length; i++) {
            if (historico[i] == null) return i;
        }
        return null;
    }

    public AbaNavegador abrirAba(int tipo, String titulo) {
        if (this.qtdAbasAbertas() == this.limiteAbas) return null;

        AbaNavegador aba;
        Integer indice = this.encontraPosicaoVazia();
        if (indice == null) return null;

        if (tipo == 1) {
            aba = new AbaBuscador(titulo);
        } 
        
        else if (tipo == 2) {
            aba = new AbaRedeSocial(titulo);
        }

        else return null;

        this.abasAbertas[indice] = aba;
        return aba;
    }

    static void registraHistorico(String registro) {
        Integer indice = encontraPosicaoHistorico();
        if (indice == null) return;
        historico[indice] = registro;
    }

    private void arrumarVetor(int indice) {
        for (int i = indice; i < this.abasAbertas.length - 1; i++) {
            if (this.abasAbertas[i + 1] == null) return;
            this.abasAbertas[i] = this.abasAbertas[i + 1];
            this.abasAbertas[i + 1] = null;
        }
    }

    public void fecharAba(AbaNavegador aba) {
        int indice = -1;
        for (int i = 0; i < this.abasAbertas.length; i++) {
            if (this.abasAbertas[i] == null) return;
            if (aba.getTitulo() == this.abasAbertas[i].getTitulo() && aba.getTipo() == this.abasAbertas[i].getTipo()) {
                this.abasAbertas[i] = null;
                indice = i;
                break;
            }
        }
        if (indice == -1) return;
        this.arrumarVetor(indice);
    }

    public String[] getAbas() {
        int qtdAbasAbertas = this.qtdAbasAbertas();
        String[] abas = new String[qtdAbasAbertas];

        for (int i = 0; i < qtdAbasAbertas; i++) {
            abas[i] = this.abasAbertas[i].getTipo() + " " + this.abasAbertas[i].getTitulo();
        }
        return abas;

    }

    private static String[] historico() {

        int qtdItensHistorico = encontraPosicaoHistorico();
        String[] historicoFormatado = new String[qtdItensHistorico];

        for (int i = 0; i < qtdItensHistorico; i++) {
            historicoFormatado[i] = historico[i];
        }
        return historicoFormatado;

    }

    public String[] getHistorico() {
        return historico();
    }

}
