import java.util.*;

public class Main {
    // Frequency of digit
	static int FrequencyofDigits(long n, int d) {
        int freq = 0;
        while(n>0)
            {
                int lastDigit = (int)(n%10);
                if(lastDigit == d)
                {
                    freq++;
                }
                n/=10;
            }
        return freq;
    }
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int d = sc.nextInt();
        System.out.println(FrequencyofDigits(n, d));
    }
}