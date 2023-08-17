//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Pair {
    int first, second, distance;
    
    Pair(int first, int second, int distance) {
        this.first = first;
        this.second = second;
        this.distance = distance;
    }
}
class Solution {
    public int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        int dist[][] = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
       
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new Pair(i, j, 0));
                    vis[i][j] = 1;
                } else {
                    vis[i][j] = 0;
                }
                dist[i][j] = Integer.MAX_VALUE; // Initialize dist with a large value.
            }
        }
       
        int drow[] = {-1, 0, 1, 0};
        int dcol[] = {0, 1, 0, -1};
       
        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            int step = q.peek().distance;
            q.poll();
            dist[row][col] = step; // Update the distance in the dist array.
           
            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.offer(new Pair(nrow, ncol, step + 1));
                }
            }
        }
        return dist;
    }
}

