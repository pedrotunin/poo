package lampadainteligente.gerenciador;

import lampadainteligente.dispositivos.LampadaInteligente;

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

    public void ligarLampada(int indiceLampada) {
        if(this.lampadas[indiceLampada] == null || this.lampadas[indiceLampada].getEstado())
            return;
        this.lampadas[indiceLampada].ligar();
    }

    public void desligarLampada(int indiceLampada) {
        if(this.lampadas[indiceLampada] == null || !this.lampadas[indiceLampada].getEstado())
            return;
        this.lampadas[indiceLampada].desligar();
    }

    public void ligarTodasLampadas() {
        for (int i = 0; i < 10; i++) {
            if(this.lampadas[i] == null || this.lampadas[i].getEstado()) continue;
            this.lampadas[i].ligar();
        }  
    }

    public void desligarTodasLampadas() {
        for (int i = 0; i < 10; i++) {
            if(this.lampadas[i] == null || !this.lampadas[i].getEstado()) continue;
            this.lampadas[i].desligar();
        }   
    }
}
