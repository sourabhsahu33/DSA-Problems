//{ Driver Code Starts

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            Long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.canJump(N));
        }
    }
}
// } Driver Code Ends

class Solution {
    static String canJump(Long N) {
      if(N==1) return "True";
      long idx =1;
      while(N > idx){
          idx +=idx;
      }
      if(idx==N) return "True";
      return "False";
      
    }
};