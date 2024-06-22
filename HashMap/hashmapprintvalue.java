import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] =  new int[10];
        for(int i=0; i<10; i++)
            {
                arr[i]= sc.nextInt();
            }
        // element , ferq
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for(int i=0;i<10;i++)
            {
                if(freqMap.containsKey(arr[i]))
                {
                    int currfreq = freqMap.get(arr[i]);
                    freqMap.put(arr[i],currfreq+1);
                }else
                {
                    freqMap.put(arr[i],1);
                }
            }
        for(int x : freqMap.keySet())
            {
                System.out.println(freqMap.get(x));
            }
        
    }

}
