package quadrilateros;

public class Paralelogramo extends Quadrilatero {

    @Override
    public void setLados(double ladoA, double ladoB) {
        super.setLados(ladoA, ladoB, ladoA, ladoB);
    }

    @Override
    public String getPropriedades() {
        return super.getPropriedades() + " Lados opostos paralelos.";
    }

}