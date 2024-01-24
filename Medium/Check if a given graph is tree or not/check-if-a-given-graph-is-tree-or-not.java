//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-- > 0)
        {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
    
            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(u);
                edge.add(v);
                edges.add(edge);
            }
    
            Solution solution = new Solution();
            boolean result = solution.isTree(n, m, edges);
    
            if (result==true) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


class Solution {
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) 
    {
        // code here
        if(m!=n-1)return false;
        boolean[]vis=new boolean[n];
        ArrayList<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<m;i++){
            adj[edges.get(i).get(0)].add(edges.get(i).get(1));
            adj[edges.get(i).get(1)].add(edges.get(i).get(0));
            
        }
    Queue<Integer>q=new LinkedList<>();
    vis[0]=true;
    q.add(0);
    int total=1;
    while(!q.isEmpty()){
        int s=q.poll();
        for(int nei:adj[s]){
            if(vis[nei]!=true){
                vis[nei]=true;
                q.add(nei);
                total++;
            }
        }
    }
    return total==n;
        
    }
}