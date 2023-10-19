//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends

class Solution
{
    public static long getMaxArea(long hist[], long n) 
    {
        
        long l[] = nsl(hist, n);
        long r[] = nsr(hist, n);
        long maxi = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++) {
            
            long width = r[i] - l[i] - 1;
            long currArea = hist[i]*width;
            maxi = Math.max(maxi, currArea);
        }
        return maxi;
        
    }
    
    public static long[] nsl(long arr[], long n) {
        
        int len = (int)n;
        
        Stack<Integer> s = new Stack<>();
        long ans[] = new long[len];
        
        for(int i=0; i<n; i++) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            
            if(s.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = s.peek();
            }
            s.push(i);
        }
        
        return ans;
        
    }
    
    public static long[] nsr(long arr[], long n) {
        
        int len = (int)n;
        
        Stack<Integer> s = new Stack<>();
        long ans[] = new long[len];
        
        for(int i=len-1; i>=0; i--) {
            
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            
            if(s.isEmpty()) {
                ans[i] = n;
            } else {
                ans[i] = s.peek();
            }
            
            s.push(i);
            
        }
        
        return ans;
        
    }
        
}
