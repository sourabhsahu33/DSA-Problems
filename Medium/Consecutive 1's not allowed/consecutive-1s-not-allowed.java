//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            long ans = new Solution().countStrings(n);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    long countStrings(int n) {
        long m = 1000000007;  // Use the literal value instead of 1e9 + 7
        long a = 2;
        long b = 3;
        for (int i = 2; i <= n; i++) {
            long temp = (a + b) % m;
            a = b;
            b = temp;
        }
        return a;
    }
}
