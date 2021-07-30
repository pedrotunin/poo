package quadrilateros;

public class Quadrado extends Retangulo {

    @Override
    public void setLados(double lado) {
        super.setLados(lado, lado);
    }

    @Override
    public String getPropriedades() {
        return super.getPropriedades() + " Todos os lados tem o mesmo tamanho."
    }

}