//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;


// } Driver Code Ends
//User function Template for Java
class Solution {
    public static int countSetBits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i <<= 1) {
            count += (n / (i << 1)) * i + Math.min(Math.max(n % (i << 1) - i + 1, 0), i);
        }
        return count;
    }
}




//{ Driver Code Starts.

// Driver code
class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//testcases
		int x, n;
		while(t-->0) {
	        n = sc.nextInt();//input n

		    Solution obj = new Solution();

		    System.out.println(obj.countSetBits(n));//calling countSetBits() method
		}
	}
}

// } Driver Code Ends