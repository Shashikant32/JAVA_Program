import java.math.*;
import java.util.Scanner;
import java.math.*;

class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    public void add(Fraction other) {
        // a/b + c/d = (a*d + b*c) / (b*d)
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        this.numerator = newNumerator;
        this.denominator = newDenominator;
        simplify();
    }

    public void multiply(Fraction other) {
        // a/b * c/d = (a*c) / (b*d)
        this.numerator *= other.numerator;
        this.denominator *= other.denominator;
        simplify();
    }

    private void simplify() {
        int gcd = gcd(Math.abs(this.numerator), this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public void print() {
        System.out.println(this.numerator + "/" + this.denominator);
    }
}

public class Main {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int den1 = sc.nextInt();

        Fraction f = new Fraction(num1, den1);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            int num2 = sc.nextInt();
            int den2 = sc.nextInt();
            if (type == 1) {
                Fraction f2 = new Fraction(num2, den2);
                f.add(f2);
                f.print();
            } else if (type == 2) {
                Fraction f2 = new Fraction(num2, den2);
                f.multiply(f2);
                f.print();
            }
        }
    }
}
