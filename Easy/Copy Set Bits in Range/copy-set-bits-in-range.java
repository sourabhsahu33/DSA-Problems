//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line[] = in.readLine().trim().split("\\s+");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int l = Integer.parseInt(line[2]);
            int r = Integer.parseInt(line[3]);
            
            Solution ob = new Solution();
            System.out.println(ob.setSetBit(x, y, l, r));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int setSetBit(int x, int y, int l, int r){
        String a = Integer.toBinaryString(x), b = Integer.toBinaryString(y);
        StringBuilder sa = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        sa.append("0".repeat(32 - a.length()));
        sb.append("0".repeat(32 - b.length()));
        sa.append(a);
        sb.append(b);
        // System.out.println(sa);
        // System.out.println(sb);
        for(int i = 32-l ; i >= 32-r ; i --){
            if(sb.charAt(i) == '1'){
                sa.setCharAt(i, '1');
            }
        }
        return Integer.parseInt(sa.toString(), 2);
    }
}