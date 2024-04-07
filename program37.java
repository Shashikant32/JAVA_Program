import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) {
        //Star Pattern
        int h=3;
        int b=5;
        for(int i=0;i<=h;i++)
            {
                for(int j=0; j<=b; j++)
                    {
                        if(j<=i*2){
                        System.out.print("*");
                        }else{
                            System.out.print("");
                        }
                    }
                System.out.println();
            }
    }
}