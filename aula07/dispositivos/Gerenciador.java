package dispositivos;

abstract class DispositivoInteligente {

    private boolean estado = false;

    public void ligar() {
        this.estado = true;
    }  
    public void desligar() {
        this.estado = false;
    }
    public boolean getEstado() {
        return this.estado;
    } 

}

class TomadaInteligente extends DispositivoInteligente {

    @Override
    public void ligar() {
        super.ligar();
    }  
    @Override
    public void desligar() {
        super.desligar();
    }
    @Override
    public boolean getEstado() {
        return super.getEstado();
    } 

}

class LampadaInteligente extends DispositivoInteligente {

    @Override
    public void ligar() {
        super.ligar();
    }  
    @Override
    public void desligar() {
        super.desligar();
    }
    @Override
    public boolean getEstado() {
        return super.getEstado();
    } 

}

class InterruptorInteligente extends DispositivoInteligente {

    @Override
    public void ligar() {
        super.ligar();
    }  
    @Override
    public void desligar() {
        super.desligar();
    }
    @Override
    public boolean getEstado() {
        return super.getEstado();
    } 

}

public class Gerenciador {
    private DispositivoInteligente[] dispositivos = new DispositivoInteligente[10]; 
    private int ultimoIndice = -1;

    public void adicionarDispositivo(DispositivoInteligente d) {
        this.dispositivos[++this.ultimoIndice] = d;
    }

    public void ligarTodosDispositivos() {
        for (int i = 0; i < this.dispositivos.length; i++) {
            if (this.dispositivos[i] == null) break;
            this.dispositivos[i].ligar();
        }
    }

    public void desligarTodosDispositivos() {
        for (int i = 0; i < this.dispositivos.length; i++) {
            if (this.dispositivos[i] == null) break;
            this.dispositivos[i].desligar();
        }
    }

}