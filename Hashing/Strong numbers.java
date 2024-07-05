import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    
    public static boolean strongNumbers(long n) {
        if (n <= 1) {
            return false; 
        }
        
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                long primeSquare = i * i;
                if (n % primeSquare != 0) {
                    return false;
                }
                
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        
        if (n > 1) {
            long primeSquare = n * n;
            if (n % primeSquare != 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        long n = Long.parseLong(br.readLine().trim());
        if(strongNumbers(n))
            System.out.println(1);
        else
            System.out.println(0);
    }
}
