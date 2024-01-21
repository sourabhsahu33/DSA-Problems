//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int m; 
            m = Integer.parseInt(br.readLine());
            
            
            int[][] edges = IntMatrix.input(br, m, 2);
            
            Solution obj = new Solution();
            int res = obj.vertexCover(n, m, edges);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

class Solution {
    public static void allSubsets(int i, int n, int[] arr, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans){
        if(i == n){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        // Take
        list.add(arr[i]);
        allSubsets(i+1, n, arr, list, ans);
        
        // notTake
        if(list.size() > 0)
         list.remove(list.size()-1);
        
        allSubsets(i+1, n, arr, list, ans);
        
        
    }
    
    public static boolean allPresent(int[][] edges, ArrayList<Integer> list){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < list.size(); i++)set.add(list.get(i));
        for(int[] edge : edges){
            int v = edge[0];
            int u = edge[1];
            if((!set.contains(v)) && (!set.contains(u)))return false;
        }
        
        return true;
    }
    
    public static int vertexCover(int n, int m, int[][] edges) {
        
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)arr[i] = i+1;
        
        ArrayList<ArrayList<Integer>> subSets = new ArrayList<>();
        allSubsets(0, n, arr, new ArrayList<>(), subSets);
        
        int mini = n;
        
        for(ArrayList<Integer> list : subSets){
            if(allPresent(edges, list)){
                mini = Math.min(list.size(), mini);
            }
        }
        
        return mini;

}

}    
