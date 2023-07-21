//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

  public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] ar1 = new int[n], ar2 = new int[n];
            String[] inputLine = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                ar1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                ar2[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().findMidSum(ar1, ar2, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int findMidSum(int[] ar1, int[] ar2, int n) {
        // code here
        List<Integer> ans= new ArrayList<>();
       
        for(int i=0; i<ar1.length; i++){
            ans.add(ar1[i]);
        }
        for(int j=0; j<ar2.length; j++){
            ans.add(ar2[j]);
        }
        Collections.sort(ans);
        int mid = ans.size()/2;
        if(ans.size()%2 !=0){
            return ans.get(mid);
        }else{
            return (ans.get(mid)+ans.get(mid-1));
        }
    }
}