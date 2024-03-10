//{ Driver Code Starts
//Initial Template for Java



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String str = br.readLine().trim();

            String ans = new Solution().removeDuplicates(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    String removeDuplicates(String str) {
    String s = "";
        for(int i = str.length()-1; i >= 0; i--)
            if(str.indexOf(str.charAt(i)) == i)
                s = str.charAt(i) + s;
        
        return s;
    }
}