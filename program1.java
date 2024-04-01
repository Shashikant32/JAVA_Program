import java.util.*;
public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        double inch = sc.nextDouble();
        double meterPerInch=0.0254; //Meter Per Inch
        double meters=meterPerInch*inch; // Multipley by Meter per Inch to INCH(Input Numbers)
        System.out.printf("%.3f",meters); //print the meters with 3 decimal places
    }
}