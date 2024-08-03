import java.util.*;
import java.io.*;
 
class Graph {
    public int vertices;
    public ArrayList<Integer>[] adjList;
 
    Graph(int v) {
        this.vertices = v+1;
        adjList = new ArrayList[v+1];
        
        for (int i = 0; i <= v; i++) adjList[i] = new ArrayList<Integer>();
    }
 
    void addEdge(int v, int w) {// v-->w
        adjList[v].add(w);
     
    }
 
    void BFS(int x) {
        // your code here
        // alredy adj list given
        int [] vis =  new int[vertices];// O(V)
        Queue<Integer> q = new LinkedList<>();// O(V)
        vis[x]=1;
        q.add(x);
        while(!q.isEmpty())//O(V + E) --> TC
            {
                int tmp = q.remove();
                System.out.print(tmp+" ");
                // travel in adj of tmp
                for(Integer it : adjList[tmp])
                    {
                        if(vis[it]==0)
                        {
                          vis[it]=1;
                          q.add(it);  
                        }
                        
                    }
            }
    }
}
 
public class Main {
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        Graph g = new Graph(110);
        for(int i =0;i<e;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            g.addEdge(x,y);
        }
        g.BFS(0);
    }
}
