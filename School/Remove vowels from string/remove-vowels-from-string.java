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
            String s = read.readLine();
            
            Solution ob = new Solution();
            String result = ob.removeVowels(s);
            
            System.out.println(result);
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    String removeVowels(String S) {
        StringBuilder st = new StringBuilder(S);
        int i = 0; // Initialize index outside the loop
        while (i < st.length()) {
            char c = st.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                st.deleteCharAt(i);
            } else {
                i++; // Increment only if no deletion
            }
        }
        return st.toString();
    }
}
