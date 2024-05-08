import java.util.*;

class Main {
    static String[] keypad = {" ","ABC","DEF","GHI","JKL","MNO","PQRS","TU","VWX","YZ"};
    static void helper(int keys[],int i, ArrayList<String> ans, String curr)
    {
        if(i==keys.length)
        {
            ans.add(curr);
            return;
        }
        int currkey= keys[i];
        String key = keypad[currkey];

        for(int j=0; j<key.length(); j++)//Time comple O(4)^n
            {
                helper(keys,i+1,ans,curr+key.charAt(j));
            }
    }
    static ArrayList <String> OldPhone(int n, int[] keys){
        ArrayList<String>ans = new ArrayList<>();
		helper(keys,0,ans,"");
        return ans;
    }
	public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] keys = new int[n];
        for(int i=0;i<n;++i){
            keys[i] = sc.nextInt();
        }
        ArrayList <String> ans=OldPhone(n,keys);
        for(String i:ans) System.out.print(i+" ");
    }
}