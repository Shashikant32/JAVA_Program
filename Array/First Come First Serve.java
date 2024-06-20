import java.util.*;

public class Main{   
   
    public static void Solve(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        for (int i = 0; i < nums.length; i++) {
            int userId = nums[i];
            if (countMap.get(userId) == k) {
                System.out.println(userId);
                return;
            }
        }
        
        System.out.println(-1);
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt(); 
		int k = sc.nextInt();  

		int[] nums = new int[n]; 
		for(int i = 0; i < n; i++){
			nums[i] = sc.nextInt(); 
		} 
           
        Solve(nums, k); 
	}
}
