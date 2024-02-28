//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S=read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.DivisibleByEight(S));
        }
    }
}
// } Driver Code Ends

class Solution{
    int DivisibleByEight(String s){
        //code here
        int n = s.length();
        if(n <= 2){
            int num = Integer.parseInt(s);
            return (num % 8 == 0) ? 1 : -1;
        }
        String st = s.substring(n-3, n);
        int num = Integer.parseInt(st);
        return (num % 8 == 0) ? 1 : -1;
    }
}