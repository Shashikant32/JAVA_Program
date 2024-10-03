import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        String ans = Solution.possibleToMakeTriangle(arr);
        System.out.println(ans);
    }
}

class Solution {
    static String possibleToMakeTriangle(ArrayList<Integer> arr) {
        Collections.sort(arr);
        
        for (int i = 0; i < arr.size() - 2; i++) {
            if (arr.get(i) + arr.get(i + 1) > arr.get(i + 2)) {
                return "YES"; 
            }
        }
    
        
        return "NO"; 
    }
}
