import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
   static ArrayList<String>ans;
   public static void printAllPath(ArrayList<Edge>[]graph , int src , int dest , int n){ 
      //Your code here
      //algo
       ans=new ArrayList<>();//O(n*no. of paths)
       String tmp="";
       int[] pvis=new int[n];
       //dfs
       dfs(graph,src,dest,pvis,tmp);

       for(int i=0;i<ans.size();i++){
           System.out.println(ans.get(i));
       }
       
   }
    //node se lekw destination ke path ko find or store karega
    public static void dfs(ArrayList<Edge>[]graph,int node,int dest,int[] pvis,String tmp){
        //base case
        tmp=addNodeToTemp(tmp,node);//O(1)
        if(node==dest){
            ans.add(tmp);
            return ;
        }
        pvis[node]=1;
        for(Edge it:graph[node]){
            if(pvis[it.nbr]==0){
                dfs(graph,it.nbr,dest,pvis,tmp);
            }
        }
        pvis[node]=0;
    }

    //temp ke end me int node ko string form me add kar dega
    public static String addNodeToTemp(String tmp,int node){
        ArrayList<Integer>a=new ArrayList<>();
        if(node==0){
            tmp=tmp+(char)(int)((int)'0'+0);
        }
        while(node>0){
            a.add(node%10);
            node/=10;
        }
        String tmp2="";
        for(int i=a.size()-1;i>=0;i--){
            tmp2+=(char)(a.get(i)+(int)'0');
        }
        tmp+=tmp2;
        return tmp;
    }
   

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
      }

      int src = Integer.parseInt(br.readLine());
      int dest = Integer.parseInt(br.readLine());

      printAllPath(graph,src,dest,vtces);
   }


}