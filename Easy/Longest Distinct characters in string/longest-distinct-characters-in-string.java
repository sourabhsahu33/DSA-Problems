//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String S){
     HashSet<Character> set = new HashSet<>();
     int start =0;
     int end = 0;
     int longest = 0;
     while( end < S.length()){
         if(set.add(S.charAt(end))){
             end++;
            longest = Math.max(longest, set.size());
         }else{
             set.remove(S.charAt(start));
             start++;
         }
     }
     return longest;
    }
}