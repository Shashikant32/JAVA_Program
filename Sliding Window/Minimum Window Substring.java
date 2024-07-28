import java.util.*;
class Solution {
    public String minWindow(String s, String t) {
//         if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
//             return "";
//         }
        
//         int[] required = new int[128];
//         for (char c : t.toCharArray()) {
//             required[c]++;
//         } 
//         int left = 0, right = 0;
//         int minLength = Integer.MAX_VALUE;
//         int minLeft = 0;
//         int count = t.length(); 
        
//         int[] window = new int[128];
        
//         while (right < s.length()) {
//             char rightChar = s.charAt(right);
//             window[rightChar]++;
            
//             if (required[rightChar] > 0 && window[rightChar] <= required[rightChar]) {
//                 count--;
//             }
            
//             while (count == 0) {
//                 if (right - left + 1 < minLength) {
//                     minLength = right - left + 1;
//                     minLeft = left;
//                 }
                
//                 char leftChar = s.charAt(left);
//                 window[leftChar]--;
                
//                 if (required[leftChar] > 0 && window[leftChar] < required[leftChar]) {
//                     count++;
//                 }
                
//                 left++;
//             }
            
//             right++;
//         }
        
//         return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
//     }
// }
int[] f1 = new int [60];
int[] f2 = new int [60];
// fill f1 with t
for(int i=0;i<t.length(); i++) f1[(int)(t.charAt(i)- 'A')]++;
for(int i=0;i<t.length()-1; i++) {
    f2[(int)(s.charAt(i)- 'A')]++;  
    }
int j=t.length()-1,i=0,anslen = Integer.MAX_VALUE;
String ans ="";
while(j<s.length())
{
f2[(int)(s.charAt(j)-'A')]++;
boolean flag = true;
for(int k=0;k<60; k++)
    {
        if(f1[k] !=0 && f1[k]> f2[k]) flag= false;
    }
while(flag)
    {
        if(anslen>j-i+1)
        {
            anslen=j-i+1;
            ans= s.substring(i,i+anslen);
        }
        f2[(int)(s.charAt(i)-'A')]--;
        if(f1[(int)(s.charAt(i)-'A')]>f2[(int)(s.charAt(i)-'A')]) flag= false;
        i++;
    }
j++;
}
return ans;
}
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        Solution obj = new Solution();
        System.out.println(obj.minWindow(s, t));
    }
}
