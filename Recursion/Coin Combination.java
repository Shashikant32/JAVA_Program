import java.util.*; 

class Solution{

    public List<List<Integer>> CoinCombination(int k, int n) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> combination = new ArrayList<>();
        findcombo(result , combination , k , n , 1);
        return result;
        
   }
    private void findcombo(List<List<Integer>> result, List<Integer> combination, int k, int n, int start )
    {
        if(combination.size() == k && n== 0)
        {
            result.add(new ArrayList<>(combination));
            return;
        }
        if(combination.size()== k || n<0)
        {
            return;
        }
       for(int i = start; i <= 9; i++)
           {
               combination.add(i);
               findcombo(result,combination , k , n - i,i + 1 );
               combination.remove(combination.size()-1);
           }
    }

}

public class Main {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in); 
        int k = scn.nextInt(); 
        int n = scn.nextInt(); 

        Solution sol = new Solution(); 
         
        List<List<Integer>> ans = sol.CoinCombination(k,n); 
        
        if(ans.size()==0){
            System.out.println(-1);  
            return;
        }

        for(List<Integer> v:ans){
            for(int ele : v){
                System.out.print(ele+" "); 
            } 
            System.out.println(); 
        }
    } 

}