//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    public int minimumEnergy(int arr[],int N){
        //code here
        int dp[] =  new int[N];
        Arrays.fill(dp, 0);
        dp[0] = 0;
          for(int i=1; i<N; i++){
              int f1 = dp[i-1] + Math.abs(arr[i] - arr[i-1]);
              int f2 = Integer.MAX_VALUE;
              if(i > 1)
               f2 = dp[i-2] + Math.abs(arr[i] - arr[i-2]);
               
               dp[i] = Math.min(f1, f2);
          }
          return dp[N-1];
    }
}