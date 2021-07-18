import dispositivos.LampadaInteligente;

class LampadaEstaLigada extends Exception {

    public LampadaEstaLigada() {
        super("A lampada ja esta ligada.");
    }

}

class LampadaEstaDesligada extends Exception {

    public LampadaEstaDesligada() {
        super("A lampada ja esta desligada.");
    }

}

public class GerenciadorLampadas {

    private LampadaInteligente[] lampadas = new LampadaInteligente[10];

    private Integer encontraPosicao() {
        for (int i = 0; i < 10; i++) {
            if (this.lampadas[i] == null) return i;
        }
        return null;
    }

    public void adicionarLampada() {
        Integer indice = this.encontraPosicao();
        if (indice == null) return;

        LampadaInteligente lampada = new LampadaInteligente();
        lampadas[indice] = lampada;
    }

    public void ligarLampada(int indiceLampada) throws LampadaEstaLigada {

        if (this.lampadas[indiceLampada].getEstado())
            throw new LampadaEstaLigada();

        this.lampadas[indiceLampada].ligar();

    }

    public void desligarLampada(int indiceLampada) throws LampadaEstaDesligada {

        if (!this.lampadas[indiceLampada].getEstado())
            throw new LampadaEstaDesligada();

        this.lampadas[indiceLampada].desligar();
        
    }

}