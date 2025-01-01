import java.util.Scanner;

class Solution {
    public static int count7(int n) {
        String str = Integer.toString(n);
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '7') {
                count++;
            }
        }

        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(Solution.count7(n));
    }
}
