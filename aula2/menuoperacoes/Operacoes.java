package menuoperacoes;

public class Operacoes {

    private int a, b, c;
    private int min, max;

    private void verificaMinMax(int value) {
        if (value > this.max || this.max == 0) this.setMax(value);
        if (value < this.min || this.min == 0) this.setMin(value);
    }

    private void setMin(int value) {
        this.min = value;
    }

    private void setMax(int value) {
        this.max = value;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int soma2() {
        this.verificaMinMax(this.a + this.b);
        return this.a + this.b;
    }

    public int soma3() {
        this.verificaMinMax(this.a + this.b + this.c);
        return this.a + this.b + this.c;
    }

    public int multiplica() {
        this.verificaMinMax(this.a * this.b);
        return this.a * this.b;
    }

    public int getMin() {
        return this.min;
    }

    public int getMax() {
        return this.max;
    }

}