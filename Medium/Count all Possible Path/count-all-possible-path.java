//{ Driver Code Starts
//Initial Template for Java

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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] paths = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    paths[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.isPossible(paths);
            System.out.println(ans);

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int isPossible(int[][] paths)
    {
      int n = paths.length;
      int deg[] = new int[n];
      Arrays.fill(deg, 0);
      for(int i=0; i<n; i++){
          for(int j=0; j<n; j++){
              if(paths[i][j] == 1){
                  deg[i]++;
              }
          }
      }
      for(int i=0; i<n; i++){
          if(deg[i] % 2 != 0){
              return 0;
          }
      }
      return 1;
    }
}