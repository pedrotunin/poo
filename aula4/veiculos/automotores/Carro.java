package automotores;

public class Carro extends Veiculo {

    private int nPortas;
    
    @Override
    public String getTipo() {
        return "Carro modelo " + this.getModelo();
    }

    public void setNumeroPortas(int nPortas) {
        this.nPortas = nPortas;
    }

    public int getNumeroPortas() {
        return this.nPortas;
    }

}