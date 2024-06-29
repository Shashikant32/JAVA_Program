import java.io.*;
import java.util.*; 

class Main{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M[][] = new int[N][N];
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                M[i][j] = sc.nextInt();
        System.out.println(new Solution().findCelebrity(M,N));
    } 
} 
class Solution
{ 
    int findCelebrity(int M[][], int n)
    {
       Stack<Integer> st = new Stack<>();
    // push all the possible celebrities
        for(int i=0; i<n; i++)
            {
                st.push(i);
            }
        while(st.size() > 1)
            {
                int p1 = st.pop();
                int p2 = st.pop();

                if(M[p1][p2]==1)
                {
                    st.push(p2);
                }
                else
                {
                    st.push(p1);
                }
            }
        int possibleCelebrity = st.peek();

        int row = possibleCelebrity;
        for(int j=0; j<n; j++)
            {
                if(j != row && M[row][j] == 1)
                {
                    return -1;
                }
            }
        
         int col = possibleCelebrity;
         for(int i=0; i<n; i++)
            {
                if(i != col && M[i][col] == 0)
                {
                    return -1;
                }
            }
        return possibleCelebrity;
    }

}