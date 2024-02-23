//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine().trim());
            
            
            int[] price = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.maxProfit(n, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

class Solution {
    public static int maxProfit(int n, int[] arr) {
        // code here
        int dp[][][]=new int[n+1][3][2];
        
        for(int i=n-1;i>=0;i--){
            for(int isbuy=0;isbuy<=1;isbuy++){
                for(int tran=1;tran<=2;tran++){
                    int ans=0;
                    if(isbuy==1){
                        int buy=dp[i+1][tran][0]-arr[i];
                        int notBuy=dp[i+1][tran][1];
                        ans+=Math.max(buy,notBuy);
                        dp[i][tran][isbuy]=ans;
                    }
                    else{
                        int sell=arr[i]+dp[i+1][tran-1][1];
                        int notSell=dp[i+1][tran][0];
                        dp[i][tran][isbuy]=Math.max(sell,notSell);
                    }
                }
            }
        }
        return dp[0][2][1];
    }
} 
