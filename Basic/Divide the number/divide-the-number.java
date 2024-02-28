//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.countWays(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long countWays(int N){
        // code here
        int c = 0;
        for(int i = 1; i<=N; i++){
            for(int j=i; j<=N; j++){
                for(int k=j; k<=N; k++){
                    if((N -(i+j+k)) >= k) c++;
                }
            }
        }
        return c;
    }
}