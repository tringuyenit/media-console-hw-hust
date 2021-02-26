package Lab01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        FirstDeg bai1 = new FirstDeg();
        try {
            System.out.println("First-degree equation ax + b = 0");

            System.out.println("Input a : ");
            bai1.setA(Double.parseDouble(scanner.nextLine()));
            System.out.println("Input b : ");
            bai1.setB(Double.parseDouble(scanner.nextLine()));

            bai1.solve();
        }catch(Exception e){
            System.out.println("Input problems\n");
        }






        FirstDegSys bai2 = new FirstDegSys();
        try {
            System.out.println("First-degree system of equations");
            System.out.println("a11.x1 + a12.x2 = b1\na21.x1 + a22.x2 = b2");

            System.out.println("Input a11 : ");
            bai2.setA11(Double.parseDouble(scanner.nextLine()));
            System.out.println("Input a12 : ");
            bai2.setA12(Double.parseDouble(scanner.nextLine()));
            System.out.println("Input b1 : ");
            bai2.setB1(Double.parseDouble(scanner.nextLine()));

            System.out.println("Input a21 : ");
            bai2.setA21(Double.parseDouble(scanner.nextLine()));
            System.out.println("Input a22 : ");
            bai2.setA22(Double.parseDouble(scanner.nextLine()));
            System.out.println("Input b2 : ");
            bai2.setB2(Double.parseDouble(scanner.nextLine()));

            bai2.solve();
        }catch(Exception e){
            System.out.println("Input problems\n");
        }





        SecondDeg bai3 = new SecondDeg();
        try {
            System.out.println("Second-degree equation ax^2 + bx + c = 0");

            System.out.println("Input a : ");
            bai3.setA(Double.parseDouble(scanner.nextLine()));
            System.out.println("Input b : ");
            bai3.setB(Double.parseDouble(scanner.nextLine()));
            System.out.println("Input c : ");
            bai3.setC(Double.parseDouble(scanner.nextLine()));

            bai3.solve();
        }catch(Exception e){
            System.out.println("Input problems\n");
        }

    }
}
