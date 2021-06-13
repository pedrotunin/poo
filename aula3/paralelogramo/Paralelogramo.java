package aula3.paralelogramo;

public class Paralelogramo {
    
    private int ladoA = 0;
    private int ladoB = 0;

    public Paralelogramo(int lado) {
        this.ladoA = lado;
        this.ladoB = lado;
    }

    public Paralelogramo(int ladoA, int ladoB) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
    }

    public int getArea() {
        return this.ladoA * this.ladoB;
    }

    public String getTipo() {
        return "Paralelogramo " + (this.ladoA == this.ladoB ? "quadrado" : "retangulo");
    }
}
