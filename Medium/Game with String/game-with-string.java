//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minValue(String s, int k){
        // code here
        Map<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
            
        PriorityQueue<Integer> max_h = new PriorityQueue<>((a, b) -> b - a);
        max_h.addAll(map.values());
        
        while(k-->0){
            int freq = max_h.poll();
            freq--;
            max_h.offer(freq);
        }
        int sum = 0;
        while(!max_h.isEmpty()){
            int f = max_h.poll();
            sum = sum + (f * f);
        }
        return sum;
    }
}