//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s[]=in.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int k=Integer.parseInt(s[1]);
            Solution ob=new Solution();
            out.println(ob.distributeTicket(n,k));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public static int distributeTicket(int N,int K)
    {
          ArrayDeque<Integer> q = new ArrayDeque<>();

        int i = 1;
        while (i <= N) {
            q.add(i);
            i++;
        }

        while (q.size() != 1) {
            
            int i1 = 1;
            while (i1 <= K) {
                q.remove();
                i1++;
                if (q.size() == 1) {
                    return q.peek();
                }
            }

            i1 =  1;
            while (i1<=K){
                q.removeLast();
                i1++;
                if (q.size() == 1) {
                    return q.peek();
                }
            }

 

 

        }
return q.peek();
    }
}