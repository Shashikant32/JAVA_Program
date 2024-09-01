import java.util.*;

class Solution {
    static int minSwapsToBalance(String s, int n) {
        int m=s.length();
        int open = 0;
        int close = 0;
        int fault = 0;
        int ans=0;
        for(int i=0;i<m;i++){
            char c=s.charAt(i);
            if(s.charAt(i)==')'){
                close++;
                fault=close-open;
            }
            else {
                open++;
                if(fault>0){
                    ans+=fault;
                    fault--;
                   
                }
            }
        }
            return ans;
        
   
        
     
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String brackets = sc.next();
        int ans = Solution.minSwapsToBalance(brackets, n);
        System.out.println(ans);
    }
}
