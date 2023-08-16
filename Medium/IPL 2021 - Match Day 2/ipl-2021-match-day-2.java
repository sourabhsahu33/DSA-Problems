//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String args[]) {
        // taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // taking total count of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking total number of elements
            int n = sc.nextInt();

            // taking size of subArrays
            int k = sc.nextInt();

            // Declaring and Intializing an array of size n
            int arr[] = new int[n];

            // adding all the elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Calling the method max_of_subarrays of class solve
            // and storing the result in an ArrayList
            ArrayList<Integer> res = new Solution().max_of_subarrays(arr, n, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
      ArrayList<Integer> ans = new ArrayList<>();
    //   for(int i=0; i<=n-k; i++){
    //       int maxof = Integer.MIN_VALUE;
    //       for(int j=i; j<i+k; j++){
    //           maxof = Math.max(maxof, arr[j]);
    //       }
    //      ans.add(maxof);
    //   }
    //   return ans;
    
    int idx = 0;
    Deque<Integer> q = new ArrayDeque<>();
    for(int i=0; i<n; i++){
        // remove numbers out of range k
        if(!q.isEmpty() && q.peek() == i-k){
            q.poll();
        }
        // remvoe smaller numbers in k range as they ar not use
        while(!q.isEmpty() && arr[q.peekLast()] < arr[i]){
            q.pollLast();
        }
        q.offer(i);
        if( i>= k-1){
            ans.add(arr[q.peek()]);
        }
    }
    return ans;
    }
}