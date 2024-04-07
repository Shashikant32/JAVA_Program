import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
       //the program should print the largest and smallest numbers.
        Scanner scanner = new Scanner(System.in);
        
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        
        char choice;
        do {
            int number = scanner.nextInt();
            
            if (number > largest) {
                largest = number;
            }
            if (number < smallest) {
                smallest = number;
            }
            choice = scanner.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
        
        System.out.println("Largest number: " + largest);
        System.out.println("Smallest number: " + smallest);
        
        scanner.close();
    }
}