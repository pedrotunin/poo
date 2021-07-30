package automotores;

public class Veiculo {

    private String modelo;

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return "Veiculo generico modelo " + this.getModelo();
    }

    public String getModelo() {
        return this.modelo;
    }
    
}