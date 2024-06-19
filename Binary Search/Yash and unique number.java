import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        int ans = Solution.uniqueElement(arr);
        System.out.println(ans);
    }
}

class Solution {
    static int uniqueElement(ArrayList<Integer> arr) {
        int unique = arr.get(0);
        for (int i = 0; i < arr.size() - 1; i += 2) {
            if (!arr.get(i).equals(arr.get(i + 1))) {
                unique = arr.get(i); 
                break;
            }
        }
        return unique;
    }
}
