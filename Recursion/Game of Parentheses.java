

import java.util.*;
class Solution {
    public ArrayList<Integer> diffWaysToCompute(String input) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i < input.length(); i++)
            {
                char c = input.charAt(i);
                if(c == '+' || c == '-' || c == '*')
                {
                   ArrayList<Integer> leftpart =diffWaysToCompute(input.substring(0,i));
                     ArrayList<Integer> rightpart =diffWaysToCompute(input.substring(i + 1));

                    for(int left : leftpart)
                        {
                            for(int right : rightpart)
                                {
                                    switch(c)
                                        {
                                            case '+':
                                                result.add(left + right);
                                                break;
                                            case '-':
                                                result.add(left - right);
                                                break;
                                            case '*':
                                                result.add(left * right);
                                                break;
                                        }
                                }
                        }
                }
            }
        if(result.isEmpty())
        {
            result.add(Integer.parseInt(input));
        }
        return result;
    }
} 


public class Main {

    public static void main(String args[]) {
        
            Scanner scn = new Scanner(System.in);  
            String str= scn.nextLine();   

            Solution obj = new Solution() ; 
            ArrayList<Integer> ans = obj.diffWaysToCompute(str);
            Collections.sort(ans);

            for(int i = 0 ; i < ans.size() ; i++){
                System.out.print(ans.get(i)+ " ");
            }
        System.out.println();

    }
}




