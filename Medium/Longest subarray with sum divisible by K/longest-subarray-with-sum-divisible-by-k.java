//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    int longSubarrWthSumDivByK(int a[], int n, int k)
    {
       int[] remainderArray = new int[k];
        int maxLen = 0;
        int currentSum = 0;

        // Initialize the remainderArray with -1 to represent the initial state
        Arrays.fill(remainderArray, -1);

        for (int i = 0; i < n; i++) {
            currentSum += a[i];

            int remainder = (currentSum % k + k) % k;
https://media.geeksforgeeks.org/img-practice/fab-icon-new.gif
            if (remainder == 0) {
                maxLen = i + 1;
            } else {
                if (remainderArray[remainder] == -1) {
                    remainderArray[remainder] = i;
                } else {
                    maxLen = Math.max(maxLen, i - remainderArray[remainder]);
                }
            }
        }

        return maxLen;
    }
}



//{ Driver Code Starts.

// Driver class
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		   
		    int res = obj.longSubarrWthSumDivByK(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		    
		    
		}
	}
}



// } Driver Code Ends