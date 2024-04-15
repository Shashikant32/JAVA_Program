import java.util.*;
class Solution{
	public static void sumOfDigits(int num){
        //Sum of Digits of Numbers
		int sum=0;
        while(num>0)
            {
                sum+=num%10;
                num/=10;
            }
        System.out.println(sum);
	}
}
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        for(int i=1; i<=n; i++)
            {
                Solution.sumOfDigits(i);
            }
		
	}
}