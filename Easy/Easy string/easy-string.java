//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String s = read.readLine();
            Solution ob = new Solution();
            String ans = ob.transform(s);
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution {
    String transform(String S) {
        StringBuilder ans = new StringBuilder();
        int count = 1;

        char[] chars = S.toLowerCase().toCharArray();
        
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                ans.append(count);
                ans.append(chars[i - 1]);
                count = 1;
            }
        }

        // Append the count and character for the last group of characters
        if (chars.length > 0) {
            ans.append(count);
            ans.append(chars[chars.length - 1]);
        }

        return ans.toString();
    }
}
