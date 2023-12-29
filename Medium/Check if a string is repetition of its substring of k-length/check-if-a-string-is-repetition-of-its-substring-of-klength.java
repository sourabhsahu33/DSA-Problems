//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String s = sc.next();
            int k = sc.nextInt();
            int answer = new Solution().kSubstrConcat(n,s,k);
    		System.out.println(answer);
        }
        
    }
}

// Contributed By: Pranay Bansal

// } Driver Code Ends




class Solution
{
    int kSubstrConcat(int n, String s, int k)
    {
        if(n%k!=0) return 0;
        
        int idx=n/k;
        for(int i=0;i<k;i++){
            int fre[]=new int[26];
            fre[s.charAt(i)-'a']++;
            
            for(int j=1;j<idx;j++){
                fre[s.charAt((j*k)+i)-'a']++;
            }
            int max=0;
            for(int ii=0;ii<26;ii++)max=Math.max(max,fre[ii]);
            if(max<idx-1) return 0;
        }
        return 1;
        // Your Code Here   
        
    }
}