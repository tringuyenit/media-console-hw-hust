package Lab01;

import java.text.DecimalFormat;

public class SecondDeg {
    private final DecimalFormat format = new DecimalFormat("0.00");

    private double a;
    private double b;
    private double c;

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public void solve(){
        double delta = getB()*getB() - 4*getA()*getC();

        if (delta<0){
            System.out.println("The equation has no solution");
        }else if(delta == 0){
            double x = -getB()/(2*getA());
            System.out.println("the equation has double root x = "+format.format(x));
        }else{
            delta = Math.sqrt(delta);

            double x1 = (-getB() + delta)/(2*getA());
            double x2 = (-getB() - delta)/(2*getA());

            System.out.println("the equation has two distinct roots");
            System.out.println("x1 = "+format.format(x1));
            System.out.println("x2 = "+format.format(x2));
        }
    }
}
