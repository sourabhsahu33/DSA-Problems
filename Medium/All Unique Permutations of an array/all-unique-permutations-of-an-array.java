//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i=0; i<n; i++)
                arr.add(Integer.parseInt(S[i]));

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> res = ob.uniquePerms(arr,n);
            for(int i=0; i<res.size(); i++)
            {
                for(int j=0; j<n; j++)
                {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        // code here
        ArrayList<ArrayList<Integer>> ans= new ArrayList<>();
        Collections.sort(arr);
        backtrack(ans, new ArrayList<>(), arr, new boolean[arr.size()]);
        return ans;
    }
    static void backtrack(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp, ArrayList<Integer> arr , boolean [] used ){
        if(temp.size() == arr.size()){
            ans.add(new ArrayList<>(temp));
        }else{
            for(int i=0; i<arr.size(); i++){
                if(used[i] || i>0 && arr.get(i) == arr.get(i-1) && !used[i-1]) continue;
                used[i] = true;
                temp.add(arr.get(i));
                backtrack(ans, temp, arr, used);
                used[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
};

