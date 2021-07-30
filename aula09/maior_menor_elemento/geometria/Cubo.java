package geometria;

public class Cubo implements Comparable<Cubo> {
    
    private double lado;

    public Cubo(double lado) {
        this.lado = lado;
    }

    public double area() {
        return 6 * Math.pow(this.lado, 2);
    }

    @Override
    public int compareTo(Cubo c) {
        if (this.area() < c.area()) return -1;
        if (this.area() > c.area()) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return String.format("cubo de area %.1f", this.area());
    }

}
