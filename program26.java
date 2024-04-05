import java.util.*;

public class Main {
    // CountFrequencyNumber
	static int countFreqDigit(int n,int d)
    {
        int totaldigit=0;
        while(n>0)
            {
                if(n%10==d)
                {
                    totaldigit++;
                }
                n/=10;
            }
        return totaldigit;
    }
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int d= sc.nextInt();
        System.out.println(countFreqDigit(n,d));
    }
}