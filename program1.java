import java.util.*;
public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        double inch = sc.nextDouble();
        double meterPerInch=0.0254;
        double meters=meterPerInch*inch;
        System.out.printf("%.3f",meters);
    }
}