import java.io.*;
import java.util.*;

class Accio {
    static int[] quickSort(int a[], int n) {
        int pivot = a[0]; // The pivot element
        List<Integer> left = new ArrayList<>(); // Elements less than pivot
        List<Integer> equal = new ArrayList<>(); // Elements equal to pivot
        List<Integer> right = new ArrayList<>(); // Elements greater than pivot

        for (int i = 0; i < n; i++) {
            if (a[i] < pivot) {
                left.add(a[i]);
            } else if (a[i] == pivot) {
                equal.add(a[i]);
            } else {
                right.add(a[i]);
            }
        }

        int[] result = new int[n];
        int index = 0;

        for (int num : left) {
            result[index++] = num;
        }
        for (int num : equal) {
            result[index++] = num;
        }
        for (int num : right) {
            result[index++] = num;
        }

        return result;
    }  
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();
        Accio Obj = new Accio();
        int[] result = Obj.quickSort(arr1, n);
        for(int i = 0; i < n; i++)
            System.out.print(result[i] + " ");       
        System.out.println('\n');
    }
}
