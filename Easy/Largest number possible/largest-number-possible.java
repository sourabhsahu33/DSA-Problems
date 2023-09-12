//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int S = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.findLargest(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String findLargest(int N, int S) {
        if (S == 0 && N == 1) {
            return "0"; // Special case when N=1 and S=0
        }
        
        if (S < 1 || S > 9 * N) {
            return "-1"; // Not possible to form a number
        }

        StringBuilder str = new StringBuilder();

        while (N > 0) {
            for (int digit = 9; digit >= 0; digit--) {
                if (S - digit >= 0) {
                    str.append(digit);
                    S -= digit;
                    N--;
                    break;
                }
            }
        }
        return str.toString();
    }
}
