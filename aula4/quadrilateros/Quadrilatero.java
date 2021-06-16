package quadrilateros;

public class Quadrilateros {

    private double ladoAB = 0;
    private double ladoBC = 0;
    private double ladoCD = 0;
    private double ladoDA = 0;

    public void setLados(double ladoAB, double ladoBC, double ladoCD, double ladoDA) {
        this.ladoAB = ladoAB;
        this.ladoBC = ladoBC;
        this.ladoCD = ladoCD;
        this.ladoDA = ladoDA;
    }

    public double getPerimetro() {
        return this.ladoAB + this.ladoBC + this.ladoCD + this.ladoDA;
    }

    public String getPropriedades() {
         return "Figura de quatro lados.";
    }

}