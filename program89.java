import java.util.*;

class Main
{
    public static boolean isPrime(int n)
    //Composite Numbers
    {
    for(int i=2; i*i<=n; i++)
        {
            if(n%i==0)
            {
                return false;
            }
        }
        return true;
    }
   

static ArrayList<Integer> removeComposite(int arr[], int len)
{
	ArrayList<Integer> Composites = new ArrayList<>();
    for(int i=0;i<len; i++)
        {
            if(isPrime(arr[i])==true)
            {
                Composites.add(arr[i]);
            }
        }
        return Composites;
}

public static void main(String[] args)
{
	Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i=0; i<n; i++){
        arr[i] = sc.nextInt();
    }
	ArrayList<Integer> list = removeComposite(arr, n);
    for(int val : list) System.out.print(val+" ");

}
}
