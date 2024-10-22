import java.util.*;
class Node {
    int data;
    Node left, right;
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree
{
    Node constructBST(int[]arr,int start,int end,Node root)
    {
        if(start>end)
            return null;
        int mid=(start+end)/2;

        if(root==null)
            root=new Node(arr[mid]);

        root.left=constructBST(arr,start,mid-1, root.left);
        root.right=constructBST(arr,mid+1,end, root.right);

        return root;

    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i < n; i++) 
        {
            arr[i] = sc.nextInt(); 
        }

        Arrays.sort(arr);
        Node root=null;
        BinarySearchTree bst=new BinarySearchTree();
        root=bst.constructBST(arr,0,n-1,root);
            
        Accio A = new Accio();
        int ans=A.kthLargest(root,k);
        System.out.println(ans);
        sc.close();
        
    }
}

class Accio
{ 
    int kthLargest(Node root, int k){ 
       Counter counter = new Counter();
        return revInT(root, k, counter);
    } 
    private int revInT(Node node , int k ,Counter counter)
    {
        if(node == null)
        {
            return -1;
        }

        int result = revInT(node.right, k , counter);
        if(result != -1)
        {
            return result;
        }
        counter.count++;
        if(counter.count == k)
            return node.data;
        return revInT(node.left,k,counter);
    }
    static class Counter{
        int count=0;
    }
}