//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    int findMaxSum(int arr[], int n) {
        // return memo(arr, n-1, new int[n]);
        return solvTab(arr);
    }

    int solve(int arr[], int n) {
        if (n < 0)
            return 0;
        if (n == 0)
            return arr[0];

        int include = solve(arr, n - 2) + arr[n];
        int exclude = solve(arr, n - 1) + 0;

        return Math.max(include, exclude);
    }

    int solvTab(int arr[]) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 0);

        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            int include = (i - 2 >= 0 ? dp[i - 2] : 0) + arr[i];
            int exclude = dp[i - 1] + 0;
            dp[i] = Math.max(include, exclude);
        }
        return dp[n - 1];
    }

    int memo(int arr[], int n, int dp[]) {
        if (n < 0)
            return 0;
        if (n == 0)
            return arr[0];
        if (dp[n] != 0)
            return dp[n];

        int include = (n - 2 >= 0 ? memo(arr, n - 2, dp) : 0) + arr[n];
        int exclude = memo(arr, n - 1, dp) + 0;

        dp[n] = Math.max(include, exclude);
        return dp[n];
    }
}
