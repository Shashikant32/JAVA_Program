import java.io.*;
import java.util.*;
import java.util.Scanner;
public class Main {
    public static void main(String args[]) {
        // Second Largest Intrger
        Scanner scr = new Scanner(System.in);
        int []array = new int[5];
        

        for(int i=0; i<5; i++)
            {
                array[i] = scr.nextInt();
            }
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for(int i=0;i<5; i++)
            {
                if(array[i]>largest)
                {
                    secondLargest = largest;
                    largest = array[i];
                }else if(array[i]>secondLargest && array[i] != largest)
                {
                    secondLargest=array[i];
                }
            }
        System.out.println(secondLargest);
    }
}