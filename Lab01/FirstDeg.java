package Lab01;

import java.text.DecimalFormat;

public class FirstDeg {

    private final DecimalFormat format = new DecimalFormat("0.00");

    private double a;
    private double b;

    public FirstDeg(){

    }

    public FirstDeg(double a, double b){
        // did not use this because we need clear code
        setA(a);
        setB(b);
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public void solve() {
        if (a == 0){
            System.out.println("No solution\n");
        }else{
            double solution = -getB()/getA();
            System.out.println("The solution is " + format.format(solution));
        }
    }
}
