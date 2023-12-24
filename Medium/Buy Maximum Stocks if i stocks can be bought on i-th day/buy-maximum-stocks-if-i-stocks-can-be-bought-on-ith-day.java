//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String str=br.readLine();
    		String[] starr=str.split(" ");
    		
    		//input n and d
    	    int n=Integer.parseInt(starr[0]);
    		int k= Integer.parseInt(starr[1]);
            
            starr = br.readLine().trim().split(" ");
            int[] price = new int[n];
            for(int i = 0; i < n; i++)
                price[i] = Integer.parseInt(starr[i]);
            
            Solution obj = new Solution();
            int res = obj.buyMaximumProducts(n, k, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int buyMaximumProducts(int n, int k, int[] price) {
        // code here
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        for(int i=0; i<n; i++){
            mp.put(price[i], mp.getOrDefault(price[i], 0)+ i+1);
        }
        int ans = 0;
        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            while(entry.getValue() > 0 && k >= entry.getKey()){
                k -= entry.getKey();
                ans++;
                entry.setValue(entry.getValue() - 1);
            }
        }
        return ans;
    }
}
        
