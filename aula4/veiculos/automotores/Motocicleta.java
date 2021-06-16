package automotores;

public class Motocicleta extends Veiculo {

    boolean temCarroLateral;

    @Override
    public String getTipo() {
        return "Motocicleta modelo " + this.getModelo();
    }

    public void setTemCarroLateral(boolean temCarroLateral) {
        this.temCarroLateral = temCarroLateral;
    }    

    public boolean getTemCarroLateral() {
        return this.temCarroLateral;
    }

}