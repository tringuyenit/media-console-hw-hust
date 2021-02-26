package Lab01;

import java.text.DecimalFormat;

public class FirstDegSys {
    private final DecimalFormat format = new DecimalFormat("0.00");

    private double a11;
    private double a12;
    private double a21;
    private double a22;

    private double b1;
    private double b2;

    public void setA11(double a11) {
        this.a11 = a11;
    }

    public void setA12(double a12) {
        this.a12 = a12;
    }

    public void setA21(double a21) {
        this.a21 = a21;
    }

    public void setA22(double a22) {
        this.a22 = a22;
    }

    public void setB1(double b1) {
        this.b1 = b1;
    }

    public void setB2(double b2) {
        this.b2 = b2;
    }

    public DecimalFormat getFormat() {
        return format;
    }

    public double getA11() {
        return a11;
    }

    public double getA12() {
        return a12;
    }

    public double getA21() {
        return a21;
    }

    public double getA22() {
        return a22;
    }

    public double getB1() {
        return b1;
    }

    public double getB2() {
        return b2;
    }

    public void solve(){

        double d = getA11() * getA22() - getA12() * getA21();

        if (d == 0){
            if (getA11()/getA21() == getB1()/getB2()){
                System.out.println("The system has infinitely many solutions");
            }else{
                System.out.println("The system has no solution");
            }
        }else{

            double d1 = getB1() * getA22() - getB2() * getA12();
            double d2 = getA11() * getB2() - getA21() * getB1();

            double x1 = d1 / d;
            double x2 = d2 / d;

            System.out.println("The system has a unique solution ("+format.format(x1)+", "+format.format(x2)+")");
        }
    }
}
