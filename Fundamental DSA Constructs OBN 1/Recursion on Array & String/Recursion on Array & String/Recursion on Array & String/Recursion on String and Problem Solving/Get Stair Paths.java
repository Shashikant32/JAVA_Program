import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList<String> paths = getStairPaths(n);
        System.out.println(paths);
    }

    public static ArrayList<String> getStairPaths(int n) {
        ArrayList<String> res = new ArrayList<>();
        helper(n,"",res);
        return res;
    }
       static void helper(int n,String pathSoFar,ArrayList<String> res) {
        if(n==0)
        {
           res.add(pathSoFar);
            return;
        }
        // 3 choice
        helper(n-1,pathSoFar+ "1",res);
        if(n>=2)
        helper(n-2,pathSoFar+ "2",res);
        if(n>=3)
        helper(n-3,pathSoFar+ "3",res);
        
    }
}


                        
                                