//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends


class Solution {
    String reverseWords(String S) {
        S = S.trim();
        String words[] = S.split("\\."); // Splitting based on dot (".") delimiter
        int left = 0;
        int right = words.length - 1;
        
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        
        return String.join(".", words);
    }
}
