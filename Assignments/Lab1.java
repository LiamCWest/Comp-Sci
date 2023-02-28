package Assignments;

import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String shape = Input(sc, "What shape would you like to calculate values for?\n1. Rectangle\n2. Circle\n3. Trapezoid\n4. Cone\n");
        switch (shape) {
            case "1":
            case "Rectangle":
                Rectangle(sc);
                break;
            case "2":
            case "Circle":
                Circle(sc);
                break;
            case "3":
            case "Trapezoid":
                Trapezoid(sc);
                break;
            case "4":
            case "Cone":
                Cone(sc);
                break;
            default:
                break;
        }
    }

    static void Rectangle(Scanner sc){
        Double length = Double.parseDouble(Input(sc, "Length: "));
        Double width = Double.parseDouble(Input(sc, "Width: "));
        Double A = length*width;
        Double P = (length+width)*2;
        System.out.printf("Area: %3.2f\nPerimeter: %3.2f\n", A, P);
    }

    static void Circle(Scanner sc){
        Double raduis = Double.parseDouble(Input(sc, "Radius: "));
        Double A = Math.PI*Math.pow(raduis, 2);
        Double C = (Math.PI*raduis)*2;
        System.out.printf("Area: %3.2f\nCircumference: %3.2f\n", A, C);
    }

    static void Trapezoid(Scanner sc){
        Double a = Double.parseDouble(Input(sc, "a: "));
        Double b = Double.parseDouble(Input(sc, "b: "));
        Double c = Double.parseDouble(Input(sc, "c: "));
        Double d = Double.parseDouble(Input(sc, "d: "));
        Double h = Double.parseDouble(Input(sc, "Height: "));
        Double A = ((a+b)*h/2);
        Double P = a+b+c+d;
        System.out.printf("Area: %3.2f\nPerimeter: %3.2f\n", A, P);
    }

    static void Cone(Scanner sc){
        Double raduis = Double.parseDouble(Input(sc, "Radius: "));
        Double height = Double.parseDouble(Input(sc, "Height: "));
        Double Vol = Math.PI*Math.pow(raduis, 2)*(height/3);
        Double SA = Math.PI*raduis*(raduis+Math.sqrt(Math.pow(height, 2)+Math.pow(raduis, 2)));
        System.out.printf("Volume: %4.3f\nSurface Area: %4.3f\n", Vol, SA);
    }

    static String Input(Scanner sc, String q){
        System.out.print(q);
        return sc.next();
    }

}
