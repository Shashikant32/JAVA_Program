import java.io.*;
import java.util.*;
class Main {
	static void toh(int n, int source, int destination,int auxiliary ) {
        if(n==1)
        {
            System.out.println("move disk 1 from rod " + source + " to rod "+ destination);;
            return;
        }
        toh(n-1, source, auxiliary,destination);
        System.out.println("move disk "+ n + " from rod "+ source + " to rod " + destination);
        toh(n-1 , auxiliary,destination,source);
       
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        
        N = sc.nextInt();

        toh(N, 1, 3, 2);

        sc.close();
    }
}

