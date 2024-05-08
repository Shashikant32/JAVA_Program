import java.util.*;
class Accio {
    
    public void printPermutations(String str) {
        TreeSet<String> ans = new TreeSet<>();
        helper(str,0,ans);
        for(String ele:ans)//for each loop
            {
                System.out.println(ele);
            }
    }
    static void helper(String str, int i,TreeSet<String> ans)
    {
        if(i==str.length())
        {
            ans.add(str);
            return;
        }
        for(int j=i; j<str.length(); j++)
            {
                str =swap(str,i,j);
                helper(str,i+1,ans);
                //str=swap(str,i,j);// backtracking step
            }
    }
    static String swap(String str, int i, int j)
    {
        char[] arr = str.toCharArray();
        char temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return String.valueOf(arr);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Accio Obj = new Accio();
        Obj.printPermutations(str);
    }
}