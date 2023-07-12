//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {

    boolean dfs(int u, List<List<Integer>> adj, boolean[] is_visited,
                boolean[] in_stack, boolean[] nodes_present_in_cycle) {
        is_visited[u] = true;
        in_stack[u] = true;

        for (int v : adj.get(u)) {
            if (!is_visited[v]) {
                boolean is_cycle_present =
                    dfs(v, adj, is_visited, in_stack, nodes_present_in_cycle);
                if (is_cycle_present) {
                    return nodes_present_in_cycle[u] = true;
                }
            } else if (is_visited[v] && in_stack[v]) {
                return nodes_present_in_cycle[u] = true;
            }
        }

        in_stack[u] = false;
        return false;
    }

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        List<Integer> safeNodes = new ArrayList<>();
        boolean[] is_visited = new boolean[V];
        boolean[] in_stack = new boolean[V];
        boolean[] nodes_present_in_cycle = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!is_visited[i]) {
                dfs(i, adj, is_visited, in_stack, nodes_present_in_cycle);
            }
        }

        for (int i = 0; i < V; i++) {
            if (!nodes_present_in_cycle[i]) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }
};