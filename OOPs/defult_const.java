import java.util.*;
import java.lang.*;
import java.io.*;
class Calculator{
    public Calculator()
    {
       // default constactor
    }
    public int add(int x, int y)
    {
        return x+y;
    }
    public int multiply(int x, int y)
    {
        return x*y;
    }
}

public class Main{
    
    public static void main(String args[]) {
        Calculator c=new Calculator();
        System.out.println(c.add(10,20));
        System.out.println(c.multiply(5,2));
   
    }
}