import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        Item arr[] = new Item[n];
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            arr[i] = new Item(value, 0);
        }
        for (int i = 0; i < n; i++) {
            arr[i].weight = sc.nextInt();
        }
        double ans = (new Solution()).fractionalKnapsack(w, arr, n);
        System.out.println(String.format("%.2f", ans));
    }
}

class Solution {
    double fractionalKnapsack(int W, Item arr[], int n) {
        double[][] itemRatio = new double[n][3]; // [0] for value, [1] for weight, [2] for value/weight ratio

        for (int i = 0; i < n; i++) {
            itemRatio[i][0] = arr[i].value;
            itemRatio[i][1] = arr[i].weight;
            itemRatio[i][2] = arr[i].value / (double)arr[i].weight; // Compute ratio
        }

        Arrays.sort(itemRatio, (a, b) -> Double.compare(b[2], a[2]));

        double totalValue = 0.0;
        int remainingCapacity = W;

        for (int i = 0; i < n && remainingCapacity > 0; i++) {
            if (remainingCapacity >= itemRatio[i][1]) {
                totalValue += itemRatio[i][0];
                remainingCapacity -= itemRatio[i][1];
            } else {
                totalValue += itemRatio[i][0] * (remainingCapacity / itemRatio[i][1]);
                remainingCapacity = 0;
            }
        }

        return totalValue;
    }
}
