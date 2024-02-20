//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> dictionary = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            dictionary.add(p);
                        }
                    String s = sc.next();
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(n, s, dictionary));  
                    
                }
        }
}
// } Driver Code Ends


class Solution
{
    public static int wordBreak(int n, String s, ArrayList<String> dictionary )
    {
       Set<String> ws = new HashSet<>(dictionary);
        int N = s.length();
        boolean[] dp = new boolean[N + 1];
        dp[0] = true;

        for (int i=1;i<=N;i++) {
            for (int j=0;j<i;j++) {
                if (dp[j]&&ws.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }

        return dp[N] ?1:0;
    }
}