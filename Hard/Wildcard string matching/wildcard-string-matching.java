//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0)
        {
            String wild = in.readLine();
            String pattern = in.readLine();
            
            Solution ob = new Solution();
            boolean flag = ob.match(wild, pattern);
            if(flag)
            System.out.println("Yes");
            else
            System.out.println("No");
        }
    }
}
// } Driver Code Ends

class Solution{
    static boolean match(String pattern, String str)
    {
        // code here
        int m = str.length();
        int n = pattern.length();
        boolean dp[][] = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i = 1; i <= m;i++){
            dp[i][0] = false; 
        }
        for(int j = 1; j <= n;j++){
            if(pattern.charAt(j - 1) == '*'){
              dp[0][j] = dp[0][j-1];
            }
        }
        for(int i = 1; i <= m;i++){
            for(int j = 1; j <= n;j++){
                if((pattern.charAt(j - 1) == str.charAt(i-1)) || (pattern.charAt(j - 1) == '?')){
                    dp[i][j] = dp[i-1][j-1];
                }else if(pattern.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j]; 
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }
}